package com.ResulesetMetaData;

import com.Util.JdbcConnection;

import java.sql.*;

public class ResultSetMetaData {
	public static void main(String[] args) {

		try {
			Connection con = JdbcConnection.getConnection();

			PreparedStatement ps = con
					.prepareStatement("select * from customer");

			ResultSet rs = ps.executeQuery();

			java.sql.ResultSetMetaData m = rs.getMetaData();
			System.out.println("Total columns: " + m.getColumnCount());
			System.out.println("Column Name of 1st column: "
					+ m.getColumnName(1));
			System.out.println("Column Type Name of 1st column: "
					+ m.getColumnTypeName(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}