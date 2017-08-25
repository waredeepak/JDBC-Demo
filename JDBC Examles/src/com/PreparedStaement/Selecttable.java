package com.PreparedStaement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Util.JdbcConnection;

public class Selecttable {
	
	public static void main(String[] args) {
		
		
		Connection connection=JdbcConnection.getConnection();
		
		try {
			PreparedStatement ps=connection.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			System.out.println(" Student Details is:");
			System.out.println(" ID    NAME     Address");
		    System.out.println("------------------------");
			while(rs.next())
			{
				System.out.println(" "+rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
