package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.JSONArray;

import com.entity.*;


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
			pop.setHumans(humans);
			;

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

	public static JSONArray graph() {

		List<Plot> list = new ArrayList<Plot>();
		Plot plot1 = new Plot();
		plot1.setCount(70);

		plot1.setDates("2016-10-03 00:00:00 ");

		Plot plot2 = new Plot();
		plot2.setCount(600);
		plot2.setDates("2016-10-20 00:00:00");

		Plot plot3 = new Plot();
		plot3.setCount(40000);
		plot3.setDates("2016-10-21 00:00:00");

		list.add(plot1);
		list.add(plot2);
		list.add(plot3);
		JSONArray array = new JSONArray(list);

		System.out.println(array.toString());

		return array;

	}

	public static JSONArray getPopulationDetails2() {

		List<Population> list = new ArrayList<Population>();
		Population p1 = new Population();
		p1.setYear(1990);
		p1.setHumans(200);

		Population p2 = new Population();
		p2.setYear(1995);
		p2.setHumans(300);

		Population p3 = new Population();
		p1.setYear(1998);
		p1.setHumans(280);

		Population p4 = new Population();
		p1.setYear(2004);
		p1.setHumans(400);

		list.add(p1);
		list.add(p2);
		list.add(p3);
		JSONArray array = new JSONArray(list);

		System.out.println(array.toString());

		return array;

	}

	public static String sayHello(String name) {
		return "Welcome Mr . " + name;
	}

	public static void sendMail() {

		String to = "xyz@gmail.com"; // Send to whom?

		// Configuration for Gmail Server
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("abc@gmail.com.com", "password"); // enter
																					// gmail
																					// credintials
			}
		});

		// Go to below link
		// https://www.google.com/settings/security/lesssecureapps?rfn=27&rfnc=1&et=0&asae=2&anexp=ire-control
		// Access for less secure apps
		// Turn off
		// Turn on (select this)

		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("abc@gmail.com")); // From
																	// Address
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Hello");
			message.setText("Testing.......");

			// send message
			Transport.send(message);

			System.out.println("message sent successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
