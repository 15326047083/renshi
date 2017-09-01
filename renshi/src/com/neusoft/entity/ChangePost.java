package com.neusoft.entity;

public class ChangePost {
	private int id;
	private int empid;
	private String empname;
	private int oldpost;
	private int newpost;
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
	public int getOldpost() {
		return oldpost;
	}
	public void setOldpost(int oldpost) {
		this.oldpost = oldpost;
	}
	public int getNewpost() {
		return newpost;
	}
	public void setNewpost(int newpost) {
		this.newpost = newpost;
	}
	public String getChangedate() {
		return changedate;
	}
	public void setChangedate(String changedate) {
		this.changedate = changedate;
	}
	private String changedate;
	
}
