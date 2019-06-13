package com.ftd.smartshare.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;





public class UploadDao implements BaseDao {

	public void insertFile(String fileName, byte[] bytes, Long minutes, int MaxDownloads, int totalDownloads, String Password) {

		try (Connection connection = getConnection()) {
			
			
			LocalDateTime param = LocalDateTime.now();
			LocalDateTime expiration = LocalDateTime.now();
			expiration.plusMinutes(minutes);
			
			
			 PreparedStatement stmt = connection.prepareStatement("Insert Into Files (file_name,file,time_created,expiry_time,max_downloads,total_downloads,password) Values (?,?,?,?,?,?,?)");
			 
	            stmt.setString(1, fileName);
	            stmt.setBytes(2, bytes);
	            stmt.setTimestamp(3, Timestamp.from(param.toInstant(ZoneOffset.UTC)));
	            stmt.setTimestamp(4, Timestamp.from(expiration.toInstant(ZoneOffset.UTC)));
	            stmt.setInt(5, MaxDownloads);
	            stmt.setInt(6, totalDownloads);
	            stmt.setString(7, Password);
	            
	            stmt.executeUpdate();
	            

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

