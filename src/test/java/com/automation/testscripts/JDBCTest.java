package com.automation.testscripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class JDBCTest {
	
	@Test
	public void jdbcTest() throws Exception {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql ", "root", "root");
		Statement statement =	connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select host,user from user");
		
		while(resultSet.next()) {
			System.out.print(resultSet.getString("host") + "\t");
			System.out.println(resultSet.getString("user"));
		}
		
		connection.close();
		
	}

}
