package com.abcd.test.storm.freemarker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;
import redis.clients.jedis.Jedis;

public class TaskStatBolt extends BaseRichBolt {
	private OutputCollector _collector;
	private Map<String,Long> taskMap;
	private Map<String,Long> genedMap;
	private int staticPageTaskCount;
	Jedis jedis;
	String host;
	int port;
	String password;
	StringRedisTemplate redisTemplate;
	
	private void reconnect() {
		// 实例化链接工厂
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		// 设置host
		connectionFactory.setHostName(host);
		// 设置端口
		connectionFactory.setPort(port);
		// 设置密码
		connectionFactory.setPassword(password);
		// 初始化connectionFactory
		connectionFactory.afterPropertiesSet();
		// 实例化
		redisTemplate = new StringRedisTemplate(connectionFactory);
	}

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this._collector=collector;
		staticPageTaskCount=context.getComponentTasks("gen-html").size();
		if(taskMap==null){
			taskMap=new HashMap<String,Long>();
		}
		if(genedMap==null){
			genedMap=new HashMap<String,Long>();
		}
		host = stormConf.get("redis.host").toString();
		port = Integer.valueOf(stormConf.get("redis.port").toString());
		password = stormConf.get("redis.password").toString();
		reconnect();
	}

	@Override
	public void execute(Tuple input) {
		String taskId=input.getStringByField("taskid");
		Long count=input.getLongByField("count");
		if(taskMap.containsKey(taskId)){
			taskMap.put(taskId, taskMap.get(taskId)+1);
		}else{
			taskMap.put(taskId,1l);
		}
		if(genedMap.containsKey(taskId)){
			genedMap.put(taskId, genedMap.get(taskId)+count);
		}else{
			genedMap.put(taskId, count);
		}
		System.out.println(String.format("%s:%d:%d", input.getStringByField("taskid"),input.getLongByField("used"),count));
		if(taskMap.get(taskId).longValue()==staticPageTaskCount){
			this.redisTemplate.opsForValue().set(taskId,genedMap.get(taskId).toString());
			taskMap.remove(taskId);
			genedMap.remove(taskId);
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}

}
