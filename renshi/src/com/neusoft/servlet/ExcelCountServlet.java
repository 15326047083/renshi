package com.neusoft.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Count;
import com.neusoft.entity.Emp;
import com.neusoft.service.CountService;
import com.neusoft.service.EmpService;
import com.neusoft.util.ExportExcelUtil;

/**
 * Servlet implementation class ExcelCountServlet
 */
public class ExcelCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		request.setCharacterEncoding("utf-8");
		String[] excelHeader = request.getParameterValues("export");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String month1;
		int monthe = Integer.parseInt(month)+1;
		if(monthe>0&&monthe<9) {
			month = "0"+month;
			month1 = "0"+monthe;
		}else {
			month1 = ""+monthe;
		}
		String s =year+"-"+month+"-01";
		String en =year+"-"+month1+"-01";
		java.sql.Date start = null;
		try {
			start = new java.sql.Date(df.parse(s).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date end = null;
		try {
			end = new java.sql.Date(df.parse(en).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CountService cs =new CountService();
		List<Count> list = null;
		try {
			list = cs.getAllService(start, end);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		ExportExcelUtil.export(response, "人事月报", excelHeader, list);
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
