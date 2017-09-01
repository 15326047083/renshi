<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.neusoft.entity.Emp" %>
    
    <%@ page import="com.neusoft.service.*" %>
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
    
    <title></title>


 

</head>
<body>
<%	
	int id = Integer.parseInt(request.getParameter("id"));
	EmpService es = new EmpService();
	Emp e = es.selectAllService(id);
%>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 
		首页 <span class="c-gray en">&gt;</span> 
		员工信息 <span class="c-gray en">&gt;</span> 
		人员信息
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
		<i class="Hui-iconfont">&#xe68f;</i></a>
		<a class="btn btn-primary radius r" style="line-height:1.6em;margin-top:3px" onclick="history.back();" title="返回" >
		<i class="Hui-iconfont">&#xe678;</i></a>
	</nav>
<article class="page-container">
<form action="${pageContext.request.contextPath }/EmpUpdateServlet?id=<%=e.getId() %>" method="post" class="form form-horizontal" id="form-article-add" >
         <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="emp_name"  readonly value="<%=e.getName()%>"/>
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
                <input type="date" class="input-text"  id="articletitle" name="emp_birthday"  value="<%=e.getBirthday() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>身份证号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="idNum" value="<%=e.getIdNum() %>"  />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>部门：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="emp_dept" value="<%=e.getDeptName() %>"  />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>岗位：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="emp_post" value="<%=e.getPostName() %>"  />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>入职日期：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="date" class="input-text"  id="articletitle" name="hiredate" value="<%=e.getHiredate() %>"  />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>参加工作日期：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="date" class="input-text"  id="articletitle" name="emp_date" value="<%=e.getWorkDate() %>"  />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>用工形式:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="emp_form" class="select">
                        <option value="1" selected="select">正式员工</option>
                <option value="2">临时员工</option>
                </select>
                </span> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>人员来源:</label>
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
                        <option value="1" selected="selected">党员</option>
                <option value="2">预备党员</option>
                <option value="3">团员</option>
                <option value="4">其他</option>
                </select>
                </span> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">民族</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="nation" value="<%=e.getNation() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">籍贯</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="native_place" value="<%=e.getNativePlace() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">联系电话</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="tel" value="<%=e.getTel() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">电子邮件</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="email" value="<%=e.getEmail() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 身高</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="height" value="<%=e.getHeight() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">血型:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="Blood_type" class="select">
                        <option value="1" selected="selected">A血型</option>
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
                        <option value="1" selected="selected">未婚</option>
                    <option value="2">已婚</option>
                    <option value="3">丧偶</option>
                    <option value="4">离婚</option>
                </select>
                </span> </div>
        </div>



        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 出生地</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="homeplace" value="<%=e.getHomeplace() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 户口所在地</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="Registered_residence" value="<%=e.getRegisteredResidence() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">最高学历:</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
                <select name="highest_edu" class="select">
                        <option value="1" selected="selected">无学位</option>
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
                <input type="text" class="input-text"  id="articletitle" name="Graduation_school" value="<%=e.getGraduationSchool() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 所学专业</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="major" value="<%=e.getMajor() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 毕业日期</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="date" class="input-text"  id="articletitle" name="graduation_date" value="<%=e.getGraduationDate() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 外语信息</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="foreignLanguagesInfo" value="<%=e.getForeignLanguagesInfo() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 家庭信息</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="familyInfo" value="<%=e.getFamilyInfo() %>"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"> 职业信息</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  id="articletitle" name="workInfo" value="<%=e.getWorkInfo() %>"/>
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
</body>
</html>

