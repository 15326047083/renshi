package com.neusoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Post;
import com.neusoft.service.PostService;

/**
 * Servlet implementation class GetPostIdServlt
 */
public class GetPostIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		PostService postservice = new PostService();
		Post post = postservice.getinfo(id);
		String type=request.getParameter("type");
		
		//request.getRequestDispatcher("/page/post/updateinfo.jsp").forward(request, response);
		if("1".equals(type)){
			request.getSession().setAttribute("post", post);
			response.sendRedirect("page/post/updatepost.jsp");
		}
		//删除
		if("0".equals(type)){
			if(postservice.countPostEmp(id)>0){
				response.sendRedirect("page/post/postlist.jsp?delNum=1");
			}else{
				postservice.deletePost(id);
				response.sendRedirect("page/post/postlist.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
