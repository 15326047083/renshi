package com.neusoft.entity;

import java.util.Date;

public class ChangeDept {
	private int id;
	private int empid;
	private String empname;
	private int olddept;
	private int newdept;
	private String changedate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getOlddept() {
		return olddept;
	}
	public void setOlddept(int olddept) {
		this.olddept = olddept;
	}
	public int getNewdept() {
		return newdept;
	}
	public void setNewdept(int newdept) {
		this.newdept = newdept;
	}
	public String getChangedate() {
		return changedate;
	}
	public void setChangedate(String changedate) {
		this.changedate = changedate;
	}
	
	
}
