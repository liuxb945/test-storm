package com.abcd.test.storm.vbs;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class BSpout extends BaseRichSpout {
	private SpoutOutputCollector _collector;
	private int count=5;
	private String[] _users={"userA","userB","userC","userD","userE"};
	private String[] _pays={"100","200","300","400","200"};

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this._collector=collector;
	}

	@Override
	public void nextTuple() {
		for(int i=0;i<count;i++){
			try {
				Thread.sleep(1500);
				_collector.emit("business",new Values(System.currentTimeMillis(),_users[i],_pays[i]));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declareStream("business",new Fields("time","user","pay"));
	}

}
