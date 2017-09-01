package com.neusoft.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.service.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
//@WebServlet("/EmpDeleteServlet")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(request.getParameter("id"));
		EmpService es =new EmpService();
		try {
			es.deleteService(id);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("page/quit/quitAll.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
