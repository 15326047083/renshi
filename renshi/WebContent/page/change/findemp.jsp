<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List"%>
<%@page import="com.neusoft.service.*"%>
<%@page import="com.neusoft.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</head>
<body>
<article class="page-container">
    
    <form class="form form-horizontal" id="form-article-add" action="${pageContext.request.contextPath}/FindEmpServlet" method="POST">
<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入需调换部门的员工信息：</h3> 
 <div class="row cl">
 
    
        <div class="row cl">
         
            <label class="form-label col-xs-4 col-sm-2">员工号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="请输入需要调换部门的员工编号" id="articletitle" name="emp_id" />
                <span id="emp_name"></span>
            </div></div>
             <div class="row cl">
         
           <label class="form-label col-xs-4 col-sm-2">姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="请输入需要调换部门的员工姓名" id="articletitle" name="emp_name" />
                <span id="emp_name"></span>
            </div></div>
            
            <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input type="submit" value="查询" class="btn btn-primary radius" /> 
             </div>
        </div>
        </div>
        </form>

    <form class="form form-horizontal" id="form-article-add" action="${pageContext.request.contextPath}/ChangeDeptServlet" method="POST">
    <% 
    Emp emp=(Emp)request.getSession().getAttribute("emp");
    DeptService ds = new DeptService();
    List<Dept> deptList = ds.findAll("");
        if("0".equals(request.getParameter("num"))){
            %>
            <span class="c-red"><h4>该员工不存在！请重新输入</h4></span>
            <%
        }
        else if("1".equals(request.getParameter("num"))){
        	DeptService deptservice= new DeptService();
        	  Dept dept= new Dept();
        	   dept=deptservice.findInfo(emp.getDeptId());
            %>
    		<input type="hidden" name="old_dept" value="<%=emp.getDeptId()%>"/>
            <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">员工号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="emp_id" value= <%=emp.getId() %> readonly/> 
            </div>
            </div>
            <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="name" value= <%=emp.getName() %> readonly/> 
            </div>
            </div>
            <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">当前部门：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" value= <%=dept.getName() %> readonly/> 
            </div>
            </div>
            <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>调换部门:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="dept_id" class="select">
                       <%
                       		for(Dept d:deptList){
                       			%>
                       			<option value=<%=d.getId() %>><%=d.getName() %></option>
                       		<%}
                       %></select>
                </span> </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input type="submit" value="提交" class="btn btn-primary radius" /> 
               
             </div>
        </div>
           
            <%}
            else if("2".equals(request.getParameter("num"))){
            	DeptService deptservice= new DeptService();
            	  Dept dept= new Dept();
            	    dept=deptservice.findInfo(emp.getDeptId());
                %><br/><br/><br/><span class="c-red"><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改成功!</h3></span>
                <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">员工号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="emp_id" value= <%=emp.getId() %> readonly/> 
            </div>
            </div>
            <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" value= <%=emp.getName() %> readonly/> 
            </div>
            </div>
            <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">新部门：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" value= <%=dept.getName() %> readonly/> 
            </div>
            </div>
               
                <%}

    %>
    </form>
</article>
</body>
</html>