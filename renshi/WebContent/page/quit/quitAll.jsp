<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.neusoft.entity.Emp" %>
    <%@ page import="com.neusoft.service.EmpService" %>
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
		function checkA(obj) {
			var str = obj.value;
			if(str != null && str != "") {
			 document.all.bbb.disabled = "";
			} else {
			 document.all.bbb.disabled = "disabled";
			}
		}
	</script>
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
<title>职工信息表</title>
</head>
<body>
               	<% 
					EmpService es = new EmpService();
					List<Emp> list =null;
					if("1".equals(request.getParameter("num"))){
						list=(List)request.getSession().getAttribute("list");
					}else{
						list=es.quarryAllService();
					}
					%>
<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 
	首页 <span class="c-gray en">&gt;</span> 
	人事信息 <span class="c-gray en">&gt;</span> 
	员工离职 
	<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
	<i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
				
<article class="page-container">
	<form action="${pageContext.request.contextPath }/EmpFindServlet" method="POST">
		<div class="text-c">
			请输入员工编号：<span class="select-box inline" >
				<input type="text" class="input-text"  id="articletitle" name="id" />
			</span>
			<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
		</div>
	</form>
	    <form action="${pageContext.request.contextPath }/QuitDeleteAll" method="post">
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		 <span class="l">
<%-- 		 	<a href="${pageContext.request.contextPath }/QuitDeleteAll" class="btn btn-danger radius">
		 		<i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>  --%>
		 	<input type="submit" class="btn btn-danger radius" value="批量删除"/>
		 </span> 
		 <span class="r">共有数据：<strong><%=list.size()%></strong> 条</span> 
	</div>
	
	


		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
                <tr class="text-c">
                    <th width="25">选择<input type="checkbox" name="Empitem1" value="" onclick="testall(this)"/></th>
                    <th width="80">工号</th>
                    <th>姓名</th>
                    <th width="60">部门</th>
                    <th width="80">岗位</th>
                    <th width="80">联系电话</th>
                    <th width="100">电子邮件</th>
                    <th width="80">操作</th>
                
                </tr>
            </thead>
			<%
				for(Emp e:list){%>
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
                    	<a style="text-decoration:none" class="ml-5" onclick="delete()" href="${pageContext.request.contextPath }/EmpDeleteServlet?id=<%=e.getId() %>" method="POST" title="删除">
						<i class="Hui-iconfont">&#xe6e2;</i></a>
                    </td>
                </tr>
	 		<%}%>
	 	</table>          
	</form>
</article>
</body>
</html>