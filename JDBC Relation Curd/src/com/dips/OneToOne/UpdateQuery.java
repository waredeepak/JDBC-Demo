package com.dips.OneToOne;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateQuery 
{
	
	public static void main(String[] args) throws SQLException 
	{
		int max=0;
		ResultSet rs=null;
		Student s=new Student();
		College c=new College();
		s.setSid(3);
		s.setSname("pravin");
		//c.setCid(1);
		c.setCname("BNCOE");
		c.setS(s);
		s.setC(c);
		System.out.println(s.getSid());
		String sql="update student set sname='"+s.getSname()+"'where sid="+s.getSid();
		int result=JdbcUtility.runQuery(sql);
		System.out.println(result);
		if(result>0)
		{
			String sql1="select max(sid) from student";
		rs=	JdbcUtility.getResultSet(sql1);
			if(rs.next())
			{
				 max=rs.getInt(1);
			}
			
			String sql2="update college set cid="+max+" ,cname='"+c.getCname()+"'";
			
			result=JdbcUtility.runQuery(sql2);
			if(result>0)
			{
				System.out.println("succsessfully updated");
			}
			else
			{
				System.out.println("try again");
			}
			
		}
	}
}
