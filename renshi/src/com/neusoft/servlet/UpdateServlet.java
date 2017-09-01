package com.neusoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Post;
import com.neusoft.service.PostService;

/**
 * Servlet implementation class UpdateServlt
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String postname = new String(request.getParameter("postname").getBytes("iso-8859-1"),"utf-8");
		int posttype = Integer.parseInt(request.getParameter("posttype"));
		int maxep = Integer.parseInt(request.getParameter("maxep"));
		Post post = new Post();
		post.setId(id);
		post.setPostname(postname);
		post.setPosttype(posttype);
		post.setMaxep(maxep);
		PostService postservice = new PostService();
		postservice.updatePost(post);
		System.out.println(postname);
		request.getSession().setAttribute("post", post);
		response.sendRedirect("page/post/postlist.jsp");
		//request.getRequestDispatcher("/page/post/userinfo.jsp").forward(request, response);
		//response.sendRedirect("page/post/userinfo.jsp");
	}

}
