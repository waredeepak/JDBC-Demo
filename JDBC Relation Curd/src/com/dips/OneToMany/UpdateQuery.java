package com.dips.OneToMany;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateQuery 
{
	List<Address> alist=null;
	public static void main(String[] args) throws SQLException
	{
		List<Address> alist=new ArrayList<Address>();
		int result1=0;
		Student s=new Student();
		s.setSid(5);
		s.setSname("Vidya");
	
		Address a=new Address();
		//a.setAid(1);
		a.setAddress("Solapur");
		
		Address a1=new Address();
		//a1.setAid(7);
		a1.setAddress("Satara");
		
			
		alist.add(a);
		alist.add(a1);
			
		
		s.setAddr(alist);
	
		String sql="update student2 set sname='"+s.getSname()+"' where sid="+s.getSid()+"";
		
		
		int result=JdbcUtility.runQuery(sql);
		if(result>0)
		{
			
			ResultSet rs=null;
			String sql2="select aid from address where sid="+s.getSid()+"";
			rs=JdbcUtility.getResultSet(sql2);
			
			
			List<Address> addressList=s.getAddr();
			for (Address aa : addressList)
			{
				

				rs.next();
				
				a.setAid(rs.getInt(1));
				
				String sql1="update address  set address='"+aa.getAddress()+"' where sid="+s.getSid()+" and aid="+a.getAid()+"";
			    result1=JdbcUtility.runQuery(sql1);
			}
			
				if(result1>0)
				{
					System.out.println("update successfully");
				}
				else
				{
					System.out.println("update failed");
				}
		}
		
	}
	
	
	
}
