package com.abcd.test.storm.freemarker.model;

/**
 * 商品规格属性
 * @author 李永平
 *
 */
public class ProductPropertyValueInfo {
	private Integer id;
	private String goodstypepropertyvalue;
	private String propertyvalue;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodstypepropertyvalue() {
		return goodstypepropertyvalue;
	}
	public void setGoodstypepropertyvalue(String goodstypepropertyvalue) {
		this.goodstypepropertyvalue = goodstypepropertyvalue;
	}
	public String getPropertyvalue() {
		return propertyvalue;
	}
	public void setPropertyvalue(String propertyvalue) {
		this.propertyvalue = propertyvalue;
	}
	

}
