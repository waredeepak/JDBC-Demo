package com.dips.OneToMany;

import java.sql.SQLException;


public class DeleteQuery
{
	public static Integer deleteById(Integer id)
	{
		Integer result=0;
		
		String query="delete from student2 where sid="+id;
		
		try {
			result=JdbcUtility.runQuery(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public static void main(String[] args)
	{
		Integer result=0;
		
	    result= deleteById(3);	
		if(result>0)
		{
			System.out.println("delete successfully");
		}
		else
		{
			System.out.println("please try again");
		}
		
	}
}
