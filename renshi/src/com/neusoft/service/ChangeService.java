package com.neusoft.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.ChangeDao;
import com.neusoft.entity.ChangeDept;
import com.neusoft.entity.ChangePost;
import com.neusoft.entity.Emp;

public class ChangeService {
	/**
	 * 根据id找员工
	 * @param id
	 * @return
	 */
	public Emp findEmpDept(int id){
		ChangeDao changedao  = new ChangeDao();
	
		Emp emp = null;
		try {
			emp=changedao.findEmpDept(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	/**
	 * 根据name找员工
	 * @param id
	 * @return
	 */
	public Emp findEmpDept(String name){
		ChangeDao changedao  = new ChangeDao();
	
		Emp emp = null;
		try {
			emp=changedao.findEmpDept(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	/**
	 * 调换员工部门
	 * @param emp
	 */
	public void changedept(Emp emp){
		ChangeDao changedao  = new ChangeDao();
		try {
			changedao.changedept(emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addChangeDept(ChangeDept changedept) {
		ChangeDao changedao  = new ChangeDao();
		try {
			changedao.addChangeDept(changedept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取部门调换列表
	 * @return
	 * @throws SQLException
	 */
	public List findAll(){
		ChangeDao changedao  = new ChangeDao();
		List list =null;
		try {
			list=changedao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	/**
	 * 调换员工岗位
	 * @param emp
	 */
	public void changepost(Emp emp){
		ChangeDao changedao  = new ChangeDao();
		try {
			changedao.changepost(emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addChangePost(ChangePost changepost) {
		ChangeDao changedao  = new ChangeDao();
		try {
			changedao.addChangePost(changepost);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取部门调换列表
	 * @return
	 * @throws SQLException
	 */
	public List findAllpost(){
		ChangeDao changedao  = new ChangeDao();
		List list =null;
		try {
			list=changedao.findAllpost();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List findAllpostByTime(String start,String end){
		ChangeDao changedao  = new ChangeDao();
		List list =null;
		try {
			list=changedao.findAllpostByTime(start, end);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public List findAllDeptByTime(String start,String end){
		ChangeDao changedao  = new ChangeDao();
		List list =null;
		try {
			list=changedao.findAllByTime(start, end);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
