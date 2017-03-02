package com.abcd.test.storm.freemarker.model;

import java.util.Date;
import java.util.List;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Tgoodscategory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4813268569508424912L;
	//;
	private Integer id;
	//;
	private String categoryname;
	//;
	private Integer parentid;
	//;
	private String numunit;
	//;
	private Integer goodstypeid;
	//;
	private BigDecimal isnavishow;
	//;
	private BigDecimal isindexshow;
	//;
	private Integer sortindex;
	//;
	private Date indbtime;
	private String indbtimestring;
	//;
	private Integer userid;
	//;
	private Date modifytime;
	private String modifytimestring;
	//;
	private Integer modifyuserid;
	private String METATitle;
	private String METAKeywords;
	private String METADescription;
	private List<Tgoodscategory> children;

	public Tgoodscategory(){
	}

	public Tgoodscategory(Integer id,String categoryname,Integer parentid,String numunit,Integer goodstypeid,BigDecimal isnavishow,BigDecimal isindexshow,Integer sortindex,Date indbtime,Integer userid,Date modifytime,Integer modifyuserid,String METATitle,String METAKeywords,String METADescription){
		this.id = id;
		this.categoryname = categoryname;
		this.parentid = parentid;
		this.numunit = numunit;
		this.goodstypeid = goodstypeid;
		this.isnavishow = isnavishow;
		this.isindexshow = isindexshow;
		this.sortindex = sortindex;
		this.indbtime = indbtime;
		this.userid = userid;
		this.modifytime = modifytime;
		this.modifyuserid = modifyuserid;
		this.METATitle = METATitle;
		this.METAKeywords = METAKeywords;
		this.METADescription = METADescription;
	}

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getNumunit() {
		return numunit;
	}

	public void setNumunit(String numunit) {
		this.numunit = numunit;
	}

	public Integer getGoodstypeid() {
		return goodstypeid;
	}

	public void setGoodstypeid(Integer goodstypeid) {
		this.goodstypeid = goodstypeid;
	}

	public BigDecimal getIsnavishow() {
		return isnavishow;
	}

	public void setIsnavishow(BigDecimal isnavishow) {
		this.isnavishow = isnavishow;
	}

	public BigDecimal getIsindexshow() {
		return isindexshow;
	}

	public void setIsindexshow(BigDecimal isindexshow) {
		this.isindexshow = isindexshow;
	}

	public Integer getSortindex() {
		return sortindex;
	}

	public void setSortindex(Integer sortindex) {
		this.sortindex = sortindex;
	}

	public Date getIndbtime() {
		return indbtime;
	}

	public void setIndbtime(Date indbtime) {
		this.indbtime = indbtime;
	}

	public String getIndbtimestring() {
		return indbtimestring;
	}

	public void setIndbtimestring(String indbtimestring) {
		this.indbtimestring = indbtimestring;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public String getModifytimestring() {
		return modifytimestring;
	}

	public void setModifytimestring(String modifytimestring) {
		this.modifytimestring = modifytimestring;
	}

	public Integer getModifyuserid() {
		return modifyuserid;
	}

	public void setModifyuserid(Integer modifyuserid) {
		this.modifyuserid = modifyuserid;
	}

	public List<Tgoodscategory> getChildren() {
		return children;
	}

	public void setChildren(List<Tgoodscategory> children) {
		this.children = children;
	}

}