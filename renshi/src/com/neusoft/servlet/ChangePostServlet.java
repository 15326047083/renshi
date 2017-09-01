package com.neusoft.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.neusoft.entity.ChangePost;
import com.neusoft.entity.Emp;
import com.neusoft.service.ChangeService;

/**
 * Servlet implementation class ChangePostServlet
 */
public class ChangePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int postid=Integer.parseInt(request.getParameter("post_id"));
		int empid=Integer.parseInt(request.getParameter("emp_id"));
	String empname = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		
		int oldpost=Integer.parseInt(request.getParameter("old_post"));

		ChangePost changepost=new ChangePost();
		changepost.setEmpid(empid);
		changepost.setEmpname(empname);
		changepost.setOldpost(oldpost);
		changepost.setNewpost(postid);
		Date date=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		changepost.setChangedate(df.format(date));
	
		Emp emp=new Emp();
		emp.setId(empid);
		emp.setPostId(postid);
		emp.setName(empname);
		ChangeService changeservice = new ChangeService();
		
		changeservice.changepost(emp);
		changeservice.addChangePost(changepost);
		
		request.getSession().setAttribute("emp", emp);
		response.sendRedirect("page/change/findemppost.jsp?num=2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
