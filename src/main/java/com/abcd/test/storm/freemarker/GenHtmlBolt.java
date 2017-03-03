package com.abcd.test.storm.freemarker;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.abcd.test.storm.freemarker.model.ProductPackageVo;
import com.abcd.test.storm.freemarker.model.Tgoodscategory;
import com.abcd.test.storm.util.FreemarkerUtil;
import com.abcd.test.storm.util.JsonUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.BucketInfo;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import redis.clients.jedis.Jedis;

public class GenHtmlBolt extends BaseRichBolt {
	private OutputCollector _collector;
	private Map<String,Long> taskMap;
	private Map<String,Long> genedMap;
	private FreemarkerUtil util;
	private String fn;
	Jedis jedis;
	String host;
	int port;
	String password;
	StringRedisTemplate redisTemplate;
	List<Tgoodscategory> categorys;
	private static String endpoint = "http://oss-cn-beijing.aliyuncs.com/";

    // accessKeyId和accessKeySecret是OSS的访问密钥，您可以在控制台上创建和查看，
    // 创建和查看访问密钥的链接地址是：https://ak-console.aliyun.com/#/。
    // 注意：accessKeyId和accessKeySecret前后都没有空格，从控制台复制时请检查并去除多余的空格。
    private static String accessKeyId = "SDXVeM5CZ30S99cN";
    private static String accessKeySecret = "3c8ohP2zI1uh8obue55uVJiGDy97bX";
    private OSSClient ossClient;
    private static String bucketName = "oss-server";
    BucketInfo info;

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this._collector=collector;
		if(taskMap==null){
			taskMap=new HashMap<String,Long>();
		}
		if(genedMap==null){
			genedMap=new HashMap<String,Long>();
		}
		if(categorys==null){
			categorys=new ArrayList<Tgoodscategory>();
		}
		util=FreemarkerUtil.getInstance("/ftl");
		host = stormConf.get("redis.host").toString();
		port = Integer.valueOf(stormConf.get("redis.port").toString());
		password = stormConf.get("redis.password").toString();
		fn=stormConf.get("savefile.path").toString();
		reconnectRedis();
	}
	
	private void reconnectRedis() {
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
	
	private void reconnectOss(){
		ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		info = ossClient.getBucketInfo(bucketName);
	}
	
	private void disconnectOss(){
		if(ossClient!=null){
			 ossClient.shutdown();
		}
	}

	@Override
	public void execute(Tuple input) {
		String streamId=input.getSourceStreamId();
		String taskid=input.getStringByField("taskid");
		Long time=input.getLongByField("time");
		if(streamId.equals("start")){
			taskMap.clear();
			taskMap.put(taskid, time);
			genedMap.clear();
			categorys.clear();
			reconnectOss();
			List<String> listCache = redisTemplate.opsForList().range("rootCatList", 0, -1);
			for (String str : listCache) {
				try {
					Tgoodscategory cat=(Tgoodscategory) JsonUtil.jsonToBean(str, Tgoodscategory.class);
					categorys.add(cat);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		else if(streamId.equals("stop")){
			Long now=System.currentTimeMillis();
			Long used=now-taskMap.get(taskid);
			Long count=genedMap.get(taskid);
			this._collector.emit(new Values(taskid,used,count));
			this.disconnectOss();
		}
		else {
			String str = input.getStringByField("product");
			try {
				/*Product p = (Product) JsonUtil.jsonToBean(str, Product.class);
				Map<String,Object> root = new HashMap<String,Object>();
				root.put("p", p);
				Copyright cr=new Copyright();
				cr.setWebName("网易");
				cr.setWebUrl("www.163.com");
				root.put("cr", cr);
				util.fprint(root, "01.ftl", fn + p.getId()+".html");
				util.sprint(root, "01.ftl");*/
				ProductPackageVo pp=(ProductPackageVo) JsonUtil.jsonToBean(str, ProductPackageVo.class);
				Map<String,Object> root = new HashMap<String,Object>();
				root.put("tgoodsCategories", categorys);
				root.put("category", pp.getCategory());
				root.put("saleLists", pp.getSaleLists());
				root.put("specificationItems", pp.getItemList());
				root.put("goods", pp.getGoods());
				root.put("seeGoodsInfoList", pp.getSeeGoodsInfoList());
				root.put("paramterList", pp.getParamterList());
				root.put("goodsDetail", pp.getGoodsDetail());
				//变量
				root.put("base", "http://192.168.0.20/rmdfront");
				root.put("cmsUrlHelpCenter", "http://192.168.0.20/rmdfront");
				util.fprint(root, "content.ftl", fn + "/products/id-"+pp.getGoods().getId()+".html");
//				util.sprint(root, "content.ftl");
				/*File tempFile=util.creatTemp();
				System.out.println(tempFile.getAbsolutePath());
				util.tprint(root, "content.ftl", tempFile);
				InputStream is=new FileInputStream(tempFile);
				String key="development/saharabuy/pccn/html/products/"+"id-"+pp.getGoods().getId()+".html";
	            ossClient.putObject(bucketName, key, is);
	            is.close();
	            tempFile.deleteOnExit();*/
				if(genedMap.containsKey(taskid)){
					genedMap.put(taskid, genedMap.get(taskid)+1);
				}else{
					genedMap.put(taskid, 1l);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("taskid","used","count"));
	}

}
