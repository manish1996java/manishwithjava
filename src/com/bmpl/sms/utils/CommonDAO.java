package com.bmpl.sms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDAO {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		ResourceBundle rb = ResourceBundle.getBundle("config"); 
		
		Class.forName(rb.getString("driver"));
		con = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));
		
		return con;
	}
}
