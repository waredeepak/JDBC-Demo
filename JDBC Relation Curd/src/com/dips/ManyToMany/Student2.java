package com.dips.ManyToMany;

import java.util.ArrayList;



public class Student2 {
	
	private int sId;
	private String sName;
	private ArrayList<Course2> als;
	
	
	public int getSId() {
		return sId;
	}
	public void setSId(int sId) {
		this.sId = sId;
	}
	
	public String getSName() {
		return sName;
	}
	public void setSName(String sName) {
		this.sName = sName;
	}
	
	public ArrayList<Course2> getAls() {
		return als;
	}
	public void setAls(ArrayList<Course2> als) {
		this.als = als;
	}
	
	
	
	
	
	
}
