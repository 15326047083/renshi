package com.neusoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.service.UserService;

/**
 * Servlet implementation class FindPasswordServlet
 */
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String problem=new String(request.getParameter("problem").getBytes("iso-8859-1"),"utf-8");
		String answer=new String(request.getParameter("answer").getBytes("iso-8859-1"),"utf-8");
		UserService userservice=new UserService();
		String []anquan=userservice.findPassword(username);
		if(problem.equals(anquan[0])&&answer.equals(anquan[1])){
			response.sendRedirect("regist/newPassword.jsp?num=true&username="+username);
		}else{
			response.sendRedirect("regist/findPassword.jsp?num=false");
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
