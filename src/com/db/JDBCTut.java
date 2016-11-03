/*package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.City;

public class JDBCTut {

	public static void main(String[] args) throws Exception {

		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://127.0.0.1:3306/stockdb2";

		// Database credentials
		String USER = "root";
		String PASS = "root";

		Connection conn;
		// Register JDBC driver
		try {
			Class.forName(JDBC_DRIVER);

			// Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<City> cityList = new ArrayList<>();
		conn = JDBCConnection.getDBConn();

		// Execute a query
		System.out.println("Creating statement...");
		Statement stmt = conn.createStatement();

		String sql = "SELECT * FROM City";
		ResultSet rs = stmt.executeQuery(sql);

		// Extract data from result set
		while (rs.next()) {

			// Retrieve by column name
			int id = rs.getInt("id");
			Double map = rs.getDouble("map");
			String country = rs.getString("country");
			String name = rs.getString("name");
			String state = rs.getString("state");

			// Store in an entity
			City city = new City();
			city.setId(id);
			city.setCountry(country);
			city.setMap(map);
			city.setName(name);
			city.setState(state);

			cityList.add(city);

		}
		System.out.println(cityList);
		System.out.println("Goodbye!");

	}
}
*/