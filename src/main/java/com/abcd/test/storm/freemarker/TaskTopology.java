package com.abcd.test.storm.freemarker;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

public class TaskTopology {
	public static void main(String[] args) {
        try {
            // 实例化TopologyBuilder类。
            TopologyBuilder topologyBuilder = new TopologyBuilder();
            // 设置喷发节点并分配并发数，该并发数将会控制该对象在集群中的线程数。
            topologyBuilder.setSpout("data-reader", new DataReaderSpout(), 1);
            // 设置数据处理节点并分配并发数。指定该节点接收喷发节点的策略为随机方式。
            topologyBuilder.setBolt("gen-html", new GenHtmlBolt(), 2).shuffleGrouping("data-reader","product-stream").allGrouping("data-reader","stop").allGrouping("data-reader","start");
            topologyBuilder.setBolt("task-stat", new TaskStatBolt(),1).fieldsGrouping("gen-html", new Fields("taskid"));
            Config config = new Config();
            config.setDebug(false);
            config.setNumWorkers(5);
            if (args != null && args.length > 0) {
                config.setNumWorkers(1);
                StormSubmitter.submitTopology(args[0], config, topologyBuilder.createTopology());
            } else {
                // 这里是本地模式下运行的启动代码。
//                config.setMaxTaskParallelism(1);
                LocalCluster cluster = new LocalCluster();
                cluster.submitTopology("task-topology", config, topologyBuilder.createTopology());
            }
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

}
