package com.abcd.test.storm.freemarker;

import java.io.Serializable;

public class Copyright implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5516874559854158432L;
	private String webName;
	private String webUrl;
	public String getWebName() {
		return webName;
	}
	public void setWebName(String webName) {
		this.webName = webName;
	}
	public String getWebUrl() {
		return webUrl;
	}
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

}
