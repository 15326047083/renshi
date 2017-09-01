package com.neusoft.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Emp;
import com.neusoft.service.EmpService;

/**
 * Servlet implementation class EmpFindServlet
 */

public class EmpFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmpService es = new EmpService();
		List<Emp> list =null;
		if("".equals(request.getParameter("id"))){
			list=es.quarryAllService();
		}else{
			int id = Integer.parseInt(request.getParameter("id"));
			list = es.quarryAllByIdService(id);
		}
		request.getSession().setAttribute("list", list);
		response.sendRedirect("page/quit/quitAll.jsp?num=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
