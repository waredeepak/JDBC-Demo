package com.dips.OneToMany;

import java.util.List;

public class Student 
{
	
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
	public List<Address> getAddr() {
		return addr;
	}
	public void setAddr(List<Address> addr) {
		this.addr = addr;
	}
	private String sname;
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", sid=" + sid + ", addr=" + addr
				+ "]";
	}
	private int sid;
	List<Address> addr;
}
