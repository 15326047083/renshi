package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import com.neusoft.entity.Emp;
import com.neusoft.util.DBUtil;
import com.neusoft.util.Sql;

public class EmpDao {
	public void registByTalent(Emp e) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt=null;
		String sql = Sql.addInfo;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getName());
			pstmt.setInt(2, e.getSexInt());
			pstmt.setDate(3, e.getBirthday());
			pstmt.setString(4, e.getIdNum());
			pstmt.setInt(5,getDeptIdDao(e.getDeptName()) );
			pstmt.setDate(6, e.getHiredate());
			pstmt.setDate(7, e.getWorkDate());
			pstmt.setInt(8, e.getEmpFormInt());
			pstmt.setInt(9, e.getEmpSourcesInt());
			pstmt.setInt(10, e.getPoliticalOutlookInt());
			pstmt.setString(11, e.getNation());
			pstmt.setString(12, e.getNativePlace());
			pstmt.setString(13, e.getTel());
			pstmt.setString(14, e.getEmail());
			pstmt.setDouble(15, e.getHeight());
			pstmt.setInt(16, e.getBloodTypeInt());
			pstmt.setInt(17, e.getMaritalStatusInt());
			pstmt.setString(18, e.getHomeplace());
			pstmt.setString(19, e.getRegisteredResidence());
			pstmt.setInt(20, e.getHighestEducationInt());
			pstmt.setString(21, e.getGraduationSchool());
			pstmt.setString(22, e.getMajor());
			pstmt.setDate(23, e.getGraduationDate());
			pstmt.setInt(24, getPostIdDao(e.getPostName()));
			pstmt.setString(25, e.getWorkInfo());
			pstmt.setString(26, e.getForeignLanguagesInfo());
			pstmt.setString(27, e.getFamilyInfo());
			pstmt.setInt(28, 0);
			pstmt.setInt(29, 1);
			pstmt.executeUpdate();		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}
	}
	public void deleteDao(int id) throws SQLException, ParseException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt=null;
		java.util.Date date=new java.util.Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		df.format(date);
		java.sql.Date hiredate = new java.sql.Date(df.parse(df.format(date)).getTime());
		String sql = Sql.deleteInfo;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1,hiredate);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}
	}
	public void updataDao(Emp e) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt=null;
		String sql = Sql.updateInfo;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getName());
			pstmt.setInt(2, e.getSexInt());
			pstmt.setDate(3, e.getBirthday());
			pstmt.setString(4, e.getIdNum());
			pstmt.setInt(5,getDeptIdDao(e.getDeptName()) );
			pstmt.setDate(6, e.getHiredate());
			pstmt.setDate(7, e.getWorkDate());
			pstmt.setInt(8, e.getEmpFormInt());
			pstmt.setInt(9, e.getEmpSourcesInt());
			pstmt.setInt(10, e.getPoliticalOutlookInt());
			pstmt.setString(11, e.getNation());
			pstmt.setString(12, e.getNativePlace());
			pstmt.setString(13, e.getTel());
			pstmt.setString(14, e.getEmail());
			pstmt.setDouble(15, e.getHeight());
			pstmt.setInt(16, e.getBloodTypeInt());
			pstmt.setInt(17, e.getMaritalStatusInt());
			pstmt.setString(18, e.getHomeplace());
			pstmt.setString(19, e.getRegisteredResidence());
			pstmt.setInt(20, e.getHighestEducationInt());
			pstmt.setString(21, e.getGraduationSchool());
			pstmt.setString(22, e.getMajor());
			pstmt.setDate(23, e.getGraduationDate());
			pstmt.setInt(24, getPostIdDao(e.getPostName()));
			pstmt.setString(25, e.getWorkInfo());
			pstmt.setString(26, e.getForeignLanguagesInfo());
			pstmt.setString(27, e.getFamilyInfo());
			pstmt.setInt(28, 0);
			pstmt.setInt(29, 0);
			pstmt.setInt(30, e.getId());
			pstmt.executeUpdate();		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}
	}
	public Emp selectAllDao(int id) throws SQLException{
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Emp e = null;
		String sql=Sql.selectAll;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				e = new Emp();
				e.setId(id);
				e.setName(rs.getString(2));
				e.setSex(rs.getInt(3));
				e.setBirthday(rs.getDate(4));
				e.setIdNum(rs.getString(5));
				e.setDeptName(getDeptNameByIdDao(rs.getInt(6)));
				e.setHiredate(rs.getDate(7));
				e.setWorkDate(rs.getDate(8));
				e.setEmpForm(rs.getInt(9));
				e.setEmpSources(rs.getInt(10));
				e.setPoliticalOutlook(rs.getInt(11));
				e.setNation(rs.getString(12));
				e.setNativePlace(rs.getString(13));
				e.setTel(rs.getString(14));
				e.setEmail(rs.getString(15));
				e.setHeight(rs.getDouble(16));
				e.setBloodType(rs.getInt(17));
				e.setMaritalStatus(rs.getInt(18));
				e.setHomeplace(rs.getString(19));
				e.setRegisteredResidence(rs.getString(20));
				e.setHighestEducation(rs.getInt(21));
				e.setGraduationSchool(rs.getString(22));
				e.setMajor(rs.getString(23));
				e.setGraduationDate(rs.getDate(24));
				e.setPostName(getPostNameByIdDao(rs.getInt(25)));
				e.setWorkInfo(rs.getString(26));
				e.setForeignLanguagesInfo(rs.getString(27));
				e.setFamilyInfo(rs.getString(28));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}	
		
		return e;
	}
	/*public ArrayList<Emp> QuarryAllDao() throws SQLException{
		ArrayList<Emp> list = new ArrayList<Emp>();
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Emp e = null;
		String sql=Sql.quarryAll;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSex(rs.getInt(3));
				e.setBirthday(rs.getDate(4));
				e.setIdNum(rs.getString(5));
				e.setDeptName(getDeptNameByIdDao(rs.getInt(6)));
				e.setHiredate(rs.getDate(7));
				e.setWorkDate(rs.getDate(8));
				e.setEmpForm(rs.getInt(9));
				e.setEmpSources(rs.getInt(10));
				e.setPoliticalOutlook(rs.getInt(11));
				e.setNation(rs.getString(12));
				e.setNativePlace(rs.getString(13));
				e.setTel(rs.getString(14));
				e.setEmail(rs.getString(15));
				e.setHeight(rs.getDouble(16));
				e.setBloodType(rs.getInt(17));
				e.setMaritalStatus(rs.getInt(18));
				e.setHomeplace(rs.getString(19));
				e.setRegisteredResidence(rs.getString(20));
				e.setHighestEducation(rs.getInt(21));
				e.setGraduationSchool(rs.getString(22));
				e.setMajor(rs.getString(23));
				e.setGraduationDate(rs.getDate(24));
				e.setPostName(getPostNameByIdDao(rs.getInt(25)));
				e.setWorkInfo(rs.getString(26));
				e.setForeignLanguagesInfo(rs.getString(27));
//				e.setIsQuit(rs.getInt(28));
//				e.setIsPeriod(rs.getInt(29));
				list.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}	
		return list;
	}*/
	public ArrayList<Emp> QuarryAllDao() throws SQLException{
		ArrayList<Emp> list = new ArrayList<Emp>();
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Emp e = null;
		String sql=Sql.quarryAll;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDeptName(getDeptNameByIdDao(rs.getInt(6)));
				e.setTel(rs.getString(14));
				e.setEmail(rs.getString(15));
				e.setPostName(getPostNameByIdDao(rs.getInt(25)));
				list.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}	
		return list;
	}
	public ArrayList<Emp> QuarryAllByIdDao(int id) throws SQLException{
		ArrayList<Emp> list = new ArrayList<Emp>();
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Emp e = null;
		String sql=Sql.quarryAllById;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDeptName(getDeptNameByIdDao(rs.getInt(6)));
				e.setTel(rs.getString(14));
				e.setEmail(rs.getString(15));
				e.setPostName(getPostNameByIdDao(rs.getInt(25)));
				list.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}	
		return list;
	}
	public int selectEmpIdByName(String name) throws SQLException{
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		int id=0;
		String sql = Sql.selectIdByName;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				id=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}	
		return id;
	}
	public int getDeptIdDao(String deptName) throws SQLException{
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		String sql = Sql.getDeptId;
		int deptId = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				deptId = rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}	
		return deptId;
	}
	public int getPostIdDao(String postName) throws SQLException{
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		String sql = Sql.getPostId;
		int postId = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, postName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				postId = rs.getInt("post_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}	
		return postId;
	}
	public int getMaxIdDao() throws SQLException{
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		String sql = Sql.getMaxId;
		int maxId=0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				maxId= rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}
		return maxId;
	}
	public String getDeptNameByIdDao(int id) throws SQLException{
		String name="";
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		String sql = Sql.selectDeptName;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}
		return name;
	}
	public String getPostNameByIdDao(int id) throws SQLException{
		String name="";
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		String sql = Sql.selectPostName;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				name = rs.getString("post_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}
		return name;
	}
	public ArrayList<Emp> QuarryAllQuitDao() throws SQLException{
		ArrayList<Emp> list = new ArrayList<Emp>();
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Emp e = null;
		String sql=Sql.quarryAllQuit;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDeptName(getDeptNameByIdDao(rs.getInt(6)));
				e.setTel(rs.getString(14));
				e.setEmail(rs.getString(15));
				e.setPostName(getPostNameByIdDao(rs.getInt(25)));
				list.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}	
		return list;
	}
	
	
	public ArrayList<Emp> SelectAllQuitByDeptDao(String dept,Date start,Date end) throws SQLException{
		ArrayList<Emp> list = new ArrayList<Emp>();
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Emp e = null;
		String sql=Sql.selectQuit;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, start);
			pstmt.setDate(2, end);
			pstmt.setInt(3, getDeptIdDao(dept));
			rs = pstmt.executeQuery();
			while(rs.next()){
				e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSex(rs.getInt(3));
				e.setBirthday(rs.getDate(4));
				e.setIdNum(rs.getString(5));
				e.setDeptName(getDeptNameByIdDao(rs.getInt(6)));
				e.setHiredate(rs.getDate(7));
				e.setWorkDate(rs.getDate(8));
				e.setEmpForm(rs.getInt(9));
				e.setEmpSources(rs.getInt(10));
				e.setPoliticalOutlook(rs.getInt(11));
				e.setNation(rs.getString(12));
				e.setNativePlace(rs.getString(13));
				e.setTel(rs.getString(14));
				e.setEmail(rs.getString(15));
				e.setHeight(rs.getDouble(16));
				e.setBloodType(rs.getInt(17));
				e.setMaritalStatus(rs.getInt(18));
				e.setHomeplace(rs.getString(19));
				e.setRegisteredResidence(rs.getString(20));
				e.setHighestEducation(rs.getInt(21));
				e.setGraduationSchool(rs.getString(22));
				e.setMajor(rs.getString(23));
				e.setGraduationDate(rs.getDate(24));
				e.setPostName(getPostNameByIdDao(rs.getInt(25)));
				e.setWorkInfo(rs.getString(26));
				e.setForeignLanguagesInfo(rs.getString(27));
//				e.setIsQuit(rs.getInt(28));
//				e.setIsPeriod(rs.getInt(29));
				list.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}	
		return list;
	}
	
	public ArrayList<Emp> SelectAllByDeptDao(String dept,Date start,Date end) throws SQLException{
		ArrayList<Emp> list = new ArrayList<Emp>();
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Emp e = null;
		String sql=Sql.selectNewByDept;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, start);
			pstmt.setDate(2, end);
			pstmt.setInt(3, getDeptIdDao(dept));
			rs = pstmt.executeQuery();
			while(rs.next()){
				e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSex(rs.getInt(3));
				e.setBirthday(rs.getDate(4));
				e.setIdNum(rs.getString(5));
				e.setDeptName(getDeptNameByIdDao(rs.getInt(6)));
				e.setHiredate(rs.getDate(7));
				e.setWorkDate(rs.getDate(8));
				e.setEmpForm(rs.getInt(9));
				e.setEmpSources(rs.getInt(10));
				e.setPoliticalOutlook(rs.getInt(11));
				e.setNation(rs.getString(12));
				e.setNativePlace(rs.getString(13));
				e.setTel(rs.getString(14));
				e.setEmail(rs.getString(15));
				e.setHeight(rs.getDouble(16));
				e.setBloodType(rs.getInt(17));
				e.setMaritalStatus(rs.getInt(18));
				e.setHomeplace(rs.getString(19));
				e.setRegisteredResidence(rs.getString(20));
				e.setHighestEducation(rs.getInt(21));
				e.setGraduationSchool(rs.getString(22));
				e.setMajor(rs.getString(23));
				e.setGraduationDate(rs.getDate(24));
				e.setPostName(getPostNameByIdDao(rs.getInt(25)));
				e.setWorkInfo(rs.getString(26));
				e.setForeignLanguagesInfo(rs.getString(27));
//				e.setIsQuit(rs.getInt(28));
//				e.setIsPeriod(rs.getInt(29));
				list.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
			}if(pstmt!=null){
				pstmt.close();
			}if(conn!=null){
				conn.close();
			}
		}	
		return list;
	}
	public Emp selectAllQuitService(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Emp e = null;
		String sql=Sql.selectAllQuitService;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				e = new Emp();
				e.setId(id);
				e.setName(rs.getString(2));
				e.setSex(rs.getInt(3));
				e.setBirthday(rs.getDate(4));
				e.setIdNum(rs.getString(5));
				e.setDeptName(getDeptNameByIdDao(rs.getInt(6)));
				e.setHiredate(rs.getDate(7));
				e.setWorkDate(rs.getDate(8));
				e.setEmpForm(rs.getInt(9));
				e.setEmpSources(rs.getInt(10));
				e.setPoliticalOutlook(rs.getInt(11));
				e.setNation(rs.getString(12));
				e.setNativePlace(rs.getString(13));
				e.setTel(rs.getString(14));
				e.setEmail(rs.getString(15));
				e.setHeight(rs.getDouble(16));
				e.setBloodType(rs.getInt(17));
				e.setMaritalStatus(rs.getInt(18));
				e.setHomeplace(rs.getString(19));
				e.setRegisteredResidence(rs.getString(20));
				e.setHighestEducation(rs.getInt(21));
				e.setGraduationSchool(rs.getString(22));
				e.setMajor(rs.getString(23));
				e.setGraduationDate(rs.getDate(24));
				e.setPostName(getPostNameByIdDao(rs.getInt(25)));
				e.setWorkInfo(rs.getString(26));
				e.setForeignLanguagesInfo(rs.getString(27));
				e.setFamilyInfo(rs.getString(28));
			}
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				if(rs!=null){
					rs.close();
				}if(pstmt!=null){
					pstmt.close();
				}if(conn!=null){
					conn.close();
				}
			}	
			return e;
	}
}
