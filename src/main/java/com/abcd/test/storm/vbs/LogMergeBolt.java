package com.abcd.test.storm.vbs;

import java.util.HashMap;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class LogMergeBolt extends BaseRichBolt {
	private transient OutputCollector _collector;
	private HashMap<String,String> srcmap;

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this._collector=collector;
		if(srcmap==null){
			srcmap=new HashMap<String,String>();
		}
	}

	@Override
	public void execute(Tuple input) {
		String streamId=input.getSourceStreamId();
		if(streamId.equals("visit")){
			String user=input.getStringByField("user");
			String srcid=input.getStringByField("srcid");
			srcmap.put(user, srcid);
		}else if(streamId.equals("business")){
			String user=input.getStringByField("user");
			String pay=input.getStringByField("pay");
			String srcid=srcmap.get(user);
			if(srcid!=null){
				_collector.emit(new Values(user,srcid,pay));
				srcmap.remove(user);
			}
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("user","srcid","pay"));
	}

}
