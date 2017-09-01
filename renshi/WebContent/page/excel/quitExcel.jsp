<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ page import="com.neusoft.service.DeptService" %>
      <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
      <%@ page import="com.neusoft.entity.Dept" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css" href="css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="css/iconfont.css" />
<link rel="stylesheet" type="text/css" href="css/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 
		首页 <span class="c-gray en">&gt;</span> 
		报表管理<span class="c-gray en">&gt;</span> 
		离职员工报表 
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<%
	DeptService ds = new DeptService();
	List<Dept> dept =ds.findAll("");
	%>
	<form action="${pageContext.request.contextPath }/ExcelQuitServlet" method = "post">
		<div class="text-c">
			<span class="select-box inline" id="s">
			         开始日期<input type="date" name="start" />
			         结束日期<input type="date" name="end"/>
			</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button name="" id="bbb" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe640;

</i> 导出</button>
		</div>
		<br/>
		<br/>
	<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">	
		<tr class="text-c">
			<td>部门名称
				<select name="dept" ">
           		 <%for(Dept d:dept){
            		%>
            		<option value="<%=d.getName()%>"><%=d.getName() %></option>
            		<%
          		  }%>
           	 	</select>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="工号#id" name="export" checked="checked"></span>
 					<input type="text" value="工号" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="姓名#name" name="export" checked="checked"></span>
 					<input type="text" value="姓名" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="性别#sex" name="export" checked="checked"></span>
 					<input type="text" value="性别" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="出生日期#birthday" name="export" checked="checked"></span>
 					<input type="text" value="出生日期" disabled="disabled">
				</div>
			</td>
		</tr>
		<tr class="text-c">
			<td>
				<div>
    				<span><input type="checkbox" value="身份证号#idNum" name="export" checked="checked"></span>
 					<input type="text" value="身份证号" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="部门名称#deptName" name="export" checked="checked"></span>
 					<input type="text" value="部门名称" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="岗位名称#postName" name="export" checked="checked"></span>
 					<input type="text" value="岗位名称" disabled="disabled">
				</div>
			</td>

			<td>
				<div>
    				<span><input type="checkbox" value="正式入职日期#workDate" name="export" checked="checked"></span>
 					<input type="text" value="正式入职日期" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="试用期入职日期#hiredate" name="export" checked="checked"></span>
 					<input type="text" value="试用期入职日期" disabled="disabled">
				</div>
			</td>
		</tr>
		<tr class="text-c">
			<td>
				<div>
    				<span><input type="checkbox" value="用工形式#empForm" name="export" checked="checked"></span>
 					<input type="text" value="用工形式" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="用工来源#empSources" name="export" checked="checked"></span>
 					<input type="text" value="用工来源" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="政治面貌#politicalOutlook" name="export" checked="checked"></span>
 					<input type="text" value="政治面貌" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="民族#nation" name="export" checked="checked"></span>
 					<input type="text" value="民族" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="籍贯#nativePlace" name="export" checked="checked"></span>
 					<input type="text" value="籍贯" disabled="disabled">
				</div>
			</td>
		</tr>
		<tr class="text-c">
			<td>
				<div>
    				<span><input type="checkbox" value="电子邮件#email" name="export" checked="checked"></span>
 					<input type="text" value="电子邮件" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="身高#height" name="export" checked="checked"></span>
 					<input type="text" value="身高" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="血型#bloodType" name="export" checked="checked"></span>
 					<input type="text" value="血型" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="婚姻状态#maritalStatus" name="export" checked="checked"></span>
 					<input type="text" value="婚姻状态" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="出生地#homeplace" name="export" checked="checked"></span>
 					<input type="text" value="出生地" disabled="disabled">
				</div>
			</td>
		</tr>
		<tr class="text-c">
			<td>
				<div>
    				<span><input type="checkbox" value="户口所在地#registeredResidence" name="export" checked="checked"></span>
 					<input type="text" value="户口所在地" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="最高学历#highestEducation" name="export" checked="checked"></span>
 					<input type="text" value="最高学历" disabled="disabled">
				</div>
			</td>

			<td>
				<div>
    				<span><input type="checkbox" value="毕业学校#graduationSchool" name="export" checked="checked"></span>
 					<input type="text" value="毕业学校" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="所学专业#major" name="export" checked="checked"></span>
 					<input type="text" value="所学专业" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="毕业日期#graduationDate" name="export" checked="checked"></span>
 					<input type="text" value="毕业日期" disabled="disabled">
				</div>
			</td>
		</tr>
		<tr class="text-c">
			<td>
				<div>
    		 		<span><input type="checkbox" value="职业信息#workInfo" name="export" checked="checked"></span>
 			 		<input type="text" value="职业信息" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="外语信息#foreignLanguagesInfo" name="export" checked="checked"></span>
 					<input type="text" value="外语信息" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="家庭信息#familyInfo" name="export" checked="checked"></span>
 					<input type="text" value="家庭信息" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="联系电话#tel" name="export" checked="checked"></span>
 					<input type="text" value="联系电话" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
				</div>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>