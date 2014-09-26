package com.apk.manager.action.functionality;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AppDetailsAction extends ActionSupport implements SessionAware {
	
	
	public String execute() {		

		return SUCCESS;
	}

	@Override
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		
	}

}
