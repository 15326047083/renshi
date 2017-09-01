package com.neusoft.entity;

import java.sql.Date;

/**
 * @author ttc
 *
 */
public class Emp {
	/**
	 * 员工id
	 */
	private int id;
	/**
	 * 员工姓名
	 */
	private String name;
	/**
	 * 员工性别
	 */
	private String sex;	
	/**
	 * 员工生日
	 */
	private	Date birthday;	
	/**
	 * 身份证号
	 */
	private String idNum;
	/**
	 * 部门id
	 */
	private int deptId;
	/**
	 * 部门名称
	 */
	private String deptName;
	/**
	 * 岗位id
	 */
	private int postId;
	/**
	 * 岗位名称
	 */
	private String postName;
	/**
	 * 入职日期
	 */
	private Date hiredate;
	/**
	 * 参加工作日期
	 */
	private Date workDate;
	/**
	 * 用工形式
	 */
	private String empForm;
	/**
	 * 人员来源
	 */
	private String empSources;
	/**
	 * 政治面貌
	 */
	private	String politicalOutlook;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 籍贯
	 */
	private String nativePlace;
	/**
	 * 联系电话
	 */
	private String tel;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 身高
	 */
	private double height;
	/**
	 * 血型
	 */
	private String bloodType;
	/**
	 * 婚姻状态
	 */
	private String maritalStatus;
	/**
	 * 出生地
	 */
	private String homeplace;
	/**
	 * 户口所在地
	 */
	private String registeredResidence;
	/**
	 * 最高学历
	 */
	private String highestEducation;
	/**
	 * 毕业院校
	 */
	private String graduationSchool;
	/**
	 * 所选专业
	 */
	private String major;
	/**
	 * 毕业日期
	 */
	private Date graduationDate;
	/**
	 * 是否离职
	 */
	private int isQuit;
	/**
	 * 试用期id
	 */
	private int periodId;
	/**
	 * 职业信息
	 */
	private String workInfo;
	/**
	 * 外语信息
	 */
	private String foreignLanguagesInfo;
	/**
	 * 家庭关系
	 */
	private String familyInfo;
	/**
	 * 是否试用期
	 */
	private int isPeriod;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public int getSexInt() {
		if("男".equals(this.sex)){
			return 1;
		}else{
			return 2;
		}
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setSex(int sex) {
		if(sex==1){
			this.sex ="男";
		}else{
			this.sex="女";
		}
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	public String getEmpForm() {
		return empForm;
	}
	public int getEmpFormInt() {
		if("正式员工".equals(this.empForm)){
			return 1;
		}else{
			return 2;
		}
	}
	public void setEmpForm(String empForm) {
		this.empForm = empForm;
	}
	public void setEmpForm(int empForm) {
		if(empForm==1){
			this.empForm="正式员工";
		}else{
			this.empForm="临时员工";
		}
	}
	public String getEmpSources() {
		return empSources;
	}
	public int getEmpSourcesInt() {
		if("校园招聘".equals(this.empSources)){
			return 1;
		}else if("社会招聘".equals(this.empSources)){
			return 2;
		}else{
			return 3;
		}
	}
	public void setEmpSources(String empSources) {
		this.empSources = empSources;
	}
	public void setEmpSources(int empSources) {
		if(empSources==1){
			this.empSources="校园招聘";
		}else if(empSources==2){
			this.empSources="社会招聘";
		}else{
			this.empSources="其他";
		}
	}
	public String getPoliticalOutlook() {
		return politicalOutlook;
	}
	public int getPoliticalOutlookInt() {
		String []p={"党员","预备党员","团员","其他"};
		int po=0;
		for(int i = 0;i<p.length;i++){
			if(p[i].equals(this.politicalOutlook)){
				po=i;
				break;
			}
		}
		return po+1;
	}
	public void setPoliticalOutlook(String politicalOutlook) {
		this.politicalOutlook = politicalOutlook;
	}
	public void setPoliticalOutlook(int politicalOutlook) {
		String []p={"党员","预备党员","团员","其他"};
		this.politicalOutlook=p[politicalOutlook-1];
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getBloodType() {
		return bloodType;
	}
	public int getBloodTypeInt() {
		String []b={"A型","B型","AB型","O型","其他"};
		int bt=0;
		for(int i=0;i<b.length;i++){
			if(b[i].equals(this.bloodType)){
				bt = i;
				break;
			}
		}
		return bt+1;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public void setBloodType(int bloodType) {
		String []b={"A型","B型","AB型","O型","其他"};
		this.bloodType=b[bloodType-1];
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public int getMaritalStatusInt() {
		String []m={"未婚","已婚","丧偶","离婚"};
		int ms=0;
		for(int i=0;i<m.length;i++){
			if(m[i].equals(this.maritalStatus)){
				ms=i;
				break;
			}
		}
		return ms+1;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public void setMaritalStatus(int maritalStatus) {
		String []m={"未婚","已婚","丧偶","离婚"};
		this.maritalStatus=m[maritalStatus-1];
	}
	public String getHomeplace() {
		return homeplace;
	}
	public void setHomeplace(String homeplace) {
		this.homeplace = homeplace;
	}
	public String getRegisteredResidence() {
		return registeredResidence;
	}
	public void setRegisteredResidence(String registeredResidence) {
		this.registeredResidence = registeredResidence;
	}
	public String getHighestEducation() {
		return highestEducation;
	}
	public int getHighestEducationInt() {
		String []h={"无学位","学士","双学士","硕士","博士","博士后"};
		int he=0;
		for(int i=0;i<h.length;i++){
			if(h[i].equals(this.highestEducation)){
				he=i;
				break;
			}
		}
		return he+1;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public void setHighestEducation(int highestEducation) {
		String []h={"无学位","学士","双学士","硕士","博士","博士后"};
		this.highestEducation = h[highestEducation+1];
	}
	public String getGraduationSchool() {
		return graduationSchool;
	}
	public void setGraduationSchool(String graduationSchool) {
		this.graduationSchool = graduationSchool;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Date getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}
	public int getIsQuit() {
		return isQuit;
	}
	public void setIsQuit(int isQuit) {
		this.isQuit = isQuit;
	}
	public int getPeriodId() {
		return periodId;
	}
	public void setPeriodId(int periodId) {
		this.periodId = periodId;
	}
	public String getWorkInfo() {
		return workInfo;
	}
	public void setWorkInfo(String workInfo) {
		this.workInfo = workInfo;
	}
	public String getForeignLanguagesInfo() {
		return foreignLanguagesInfo;
	}
	public void setForeignLanguagesInfo(String foreignLanguagesInfo) {
		this.foreignLanguagesInfo = foreignLanguagesInfo;
	}
	public String getFamilyInfo() {
		return familyInfo;
	}
	public void setFamilyInfo(String familyInfo) {
		this.familyInfo = familyInfo;
	}
	public int getIsPeriod() {
		return isPeriod;
	}
	public void setIsPeriod(int isPeriod) {
		this.isPeriod = isPeriod;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
}
