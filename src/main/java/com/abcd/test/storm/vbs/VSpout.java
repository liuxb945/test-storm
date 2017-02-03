package com.abcd.test.storm.vbs;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class VSpout extends BaseRichSpout {
	private SpoutOutputCollector _collector;
	private int count=5;
	private String[] _users={"userA","userB","userC","userD","userE"};
	private String[] _srcid={"s1","s2","s3","s1","s1"};

	@Override
	public void nextTuple() {
		for(int i=0;i<count;i++){
			try {
				Thread.sleep(1000);
				_collector.emit("visit",new Values(System.currentTimeMillis(),_users[i],_srcid[i]));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this._collector=collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declareStream("visit",new Fields("time","user","srcid"));
	}

}
