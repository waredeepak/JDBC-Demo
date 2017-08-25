package com.Statement;

import java.sql.*;

import com.Util.JdbcConnection;

public class DropTable {

	public static void main(String[] args) throws SQLException {

		Connection connection = JdbcConnection.getConnection();

		String sql = "drop table student1";
		try {
			Statement s = connection.createStatement();
			int result = s.executeUpdate(sql);

			if (result > 0) {
				System.out.println("Table is droped");
			} else
				System.out.println("Table already Droped");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();

		}

	}
}
