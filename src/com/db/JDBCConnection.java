package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.City;

public class JDBCConnection {

	private static Connection conn = null;

	private JDBCConnection(){
	}
	
	public static Connection getDBConn() {

		if(conn != null) return conn;
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://52.221.233.113:3306/Development";

		//Database credentials
		String USER = "stocksapp";
		String PASS = "#StocksApp#";

		//Register JDBC driver
		try {
			Class.forName(JDBC_DRIVER);

			//Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}
}
