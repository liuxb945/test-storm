package com.abcd.test.storm.vbs;

import java.util.HashMap;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class LogStatBolt extends BaseRichBolt {
	private transient OutputCollector _collector;
	private HashMap<String,Long> srcpay;

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this._collector=collector;
		if(srcpay==null){
			srcpay=new HashMap<String,Long>();
		}
	}

	@Override
	public void execute(Tuple input) {
		String pay=input.getStringByField("pay");
		String srcid=input.getStringByField("srcid");
		if(srcpay.containsKey(srcid)){
			srcpay.put(srcid, Long.parseLong(pay)+srcpay.get(srcid));
		}
		else{
			srcpay.put(srcid, Long.parseLong(pay));
		}
		System.out.println(String.format("%s:%d", srcid,srcpay.get(srcid)));
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}

}
