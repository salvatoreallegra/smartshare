package com.ftd.smartshare.data.dao;

import java.sql.Connection;

import com.ftd.smartshare.data.JDBCConnectionFactory;

public interface BaseDao {

	default Connection getConnection() {
		return JDBCConnectionFactory.getInstance().getConnection();

	}
}
