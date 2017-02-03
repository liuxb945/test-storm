package com.abcd.test.storm.vbs;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

public class LogTopology {
	public static void main(String[] args) {
        try {
            // 实例化TopologyBuilder类。
            TopologyBuilder topologyBuilder = new TopologyBuilder();
            // 设置喷发节点并分配并发数，该并发数将会控制该对象在集群中的线程数。
            topologyBuilder.setSpout("log-vspout", new VSpout(), 1);
            topologyBuilder.setSpout("log-bspout", new BSpout(), 1);
            // 设置数据处理节点并分配并发数。指定该节点接收喷发节点的策略为随机方式。
            topologyBuilder.setBolt("log-merge", new LogMergeBolt(), 2).fieldsGrouping("log-vspout","visit",new Fields("user")).fieldsGrouping("log-bspout","business",new Fields("user"));
            topologyBuilder.setBolt("log-stat", new LogStatBolt(),2).fieldsGrouping("log-merge",new Fields("srcid"));
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
                cluster.submitTopology("log-topology", config, topologyBuilder.createTopology());
            }
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

}
