package com.PreparedStaement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Util.JdbcConnection;

public class UpdatedTable {

	public static void main(String[] args) {

		Connection con = JdbcConnection.getConnection();

		try {
			PreparedStatement ps = con
					.prepareStatement("update student set name=? where id=?");
			ps.setInt(2, 102);
			ps.setString(1, "Eknath");
			int result = ps.executeUpdate();

			if (result > 0) {
				System.out.println(" record is updated ");
			} else {
				System.out.println("could not update record");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
