package com.neusoft.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Emp;
import com.neusoft.service.EmpService;
import com.neusoft.util.ExportExcelUtil;

/**
 * Servlet implementation class ExcelNewServlet
 */

public class ExcelNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		request.setCharacterEncoding("utf-8");
		String[] excelHeader = request.getParameterValues("export");
		java.sql.Date start = null;
		try {
			start = new java.sql.Date(df.parse(request.getParameter("start")).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date end = null;
		try {
			end = new java.sql.Date(df.parse(request.getParameter("end")).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String dept = request.getParameter("dept");
		EmpService es = new EmpService();
		List<Emp> list = es.selectNewService(dept, start, end);
		try {
		ExportExcelUtil.export(response, "新聘员工报表", excelHeader, list);
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
