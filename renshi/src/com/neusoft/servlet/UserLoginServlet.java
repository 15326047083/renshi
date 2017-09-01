package com.neusoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		UserService userservice=new UserService();		
		int count=userservice.getCountUsername(username);
		if(count==1){
			String sqlPassword=userservice.getPassword(username);
			if("".equals(sqlPassword)){
				response.sendRedirect("index.jsp?num=false");
			}else{
				if(sqlPassword.equals(password)){
					response.sendRedirect("index2.jsp?num=true&name="+username);
				}else{
					response.sendRedirect("index.jsp?num=false");
				}
			}
		}else{
			response.sendRedirect("index.jsp?num=false");
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
