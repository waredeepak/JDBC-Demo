package com.dips.OneToMany;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertOperation
{
	public static void main(String[] args) throws SQLException {
		ResultSet rs=null;
		int max=0;
		boolean result=false;
		List<Address> alist = new ArrayList();
		List<Address> al=new ArrayList();
		Student s=new Student();
		
		s.setSname("abc");
	    
		Address a=new Address();
		
		a.setAddress("pune");
		
		Address a1=new Address();
		
		a1.setAddress("Nanded");
		
		alist.add(a);
		alist.add(a1);
		
		s.setAddr(alist);
		
		String sql="insert into student2(sname) values('"+s.getSname()+"')";
	result=	JdbcUtility.insertOperation(sql);
		if(result==false)
		{
			String sql1="select max(sid) from student2";
			rs=JdbcUtility.getResultSet(sql1);
			if(rs.next())
			{
				 max=rs.getInt(1);
			}
			for(Address aa:alist)
			{
			
			String sql2="insert into address(address,sid) values('"+aa.getAddress()+"',"+max+")";
			
			result=JdbcUtility.insertOperation(sql2);
			if(result==false)
			{
				
				System.out.println("successfully inserted");
			}
			
			}
			
		}
			
	}
}
