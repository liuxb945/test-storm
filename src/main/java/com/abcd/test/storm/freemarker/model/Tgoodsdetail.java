package com.abcd.test.storm.freemarker.model;

import java.util.Date;


import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Tgoodsdetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7012245448081073859L;
	//;
	private Integer id;
	//;
	private Integer baseid;
	//;
	private String url;

	public Tgoodsdetail(){
	}

	public Tgoodsdetail(Integer id,Integer baseid,String url){
		this.id = id;
		this.baseid = baseid;
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBaseid() {
		return baseid;
	}

	public void setBaseid(Integer baseid) {
		this.baseid = baseid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}