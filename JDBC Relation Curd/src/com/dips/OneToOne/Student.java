package com.dips.OneToOne;


public class Student 
{
	private int sid;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public College getC() {
		return c;
	}
	public void setC(College c) {
		this.c = c;
	}
	private String sname;
	private College c;
}
