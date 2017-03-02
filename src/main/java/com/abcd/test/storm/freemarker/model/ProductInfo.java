package com.abcd.test.storm.freemarker.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * 定义首页面显示的商品信息
 * @author 李永平
 *
 */
public class ProductInfo implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1360525671592915376L;
	private Integer id;//商品id
	private String pname;//商品名称
	private String pprice;//商品价格
	private String promotionprice;//促销价
	private Integer categoryid;//分类ID
	private Integer parentId;//分类父ID
	private String categoryname;//分类名称
	private String imgurl;//商品图片大图
	private String pimg;//商品缩略图片
	private String modifytime; //商品修改时间
	private String subname;//副标题 
	private Integer brandid; //品牌id
	private String brandname;//品牌名称
	private String setupbookurl;//安装说明书
	private List<Tgoodsphoto> photolists; //图片URL集合
	private BigDecimal maxprice;//销售最大价格
	private BigDecimal minprice;//销售最小价格
	private BigDecimal maxcprice;//最大促销价格
	private BigDecimal mincprice;//最小促销价格
	private String status;//商品状态
	private String producingarea;//产地
	private String watermark;//水印
	
	private String code;// 商品编码
	private String spec;// 规格
	private String packnum;// 包装数量
	private String packname;// 包装数量单位
	private String unitname;// 计量单位
	private String startnum;// 起售数量
	private BigDecimal prefprice;
	private BigDecimal promoprice;
	private Integer saleinfoid;// 商品属性Id
	
	public Integer getSaleinfoid() {
		return saleinfoid;
	}
	public void setSaleinfoid(Integer saleinfoid) {
		this.saleinfoid = saleinfoid;
	}
	public BigDecimal getPrefprice() {
		return prefprice;
	}
	public void setPrefprice(BigDecimal prefprice) {
		this.prefprice = prefprice;
	}
	public BigDecimal getPromoprice() {
		return promoprice;
	}
	public void setPromoprice(BigDecimal promoprice) {
		this.promoprice = promoprice;
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
	public String getPacknum() {
		return packnum;
	}
	public void setPacknum(String packnum) {
		this.packnum = packnum;
	}
	public String getPackname() {
		return packname;
	}
	public void setPackname(String packname) {
		this.packname = packname;
	}
	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public String getStartnum() {
		return startnum;
	}
	public void setStartnum(String startnum) {
		this.startnum = startnum;
	}
	public String getWatermark() {
		return watermark;
	}
	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}
	public String getProducingarea() {
		return producingarea;
	}
	public void setProducingarea(String producingarea) {
		this.producingarea = producingarea;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPromotionprice() {
		return promotionprice;
	}
	public void setPromotionprice(String promotionprice) {
		this.promotionprice = promotionprice;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public Integer getBrandid() {
		return brandid;
	}
	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}
	public List<Tgoodsphoto> getPhotolists() {
		return photolists;
	}
	public void setPhotolists(List<Tgoodsphoto> photolists) {
		this.photolists = photolists;
	}
	public String getSetupbookurl() {
		return setupbookurl;
	}
	public void setSetupbookurl(String setupbookurl) {
		this.setupbookurl = setupbookurl;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public BigDecimal getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(BigDecimal maxprice) {
		this.maxprice = maxprice;
	}
	public BigDecimal getMinprice() {
		return minprice;
	}
	public void setMinprice(BigDecimal minprice) {
		this.minprice = minprice;
	}
	public BigDecimal getMaxcprice() {
		return maxcprice;
	}
	public void setMaxcprice(BigDecimal maxcprice) {
		this.maxcprice = maxcprice;
	}
	public BigDecimal getMincprice() {
		return mincprice;
	}
	public void setMincprice(BigDecimal mincprice) {
		this.mincprice = mincprice;
	}
	
	
	
	
}
