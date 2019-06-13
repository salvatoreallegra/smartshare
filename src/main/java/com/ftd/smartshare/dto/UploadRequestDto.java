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
	private byte[] fileBytes;
	@XmlElement
	private Date timeCreated;
	@XmlElement
	private int timeTillExpiration;
	@XmlElement
	private int maxDownloads;
	@XmlElement
	private int totalDownloads;
	@XmlElement
	private String Password;
	
	
	public UploadRequestDto(){
		
		timeTillExpiration = 60;
			
				
	}
	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileBytes() {
		return fileBytes;
	}
	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

	


	public Date getTimeCreated() {
		return timeCreated;
	}


	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}


	public int getTimeTillExpiration() {
		return timeTillExpiration;
	}


	public void setTimeTillExpiration(int timeTillExpiration) {
		if((timeTillExpiration < 1) || (timeTillExpiration > 1440)) {
			throw new IllegalArgumentException();
		}
		this.timeTillExpiration = timeTillExpiration;
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
