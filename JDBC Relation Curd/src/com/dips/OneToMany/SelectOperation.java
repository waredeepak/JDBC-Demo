package com.dips.OneToMany;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectOperation {
	public static void main(String[] args) throws SQLException {
		List<Address> al;
		List<Student> studentList = getStudentList();

		for (Student ss : studentList) {

			System.out.println(ss.getSid());
			System.out.println(ss.getSname());

			al = new ArrayList();
			al = ss.getAddr();
			for (Address address : al) {
				System.out.println(address.getAddress());
			}
		}
	}

	public static List<Student> getStudentList() throws SQLException {
		ResultSet rs = null;

		List<Address> alist = null;
		Student s;
		Address a;
		String sql = "select * from student2";
		List<Student> slist = new ArrayList();
		rs = JdbcUtility.getResultSet(sql);

		while (rs.next()) {
			System.out.println("in while");
			s = new Student();
			s.setSid(rs.getInt(1));

			s.setSname(rs.getString(2));

			String sql1 = "select * from address where sid='" + s.getSid()
					+ "'";
			ResultSet rs1 = JdbcUtility.getResultSet(sql1);
			alist = new ArrayList();
			while (rs1.next()) {
				a = new Address();

				a.setAid(rs1.getInt(1));
				a.setAddress(rs1.getString(2));
				alist.add(a);
			}
			s.setAddr(alist);

			slist.add(s);
			/*
			 * for (Student s1 : slist) {
			 * 
			 * }
			 */
		}
		return slist;
	}

}
