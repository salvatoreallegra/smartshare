package com.ftd.smartshare.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.cooksys.jdbc.data.enitity.Major;



public class UploadDao implements BaseDao {

	public void insertFile(String fileName, byte[] bytes, Date timeCreated, int timeTillExpiration, int MaxDownloads, int totalDownloads) {

		try (Connection connection = getConnection()) {
			 PreparedStatement stmt = connection.prepareStatement("Insert Into Files (file_name,file,time_created,expiry_time,max_downloads,total_downloads,password) Values (?,?,?,?,?,?,?");
			 
	            stmt.setString(1, fileName);
	            stmt.setBytes(2, bytes);
	            stmt.setDate(3, (java.sql.Date) timeCreated);
	            stmt.setInt(4, timeTillExpiration);
	            stmt.setInt(5, MaxDownloads);
	            stmt.setInt(6, totalDownloads);
	            
	            stmt.executeUpdate();
	            

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

