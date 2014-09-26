package rest.client;

import java.util.ArrayList;

import com.apk.manager.hibernate.dao.Dao;
import com.apk.manager.hibernate.mapping.ApplicationDetails;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dao dao = new Dao();
		ArrayList<ApplicationDetails>appList=dao.getApplicationList();
		System.out.println("#############################################");
		for(ApplicationDetails app:appList){
			System.out.println(app.getAppId());
			ApplicationDetails a1=dao.getApplicationDetails(app.getAppName());
			try{
				System.out.println(a1.getAppName());
				System.out.println(a1.getAppId());
				System.out.println(a1.getAppOwner());
				System.out.println(a1.getAppVer());
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		System.out.println("#############################################");
		

	}

}
