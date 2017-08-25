package com.dips.ManyToMany;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test2 {

	static Scanner sc = Scanner2.getS();
	
	
	public void insert() 
	{
		
		Student2 s1 = new Student2();
		s1.setSName("swapnil");
		Student2 s2 = new Student2();
		s2.setSName("rohit");

		Course2 c1 = new Course2();
		c1.setCName("java");
		Course2 c2 = new Course2();
		c2.setCName("oracle");
		Course2 c3 = new Course2();
		c3.setCName("android");

		ArrayList<Student2> sList = new ArrayList<Student2>();
		sList.add(s1);
		sList.add(s2); ///android
		
		c3.setAlc(sList);
		
		ArrayList<Course2> cList = new ArrayList<Course2>();
		cList.add(c1);
		cList.add(c2);
		cList.add(c3);
		
		
		ArrayList<Course2> cList1 = new ArrayList<Course2>();
		cList1.add(c3);
   
		s1.setAls(cList1);
		s2.setAls(cList1);
 
		ArrayList<Course2> clist2= new ArrayList<Course2>();
		clist2.add(c2);
		clist2.add(c3);
		s2.setAls(clist2);
		
		ArrayList<Student2> slist= new ArrayList<Student2>();
		slist.add(s2);
		c2.setAlc(slist);
		
		ArrayList<Course2> clist3= new ArrayList<Course2>();
			clist3.add(c1);
			clist3.add(c3);
	    	s1.setAls(clist3);
		
		ArrayList<Student2> slist1= new ArrayList<Student2>();
		slist1.add(s1);
		c1.setAlc(slist1);
		
		
		try {
			Connection connection = JdbcConnnection2.getConnection();
			Statement statement = connection.createStatement();
			for(Student2 s : sList)
			{
			
			int maxId = 0;
			int result = statement
					.executeUpdate("insert into student3(sname)values('"
							+ s.getSName() + "')");
			if (result > 0) {
				System.out.println("insert success ");
				ResultSet rs = statement
						.executeQuery("select max(sId) from student3");
				if (rs.next()) {
					maxId = rs.getInt(1);
					s.setSId(maxId);
				}
			} else {
				System.err.println("insert failure ");
			}
			}

			
			for (Course2 co : cList) {
				int maxxId = 0;
				int result2 = statement
						.executeUpdate("insert into course(cname)values('"
								+ co.getCName() + "')");
				if (result2 > 0) {
					ResultSet rs3 = statement
							.executeQuery("select max(cId) from course");

					if (rs3.next()) {
						System.out.println("insert success ");
						maxxId = rs3.getInt(1);
						co.setCId(maxxId);
					}
				} else {
					System.err.println("insert failure ");
				}
			}
			
			for (Student2 stu : sList) {
				for (Course2 cou : stu.getAls()) {

				int result4 = statement
						.executeUpdate("insert into student_course(sid,cid)values("
							+ stu.getSId() + "," + cou.getCId() + ")");
				if (result4 > 0) {
					System.out.println("insert success ");
				} else {
					System.err.println("insert failure ");
				}

			}
		}
	}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
  public void displayInfo() 
	{
		try{
		Connection connection = JdbcConnnection2.getConnection();
		Statement statement = connection.createStatement();
		
		ArrayList<Student2> alStu= new ArrayList<Student2>();
		ResultSet rs = statement.executeQuery("select * from student3");
		
		while (rs.next()) {
			Student2 s= new Student2();
			s.setSId(rs.getInt(1));
			s.setSName(rs.getString(2));
			alStu.add(s);
		}
		
		 ArrayList<Course2> alCou= new ArrayList<Course2>();
	 		ResultSet rs1 = statement.executeQuery("select * from course");
			
			while (rs1.next()) {
				Course2 c= new Course2();
				c.setCId(rs1.getInt(1));
				c.setCName(rs1.getString(2));
				alCou.add(c);
			}
		
			ArrayList<Student2> alStud= new ArrayList<Student2>();
			for(Student2 student2: alStu){
				
				String sql="select c.cname from course c, student3 s, student_course sc where c.cid=sc.cid and s.sid=sc.sid and sc.sid="+student2.getSId()+"";
				ResultSet rs2 = statement.executeQuery(sql);
				
				 ArrayList<Course2> arrayList= new ArrayList<Course2>();
				while (rs2.next()) {
					Course2 c= new Course2();
					c.setCName(rs2.getString(1));
					arrayList.add(c);
				}
				student2.setAls(arrayList);
				alStud.add(student2);
				
			}
		
		 for(Student2 st:alStud){
			
				
				System.out.println(st.getSId() + "    " + st.getSName());

				for (Course2 course : st.getAls()) {
					
					System.out.println(course.getCName());

				}
				
			 
		 }
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateStudent() {

		Student2 st= new Student2();
		System.out.println("insert student-id for update name in STUDENT table");
		st.setSId(sc.nextInt());
		System.out.println("insert student-name to update in STUDENT table");
		st.setSName(sc.next());
		try {
			Connection connection = JdbcConnnection2.getConnection(); // getting
																// connection-2

			String sql = "update student3 set sname=? where sid=?";
			PreparedStatement ps = connection.prepareStatement(sql); // create
																// statement

			ps.setString(1, st.getSName());
			ps.setInt(2, st.getSId());
			
			

			boolean result = ps.execute();

			if (result == false) {
				System.out.println("update success");
			} else {
				System.err.println("update failure");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

		
	public void updateCourse() {

		Course2 course= new Course2();
		System.out.println("insert course-id for update name in COURSE table");
		course.setCId(sc.nextInt());
		System.out.println("insert course-name to update in COURSE table");
		course.setCName(sc.next());
		try {
			Connection connection = JdbcConnnection2.getConnection(); // getting
																// connection-2

			String sql = "update course set cname=? where cid=?";
			PreparedStatement ps = connection.prepareStatement(sql); // create
																// statement

			ps.setString(1, course.getCName());
			ps.setInt(2, course.getCId());
			
			

			boolean result = ps.execute();

			if (result == false) {
				System.out.println("update success");
			} else {
				System.err.println("update failure");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	 
	public void deleteStudent() {

		Student2 st1= new Student2();
		System.out.println("insert student-id to delete student information");
		st1.setSId(sc.nextInt());
		
		try {
			Connection connection = JdbcConnnection2.getConnection(); // getting
																// connection-2

			String sql = "delete from student3 where sid=?";
			PreparedStatement ps = connection.prepareStatement(sql); // create
																// statement

			ps.setInt(1, st1.getSId());

			boolean result = ps.execute();

			if (result == false) {
				System.out.println("delete success");
			} else {
				System.err.println("delete failure");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
		
		
	


public static void main(String[] args) {
	
	Test2 t= new Test2();
	
	//t.insert();
	//t.displayInfo();
    t.updateStudent();
	//t.updateCourse();
	//t.deleteStudent();
	
}
}

	
	
	

