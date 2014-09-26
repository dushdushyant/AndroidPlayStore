package com.apk.manager.action.authenticate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;


import com.apk.manager.beans.ApkBean;
import com.apk.manager.hibernate.dao.Dao;
import com.apk.manager.hibernate.mapping.UserDetails;
import com.apk.manager.util.ApkFetcher;
import com.apk.manager.util.AppManagerProperties;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String employeeName;
	UserDetails user;
	private Dao authMgr;

	public static Map<String, String> session;

	public Login() {
		//		authMgr= new HibernateDao();
	}

	public String execute() {		

		//		final RabbitExchange consumerObj = new RabbitExchange();
		//		if (!RabbitUtils.consumerrun) {
		//			System.out.println("inside thread");
		//			RabbitUtils.consumerrun = true;
		//			new Thread() {
		//				public void run() {
		//					System.out.println("Thread Running");
		//					consumerObj.startConsumer();
		//				}
		//			}.start();
		//		}

		//		File fodlerName= new File("D:\\Softwares");
		//		ArrayList<ApkBean>apkList=ApkFetcher.getInstance().getApkFiles(fodlerName);

		return SUCCESS;
	}

	// simple validation
	public void validate() {	
		try {
			AppManagerProperties.getInstance().getApkLocn();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String loginPass;
		authMgr= new Dao();
		UserDetails user=authMgr.getUserDetailsonUserName(username);
		if(user!=null){
			employeeName=user.getFirstName();
			session.put("empName", employeeName);
			loginPass= user.getPassword();
		}else loginPass="";

		if ("".equals(getUsername())) {
			addFieldError("username", getText("username.required"));
		} else if ("".equals(getPassword())) {
			addFieldError("password", getText("password.required"));
		} else if (!(loginPass.trim().equals(password))) {
			addFieldError("password", getText("password.wrong"));
		}

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSession(Map arg0) {
		this.session = arg0;

	}



}