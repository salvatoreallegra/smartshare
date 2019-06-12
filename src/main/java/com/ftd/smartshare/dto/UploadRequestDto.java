package com.ftd.smartshare.dto;

import java.io.File;
import java.util.Date;


public class UploadRequestDto {
	
	private String fileName;
	private File file;
	private Date timeCreated;
	private int time;
	private int maxDownloads;
	private int totalDownloads;
	private String Password;
	
	
	public UploadRequestDto(){
		
				
	}
	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public Date getTimeCreated() {
		return timeCreated;
	}


	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public int getMaxDownloads() {
		return maxDownloads;
	}


	public void setMaxDownloads(int maxDownloads) {
		this.maxDownloads = maxDownloads;
	}


	public int getTotalDownloads() {
		return totalDownloads;
	}


	public void setTotalDownloads(int totalDownloads) {
		this.totalDownloads = totalDownloads;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}
	
    
}
