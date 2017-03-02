package com.abcd.test.storm.freemarker.model;

import java.io.Serializable;

public class SpecificationItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String itemname;
	private Integer itemindex;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Integer getItemindex() {
		return itemindex;
	}
	public void setItemindex(Integer itemindex) {
		this.itemindex = itemindex;
	}
	

}
