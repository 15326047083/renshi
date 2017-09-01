package com.neusoft.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Post;
import com.neusoft.service.PostService;

/**
 * Servlet implementation class EpInPostServlt
 */
public class EpInPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int posttype = Integer.parseInt(request.getParameter("posttype"));
		PostService postservice = new PostService();
		List<Post> list=null;
		if(posttype==0){
			list=postservice.findAll();
		}else{
			list=postservice.emInPost(posttype);
		}
		request.getSession().setAttribute("list", list);
		response.sendRedirect("page/post/querypostlist.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
