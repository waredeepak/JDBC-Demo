package com.PreparedStaement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Util.JdbcConnection;

public class Createtable {

	public static void main(String[] args) throws SQLException {

		Connection connection = JdbcConnection.getConnection();

		String sql = "create table Student (id int(10)primary key,name varchar(10),address varchar(10))";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println(" Table is created in database");
			} else {
				System.out.println("Table is already created");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			connection.close();
		}

	}

}
