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
			<h1>注册页面</h1>
		</div>
		
			<form action="${pageContext.request.contextPath}/NewUserServlet">
				<ul class="left-form">
					<h2>创建新账号:</h2>
					<li>
						<span style="color: red;">*</span><input type="text"   placeholder="Username" name="username" onblur="testonready(this.value)" required/>
						<span style="color: red;" id="username"></span>
						<div class="clear"> </div>
					</li> 
					
					<li>
						<span style="color: red;">*</span>
						<input type="password" id="pass" placeholder="password" name="password" onblur="mima(this.value)" required/>
						<span style="color: red;" id="password"></span>
						<div class="clear"> </div>
					</li> 
					<li>
						<span style="color: red;">*</span>
						<input type="password" id="suerpass" placeholder="password" name="suerpassword" onblur="yizhi(this.value)" required/>
						<span style="color: red;" id="suerpassword"></span>
						<div class="clear"> </div>
					</li> 
					<li>
						<span style="color: red;">*</span><input type="text"   placeholder="Phone number" name="phone" onblur="kong(this.name,this.value)" required/>
						<span style="color: red;" id="phone"></span>
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
					<input type="submit" value="点击创建账号" >
						<div class="clear"> </div>
					</li>
				</ul>
				
				<div class="clear"> </div>
					
			</form>
			
		</div>
			<!-----start-copyright---->
   				
				<!-----//end-copyright---->
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
		
		function testonready(name){
			if(name==""){
				document.getElementById("username").innerHTML = "不可为空";
			}
			else{
				if(window.XMLHttpRequest){
					req = new XMLHttpRequest();
				}
				if(window.ActiveXObject){
					req = new ActiveXObject("Microsoft.XMLHTTP");
				}
				if(req){
					var url = "${pageContext.request.contextPath}/CheckUserNameServlet";
					req.open("post",url,true);
					req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
					req.onreadystatechange = test1;
					req.send("name="+name);
				}
			}
		}
		function test1(){
			if(req.readyState==4){
				if(req.status==200){
					var result = req.responseText;
					if("true"==result){
						document.getElementById("username").innerHTML = "用户名已存在";
					}else{
						document.getElementById("username").innerHTML = "";
					}
				}
			}
		}
	</script>
	<body>
</html>