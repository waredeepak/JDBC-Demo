package com.PreparedStaement;

import java.sql.*;

import com.Util.JdbcConnection;

public class InsertTable {

	public static void main(String[] args) {

		Connection connection = JdbcConnection.getConnection();
		// String sql =
		// "insert into student (id,name,address) values(101,'Deepak','osmanabad')";

		/*
		 * try { PreparedStatement ps = connection.prepareStatement(sql); int
		 * result = ps.executeUpdate(); if (result > 0) {
		 * System.out.println("record is insered"); } else
		 * System.out.println("could not insert record");
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, 102);
			ps.setString(2, "Prashant");
			ps.setString(3, "satya");

			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("record is inserted sucessfully");
			} else
				System.out.println("could not insert record");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
