package com.neusoft.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Emp;
import com.neusoft.service.EmpService;

/**
 * Servlet implementation class EmpUpdateServlet
 */
//@WebServlet("/EmpUpdateServlet")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = new String(request.getParameter("emp_name").getBytes("iso-8859-1"),"utf-8");
		String sex = new String(request.getParameter("emp_sex").getBytes("iso-8859-1"),"utf-8");
		java.sql.Date birthday = null;
		try {
			birthday = new java.sql.Date(df.parse(request.getParameter("emp_birthday")).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String idNum = request.getParameter("idNum");
		String deptName = new String(request.getParameter("emp_dept").getBytes("iso-8859-1"),"utf-8");
		String postName = new String(request.getParameter("emp_post").getBytes("iso-8859-1"),"utf-8");
		java.sql.Date hiredate = null;
		try {
			hiredate = new java.sql.Date(df.parse(request.getParameter("hiredate")).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date empDate =null;
		try {
			empDate = new java.sql.Date(df.parse(request.getParameter("emp_date")).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int empForm = Integer.parseInt(request.getParameter("emp_form"));
		int empSources = Integer.parseInt(request.getParameter("emp_sources"));
		int politicalOutlook = Integer.parseInt(request.getParameter("Political_outlook"));
		String nation = new String(request.getParameter("nation").getBytes("iso-8859-1"),"utf-8");
		String nativePlace = new String(request.getParameter("native_place").getBytes("iso-8859-1"),"utf-8");
		String tel = new String(request.getParameter("tel").getBytes("iso-8859-1"),"utf-8");
		String email = new String(request.getParameter("email").getBytes("iso-8859-1"),"utf-8");
		double height = 0.00;
		String h = request.getParameter("height");
		if("".equals(h)){
			height = 0.00;
		}else{
			height = Double.parseDouble(h);
		}
	 
		int bloodType = Integer.parseInt(request.getParameter("Blood_type"));
		int maritalStatus = Integer.parseInt(request.getParameter("Marital_status"));
		String homeplace = new String(request.getParameter("homeplace").getBytes("iso-8859-1"),"utf-8");
		String registeredResidence = new String(request.getParameter("Registered_residence").getBytes("iso-8859-1"),"utf-8");
		int highestEducation = Integer.parseInt(request.getParameter("highest_edu"));
		String graduationSchool = new String(request.getParameter("Graduation_school").getBytes("iso-8859-1"),"utf-8");
		String major = new String(request.getParameter("major").getBytes("iso-8859-1"),"utf-8");
		java.sql.Date graduationDate =null;
		try {
			graduationDate = new java.sql.Date(df.parse(request.getParameter("graduation_date")).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String foreignLanguagesInfo = new String(request.getParameter("foreignLanguagesInfo").getBytes("iso-8859-1"),"utf-8");
		String familyInfo = new String(request.getParameter("familyInfo").getBytes("iso-8859-1"),"utf-8");
		String workInfo = new String(request.getParameter("workInfo").getBytes("iso-8859-1"),"utf-8");
		Emp e = new Emp();
		e.setId(id);
		e.setName(name);
		e.setSex(sex);
		e.setBirthday(birthday);
		e.setIdNum(idNum);
		e.setDeptName(deptName);
		e.setPostName(postName);
		e.setHiredate(hiredate);
		e.setWorkDate(empDate);
		e.setEmpForm(empForm);
		e.setEmpSources(empSources);
		e.setPoliticalOutlook(politicalOutlook);
		e.setNation(nation);
		e.setNativePlace(nativePlace);
		e.setTel(tel);
		e.setEmail(email);
		e.setHeight(height);
		e.setBloodType(bloodType);
		e.setMaritalStatus(maritalStatus);
		e.setHomeplace(homeplace);
		e.setRegisteredResidence(registeredResidence);
		e.setHighestEducation(highestEducation);
		e.setGraduationSchool(graduationSchool);
		e.setMajor(major);
		e.setGraduationDate(graduationDate);
		e.setForeignLanguagesInfo(foreignLanguagesInfo);
		e.setFamilyInfo(familyInfo);
		e.setWorkInfo(workInfo);
		EmpService es = new EmpService();
		es.updateService(e);
		response.sendRedirect("page/emp/admin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
