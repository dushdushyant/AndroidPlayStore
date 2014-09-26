package com.apk.manager.action.authenticate;

import java.util.ArrayList;
import java.util.Date;

import com.apk.manager.hibernate.dao.Dao;
import com.apk.manager.hibernate.mapping.AppDownloadDetails;
import com.apk.manager.hibernate.mapping.ApplicationDetails;
import com.apk.manager.hibernate.mapping.UserDetails;

public class TestDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dao dao = new Dao();
		UserDetails user=dao.getUserDetails(1);
		System.out.println(user.getFirstName());

		ArrayList<ApplicationDetails> appLIst= new ArrayList<ApplicationDetails>();
		appLIst= dao.getApplicationList();
		System.out.println("*****************"+appLIst.size());

		ArrayList<AppDownloadDetails> appList = dao.getAppDownloadList();
		for(AppDownloadDetails app:appList){
			System.out.println("*********************"+app.getAppId());
		}

		Date today = new Date();

	/*	System.out.println("Inserting app data");
		ApplicationDetails appDetails = new ApplicationDetails();
		appDetails.setAppName("app2");
		appDetails.setAppOwner("owner1");
		appDetails.setAppVer("V1.0");
		appDetails.setDate(today);
		appDetails.setIsActive(true);
		dao.insertAppDetails(appDetails);*/
		
		dao.getUserDetailsonUserName("admin");
	}

}
