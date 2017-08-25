package com.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Util.JdbcConnection;

public class SelectTable {

	public static void main(String[] args) {

		Connection connection = JdbcConnection.getConnection();
		String sql = "select * from student1";

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			System.out.println("Your Details");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " Name " + rs.getString(2)
						+ " Address " + rs.getString(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
