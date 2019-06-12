package com.ftd.smartshare.dto;

import java.io.File;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Field")
@XmlAccessorType(XmlAccessType.FIELD)
public class UploadRequestDto {
	
	@XmlElement
	private String fileName;
	@XmlElement
	private File file;
	@XmlElement
	private Date timeCreated;
	@XmlElement
	private int time;
	@XmlElement
	private int maxDownloads;
	@XmlElement
	private int totalDownloads;
	@XmlElement
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
