package com.abcd.test.storm.testlog;

import java.util.Map;
import java.util.Random;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class LogReader extends BaseRichSpout {
	private SpoutOutputCollector _collector;
	private Random _rand=new Random();
	private int _count=100;
	private String[] _users={"userA","userB","userC","userD","userE"};
	private String[] _urls={"url1","url2","url3","url4","url5"};

	@Override
	public void nextTuple() {
		try{
			Thread.sleep(1000);
			while(_count-->=0){
				if(_count==0){
					_collector.emit("stop",new Values(""));
				}
				else{
				this._collector.emit("log",new Values(
						System.currentTimeMillis(),
						_users[_rand.nextInt(5)],
						_urls[_rand.nextInt(5)]
						));
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this._collector=collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
//		declarer.declare(new Fields("time","user","url"));
		//2.
		declarer.declareStream("log", new Fields("time","user","url"));
		declarer.declareStream("stop", new Fields("flag"));
	}

}
