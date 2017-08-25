package com.SimpleCurd;
import java.sql.*;

import com.Util.JdbcConnection;
public class OracleConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con=JdbcConnection.getConnection();
		System.out.println("connection sucessful");
		
		System.out.println(con.toString());
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from students");
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getInt(5));
			System.out.println(rs.getString(6));
			System.out.println(rs.getDate(7));
			System.out.println(rs.getString(8));
			System.out.println(" ******************** ");
		}
		
		
		
	}
}
