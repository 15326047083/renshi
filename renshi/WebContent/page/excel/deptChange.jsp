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
		部门调动员工报表 
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<form action="${pageContext.request.contextPath }/ExcelDeptServlet" method = "post">
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
				<td>
					<div>
	    				<span><input type="checkbox" value="工号#empid" name="export" checked="checked"></span>
	 					<input type="text" value="工号" disabled="disabled">
					</div>
				</td>
				<td>
					<div>
	    				<span><input type="checkbox" value="姓名#empname" name="export" checked="checked"></span>
	 					<input type="text" value="姓名" disabled="disabled">
					</div>
				</td>
				<td>
					<div>
	    				<span><input type="checkbox" value="旧部门#olddept" name="export" checked="checked"></span>
	 					<input type="text" value="旧部门" disabled="disabled">
					</div>
				</td>
				<td>
					<div>
	    				<span><input type="checkbox" value="新部门#newdept" name="export" checked="checked"></span>
	 					<input type="text" value="新部门" disabled="disabled">
					</div>
				</td>
				<td>
					<div>
	    				<span><input type="checkbox" value="调动日期#changedate" name="export" checked="checked"></span>
	 					<input type="text" value="调动日期" disabled="disabled">
					</div>
				</td>
			</tr>
		
		</table>
	</form>
</body>
</html>