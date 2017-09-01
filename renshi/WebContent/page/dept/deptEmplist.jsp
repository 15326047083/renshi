<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.neusoft.service.*"%>
<%@page import="java.util.List"%>
<%@page import="com.neusoft.entity.*"%>
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
	<%
	DeptService deptservice=new DeptService();
	int id=Integer.parseInt(request.getParameter("deptid"));
	List<Emp> list=deptservice.fingEmpById(id);
	%>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 
		首页 <span class="c-gray en">&gt;</span> 
		部门管理 <span class="c-gray en">&gt;</span> 
		部门列表 
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i></a>
		<a class="btn btn-primary radius r" style="line-height:1.6em;margin-top:3px" onclick="history.back();" title="返回" >
		<i class="Hui-iconfont">&#xe678;</i></a>
	</nav>
	<div class="mt-20">
	<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
 			<caption>员工管理</caption>
 			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="deptitem" value=""/></th>
					<th width="80">编号</th>
					<th>姓名</th>
					<th width="120">性别</th>
					<th width="250">员工生日</th>
				</tr>
			</thead>
 		<%for(Emp e:list){%> 
 			<tbody>
 				<tr>
 					<td><input type="checkbox" value="<%=e.getId()%>" name="empitem"/></td>
 					<td><%=e.getId() %></td>
 					<td><%=e.getName() %></td>
 					<td><%=e.getSex() %></td>
 					<td><%=e.getBirthday() %></td>
 				</tr>

 			</tbody>
 			<%}%>

	 </table>
	 </div>
</body>
</html>