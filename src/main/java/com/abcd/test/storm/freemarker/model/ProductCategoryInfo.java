package com.abcd.test.storm.freemarker.model;
/**
 * 详情页显示分类
 * @author 李永平
 *
 */
public class ProductCategoryInfo {
	
	private String indexname="首页";
	private String indexpath="/index.html";
	private Integer rootid;
	private Integer parentid;
	private Integer childid;
	
	private String rootname;
	private String parentname;
	private String childname;
	
	private String rootpath;
	private String parentpath;
	private String childpath;
	
	private String productpath;
	private String METATitle;
	private String METAKeywords;
	private String METADescription;
	
	public String getMETATitle() {
		return METATitle;
	}
	public void setMETATitle(String mETATitle) {
		METATitle = mETATitle;
	}
	public String getMETAKeywords() {
		return METAKeywords;
	}
	public void setMETAKeywords(String mETAKeywords) {
		METAKeywords = mETAKeywords;
	}
	public String getMETADescription() {
		return METADescription;
	}
	public void setMETADescription(String mETADescription) {
		METADescription = mETADescription;
	}
	public Integer getRootid() {
		return rootid;
	}
	public void setRootid(Integer rootid) {
		this.rootid = rootid;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public Integer getChildid() {
		return childid;
	}
	public void setChildid(Integer childid) {
		this.childid = childid;
	}
	public String getIndexname() {
		return indexname;
	}
	public void setIndexname(String indexname) {
		this.indexname = indexname;
	}
	public String getRootname() {
		return rootname;
	}
	public void setRootname(String rootname) {
		this.rootname = rootname;
	}
	public String getParentname() {
		return parentname;
	}
	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
	
	public String getChildname() {
		return childname;
	}
	public void setChildname(String childname) {
		this.childname = childname;
	}
	public String getRootpath() {
		return rootpath;
	}
	public void setRootpath(String rootpath) {
		this.rootpath = rootpath;
	}
	public String getParentpath() {
		return parentpath;
	}
	public void setParentpath(String parentpath) {
		this.parentpath = parentpath;
	}
	public String getChildpath() {
		return childpath;
	}
	public void setChildpath(String childpath) {
		this.childpath = childpath;
	}
	public String getProductpath() {
		return productpath;
	}
	public void setProductpath(String productpath) {
		this.productpath = productpath;
	}
	public String getIndexpath() {
		return indexpath;
	}
	public void setIndexpath(String indexpath) {
		this.indexpath = indexpath;
	}
	

}
