package com.dips.OneToMany;

public class Address
{
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private int aid;
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", address=" + address + ", getAid()="
				+ getAid() + ", getAddress()=" + getAddress() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	private String address;
	private Student sid;
	public Student getSid() {
		return sid;
	}
	public void setSid(Student sid) {
		this.sid = sid;
	}
}
