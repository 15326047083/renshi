package com.neusoft.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neusoft.dao.TryDao;
import com.neusoft.entity.Emp;

public class TryService {
	public void registTryService(Emp e) {
		TryDao td = new TryDao();
		try {
			td.registTryDao(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void changeWorkDate(int id,Date date) {
		TryDao td =new TryDao();
		try {
			td.changeWorkDateDao(id, date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void tryPassService(int id) {
		TryDao td = new TryDao();
		try {
			td.tryPassDao(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void tryQuitService(int id) {
		TryDao td = new TryDao();
		try {
			td.tryQuitDao(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Emp> quarryAllService(){
		TryDao td =new TryDao();
		ArrayList<Emp> list =null;
		try {
			list = td.QuarryAllDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Emp> quarryAllByIdService(int id){
		TryDao td =new TryDao();
		ArrayList<Emp> list =null;
		try {
			list = td.QuarryAllByIdDao(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
