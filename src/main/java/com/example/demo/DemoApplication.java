package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Starting spring boot app");


		try {
			Class.forName("org.postgresql.Driver");
		}
		catch (java.lang.ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		String url = "jdbc:postgresql://horton.elephantsql.com:5432/ctlaqrup";
		String username = "ctlaqrup";
		String password = "n-eCEw5jU6RPDGmzBnYVliH-uIxcmm4s";

		try {
			Connection db = DriverManager.getConnection(url, username, password);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("select * from simpleTable");
			rs.close();

		}
		catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}

		SpringApplication.run(DemoApplication.class, args);
	}
}
