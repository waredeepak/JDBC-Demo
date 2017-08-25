package com.AggregateFunction;

import java.sql.*;

import com.Util.JdbcConnection;

public class Test {

	public static void main(String[] args) {

		try {
			Connection con = JdbcConnection.getConnection();

			// String sql="select max(salary) from student1";
			// String sql="select count(salary) from student1";
			// String sql="select sum(salary) from student1";
			// String sql="select avg(salary) from student1";

			String sql = "select min(salary) from student1";

			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
