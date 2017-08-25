package com.AddBatchExample;

import java.sql.*;

public class BatchDemo1 {

	Connection con;
	Statement stmt;

	public BatchDemo1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/JDBC1?user=root&password=root");
		} catch (Exception e) {
			System.out.println("Error in connection" + e);
		}
	}

	// Create table in database server
	public void createTable() {
		try {
			String sql1 = "drop table if exists Student";
			String sql = "create table Student(rollNo int primary key, Name varchar(30), Dob varchar(20), Course varchar(20))";

			// drop the table if exists
			stmt = con.createStatement();
			stmt.executeUpdate(sql1);

			// execute SQL statement to create table statement
			stmt = con.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println("Table created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void batchProcess() {
		try {
			stmt.addBatch("insert into Student values(1,'Ram Kumar','10-02-1990','BTech')");

			stmt.addBatch("insert into Student values(2,'Shayam Kumar','15-05-1992','BTech')");

			stmt.addBatch("insert into Student values(3,'Ritu Kumari','4-07-1989','MCA')");

			stmt.addBatch("insert into Student  values(4,'Suman Saurabh','12-12-1995','MCA')");

			stmt.addBatch("insert into Student  values(5,'Suresh Sharma','10-11-1991','BTech')");
			int i[] = stmt.executeBatch();
			for (int j : i) {
				if (j != 0)
					System.out.println("Executed successfully");
				else
					System.out.println("Not Executed successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showRecords() {
		try {
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from Student");
			while (res.next()) {
				System.out.print(res.getString(1));
				System.out.print("\t" + res.getString(2));
				System.out.print("\t" + res.getString(3));
				System.out.println("\t" + res.getString(4));
			}
		} catch (Exception e) {
			System.out.println("Error in fetching data" + e);
		}
	}

	public static void main(String[] args) {
		BatchDemo1 obj = new BatchDemo1();
		obj.createTable();
		obj.batchProcess();
		obj.showRecords();
	}
}