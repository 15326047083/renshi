package com.neusoft.service;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.dao.DeptDao;
import com.neusoft.entity.Dept;
import com.neusoft.entity.Emp;

public class DeptService {
	public void NewDept(Dept dept){
		DeptDao deptdao=new DeptDao();
		try {
			deptdao.NewDept(dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int selectMaxId(){
		DeptDao deptdao=new DeptDao();
		int id=0;
		try {
			id=deptdao.selectMaxId();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	public List findAll(String sql1){
		DeptDao deptdao=new DeptDao();
		List<Dept> list=null;
		try {
			list=deptdao.findAll(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Dept findInfo(int id) {
		DeptDao deptdao=new DeptDao();
		Dept dept=new Dept();
		try {
			dept=deptdao.findInfo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept;
	}
	public void updateDept(Dept dept) {
		// TODO Auto-generated method stub
		DeptDao deptdao=new DeptDao();
		try {
			deptdao.updateDept(dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delDept(int id) {
		// TODO Auto-generated method stub
		DeptDao deptdao=new DeptDao();
		try {
			deptdao.delDept(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int findId(String name){
		DeptDao deptdao=new DeptDao();
		int id=0;
		id=deptdao.findId(name);
		return id;
	}
	public List fingEmpById(int id){
		DeptDao deptdao=new DeptDao();
		List<Emp> list=null;
		list=deptdao.fingEmpById(id);
		return list;
	}
	public String findname(int id){
		DeptDao deptdao=new DeptDao();
		String name=null;
		try {
			name = deptdao.findname(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	public int countDeptEmp(int id) {
		// TODO Auto-generated method stub
		int num=0;
		DeptDao deptdao=new DeptDao();
		num=deptdao.countDeptEmp(id);
		return num;
	}
}
