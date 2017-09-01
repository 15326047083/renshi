package com.neusoft.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Emp;
import com.neusoft.service.TryService;

/**
 * Servlet implementation class TryFindServlet
 */

public class TryFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Emp> list=null;
		if("".equals(request.getParameter("id"))){
			TryService ts = new TryService();
			list =ts.quarryAllService();
		}else{
			int id = Integer.parseInt(request.getParameter("id"));
			TryService ts = new TryService();
			list = ts.quarryAllByIdService(id);
		}
		request.getSession().setAttribute("list", list);
		response.sendRedirect("page/try/tryManager.jsp?num=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
