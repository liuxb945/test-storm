package com.abcd.test.storm.freemarker.model;

public class Tgoodsphoto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7219555817150159253L;
	//;
	private Integer id;
	//;
	private Integer goodsbaseid;
	//;
	private String photourl;

	public Tgoodsphoto(){
	}

	public Tgoodsphoto(Integer id,Integer goodsbaseid,String photourl){
		this.id = id;
		this.goodsbaseid = goodsbaseid;
		this.photourl = photourl;
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

	public String getPhotourl() {
		return photourl;
	}

	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}

}