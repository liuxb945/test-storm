package com.abcd.test.storm.freemarker.model;

/**
 * 商品参数
 * @author 李永平
 *
 */
public class ProductParamerInfo {
	
	private Integer id; 
	private Integer goodsbaseid;
	private String name;
	private String propertyselectvalue;
	private String propertyvalue;
	private String setupbookurl;//说明书路径
	
	public String getSetupbookurl() {
		return setupbookurl;
	}
	public void setSetupbookurl(String setupbookurl) {
		this.setupbookurl = setupbookurl;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodsbaseid() {
		return goodsbaseid;
	}
	public void setGoodsbaseid(Integer goodsbaseid) {
		this.goodsbaseid = goodsbaseid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPropertyselectvalue() {
		return propertyselectvalue;
	}
	public void setPropertyselectvalue(String propertyselectvalue) {
		this.propertyselectvalue = propertyselectvalue;
	}
	public String getPropertyvalue() {
		return propertyvalue;
	}
	public void setPropertyvalue(String propertyvalue) {
		this.propertyvalue = propertyvalue;
	}
	

}
