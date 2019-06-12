package com.ftd.smartshare.dto;

import java.io.File;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Field")
@XmlAccessorType(XmlAccessType.FIELD)
public class DownloadRequestDto {
	
	@XmlElement
	private String password;
	@XmlElement
	private File file;
	@XmlElement
	private String fileName;
	
	public DownloadRequestDto() {}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
