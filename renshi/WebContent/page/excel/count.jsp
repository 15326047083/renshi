<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
		人事月报
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<form action="${pageContext.request.contextPath }/ExcelCountServlet" method = "post">
		<div class="text-c">
			<span class="select-box inline" id="s">
			       选择月份<select name="year">
			       		<%
			       			for(int i=2017;i>=1950;i--){
			       				%>
			       				<option value="<%=i%>" ><%=i%></option>
			       			<%}
			       		%>
			       </select>年
			       <select name="month">
			       		<%
			       			for(int i=1;i<=12;i++){
			       				%>
			       				<option value="<%=i%>" ><%=i%></option>
			       			<%}
			       		%>
			       </select>月
			</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button name="" id="bbb" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe640;

</i> 导出</button>
		</div>
		<br/>
		<br/>
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">	
			<tr class="text-c">
			<td>
				<div>
    				<span><input type="checkbox" value="部门#deptName" name="export" checked="checked"></span>
 					<input type="text" value="部门" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="月初人数#firstNum" name="export" checked="checked"></span>
 					<input type="text" value="月初人数" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="月末人数#endNum" name="export" checked="checked"></span>
 					<input type="text" value="月末人数" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="本月新入职#newNum" name="export" checked="checked"></span>
 					<input type="text" value="本月新入职" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="本月离职#quitNum" name="export" checked="checked"></span>
 					<input type="text" value="本月离职" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="本月调入#thisIn" name="export" checked="checked"></span>
 					<input type="text" value="本月调入" disabled="disabled">
				</div>
			</td>
			<td>
				<div>
    				<span><input type="checkbox" value="本月调出#thisOut" name="export" checked="checked"></span>
 					<input type="text" value="本月调出" disabled="disabled">
				</div>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>