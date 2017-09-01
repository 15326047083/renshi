package com.neusoft.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Dept;
import com.neusoft.service.DeptService;

/**
 * Servlet implementation class NewDeptSrvlet
 */
public class NewDeptSrvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		String type=new String(request.getParameter("type").getBytes("iso-8859-1"),"utf-8");
		String phone=request.getParameter("phone");
		
		String fax=request.getParameter("fax"); 
		String info=new String(request.getParameter("info").getBytes("iso-8859-1"),"utf-8");
		String sdept=new String(request.getParameter("sdept").getBytes("iso-8859-1"),"utf-8");
		Date date=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		df.format(date);
		Dept dept=new Dept();
		dept.setId(id);
		dept.setName(name);
		dept.setType(type);
		dept.setPhone(phone);
		dept.setFax(fax);
		dept.setInfo(info);
		dept.setSdept(sdept);
		dept.setDate(df.format(date));
		DeptService deptservice=new DeptService();
		deptservice.NewDept(dept);
		List list=deptservice.findAll("");
		request.getSession().setAttribute("list", list);
		/*request.getRequestDispatcher("/page/dept/deptlist.jsp?num=1").forward(request, response);*/
		response.sendRedirect("page/dept/deptlist.jsp?num=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
