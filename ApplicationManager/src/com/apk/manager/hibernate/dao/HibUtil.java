package com.apk.manager.hibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibUtil {
	
	   private static final SessionFactory sessionFactory = buildSessionFactory();
	   
	    private static SessionFactory buildSessionFactory() {
	        try {
	        	
	        	
	            // Create the SessionFactory from hibernate.cfg.xml
	            return new AnnotationConfiguration().configure("/hibernate.cfg.xml")
	                    .buildSessionFactory();
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed. " + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	    
	    public static void shutdown() {
			// Close caches and connection pools
			getSessionFactory().close();
		}

}
