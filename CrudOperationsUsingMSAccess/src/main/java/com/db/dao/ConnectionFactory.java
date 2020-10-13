package com.db.dao;

import java.sql.*;

public class ConnectionFactory {

	public static Connection getConnection() {
		try {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return DriverManager.getConnection("jdbc:ucanaccess://E:/ms access/db.accdb");
		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}
	}
}
