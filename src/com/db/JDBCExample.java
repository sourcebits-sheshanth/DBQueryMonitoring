package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.City;

public class JDBCExample {

	public static List<City> getDBDetails() throws SQLException, ClassNotFoundException {

		List<City> cityList = new ArrayList<>();
		Connection conn = JDBCConnection.getDBConn();

		//Execute a query
		System.out.println("Creating statement...");
		Statement stmt = conn.createStatement();

		String sql = "SELECT * FROM City";
		ResultSet rs = stmt.executeQuery(sql);

		//Extract data from result set
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

		// JSONArray array = new JSONArray(cityList);
		// System.out.println(array.toString());

		// obj.put("CityList", array);
		// System.out.println(obj.toString());

		System.out.println("Goodbye!");
		return cityList;
	}
}
