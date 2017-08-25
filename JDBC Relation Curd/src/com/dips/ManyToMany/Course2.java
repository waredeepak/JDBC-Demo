package com.dips.ManyToMany;

import java.util.ArrayList;

public class Course2 {

	private int cId;
	private String cName;
	private ArrayList<Student2> alc;
	
	
	public int getCId() {
		return cId;
	}
	public void setCId(int cId) {
		this.cId = cId;
	}
	public String getCName() {
		return cName;
	}
	public void setCName(String cName) {
		this.cName = cName;
	}
	public ArrayList<Student2> getAlc() {
		return alc;
	}
	public void setAlc(ArrayList<Student2> alc) {
		this.alc = alc;
	}
	
	
	
	
}
