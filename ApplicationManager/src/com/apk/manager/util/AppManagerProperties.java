package com.apk.manager.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppManagerProperties {
	public static AppManagerProperties instance;

	private String apkLocn;

	public String getApkLocn() {
		return apkLocn;
	}
	public void setApkLocn(String apkLocn) {
		this.apkLocn = apkLocn;
	}
	private AppManagerProperties() throws IOException{
		Properties prop = new Properties();
		InputStream input = null;
		
//		 String path = servletContext.getRealPath("/MyProps/MyProperty.properties");
//	        System.out.println("path: " + path);
//	        
		if(input==null){
			input=AppManagerProperties.class.getResourceAsStream("./config.properties"); 
		}
//		input = new FileInputStream("./properties/config.properties");
		prop.load(input);
		setApkLocn(prop.getProperty("apkstore_locn"));
	}
	public static AppManagerProperties getInstance() throws IOException{
		if(instance==null){
			instance = new AppManagerProperties();
		}
		return instance;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			System.out.println(AppManagerProperties.getInstance().getApkLocn());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}




}
