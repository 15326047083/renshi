package com.neusoft.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.CountDao;
import com.neusoft.dao.DeptDao;
import com.neusoft.dao.EmpDao;
import com.neusoft.entity.Count;
import com.neusoft.entity.Dept;

public class CountService {
	public List<Count> getAllService(Date start,Date end) throws SQLException{
		List<Count> list =null;
		list = new ArrayList<Count>();
		CountDao cd = new CountDao();
		DeptDao dd = new DeptDao();
		Count c = null;
		List<Dept> dl = dd.findAll("");
		for(int i=0;i<dl.size();i++) {
			c = new Count();
			String deptName = dl.get(i).getName();
			int deptId = dl.get(i).getId();
			int firstNum = cd.getStartNum1Dao(start, deptId)+cd.getStartNum2Dao(start, deptId);
			int newNum = cd.getNewNumDao(start, end, deptId);
			int quitNum = cd.getQuitNum(start, end, deptId);
			int thisIn = cd.getInNum(start, end, deptId);
			int thisOut = cd.getOutNum(start, end, deptId);
			int endNum = firstNum+newNum+thisIn-quitNum-thisOut;
			c.setDeptName(deptName);
			c.setFirstNum(firstNum);
			c.setEndNum(endNum);
			c.setNewNum(newNum);
			c.setQuitNum(quitNum);
			c.setThisIn(thisIn);
			c.setThisOut(thisOut);
			list.add(c);
		}
		return list;
	}
}
