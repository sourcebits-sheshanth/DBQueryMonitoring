package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.entity.City;
import com.entity.Population;

public class JDBCExample {

	public static List<City> getDBDetails() throws SQLException, ClassNotFoundException {

		List<City> cityList = new ArrayList<>();
		Connection conn = JDBCConnection.getDBConn();

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

		// JSONArray array = new JSONArray(cityList);
		// System.out.println(array.toString());

		// obj.put("CityList", array);
		// System.out.println(obj.toString());

		System.out.println("Goodbye!");
		return cityList;
	}
	
	public static JSONArray getPopulationDetails() throws SQLException, ClassNotFoundException {

		List<Population> populationList = new ArrayList<>();
		Connection conn = JDBCConnection.getDBConn();

		// Execute a query
		System.out.println("Creating statement...");
		Statement stmt = conn.createStatement();

		String sql = "SELECT * FROM population";
		ResultSet rs = stmt.executeQuery(sql);

		// Extract data from result set
		while (rs.next()) {

			// Retrieve by column name
			int id = rs.getInt("id");
			int year = rs.getInt("year");
			int humans = rs.getInt("humans");

			// Store in an entity
			Population pop = new Population();
			pop.setId(id);
			pop.setYear(year);
			pop.setHumans(humans);;

			populationList.add(pop);

		}
		System.out.println(populationList);

		JSONArray array = new JSONArray(populationList);
		System.out.println(array.toString());

		// obj.put("CityList", array);
		// System.out.println(obj.toString());

		System.out.println("Goodbye!");
		return array;
	}

	
	public static String sayHello(String name) {
		return "Welcome Mr . " + name;
	}
	
}
