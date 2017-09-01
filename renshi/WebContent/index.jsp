<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>管理系统登陆界面</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="login/css/reset.css">
        <link rel="stylesheet" href="login/css/supersized.css">
		<link rel="stylesheet" type="text/css" href="login/css/iconfont.css" />
        <link rel="stylesheet" href="login/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

</head>
<body>
    <div class="top"></div>
	<div id="header">
    	<div class="logo">
    		<h1>员工后台管理系统</h1>
    	</div>
	</div>
        <div class="page-container">
            <h1>登陆</h1>

            <form action="UserLoginServlet" method="post">
                <input type="text" name="username" class="username" placeholder="Username"/>
                <input type="password" name="password" class="password" placeholder="Password"/>
                     <%
            if("false".equals(request.getParameter("num"))){%> 
            
                <br/><br/><i class="Hui-iconfont menu_dropdown-arrow">&#xe6dd;</i>
            	<span style="color: red;">账号或密码错误</span><br/>
            <%}if("1".equals(request.getParameter("num"))){ %>
            
                <br/><br/><br/><i class="Hui-iconfont menu_dropdown-arrow" style="color: red;">&#xe6dd;</i>
            	<span style="color: red;">请先登录</span><br/>       
            <%}%>
            	<a href="regist/regist.jsp">立即注册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="regist/findPassword.jsp">找回密码</a>
                <button type="submit">点击进入</button>
                <div class="error"><span>+</span></div>
            </form>
           
        </div>

        <!-- Javascript -->
 <script src="login/js/jquery-1.8.2.js"></script>
 <script src="login/js/supersized.3.2.7.min.js"></script>
 <script src="login/js/supersized-init.js"></script>
 <script src="login/js/scripts.js"></script>

</body>

</html>
