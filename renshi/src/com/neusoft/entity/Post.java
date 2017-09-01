package com.neusoft.entity;

public class Post {
	/**
	 * 岗位id
	 */
	private int id;    
	/**
	 * 岗位名称
	 */
	private String postname;
	/**
	 * 岗位类型： 1管理，2技术，3营销，4市场, 5财务
	 */
	private int posttype;
	/**
	 * 岗位编制（最多员工数）
	 */
	private int maxep;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostname() {
		return postname;
	}
	public void setPostname(String postname) {
		this.postname = postname;
	}
	public int getPosttype() {
		return posttype;
	}
	public void setPosttype(int posttype) {
		this.posttype = posttype;
	}
	public int getMaxep() {
		return maxep;
	}
	public void setMaxep(int maxep) {
		this.maxep = maxep;
	}
	
	
}
