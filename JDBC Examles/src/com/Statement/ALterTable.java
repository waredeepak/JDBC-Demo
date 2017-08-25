package com.Statement;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.Util.JdbcConnection;

public class ALterTable {

	public static void main(String[] args) throws SQLException {

		Connection connection = JdbcConnection.getConnection();
		String sql = "Alter table  student1 add pno varchar(20) after address ";
		Statement smt = connection.createStatement();
		int result = smt.executeUpdate(sql);
		if (result > 0) {
			System.out.println("sucessfully alter");
		} else {
			System.out.println("Failed");
		}

		connection.close();
		smt.close();

	}
}
