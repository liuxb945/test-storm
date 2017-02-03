package com.abcd.test.storm.testlog;

import java.util.HashMap;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class LogStat extends BaseRichBolt {
	private OutputCollector _collector;
	private Map<String,Integer> _pvMap=new HashMap<String,Integer>();

	@Override
	public void execute(Tuple input) {
		String user=input.getStringByField("user");
		if(_pvMap.containsKey(user))
			_pvMap.put(user, _pvMap.get(user)+1);
		else
			_pvMap.put(user, 1);
		_collector.emit(new Values(user,_pvMap.get(user)));
	}

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this._collector=collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("user","pv"));
	}

}
