package com.apk.manager.action.functionality;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.apk.manager.hibernate.dao.Dao;
import com.apk.manager.hibernate.mapping.ApplicationDetails;
import com.apk.manager.util.AppManagerProperties;
import com.opensymphony.xwork2.ActionSupport;

public class DeployAction extends ActionSupport implements SessionAware ,ServletRequestAware  {
	private File userApk;
	private String userApkContentType;
	private String userApkFileName;



	/*
	 * Apk Details captured from screen
	 */
	private String appOwner;
	private String appName;
	private String appVer;

	public String getAppOwner() {
		return appOwner;
	}

	public void setAppOwner(String appOwner) {
		this.appOwner = appOwner;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVer() {
		return appVer;
	}

	public void setAppVer(String appVer) {
		this.appVer = appVer;
	}

	/*	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}*/

	public File getUserApk() {
		return userApk;
	}

	public void setUserApk(File userApk) {
		this.userApk = userApk;
	}

	public String getUserApkContentType() {
		return userApkContentType;
	}

	public void setUserApkContentType(String userApkContentType) {
		this.userApkContentType = userApkContentType;
	}

	public String getUserApkFileName() {
		return userApkFileName;
	}

	public void setUserApkFileName(String userApkFileName) {
		this.userApkFileName = userApkFileName;
	}

	private HttpServletRequest servletRequest;

	public String execute() {		

		return SUCCESS;
	}

	@Override
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub

	}
	public String deployApp(){
		String returnString="success";
		File fileToCreate =null;
		try {
			//          String filePath = servletRequest.getSession().getServletContext().getRealPath("/");
//			String filePath ="D:\\AppManager";
			String filePath =AppManagerProperties.getInstance().getApkLocn();
			if(userApkFileName!=null){

				if(!appName.equalsIgnoreCase("")){
					if(!appOwner.equalsIgnoreCase("")){
						if(!appVer.equalsIgnoreCase("")){
							//all inputs are received
							//proceed with operations
							Date today = new Date();
							fileToCreate = new File(filePath, this.userApkFileName);
							Dao dao = new Dao();

							ApplicationDetails appDetails = new ApplicationDetails();
							appDetails.setAppName(appName);
							appDetails.setAppOwner(appOwner);
							appDetails.setAppVer(appVer);
							appDetails.setDate(today);
							appDetails.setIsActive(true);
							dao.insertAppDetails(appDetails);
							FileUtils.copyFile(this.userApk, fileToCreate);

						}else{
							//null appVer Registered
							//flag error message
							addFieldError("appVer", getText("appVer.required"));
							returnString="input";							
						}
					}else{
						//null appOwner Registered
						//flag error message
						addFieldError("appOwner", getText("appOwner.required"));
						returnString="input";
					}					
				}else{
					//null appName Registered
					//flag error message
					addFieldError("appName", getText("appName.required"));
					returnString="input";
				}

			}else{
				//null apk Selected
				//flag error message
				addFieldError("userApk", getText("userApkFileName.required"));
				//				addActionError(getText("userImageFileName.required"));
				returnString="input";
			}


		} catch (Exception e) {
			e.printStackTrace();
			//			addActionError(e.getMessage());
			returnString="input";


		}
		return returnString;

	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}

}
