package com.abcd.test.storm.freemarker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.abcd.test.storm.freemarker.model.ProductPackageVo;
import com.abcd.test.storm.util.JsonUtil;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import redis.clients.jedis.Jedis;

public class DataReaderSpout extends BaseRichSpout {
	private SpoutOutputCollector _collector;
	private List<Product> products;
	private String[] names = { "电视", "冰箱", "洗衣机", "热水器", "木门" };
	private Random _rand = new Random();
	private boolean _completed = true;
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

	private void initData() {
		products = new ArrayList<Product>();
		for (int i = 0; i < 10; i++) {
			Product p = new Product();
			p.setId(i);
			String cat = names[_rand.nextInt(5)];
			p.setName(cat + i);
			p.setCategory(cat);
			products.add(p);
		}
	}

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this._collector = collector;
		if (products == null) {
			products = new ArrayList<Product>();
		}
		host = conf.get("redis.host").toString();
		port = Integer.valueOf(conf.get("redis.port").toString());
		password = conf.get("redis.password").toString();
		reconnect();
	}

	@Override
	public void nextTuple() {
		try {
			String taskid = redisTemplate.opsForList().rightPop("static_page_task");
			if (taskid == null || "nil".equals(taskid)||!_completed) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
			} else {
				if (_completed) {
//					initData();
//					String taskid = UUID.randomUUID().toString();
					System.out.println("==========>begin task:"+taskid);
					_collector.emit("start", new Values("", System.currentTimeMillis(), taskid));
					List<String> listCache = redisTemplate.opsForList().range("ppList", 0, -1);
					for (String str : listCache) {
						_collector.emit("product-stream", new Values(System.currentTimeMillis(), taskid, str));

					}

					/*
					 * for(Product p:products){ String
					 * str=JsonUtil.beanToJson(p);
					 * _collector.emit("product-stream",new
					 * Values(System.currentTimeMillis(),taskid,str)); }
					 */
					_collector.emit("stop", new Values("", System.currentTimeMillis(), taskid));
					_completed = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declareStream("product-stream", new Fields("time", "taskid", "product"));
		declarer.declareStream("stop", new Fields("flag", "time", "taskid"));
		declarer.declareStream("start", new Fields("flag", "time", "taskid"));
	}

}
