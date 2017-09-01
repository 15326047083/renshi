<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.neusoft.service.DeptService" %>
    <%@ page import="com.neusoft.service.PostService" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.neusoft.entity.Dept" %>
     <%@ page import="com.neusoft.entity.Post" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
    <title>注册界面</title>
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
<%
	DeptService ds = new DeptService();
	List<Dept> dept =ds.findAll("");
	PostService ps = new PostService();
	List<Post> post = ps.findCanAddAll();
%>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 
		首页 <span class="c-gray en">&gt;</span> 
		人事信息 <span class="c-gray en">&gt;</span> 
		员工入职
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i></a>
		<a class="btn btn-primary radius r" style="line-height:1.6em;margin-top:3px" onclick="history.back();" title="返回" >
		<i class="Hui-iconfont">&#xe678;</i></a>
	</nav>
<article class="page-container">
<form class="form form-horizontal" id="form-article-add" action="${pageContext.request.contextPath }/EmpRegistServlet" method="post" >
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="请输入员工姓名" id="articletitle" name="emp_name" onblur="kong(this.name,this.value)"/>
                <span class="c-red" id="emp_name"></span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>性别:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="emp_sex" class="select">
                        <option value="1" selected="selected">男</option>
                        <option value="2">女</option>
                </select>
                </span> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>出生日期：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="date" class="input-text" placeholder="请选择出身日期" id="articletitle" name="emp_birthday" onblur="kong(this.name,this.value)" >
                <span class="c-red" id="emp_birthday"></span>
            </div>
        </div>
         <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>身份证号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="请输入员工身份证号码" id="articletitle" name="idNum" onblur="kong(this.name,this.value)"/>
                <span class="c-red" id="idNum"></span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">身高</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="请输入员工身高（例：170）" id="articletitle" name="height" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span> 部门:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="emp_dept" class="select">
                        <%for(Dept d:dept){
                %>
                <option value="<%=d.getName()%>"><%=d.getName() %></option>
                <%
            }%>
                </select>
                </span> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span> 岗位:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="emp_post" class="select">
		            <%for(Post p:post){
		                %>
		                <option value="<%=p.getPostname() %>"><%=p.getPostname() %></option>
		                <%
		            }%>
                </select>
                </span> </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>试用期入职日期：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="date" class="input-text"  id="articletitle" name="hiredate" onblur="kong(this.name,this.value)"/>
                <span class="c-red" id="hiredate"></span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>正式入职日期：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="date" class="input-text"  id="articletitle" name="emp_date" onblur="kong(this.name,this.value)"/>
                <span class="c-red" id="emp_date"></span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span> 用工形式:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="emp_form" class="select">
                        <option value="1" selected="select">正式员工</option>
                        <option value="2">临时员工</option>
                </select>
                </span> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span> 人员来源:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="emp_sources" class="select">
                        <option value="1" selected="select">校园招聘</option>
                        <option value="2">社会招聘</option>
                        <option value="3">其他</option>
                </select>
                </span> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">政治面貌:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="Political_outlook" class="select">
                        <option value="1">党员</option>
                        <option value="2">预备党员</option>
                        <option value="3">团员</option>
                        <option value="4">其他</option></select>
                </span> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">民族</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="nation" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">籍贯</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="native_place" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">联系电话</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="tel" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">电子邮件</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="email" >
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">血型:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="Blood_type" class="select">
                        <option value="1">A血型</option>
                <option value="2">B血型</option>
                <option value="3">AB血型</option>
                <option value="4">O血型</option>
                <option value="5">其他</option>
                </select>
                </span> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">婚姻状态:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="Marital_status" class="select">
                        <option value="1">未婚</option>
                	<option value="2">已婚</option>
                	<option value="3">丧偶</option>
                	<option value="4">离婚</option>
                </select>
                </span> </div>
        </div>



        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 出生地</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="homeplace" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 户口所在地</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="Registered_residence" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">最高学历:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="highest_edu" class="select">
                        <option value="1">无学位</option>
                <option value="2">学士</option>
                <option value="3">双学士</option>
                <option value="4">硕士</option>
                <option value="5">博士</option>
                <option value="6">博士后</option></select>
                </span> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 毕业学校</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="Graduation_school" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 所学专业</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="major" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 毕业日期</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="date" class="input-text"  id="articletitle" name="graduation_date" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 外语信息</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="foreignLanguagesInfo" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 家庭信息</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="familyInfo" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 职业信息</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="workInfo" >
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <input type="submit" value="保存" class="btn btn-primary radius" /> 
  				<input type="reset" value="重置" class="btn btn-primary radius" />
       		 </div>
		</div>

</form>
</article>
<script type="text/javascript">
	function kong(name,value){
		if(value==""){
			document.getElementById(name).innerHTML = "不可为空";
		}else{
			document.getElementById(name).innerHTML = "";
		}
	}
</script>
</body>
</html>
