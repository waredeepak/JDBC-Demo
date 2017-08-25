package com.dips.OneToOne;

import java.sql.SQLException;

public class DeleteOperation
{
	public static void deleteStudentById(Integer id) throws SQLException
 	{
		String sql="delete  from student where sid="+id;
		int result=JdbcUtility.runQuery(sql);
		if(result>0)
		{
			System.out.println("successfully deleted");
		}
		else
		{
			System.out.println("try again");
		}
 	}
	
	public static void main(String[] args) throws SQLException {
		
		deleteStudentById(3);
		
		
	}
}
