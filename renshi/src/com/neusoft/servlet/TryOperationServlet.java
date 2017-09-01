package com.neusoft.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.service.TryService;

/**
 * Servlet implementation class TryOperationServlet
 */
public class TryOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int flag = Integer.parseInt(request.getParameter("operation"));
		int id = Integer.parseInt(request.getParameter("id"));
		java.sql.Date workdate = null;

		TryService ts = new TryService();
		if(flag==1) {
			ts.tryPassService(id);
		}else if(flag==2) {		
			try {
				workdate = new java.sql.Date(df.parse(request.getParameter("emp_workdate")).getTime());
			} catch (ParseException e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ts.changeWorkDate(id, workdate);
		}else {
			ts.tryQuitService(id);
		}
		response.sendRedirect("page/try/tryManager.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
