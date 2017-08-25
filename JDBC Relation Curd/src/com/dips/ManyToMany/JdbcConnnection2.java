package com.dips.ManyToMany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnnection2 {

	

	public static Connection connection = null;
	private static final String URL="jdbc:mysql://localhost:3306/jdbc";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");                    //load driver
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);   //getting connection-1
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}}
