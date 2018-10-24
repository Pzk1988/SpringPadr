package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
//@ComponentScan("model")
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Starting spring boot app");
		SpringApplication.run(DemoApplication.class, args);
	}
}












//		try {
//			Class.forName("org.postgresql.Driver");
//		}
//		catch (java.lang.ClassNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//
//		String url = "jdbc:postgresql://horton.elephantsql.com:5432/ctlaqrup";
//		String username = "ctlaqrup";
//		String password = "n-eCEw5jU6RPDGmzBnYVliH-uIxcmm4s";
//
//		try {
//			Connection db = DriverManager.getConnection(url, username, password);
//			Statement st = db.createStatement();
//			ResultSet rs = st.executeQuery("select * from simpleTable");
//			rs.close();
//
//		}
//		catch (java.sql.SQLException e) {
//			System.out.println(e.getMessage());
//		}