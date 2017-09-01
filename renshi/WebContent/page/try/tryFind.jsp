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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/TryFindServlet" method = "post">
		<table border="1" width="800px" align="center">
			<tr>
				<td>工号</td>
				<td><input type="text" name="id"/></td>
				<td><input type="submit" value="查询"/></td>
			</tr>
		</table>
	</form>
	<form action="${pageContext.request.contextPath }/TryOperationServlet" method="post">
	<table border="1" width="800px" align="center">
				<caption>职工信息表</caption>
				<tr>
					<th>工号</th>
					<th>姓名</th>
					<th>试用期试用期时间</th>
					<th>正式入职时间</th>
					<th>操作</th>
				</tr>
				<% 
					List<Emp> list = (ArrayList)request.getAttribute("list");
					for(Emp e:list){
				%>
				<tr>
					<td><%=e.getId() %></td>
					<td><%=e.getName() %></td>
					<td><%=e.getHiredate() %></td>
					<td><input type="input" name="workdate" value="<%=e.getWorkDate() %>"/></td>
					<td>
						<select name="operation" onblur="f1()">
                			<option value="1" selected="select">转正</option>
                			<option value="2">延期</option>
                			<option value="3">不通过</option>
           				 </select>
					</td>
				</tr>
				<%} %>
					
				<tr>
					<td><input type="submit" value="确定"/></td>
				</tr>
			</table>
			</form>
</body>
</html>