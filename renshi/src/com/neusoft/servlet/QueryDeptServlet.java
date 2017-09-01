package com.neusoft.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.service.DeptService;

/**
 * Servlet implementation class QueryDeptServlet
 */
public class QueryDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		String type=new String(request.getParameter("type").getBytes("iso-8859-1"),"utf-8");

		String sql1="";
		if("1".equals(name)){
			if("2".equals(type)){
				sql1="";
			}
			else{
				sql1=" and type="+"'"+type+"'";
			}
		}else{
			if("2".equals(type)){
				sql1=" and name='"+name+"'";
			}
			else{
				sql1=" and name='"+name+"' and type='"+type+"'";
			}
		}
		
		DeptService deptservice=new DeptService();
		List list=deptservice.findAll(sql1);
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
