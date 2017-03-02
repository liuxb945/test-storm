package com.abcd.test.storm.freemarker.model;

import java.math.BigDecimal;
import java.util.List;
/**
 * 销售信息
 * @author 李永平
 *
 */
public class ProductSaleInfo {

	private Integer id;
	private Integer baseid;
	private String code;
	private String spec;
	private Integer packnum;
	
	private BigDecimal prefprice;
	private BigDecimal promotionprice;
	private Integer startnum;
	private List<ProductPropertyValueInfo> propertyList;
	
	private String status;//规格状态
	private String tpkunitid1Name;//价格单位
	private String packunitName;//包装数量单位
	
	public Integer getBaseid() {
		return baseid;
	}
	public void setBaseid(Integer baseid) {
		this.baseid = baseid;
	}
	public String getTpkunitid1Name() {
		return tpkunitid1Name;
	}
	public void setTpkunitid1Name(String tpkunitid1Name) {
		this.tpkunitid1Name = tpkunitid1Name;
	}
	public String getPackunitName() {
		return packunitName;
	}
	public void setPackunitName(String packunitName) {
		this.packunitName = packunitName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public Integer getPacknum() {
		return packnum;
	}
	public void setPacknum(Integer packnum) {
		this.packnum = packnum;
	}
	public BigDecimal getPrefprice() {
		return prefprice;
	}
	public void setPrefprice(BigDecimal prefprice) {
		this.prefprice = prefprice;
	}
	public BigDecimal getPromotionprice() {
		return promotionprice;
	}
	public void setPromotionprice(BigDecimal promotionprice) {
		this.promotionprice = promotionprice;
	}
	public Integer getStartnum() {
		return startnum;
	}
	public void setStartnum(Integer startnum) {
		this.startnum = startnum;
	}
	public List<ProductPropertyValueInfo> getPropertyList() {
		return propertyList;
	}
	public void setPropertyList(List<ProductPropertyValueInfo> propertyList) {
		this.propertyList = propertyList;
	}
	
	
	
}
