package com.DatabaseMetaData;

import java.sql.*;


import com.Util.JdbcConnection;

public class DtataBaseMetaData {

	public static void main(String[] args) {

		try {
			Connection con = JdbcConnection.getConnection();

			DatabaseMetaData dbmd = con.getMetaData();

			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			System.out.println("UserName: " + dbmd.getUserName());
			System.out.println("Database Product Name: "
					+ dbmd.getDatabaseProductName());
			System.out.println("Database Product Version: "
					+ dbmd.getDatabaseProductVersion());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
