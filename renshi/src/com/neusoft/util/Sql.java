package com.neusoft.util;

public class Sql {
	public static String addInfo="insert into EMP_BASIC_INFO set emp_name=?,emp_sex=?,emp_birthday=?,emp_id_num=?,emp_dept=?,hiredate=?,work_date=?,emp_form=?,emp_sources=?,political_outlook=?,nation=?,native_place=?,tel=?,email=?,height=?,blood_type=?,marital_status=?,homepalce=?,registered_residence=?,highest_education=?,graduation_school=?,major=?,graduation_date=?,post_id=?,work_info=?,foreign_languages_info=?,family_info=?,is_quit=?,is_period=?";
	public static String getMaxId = "select max(emp_id) from EMP_BASIC_INFO";
	public static String getDeptId = "select id from dept where name=? and dept_live=1";
	public static String getPostId = "select post_id from post where post_name=? and post_live=1";
	public static String deleteInfo = "update EMP_BASIC_INFO set is_quit=1,hiredate=? where emp_id=?";
	public static String updateInfo = "update EMP_BASIC_INFO set emp_name=?,emp_sex=?,emp_birthday=?,emp_id_num=?,emp_dept=?,hiredate=?,work_date=?,emp_form=?,emp_sources=?,political_outlook=?,nation=?,native_place=?,tel=?,email=?,height=?,blood_type=?,marital_status=?,homepalce=?,registered_residence=?,highest_education=?,graduation_school=?,major=?,graduation_date=?,post_id=?,work_info=?,foreign_languages_info=?,family_info=?,is_quit=?,is_period=? where emp_id=?";
	public static String selectIdByName = "select emp_id from EMP_BASIC_INFO where emp_name=? and is_quie=0";//不确定用没用
	public static String selectAll = "select * from EMP_BASIC_INFO where emp_id=? and is_quit=0";
	public static String selectDeptName = "select name from dept where id=? and dept_live=1";
	public static String selectPostName = "select post_name from post where post_id=? and post_live=1";
	public static String quarryAll = "select * from EMP_BASIC_INFO where is_quit=0 and is_period=0";
	public static String quarryAllById = "select * from EMP_BASIC_INFO where is_quit=0 and emp_id=? and is_period=0";
	public static String quarryAllQuit = "select * from EMP_BASIC_INFO where is_quit=1";
	public static String addTry="insert into emp_try set emp_id=?,emp_name=?,try_start=?,try_end=?";
	public static String changeWorkDate = "update emp_try t,EMP_BASIC_INFO e set t.try_end=?,e.work_date=? where t.emp_id=? and e.emp_id=?";
	public static String tryPass = "update emp_try t,EMP_BASIC_INFO e set t.is_pass=1,e.is_period=0 where t.emp_id=? and e.emp_id=?";
	public static String tryQuit = "update emp_try t,EMP_BASIC_INFO e set t.is_quit=1,e.is_quit=1 where t.emp_id=? and e.emp_id=?";
	public static String quarryTry = "select * from emp_try where is_quit=0 and is_pass=0";
	public static String quarryTryById = "select * from emp_try where emp_id=? and is_quit=0 and is_pass=0";
	public static String selectNewByDept = "select * from EMP_BASIC_INFO where work_date>? and work_date<? and emp_dept=? and is_quit=0 and is_period=0";
	public static String selectQuit = "select * from EMP_BASIC_INFO where hiredate>? and hiredate<? and emp_dept=? and is_quit=1 ";
	public static String selectAllQuitService="select * from EMP_BASIC_INFO where emp_id=? and is_quit=1";
	
	public static String selectStartNum1 ="select count(emp_id) from EMP_BASIC_INFO where is_quit=0 and work_date<? and emp_dept=?";
	public static String selectStartNum2 ="select count(emp_id) from EMP_BASIC_INFO where is_quit=1 and hiredate>? and work_date>? and emp_dept=?";
	public static String selectNewNum ="select count(emp_id) from EMP_BASIC_INFO  where is_quit=0 and work_date<? and work_date>=? and emp_dept=?";
	public static String selectChangeIn="select count(emp_id) from change_dept where new_dept_id=? and change_date<? and change_date>=?";
	public static String selectChangeOut="select count(emp_id) from change_dept where old_dept_id=? and change_date<? and change_date>=?";
	public static String selectQuitNum = "select count(emp_id) from EMP_BASIC_INFO where hiredate<? and hiredate>=? and is_quit=1 and emp_dept=?";
}
