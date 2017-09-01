package com.neusoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Emp;
import com.neusoft.service.ChangeService;

/**
 * Servlet implementation class FindEmpServlet
 */
public class FindEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empname=null;
		Emp emp= new Emp();
		int empid= 0;
	
		if(request.getParameter("emp_id") != ""){
			
			empid=Integer.parseInt(request.getParameter("emp_id"));
			
			ChangeService changeservice = new ChangeService();
			emp=changeservice.findEmpDept(empid);
			if(emp != null){
				request.getSession().setAttribute("emp", emp);
				response.sendRedirect("page/change/findemp.jsp?num=1");
			}
			else{
				response.sendRedirect("page/change/findemp.jsp?num=0");//不存在
			}
			
		}
		else{
			empname=new String(request.getParameter("emp_name").getBytes("iso-8859-1"),"utf-8");
			ChangeService changeservice = new ChangeService();
			emp=changeservice.findEmpDept(empname);
			if(emp != null){
				request.getSession().setAttribute("emp", emp);
				response.sendRedirect("page/change/findemp.jsp?num=1");
			}
			else{
				response.sendRedirect("page/change/findemp.jsp?num=0");//不存在
			}
		}
		 
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
