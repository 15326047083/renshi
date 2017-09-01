<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.neusoft.entity.*" %>
<%@page import="com.neusoft.service.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="css/iconfont.css" />
<link rel="stylesheet" type="text/css" href="css/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>部门调换记录表</title>
</head>
<body>
	<%ChangeService changeservice = new ChangeService(); 
		DeptService deptservice=new DeptService();
		List<ChangeDept> list = changeservice.findAll();%> 
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 
		首页 <span class="c-gray en">&gt;</span> 
		员工信息 <span class="c-gray en">&gt;</span> 
		部门调换记录 
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive" >
		
		<caption><h3>部门调换记录表</h3></caption>
			<thead>
				<tr class="text-c" >
					
					<th width="80">编号</th>
					<th width="80">员工编号</th>
					<th>原工姓名</th>
					<th width="160">旧部门</th>
					<th width="160">当前部门</th>
					<th width="160">调换部门</th>
					
				</tr>
			</thead>
			<tbody>
			<%for(ChangeDept p:list) {%>
			<tr class="text-c">
			
				<td><%=p.getId() %></td>
				<td><%=p.getEmpid() %></td>
				<td><%=p.getEmpname() %></td>  	<!-- 用if语句改为汉字 -->
				<td><%=deptservice.findname(p.getOlddept()) %></td>
				<td><%=deptservice.findname(p.getNewdept()) %></td>	
				<td><%=p.getChangedate()%></td>
				</tr>
				</tbody>
		<%} %>
	 		
		 
	 	</table></div>
	 	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
		
		
		
		
		
		
			
		
	</table>
</body>
</html>