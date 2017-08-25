package com.Statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.Util.JdbcConnection;

public class UpdateTable {

	public static void main(String[] args) throws SQLException {

		Connection con = JdbcConnection.getConnection();
		String sql = "update student1 set name='ware' where id=101";
		Statement st = null;
		try {
			st = con.createStatement();
			int result = st.executeUpdate(sql);
			if (result > 0) {
				System.out.println("record is updated sucessfully ");
			} else {
				System.out.println("record is not executed");
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			st.close();
			con.close();
		}

	}
}
