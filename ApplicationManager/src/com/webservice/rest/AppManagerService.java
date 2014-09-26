package com.webservice.rest;

import java.io.File;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.apk.manager.beans.ApkBean;
import com.apk.manager.hibernate.dao.Dao;
import com.apk.manager.hibernate.mapping.ApplicationDetails;
import com.apk.manager.util.ApkFetcher;
import com.google.gson.Gson;

@Path("/appmanager")
public class AppManagerService {

	Gson gson = new Gson();


	@Path("/getApkDetails")
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

	}

	
	
	/**
	 * 
	 * Rest implementation to download the application
	 * @param appName
	 * @return
	 */
	@Path("/getApk/{fileName}")
	@GET
	@Produces("application/apk")
	public Response downloadApk(@PathParam("fileName") String appName){
		String appPreName="";
		ResponseBuilder response =null;
		System.out.println("File requested is : " + appName);

		//Put some validations here such as invalid file name or missing file name
		if(appName == null || appName.isEmpty())
		{
			response = Response.status(Status.BAD_REQUEST);
			return response.build();
		}else{
			File file = new File("D:\\AppManager\\"+appName);
			response = Response.ok((Object) file);
			try{
				appPreName= appName.substring(0,appName.lastIndexOf("."));
			}catch(Exception e){
				response = Response.status(Status.BAD_REQUEST);
				return response.build();
			}

			response.header("Content-Disposition", "attachment; filename=\""+appPreName+".apk");
			return response.build();
		}
	}
	
	
	/**
	 * 
	 * Rest implementation to download the application
	 * @param appName
	 * @return
	 */
	@Path("/getApkDetails/{fileName}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getApplicationDetails(@PathParam("fileName") String appName){
		Dao dao = new Dao();
		ApplicationDetails app=dao.getApplicationDetails(appName);
		return new Gson().toJson(app);
		
	}
	

}
