package com.dips.OneToOne;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertOperation
{
	public static void main(String[] args) throws SQLException 
	{
		int max=0;
		ResultSet rs=null;
		boolean result=false;
		Student s=new Student();
		//s.setSid(2);
		s.setSname("Deepak");
		College c=new College();
		//c.setCid(2);
		c.setCname("IMSIT");
		s.setC(c);
		String sql="insert into student values("+s.getSid()+",'"+s.getSname()+"')";
	    result=JdbcUtility.insertOperation(sql);
		if(result==false)
		{
			
			String sql1="select max(sid) from student";
			rs=JdbcUtility.getResultSet(sql1);
			if(rs.next())
			{
				max=rs.getInt(1);
			}
			String sql2="insert into college values("+max+",'"+c.getCname()+"')";
			
			result=JdbcUtility.insertOperation(sql2);
			if(result==false)
			{
				System.out.println("inserted Successfully");
			}
		}
		
	}
}
