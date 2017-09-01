<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.neusoft.entity.Emp" %>
    <%@ page import="com.neusoft.service.*" %>
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
<script type="text/javascript">
	function checkA(obj) {
		var str = obj.value;
		if(str != null && str != "") {
		 document.all.bbb.disabled = "";
		} else {
		 document.all.bbb.disabled = "disabled";
		}
	}
</script>
</head>
<body>
<%EmpService es = new EmpService();
List<Emp> list = es.quarryAllQuitService();  %>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 
		首页 <span class="c-gray en">&gt;</span> 
		认识信息 <span class="c-gray en">&gt;</span> 
		已离职员工 
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
<div class="page-container">
	
	<form action="find.jsp" method = "post">
		<div class="text-c">
			员工编号:<span class="select-box inline" id="s">
					<input type="text" name="id" onchange="checkA(this)"/>
				</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button name="" id="bbb" class="btn btn-success" type="submit" disabled="disabled"><i class="Hui-iconfont">&#xe665;</i> 搜索人员信息 </button>
		</div>
	</form>
	
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		 <span class="l">
		 	<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">
		 		<i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
		 	<a class="btn btn-primary radius" data-title="离职操作" data-href="article-add.html" href="quitAll.jsp">
		 		<i class="Hui-iconfont">&#xe600;</i> 离职操作</a>
		 </span> 
		 <span class="r">共有数据：<strong><%=list.size()%></strong> 条</span> 
	</div>
	
<div class="mt-20">
	<form action="${pageContext.request.contextPath }/EmpDeleteServlet" method="post">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th>选择<input type="checkbox" name="Empitem1" onclick="testall(this)" /></th>
					<th>工号</th>
					<th>姓名</th>
					<th>部门</th>
					<th>岗位</th>
					<th>联系电话</th>
					<th>电子邮件</th>
					<th>操作</th>
				</tr>
			</thead>
				<%  
					for(Emp e:list){
				%>
			<tbody>
				<tr class="text-c">
					<td><input type="checkbox" name="Empitem" value="<%=e.getId() %>"/></td>
					<td><%=e.getId() %></td>
					<td><%=e.getName() %></td>
					<td><%=e.getDeptName() %></td>
					<td><%=e.getPostName() %></td>
					<td><%=e.getTel() %></td>
					<td><%=e.getEmail() %></td>
					<td>
						<a style="text-decoration:none" class="ml-5" href="find.jsp?id=<%=e.getId() %>" title="查看">
						<i class="Hui-iconfont">&#xe695;
</i></a> 
					</td>
				</tr>
			</tbody>
				<%} %>
		</table>
	</form>
</div>
</div>
</body>
</html>