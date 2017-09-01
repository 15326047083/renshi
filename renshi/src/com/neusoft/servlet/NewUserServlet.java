package com.neusoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.User;
import com.neusoft.service.UserService;

/**
 * Servlet implementation class NewUserServlet
 */
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String problem=new String(request.getParameter("problem").getBytes("iso-8859-1"),"utf-8");
		String answer=new String(request.getParameter("answer").getBytes("iso-8859-1"),"utf-8");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setProblem(problem);
		user.setAnswer(answer);
		UserService userservice=new UserService();
		userservice.newUser(user);
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
