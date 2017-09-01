<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<title>Insert title here</title>
<script type="text/javascript">
function kong(name,value){
	if(value==""){
		document.getElementById(name).innerHTML = "不可为空";
	}else{
		document.getElementById(name).innerHTML = "";
	}
}

</script>
</head>
<body>
	<%if("true".equals(request.getParameter("num"))){ %>
	<div class="main">
		<div class="header" >
		<%if("1".equals(request.getParameter("id"))) {%>
			<h1>修改密码</h1>
		<%}else{ %>
			<h1>找回密码</h1>
			<%} %>
		</div>
		<form action="${pageContext.request.contextPath}/NewPasswordServlet">
		<ul class="left-form">
		<%if("1".equals(request.getParameter("id"))) {%>
			<h2>修改密码</h2>
		<%}else{ %>
			<h2>找回密码</h2>
		<%} %>
			<li>			
				<span style="color: red;">*</span><input type="text"   placeholder="请输入用户名" name="username" onblur="kong(this.name,this.value)" value="<%=request.getParameter("username") %>" readonly="readonly" required/>
				<span style="color: red;" id="username"></span>
				<div class="clear"> </div>
			</li> 
			<li>
				<span style="color: red;">*</span><input type="text"   placeholder="请输入密码" name="password" onblur="mima(this.value)" required/>
				<span style="color: red;" id="password"></span>
				<div class="clear"> </div>
			</li>
			<li>
				<span style="color: red;">*</span><input type="text"   placeholder="请确认密码" name="suerpassword" onblur="yizhi(this.value)" required/>
				<span style="color: red;" id="suerpassword"></span>
				<div class="clear"> </div>
			</li>  
			<li>
				<input type="submit" value="提交" >
				<div class="clear"> </div>
			</li>
			</ul>
			<div class="clear"> </div>
		</form>
	</div>
		<script type="text/javascript">
		var pw1;
		var pw2;
		function mima(value){
			pw1=value;
			if(pw1==""){
				document.getElementById("password").innerHTML = "不可为空";
			}else{
				document.getElementById("password").innerHTML = "";
			}
		}
		function yizhi(value){
			pw2=value;
			if(pw1!=pw2){
				document.getElementById("suerpassword").innerHTML = "两次密码不一致";
			}else{
				document.getElementById("suerpassword").innerHTML = "";
			}
		}
	</script>
	<%}else{ 
		response.sendRedirect("findPassword.jsp");
	}
	%>
</body>
</html>