package com.SimpleCurd;

import com.Util.JdbcConnection;

import java.sql.*;

public class Employee {

	Connection con = JdbcConnection.getConnection();
	PreparedStatement ps;

	public void insertEmp(String code, String name, String city, int sal) {
		try {

			ps = con.prepareStatement("insert into Emp values(?,?,?,?)");
			ps.setString(1, code);
			ps.setString(2, name);
			ps.setString(3, city);
			ps.setInt(4, sal);
			int i = ps.executeUpdate();
			if (i != 0) {
				System.out.println("Inserted");
			} else {
				System.out.println("not Inserted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateEmp(String code, String city, int salary) {
		try {
			ps = con.prepareStatement("update emp set city=?,sal=sal+? where code=?");
			ps.setString(1, city);
			ps.setInt(2, salary);
			ps.setString(3, code);
			int i = ps.executeUpdate();
			if (i != 0) {
				System.out.println("updated");
			} else {
				System.out.println("not updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteEmp(String code) {
		try {
			ps = con.prepareStatement("delete from emp where code=?");
			ps.setString(1, code);
			int i = ps.executeUpdate();
			if (i != 0) {
				System.out.println("deleted");
			} else {
				System.out.println("not deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dispAnEmp(String s) {
		try {
			ps = con.prepareStatement("select * from Emp where code=?");
			ps.setString(1, s);
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				System.out.print(res.getString(1));
				System.out.print(res.getString(2));
				System.out.print(res.getString(3));
				System.out.println(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dispAll() {
		try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select * from emp");
			while (res.next()) {
				System.out.print(" Code: " + res.getString(1));
				System.out.print("Name :" + res.getString(2));
				System.out.print("address: " + res.getString(3));
				System.out.println(" salary :" + res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
