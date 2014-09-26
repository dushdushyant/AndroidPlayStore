package com.apk.manager.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.apk.manager.hibernate.mapping.AppDownloadDetails;
import com.apk.manager.hibernate.mapping.ApplicationDetails;
import com.apk.manager.hibernate.mapping.UserDetails;
import com.apk.manager.util.SQLQueries;
import com.rabbitmq.client.AMQP.Tx;



public class Dao {
	Session session =null;
	
	public UserDetails getUserDetails(int id){
		try{
			session = HibUtil.getSessionFactory().getCurrentSession();
		}catch(HibernateException e){
			session = HibUtil.getSessionFactory().openSession();
		}
		session.beginTransaction();
		UserDetails u= (UserDetails) session.load(UserDetails.class, id);
		System.out.println(u.getFirstName());
		
		session.close();

		return u;

	}
	
	public UserDetails getUserDetailsonUserName(String userName){
		ArrayList<UserDetails> userDetails= new ArrayList<UserDetails>();
		try{
			session = HibUtil.getSessionFactory().getCurrentSession();
		}catch(HibernateException e){
			session = HibUtil.getSessionFactory().openSession();
		}
		session.beginTransaction();
		
		userDetails = (ArrayList<UserDetails>) session.createQuery("FROM UserDetails U WHERE U.userName ="+"'"+userName+"'").list();	
		SQLQuery sql= session.createSQLQuery(SQLQueries.SELECT_USER_ON_USER_NAME+ "'"+userName+"'");
		System.out.println("********* Size: "+userDetails.size());		
//		System.out.println(userDetails.get(0).getFirstName());
		session.close();
		if(userDetails.size()>0){
			return userDetails.get(0);
		}else{
			return null;
		}
		
	}
	
	public void insertAppDetails(ApplicationDetails appDetails){
		
		try{
			session = HibUtil.getSessionFactory().getCurrentSession();
		}catch(HibernateException e){
			session = HibUtil.getSessionFactory().openSession();
		}
		
		Transaction tx = session.beginTransaction();
		int appID=(Integer) session.save(appDetails);
		tx.commit();
		session.close();
		
		
	}
	
	public ArrayList<AppDownloadDetails> getAppDownloadList(){
		try{
			session = HibUtil.getSessionFactory().getCurrentSession();
		}catch(HibernateException e){
			session = HibUtil.getSessionFactory().openSession();
		}
		session.beginTransaction();
		ArrayList<AppDownloadDetails> appdetailslist=(ArrayList<AppDownloadDetails>) session.createQuery("from AppDownloadDetails").list();
		session.close();
		return appdetailslist;
		
	}
	
	public ArrayList<ApplicationDetails> getApplicationList(){
		try{
			session = HibUtil.getSessionFactory().getCurrentSession();
		}catch(HibernateException e){
			session = HibUtil.getSessionFactory().openSession();
		}
		Transaction tx=session.beginTransaction();
		ArrayList<ApplicationDetails> applicationList=(ArrayList<ApplicationDetails>) session.createQuery("from ApplicationDetails").list();
		tx.commit();
		session.close();
		return applicationList;
		
	}
	
	public ApplicationDetails getApplicationDetails(String appName){
		ApplicationDetails appDetails=null;
		try{
			session = HibUtil.getSessionFactory().getCurrentSession();
		}catch(HibernateException e){
			session = HibUtil.getSessionFactory().openSession();
		}
		Transaction tx=session.beginTransaction();
		ArrayList<ApplicationDetails> applicationList=(ArrayList<ApplicationDetails>) session.createQuery("from ApplicationDetails U WHERE U.appName ="+"'"+appName+"'").list();
		tx.commit();
		session.close();
		if(!(applicationList==null)){
			appDetails = applicationList.get(0);
		}
		return appDetails;
		
	}

}
