package com.abcd.test.storm.freemarker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.abcd.test.storm.util.JsonUtil;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class DataReaderSpout extends BaseRichSpout {
	private SpoutOutputCollector _collector;
	private List<Product> products;
	private String[] names={"电视","冰箱","洗衣机","热水器","木门"};
	private Random _rand=new Random();
	private boolean _completed=false;
	
	private void initData(){
		products=new ArrayList<Product>();
		for(int i=0;i<100;i++){
			Product p=new Product();
			p.setId(i);
			String cat=names[_rand.nextInt(5)];
			p.setName(cat+i);
			p.setCategory(cat);
			products.add(p);
		}
	}

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this._collector=collector;
		if(products==null){
			products=new ArrayList<Product>();
		}
	}

	@Override
	public void nextTuple() {
		try {
			Thread.sleep(1000);
			if(!_completed){
				initData();
				String taskid=UUID.randomUUID().toString();
				_collector.emit("start",new Values("",System.currentTimeMillis(),taskid));
				for(Product p:products){
					String str=JsonUtil.beanToJson(p);
					_collector.emit("product-stream",new Values(System.currentTimeMillis(),taskid,str));
				}
				_completed=true;
				_collector.emit("stop",new Values("",System.currentTimeMillis(),taskid));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declareStream("product-stream", new Fields("time","taskid","product"));
		declarer.declareStream("stop", new Fields("flag","time","taskid"));
		declarer.declareStream("start", new Fields("flag","time","taskid"));
	}

}
