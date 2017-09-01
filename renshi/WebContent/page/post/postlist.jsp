<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.neusoft.entity.Post" %>
<%@page import="com.neusoft.service.*" %>
<%@page import="java.util.*" %>
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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 岗位管理 <span class="c-gray en">&gt;</span> 岗位列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<%PostService postservice = new PostService(); 
		List<Post> list = postservice.findAll();%>
	<%
		if("1".equals(request.getParameter("delNum"))){%>
			
			 <span class="c-red"><h4>岗位下有员工，删除失败</h4></span>
		<%}%>	
	
<div class="page-container">
<form action="${pageContext.request.contextPath}/EpInPostServlet" method="POST">
	<div class="text-c">
岗位分类:&nbsp;
	 <span class="select-box inline" >
		<select name="posttype" class="select" >
			<option value="0">请选择岗位类型</option>
			<option value="1">管理</option>
			<option value="2">技术</option>
			<option value="3">营销</option>
			<option value="4">市场</option>
			<option value="5">财务</option>
		</select>
		</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--  日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" class="input-text Wdate" style="width:120px;"> 
		<input type="text" name="" id="" placeholder=" 资讯名称" style="width:250px" class="input-text"> -->
		<button name="" id="" class="btn btn-success" type="submit" ><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
	</div>
</form>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	<a class="btn btn-primary radius" data-title="添加部门" data-href="addpost.jsp" onclick="Hui_admin_tab(this)" href="addpost.jsp"><i class="Hui-iconfont">&#xe600;
	</i>
	 添加岗位</a></span>  <span class="r">共有数据：<strong><%=list.size() %></strong> 条</span> </div>
	 
	<div class="mt-20">
	<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive" border="1" width="800px"  cellspacing="0" align="center">
		<thead>
			<tr class="text-c">
				<th width="80">编号</th>
				<th>名称</th>
				<th width="150">岗位类型</th>
				<th width="150">岗位编制</th>
				
				<th width="120">操作</th>
			</tr>
		</thead>
		
		
		
		<tbody>
		<%for(Post p:list) {%>
			<tr class="text-c">
				<td><%=p.getId() %></td>
				<td><%=p.getPostname() %></td>
				<%if(p.getPosttype()==1) {%>
					<td>管理</td><%} %>
				<%if(p.getPosttype()==2) {%>
					<td>技术</td><%} %>
				<%if(p.getPosttype()==3) {%>
					<td>营销</td><%} %>
				<%if(p.getPosttype()==4) {%>
					<td>市场</td><%} %>
				<%if(p.getPosttype()==5) {%>
					<td>财务</td><%} %>
				<td><%=p.getMaxep() %></td>	
				<td class="f-14 td-manage">
					<a style="text-decoration:none" class="ml-5" href="postemplist.jsp?postid=<%=p.getId() %>" title="下属员工"><i class="Hui-iconfont">&#xe62b;</i></a> 
					<a style="text-decoration:none" class="ml-5" href="${pageContext.request.contextPath}/GetPostIdServlet?id=<%=p.getId()%>&type=1" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> 
					<a style="text-decoration:none" class="ml-5" href="${pageContext.request.contextPath}/GetPostIdServlet?id=<%=p.getId()%>&type=0" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			
		<%} %>
			</tbody>
			
		
	</table>
	</div>
</div>

</body>
</html>