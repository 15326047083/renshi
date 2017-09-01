package com.neusoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.util.DBUtil;

/**
 * Servlet implementation class CheckDeptName
 */
public class CheckDeptNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter(); 
		String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		Connection conn = DBUtil.getConnection();
		String sql = "select count(name) from dept where name=? and dept_live=1"; 
		PreparedStatement pstmt = null;
		ResultSet  rs=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name); 
			rs = pstmt.executeQuery();
			if(rs.next()){ 
				if(rs.getInt(1)>0){//用户名已经存在了 
					out.write("true"); 
				}else{ 
					out.write("false"); 
				} 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
