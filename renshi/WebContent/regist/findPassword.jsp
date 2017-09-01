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
	<div class="main">
		<div class="header" >
			<h1>找回密码</h1>
		</div>
		<form action="${pageContext.request.contextPath}/FindPasswordServlet">
		<ul class="left-form">
			<h2>找回密码:</h2>

			<li>			
			<%if("false".equals(request.getParameter("num"))){ %>
				<span style="color: red;" >密保问题错误</span>
			<%}%>
				<span style="color: red;">*</span><input type="text"   placeholder="Username" name="username" onblur="kong(this.name,this.value)" required/>
				<span style="color: red;" id="username"></span>
				<div class="clear"> </div>
			</li> 
			<li>
				<span style="color: red;">*</span><input type="text"   placeholder="密保问题" name="problem" onblur="kong(this.name,this.value)" required/>
				<span style="color: red;" id="problem"></span>
				<div class="clear"> </div>
			</li>
			<li>
				<span style="color: red;">*</span><input type="text"   placeholder="密保答案" name="answer" onblur="kong(this.name,this.value)" required/>
				<span style="color: red;" id="answer"></span>
				<div class="clear"> </div>
			</li>  
			<li>
				<input type="submit" value="下一步" >
				<div class="clear"> </div>
			</li>
			</ul>
			<div class="clear"> </div>
		</form>
	</div>
</body>
</html>