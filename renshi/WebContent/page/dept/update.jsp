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
		Dept dept=deptservice.findInfo(id);
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
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add" action="${pageContext.request.contextPath}/UpdateDeptServlet" method="POST">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="<%=dept.getId()%>" readonly="readonly" id="articletitle" name="id">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  placeholder="请输入修改后部门名称" id="articletitle" name="name" value="<%=dept.getName() %>">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>分类：</label>		
				<%if("公司".equals(dept.getType())){%>
				<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
					<select name="type" class="select">
						<option value="公司" selected="selected">公司</option>
						<option value="部门">部门</option>
					</select>
					</span> 
				</div>
				<%}else{%>
				<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
						<select name="type" class="select">
							<option value="公司">公司</option>
							<option value="部门" selected="selected">部门</option>
						</select>
						</span> 
				</div>
					<%} %>
			</div>	
		
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>电话：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  placeholder="请输入修改后的部门电话" id="articletitle" name="phone" value="<%=dept.getPhone()%>">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red"></span>传真：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="请输入修改后的部门传真" id="articletitle" name="fax" value="<%=dept.getFax()%>">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red"></span>描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="请输入修改后的部门描述" id="articletitle" name="info" value="<%=dept.getInfo()%>"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red"></span>上级部门：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="请输入修改后的上级部门" id="articletitle" name="sdept" value="<%=dept.getSdept()%>">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<input type="submit" value="保存" class="btn btn-primary radius" />
				<input type="reset" value="重置" class="btn btn-primary radius" />
		</div>	
	
	</form>
</article>
</body>
</html>