package com.neusoft.service;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.neusoft.dao.EmpDao;
import com.neusoft.entity.Emp;

public class EmpService {
	public void registByTalentService(Emp e) {
		EmpDao ed = new EmpDao();
		try {
			ed.registByTalent(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public ArrayList<Emp> quarryAllService(){
		EmpDao ed = new EmpDao();
		ArrayList<Emp> list =null;
		try {
			list = ed.QuarryAllDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Emp> quarryAllByIdService(int id){
		EmpDao ed = new EmpDao();
		ArrayList<Emp> list =null;
		try {
			list = ed.QuarryAllByIdDao(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Emp> quarryAllQuitService(){
		EmpDao ed = new EmpDao();
		ArrayList<Emp> list =null;
		try {
			list = ed.QuarryAllQuitDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void deleteService(int id) throws ParseException {
		EmpDao ed = new EmpDao();
		try {
			ed.deleteDao(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Emp selectAllService(int id) {
		EmpDao ed = new EmpDao();
		Emp e = null;
		try {
			e = ed.selectAllDao(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
	public void updateService(Emp e) {
		EmpDao ed =new EmpDao();
		try {
			ed.updataDao(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public ArrayList<Emp> selectNewService(String dept,Date start,Date end){
		EmpDao ed = new EmpDao();
		ArrayList<Emp> list =null;
		try {
			list = ed.SelectAllByDeptDao(dept, start, end);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Emp> selectQuitService(String dept,Date start,Date end){
		EmpDao ed = new EmpDao();
		ArrayList<Emp> list =null;
		try {
			list = ed.SelectAllQuitByDeptDao(dept, start, end);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Emp selectAllQuitService(int id){
		EmpDao ed = new EmpDao();
		Emp e = null;
		try {
			e = ed.selectAllQuitService(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
}
