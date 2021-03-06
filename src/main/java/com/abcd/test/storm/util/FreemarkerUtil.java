package com.abcd.test.storm.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Map;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtil {
	private static FreemarkerUtil util;
	private static Configuration cfg;

	private FreemarkerUtil() {
	}

	public static FreemarkerUtil getInstance(String pname) {
		if (util == null) {
			cfg = new Configuration();
			cfg.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
			cfg.setEncoding(Locale.getDefault(), "utf-8");
			cfg.setNumberFormat("0.######");
			cfg.setDateFormat("yyyy-MM-dd");
			cfg.setTimeFormat("HH:mm:ss");
			cfg.setDateTimeFormat("yyyy-MM-dd");
			cfg.setBooleanFormat("true,false");
			cfg.setClassicCompatible(true);
			cfg.setWhitespaceStripping(true);
			cfg.setURLEscapingCharset("utf-8");
			cfg.setObjectWrapper(new BeansWrapper());
			cfg.setClassForTemplateLoading(FreemarkerUtil.class, pname);
			util = new FreemarkerUtil();
		}
		return util;
	}

	private Template getTemplate(String fname) {
		try {
			return cfg.getTemplate(fname);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过标准输出流输出模板的结果
	 * 
	 * @param root
	 *            数据对象
	 * @param fname
	 *            模板文件
	 */
	public void sprint(Map<String, Object> root, String fname) {
		try {
			getTemplate(fname).process(root, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public File tprint(Map<String, Object> root,String fname,File file) throws Exception{
		getTemplate(fname).process(root, new PrintWriter(file));
		return file;
	}
	
	public File creatTemp() throws IOException{
		File temp = File.createTempFile("pattern", ".suffix");
		temp.deleteOnExit();
		return temp;
	}

	/**
	 * 基于文件的输出
	 * 
	 * @param root
	 * @param fname
	 * @param outpath
	 */
	public void fprint(Map<String, Object> root, String fname, String outpath) {
		try {
			getTemplate(fname).process(root, new FileWriter(outpath));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
