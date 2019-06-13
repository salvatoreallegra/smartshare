package com.ftd.smartshare.dto;

import java.io.File;
import java.time.LocalDateTime;
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
	private long minutes;
	@XmlElement
	private int maxDownloads;
	@XmlElement
	private int totalDownloads;
	@XmlElement
	private String Password;
	
	
	public UploadRequestDto(){
		
			minutes = 60l;	
				
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

	


	


	public long getTimeTillExpiration() {
		return minutes;
	}


	public void setTimeTillExpiration(long minutes) {
		
	
		this.minutes = minutes;
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
