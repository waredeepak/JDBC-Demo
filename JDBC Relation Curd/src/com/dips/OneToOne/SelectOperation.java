package com.dips.OneToOne;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectOperation 
{
	
	
	public static void main(String[] args) throws SQLException
	{
		Student s=new Student();
		College c=new College();
		ResultSet rs=null;
		String sql="select * from student s,college c where s.sid=c.cid";
		
		rs=JdbcUtility.getResultSet(sql);
		while(rs.next())
		{
			s.setSid(rs.getInt(1));
			s.setSname(rs.getString(2));
			c.setCid(rs.getInt(3));
			c.setCname(rs.getString(4));	
			s.setC(c);
			c.setS(s);
		}
		
		System.out.println("Sid     "+"Sname    "+"Cid    "+"Cname   ");
		System.out.print(s.getSid());
		System.out.print("     "+s.getSname());
		System.out.print("     "+c.getCid());
		System.out.println("     "+c.getCname());
	}	
	
}
