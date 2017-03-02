package com.abcd.test.storm.freemarker.model;

import java.math.BigDecimal;

/**
 * @Description 价格专用
 * @author lc
 * @date 2016年7月7日 下午2:59:44
 */
public class ProductPriceVo {
	
	private BigDecimal prefprice;//销售价格
	
	private BigDecimal promotionPrice;//促销价格
	
	private BigDecimal PreferentialPrice;//优惠价格
	
	private BigDecimal discountPrice;//折扣价格 
	
	private BigDecimal memberPrice;//会员价格

	public BigDecimal getMemberPrice() {
		return memberPrice;
	}

	public void setMemberPrice(BigDecimal memberPrice) {
		this.memberPrice = memberPrice;
	}

	public BigDecimal getPrefprice() {
		return prefprice;
	}

	public void setPrefprice(BigDecimal prefprice) {
		this.prefprice = prefprice;
	}

	public BigDecimal getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(BigDecimal promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public BigDecimal getPreferentialPrice() {
		return PreferentialPrice;
	}

	public void setPreferentialPrice(BigDecimal preferentialPrice) {
		PreferentialPrice = preferentialPrice;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}
}
