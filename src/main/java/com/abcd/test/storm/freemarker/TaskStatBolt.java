package com.abcd.test.storm.freemarker;

import java.util.HashMap;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class TaskStatBolt extends BaseRichBolt {
	private OutputCollector _collector;
	private Map<String,Long> taskMap;

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this._collector=collector;
		if(taskMap==null){
			taskMap=new HashMap<String,Long>();
		}
	}

	@Override
	public void execute(Tuple input) {
		System.out.println(String.format("%s:%d", input.getStringByField("taskid"),input.getLongByField("used")));
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}

}
