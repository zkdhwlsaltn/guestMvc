package com.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static Connection conn=null;
	
	public static Connection getConnection() {     // Connection conn=ConnectionProvider.getConnection();
		
		try {
			// id, pass 확인하세요.
			String url="jdbc:oracle:thin:@localhost:1521:system";
			String id="sys as sysdba";
			String pass="system";
			conn=DriverManager.getConnection(url, id, pass);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
