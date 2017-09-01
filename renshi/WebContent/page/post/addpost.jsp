<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.neusoft.service.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<title>岗位注册页面</title>
</head>
<body> 
<script type="text/javascript">
	var result="false";
</script>
<%PostService postservice = new PostService(); 
	int maxid = postservice.selectMaxId()+1;
%>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 
		首页 <span class="c-gray en">&gt;</span> 
		部门管理 <span class="c-gray en">&gt;</span> 
		部门列表 
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i></a>
		<a class="btn btn-primary radius r" style="line-height:1.6em;margin-top:3px" onclick="history.back();" title="返回" >
		<i class="Hui-iconfont">&#xe678;</i></a>
	</nav>
<article class="page-container">
	 <form class="form form-horizontal" id="form-article-add" action="${pageContext.request.contextPath}/InsertPostServlet" method="post">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  id="articletitle" name="id"  readonly value="<%=maxid%>"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="请输入添加的岗位编号" id="articletitle" name="postname" onblur="testonready(this.value)"/>
				<span class="c-red" id="check"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>岗位类型:</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="posttype" class="select">
						<option value="1">管理</option>
							<option value="2">技术</option>
							<option value="3">营销</option>
							<option value="4">市场</option>
							<option value="5">财务</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>岗位编制:</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="请输入此岗位可容纳的最大员工数" id="articletitle" name="maxep" onblur="kong(this.name,this.value)"/>
				<span class="c-red" id="maxep"></span>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<input type="submit" value="保存" class="btn btn-primary radius" />
				<input type="reset" value="重置" class="btn btn-primary radius" />
				
		</div>
		</form>
</article>
<script type="text/javascript">
	var req = false;
	function kong(name,value){
		if(value==""){
			document.getElementById(name).innerHTML = "不可为空";
		}else{
			document.getElementById(name).innerHTML = "";
		}
	}
	function testonready(postname){
		if(postname==""){
			document.getElementById("check").innerHTML = "不可为空";
		}
		else{
			if(window.XMLHttpRequest){
				req = new XMLHttpRequest();
			}
			if(window.ActiveXObject){
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			if(req){
				var url = "${pageContext.request.contextPath}/CheckPostNameServlet";
				req.open("post",url,true);
				req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				req.onreadystatechange = test1;
				req.send("postname="+postname);
			}
		}
	}
	function test1(){
		if(req.readyState==4){
			if(req.status==200){
				result = req.responseText;
				if("true"==result){
					document.getElementById("check").innerHTML = "岗位已存在";
				}else{
					document.getElementById("check").innerHTML = "";
				}
			}
		}
	}
</script>
</body>
</html>