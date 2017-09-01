package com.neusoft.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.service.ChangeService;
import com.neusoft.util.ExportExcelUtil;

/**
 * Servlet implementation class ExcelDeptServlet
 */

public class ExcelDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String[] excelHeader = request.getParameterValues("export");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		ChangeService cs = new ChangeService();
		List list = cs.findAllDeptByTime(start, end);
		try {
			ExportExcelUtil.export(response, "部门调动员工报表", excelHeader, list);
			} catch (Exception e) {
				e.printStackTrace();
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
