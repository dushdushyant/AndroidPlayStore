package com.apk.manager.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.apk.manager.beans.ApkBean;

public class ApkFetcher {
	private static ApkFetcher instance;
	private static ArrayList<ApkBean> apkList= new ArrayList<ApkBean>();
	
	public static ApkFetcher getInstance(){
		if(instance==null){
			instance= new ApkFetcher();
		}
		apkList.clear();
		return instance;
	}
	
	private ApkFetcher(){
		
	}
//	ArrayList<ApkBean> apkList= new ArrayList<ApkBean>();


	public ArrayList<ApkBean> getApkList() {
		return apkList;
	}


	public void setApkList(ArrayList<ApkBean> apkList) {
		this.apkList = apkList;
	}


	public ArrayList<ApkBean> getApkFiles(final File folder) {
		String fileType;
		String fileName;
//		ArrayList<ApkBean> apkList= new ArrayList<ApkBean>();
		for (final File fileEntry : folder.listFiles()) {
			ApkBean apk = new ApkBean();
			if (fileEntry.isDirectory()) {
				getApkFiles(fileEntry);
			} else {
				fileName=fileEntry.getName();
				fileType=fileName.substring(fileName.lastIndexOf(".")+1);
				if(fileType.equalsIgnoreCase("apk")){
					apk.setApkName(fileName);
					apk.setApkPath(fileEntry.getPath());
					apkList.add(apk);
					System.out.println(fileName);
					System.out.println(fileEntry.getAbsoluteFile());
					try {
						System.out.println(fileEntry.getCanonicalPath());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(fileEntry.getTotalSpace());
				}
			}
		}
		System.out.println("Size of Apks: "+apkList.size());
		return apkList;
	}
}
