package com.abcd.test.storm.freemarker.model;

import java.io.Serializable;
import java.util.List;


public class ProductPackageVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6886534328705919422L;
	private ProductCategoryInfo category;
	private List<ProductSaleInfo> saleLists;//规格
	private List<SpecificationItem> itemList;//详情页动态属性标题
	private ProductInfo goods;
	private List<ProductInfo> seeGoodsInfoList;//看一看
	private List<ProductParamerInfo> paramterList;//商品参数
	private Tgoodsdetail goodsDetail;
	public ProductCategoryInfo getCategory() {
		return category;
	}
	public void setCategory(ProductCategoryInfo category) {
		this.category = category;
	}
	public List<ProductSaleInfo> getSaleLists() {
		return saleLists;
	}
	public void setSaleLists(List<ProductSaleInfo> saleLists) {
		this.saleLists = saleLists;
	}
	public List<SpecificationItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<SpecificationItem> itemList) {
		this.itemList = itemList;
	}
	public ProductInfo getGoods() {
		return goods;
	}
	public void setGoods(ProductInfo goods) {
		this.goods = goods;
	}
	public List<ProductInfo> getSeeGoodsInfoList() {
		return seeGoodsInfoList;
	}
	public void setSeeGoodsInfoList(List<ProductInfo> seeGoodsInfoList) {
		this.seeGoodsInfoList = seeGoodsInfoList;
	}
	public List<ProductParamerInfo> getParamterList() {
		return paramterList;
	}
	public void setParamterList(List<ProductParamerInfo> paramterList) {
		this.paramterList = paramterList;
	}
	public Tgoodsdetail getGoodsDetail() {
		return goodsDetail;
	}
	public void setGoodsDetail(Tgoodsdetail goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

}
