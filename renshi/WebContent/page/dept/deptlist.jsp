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
<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 
	首页 <span class="c-gray en">&gt;</span> 
	部门管理 <span class="c-gray en">&gt;</span> 
	部门列表 
	<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
	<i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<% 
		List<Dept> list=null;
		DeptService deptservice=new DeptService(); 
		if("1".equals(request.getParameter("num"))){
			list=(List)request.getSession().getAttribute("list");
		}
		else{
			list=deptservice.findAll("");
		}
		
		List<Dept> querylist=deptservice.findAll("");
	%>
	<%
		if("1".equals(request.getParameter("delNum"))){
	%>	<span class="c-red"><h4>该部门下有员工，删除失败</h4></span>	<%} %>
	
	
	
<div class="page-container">
	<form action="${pageContext.request.contextPath}/QueryDeptServlet" method="POST">
		<div class="text-c">
			部门分类:<span class="select-box inline" >
			<select name="name" class="select" >
				<option selected="selected" value="1">请选择部门名称</option>
				<%for(Dept d:list){%>
				<option value="<%=d.getName() %>"><%=d.getName() %></option>
				<%}%>
			</select>
			</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			部门类型<span class="select-box inline" >
			<select name="type" class="select">
				<option selected="selected" value="2">请选择部门类型</option>
				<option value="公司">公司</option>
				<option value="部门">部门</option>
			</select>
			</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
		</div>
	</form>
	
	
	
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		 <span class="l">
		 	<a class="btn btn-primary radius" data-title="添加部门" data-href="article-add.html" href="newdept.jsp">
		 		<i class="Hui-iconfont">&#xe600;</i> 添加部门</a>
		 </span> 
		 <span class="r">共有数据：<strong><%=list.size()%></strong> 条</span> 
	</div>
	<div class="mt-20">

		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="40px">编号</th>
					<th width="80px">名称</th>
					<th width="60">类型</th>
					<th width="80">电话</th>
					<th width="80">传真</th>
					<th width="100">描述</th>
					<th width="80">上级部门</th>
					<th width="80">成立日期</th>
					<th width="120">操作</th>
				</tr>
			</thead>
	 		<%for(Dept u:list){%>
		 		<tbody>
					<tr class="text-c">
						<td><%=u.getId() %></td>
						<td class="text-l"><u style="cursor:pointer" class="text-primary" title="查看"><%=u.getName() %></u></td>
						<td><%=u.getType() %></td>
						<td><%=u.getPhone() %></td>
						<td><%=u.getFax() %></td>
						<td><%=u.getInfo() %></td>
						<td><%=u.getSdept() %></td>
						<td><%=u.getDate() %></td>
						<td class="f-14 td-manage">
							<a style="text-decoration:none" class="ml-5" href="deptEmplist.jsp?deptid=<%=u.getId() %>" title="下属员工">
							<i class="Hui-iconfont">&#xe62b;</i></a> 
							<a style="text-decoration:none" class="ml-5" href="update.jsp?deptid=<%=u.getId() %>" title="编辑">
							<i class="Hui-iconfont">&#xe6df;</i></a> 
							<a style="text-decoration:none" class="ml-5" onclick="delete()" href="${pageContext.request.contextPath}/DeptInfoServlet?id=<%=u.getId() %>" method="POST" title="删除">
							<i class="Hui-iconfont">&#xe6e2;</i></a>
						</td>
					</tr>
				</tbody>
	 		<%}%>
	 	</table>
	 </div>
	
</div>
</body>
</html>