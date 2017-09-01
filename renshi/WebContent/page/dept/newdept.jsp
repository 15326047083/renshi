<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.neusoft.service.*"%>
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
<link rel="stylesheet" type="text/css" href="css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="css/iconfont.css" />
<link rel="stylesheet" type="text/css" href="css/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="css/style.css" />

<title>新建部门</title>
</head>
<body>
	<%
		DeptService deptservice=new DeptService(); 
		int id=deptservice.selectMaxId();
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
	<form class="form form-horizontal" id="form-article-add" action="${pageContext.request.contextPath}/NewDeptSrvlet" method="POST">
		<input type="hidden" name="id" value="<%=id+1%>"/>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="请输入新添加的部门名称" id="articletitle" name="name" onblur="testonready(this.value)">
				<span class="c-red" id="check"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>分类：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="type" class="select">
					<option value="公司">公司</option>
						<option value="部门">部门</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>电话：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  placeholder="请输入新添加的部门电话" id="articletitle" name="phone" onblur="kong(this.name,this.value)"/>
				<span class="c-red" id="phone"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red"></span>传真：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入新添加部门传真" id="articletitle" name="fax" onblur="kong(this.name,this.value)">
				
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red"></span>描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入新添加的部门简介" id="articletitle" name="info" onblur="kong(this.name,this.value)"/>
			
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red"></span>上级部门：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入新添加的部门的上级部门" id="articletitle" name="sdept" onblur="kong(this.name,this.value)"/>
			
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
	function testonready(name){
		if(name==""){
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
				var url = "${pageContext.request.contextPath}/CheckDeptNameServlet";
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
					document.getElementById("check").innerHTML = "部门已存在";
				}else{
					document.getElementById("check").innerHTML = "";
				}
			}
		}
	}
</script>
</body>
</html>