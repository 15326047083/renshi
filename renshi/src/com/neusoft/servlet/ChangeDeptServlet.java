package com.neusoft.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.ChangeDept;
import com.neusoft.entity.Emp;
import com.neusoft.service.ChangeService;

/**
 * Servlet implementation class ChangeDeptServlet
 */
public class ChangeDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int deptid=Integer.parseInt(request.getParameter("dept_id"));
		int empid=Integer.parseInt(request.getParameter("emp_id"));
	String empname = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		
		int olddept=Integer.parseInt(request.getParameter("old_dept"));

		ChangeDept changedept=new ChangeDept();
		changedept.setEmpid(empid);
		changedept.setEmpname(empname);
		changedept.setOlddept(olddept);
		changedept.setNewdept(deptid);
		Date date=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		changedept.setChangedate(df.format(date));
	
		Emp emp=new Emp();
		emp.setId(empid);
		emp.setDeptId(deptid);
		emp.setName(empname);
		ChangeService changeservice = new ChangeService();
		changeservice.changedept(emp);
		changeservice.addChangeDept(changedept);
		request.getSession().setAttribute("emp", emp);
		response.sendRedirect("page/change/findemp.jsp?num=2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
