package com.Statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.Util.JdbcConnection;

public class CreateTable {

	public static void main(String[] args) throws SQLException {
		
		String sql = "create table student1 (id int(10) primary key,name varchar(20),address varchar(20))";
		Connection connection = JdbcConnection.getConnection();
		Statement smt = connection.createStatement();
		boolean result = true;
		result = smt.execute(sql);
		if (result == false) {
			System.out.println("successfully created");
		} else {
			System.out.println("not created table");
		}
		connection.close();
		smt.close();
	}
}
