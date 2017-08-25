package com.Statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.Util.JdbcConnection;

public class Deletetable {

	public static void main(String[] args) {

		Connection connection = JdbcConnection.getConnection();

		String sql = "delete from student1";
		Statement st;
		try {
			st = connection.createStatement();
			int result = st.executeUpdate(sql);
			System.out.println(result);
			if (result > 0) {
				System.out.println("Record is deleted Sucessfully");
			} else {
				System.out.println("Could not delete the Table");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
