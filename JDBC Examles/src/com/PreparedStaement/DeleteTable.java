package com.PreparedStaement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Util.JdbcConnection;

public class DeleteTable {

	public static void main(String[] args) {

		Connection connection = JdbcConnection.getConnection();

		try {
			PreparedStatement ps = connection
					.prepareStatement("delete from student ");
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("Table is deleted sucessfully");
			} else {
				System.out.println("could not delete record");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}