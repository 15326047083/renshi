<%@page import="com.neusoft.service.EmpService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.neusoft.entity.Emp" %>
    <%@ page import="com.neusoft.service.TryService" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
		function testall(obj){
			var m=document.getElementsByName("Empitem");
			for(var i=0;i<m.length;i++){			
				m[i].checked=obj.checked;
			}
		}
		function Ydelete(){
			if(confirm("确认删除")==true){
				return true;
			}else{
				return false;
			}
		}
	</script>
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
		人事信息<span class="c-gray en">&gt;</span> 
		试用期管理 
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
<div class="page-container">
	<form action="${pageContext.request.contextPath }/TryFindServlet" method = "post">
		<div class="text-c">
	员工编号:<span class="select-box inline" >
					<input type="text" name="id" onchange="checkA(this)"/>
				</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button name="" id="bbb" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
		</div>
	</form>
<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th>工号</th>
					<th>姓名</th>
					<th>试用期开始时间</th>
					<th>工作开始时间</th>
					<th>试用期操作</th>
					<th>确定</th>
				</tr>
			</thead>
				<% 
				List<Emp> list=null;
				TryService t=new TryService();
 				if("1".equals(request.getParameter("num"))){
					list =(List)request.getSession().getAttribute("list");
				}else{
					list=t.quarryAllService();
				}
					for(Emp e:list){ 
				%>
			<tbody>
			<form action="${pageContext.request.contextPath }/TryOperationServlet" method="post">
				<tr class="text-c">
					<td><input type="hidden" name="id" value="<%=e.getId() %>"/><%=e.getId() %></td>
					<td><%=e.getName() %></td>
					<td><%=e.getHiredate() %></td>
					<td><input type="date" name="emp_workdate" value="<%=e.getWorkDate() %>"/></td>
					<td>
						<select name="operation" onblur="f1()">
                			<option value="1" selected="selected">转正</option>
                			<option value="2">延期</option>
                			<option value="3">不通过</option>
           				 </select>
					</td>
						<td><input type="submit" class="btn btn-primary radius" value="确定"></td>
				</tr>
			</form>
			</tbody>
				<%} %>
		</table>
</div>
</div>
</body>
</html>