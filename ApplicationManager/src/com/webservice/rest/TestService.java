package com.webservice.rest;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.apk.manager.beans.ApkBean;
import com.apk.manager.util.ApkFetcher;
import com.google.gson.Gson;

@Path("/")
public class TestService {
	
	Gson gson = new Gson();

	
	@Path("/hellos/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHellos(@Context SecurityContext sc,@PathParam("name") String name){
		if(sc.isUserInRole("admin")){
			return "Hello: Admin";
		}else{
			String returnVar="Hello "+name;
			return gson.toJson(returnVar);
		}
	
		
	}
	
	@Path("/hello/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello(@PathParam("name") String name){
			String returnVar="Hello "+name;
			return gson.toJson(returnVar);
	}
	
/*	@Path("/getApk")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getApkList(){
		File fodlerName = new File("D:\\AppManager");
		ArrayList<ApkBean> apkList=ApkFetcher.getInstance().getApkFiles(fodlerName);
		if(apkList.size()>0){
			return gson.toJson(apkList);
		}else{
			return "NA";
		}
		
	}*/
/*	@Path("/getUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsers(){
		TransactionManager tm = new TransactionManager();
		ArrayList<String> userList= new ArrayList<String>();
		String returnVal = null;
		try {
			userList=tm.getUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userList.size()>0){
			returnVal= new Gson().toJson(userList);
		}else{
			returnVal="NA";
		}
		return returnVal;
	}*/
}
