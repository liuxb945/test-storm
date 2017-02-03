package com.abcd.test.storm.freemarker;

import java.util.HashMap;
import java.util.Map;

import com.abcd.test.storm.util.FreemarkerUtil;
import com.abcd.test.storm.util.JsonUtil;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class GenHtmlBolt extends BaseRichBolt {
	private OutputCollector _collector;
	private Map<String,Long> taskMap;
	private FreemarkerUtil util;
	private String fn = "e:/test/freemarker/";

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this._collector=collector;
		if(taskMap==null){
			taskMap=new HashMap<String,Long>();
		}
		util=FreemarkerUtil.getInstance("/ftl");
	}

	@Override
	public void execute(Tuple input) {
		String streamId=input.getSourceStreamId();
		String taskid=input.getStringByField("taskid");
		Long time=input.getLongByField("time");
		if(streamId.equals("start")){
			taskMap.clear();
			taskMap.put(taskid, time);
		}
		else if(streamId.equals("stop")){
			Long now=System.currentTimeMillis();
			Long used=now-taskMap.get(taskid);
			this._collector.emit(new Values(taskid,used));
		}
		else {
			String str = input.getStringByField("product");
			try {
				Product p = (Product) JsonUtil.jsonToBean(str, Product.class);
				Map<String,Object> root = new HashMap<String,Object>();
				root.put("p", p);
				util.fprint(root, "01.ftl", fn + p.getId()+".html");
				util.sprint(root, "01.ftl");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("taskid","used"));
	}

}
