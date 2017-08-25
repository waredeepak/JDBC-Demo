package com.Statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.Util.JdbcConnection;

public class InsertTable {

	public static void main(String[] args) {

		Connection connection = JdbcConnection.getConnection();
		String sql = "insert into student1 (id,name,address) values(102,'Prashant','Pune')";
		try {
			Statement st = connection.createStatement();
			int result = st.executeUpdate(sql);
			if (result > 0) {
				System.out.println("record is inserted sucessfully");
			} else {
				System.out.println("Record is not executed sucesfully");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
