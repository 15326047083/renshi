package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.entity.ChangeDept;
import com.neusoft.entity.ChangePost;
import com.neusoft.entity.Dept;
import com.neusoft.entity.Emp;
import com.neusoft.entity.Post;
import com.neusoft.util.DBUtil;

public class ChangeDao {
	/**
	 * 根据id找员工
	 * @param id
	 * @return
	 */
	public Emp findEmpDept(int id) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "select * from emp_basic_info where emp_id=? and is_quit=0";
	
		ResultSet rs = null;
		Emp emp = null;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				emp = new Emp();
				emp.setId(rs.getInt("emp_id"));
				emp.setName(rs.getString("emp_name"));
				emp.setDeptId(rs.getInt("emp_dept"));
				emp.setPostId(rs.getInt("post_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		return emp;
	}
	/**
	 * 根据name找员工
	 * @param id
	 * @return
	 */
	public Emp findEmpDept(String name) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "select * from emp_basic_info where emp_name=? and is_quit=0";
		ResultSet rs = null;
		Emp emp = null;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				emp = new Emp();
				emp.setId(rs.getInt("emp_id"));
				emp.setName(rs.getString("emp_name"));
				emp.setDeptId(rs.getInt("emp_dept"));
				emp.setPostId(rs.getInt("post_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		return emp;
	}
	/**
	 * 调换员工部门
	 * @param emp
	 */
	public void changedept(Emp emp) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "update emp_basic_info set emp_dept=? where emp_id=? and is_quit=0";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,emp.getDeptId());
			
			pstmt.setInt(2,emp.getId());
		
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	}
	/**
	 * 记录调换部门信息
	 * @param changedept
	 * @throws SQLException
	 */
	public void addChangeDept(ChangeDept changedept) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql="insert into `change_dept` (`emp_id`,`emp_name`,`old_dept_id`,`new_dept_id`,`change_date`)values(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
		//	pstmt.setInt(1, changedept.getId());
			pstmt.setInt(1,changedept.getEmpid());
			pstmt.setString(2, changedept.getEmpname());
			pstmt.setInt(3, changedept.getOlddept());
			pstmt.setInt(4, changedept.getNewdept());
			pstmt.setString(5, changedept.getChangedate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pstmt.close();
			conn.close();
		}
	
	}
	/**
	 * 获取部门调换列表
	 * @return
	 * @throws SQLException
	 */
	public List findAll() throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "select * from `change_dept`";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		ChangeDept changedept = null;
		List<ChangeDept> list = new ArrayList<ChangeDept>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				changedept = new ChangeDept();
				changedept.setId(rs.getInt("id"));
				changedept.setEmpid(rs.getInt("emp_id"));
				changedept.setEmpname(rs.getString("emp_name"));
				changedept.setOlddept(rs.getInt("old_dept_id"));
				changedept.setNewdept(rs.getInt("new_dept_id"));
				changedept.setChangedate(rs.getString("change_date"));
			
				list.add(changedept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		return list;
	}
	/**
	 * 调换员工岗位
	 * @param emp
	 */
	public void changepost(Emp emp) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "update emp_basic_info set post_id=? where emp_id=? and is_quit=0";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,emp.getPostId());
			
			pstmt.setInt(2,emp.getId());
		
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	}
	/**
	 * 记录调换岗位信息
	 * @param changedept
	 * @throws SQLException
	 */
	public void addChangePost(ChangePost changepost) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql="insert into `change_post` (`emp_id`,`emp_name`,`old_post_id`,`new_post_id`,`change_date`)values(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
		
			pstmt.setInt(1,changepost.getEmpid());
			pstmt.setString(2, changepost.getEmpname());
			pstmt.setInt(3, changepost.getOldpost());
			pstmt.setInt(4, changepost.getNewpost());
			pstmt.setString(5, changepost.getChangedate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pstmt.close();
			conn.close();
		}
	
	}
	/**
	 * 获取岗位调换列表
	 * @return
	 * @throws SQLException
	 */
	public List findAllpost() throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "select * from `change_post`";
					
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		ChangePost changepost = null;
		List<ChangePost> list = new ArrayList<ChangePost>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				changepost = new ChangePost();
				changepost.setId(rs.getInt("id"));
				changepost.setEmpid(rs.getInt("emp_id"));
				changepost.setEmpname(rs.getString("emp_name"));
				changepost.setOldpost(rs.getInt("old_post_id"));
				changepost.setNewpost(rs.getInt("new_post_id"));
				changepost.setChangedate(rs.getString("change_date"));
			
				list.add(changepost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		return list;
	}
	
	public List findAllpostByTime(String start,String end) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "select * from `change_post` where change_date>? and change_date<?";
					
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		ChangePost changepost = null;
		List<ChangePost> list = new ArrayList<ChangePost>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, start);
			pstmt.setString(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()){
				changepost = new ChangePost();
				changepost.setId(rs.getInt("id"));
				changepost.setEmpid(rs.getInt("emp_id"));
				changepost.setEmpname(rs.getString("emp_name"));
				changepost.setOldpost(rs.getInt("old_post_id"));
				changepost.setNewpost(rs.getInt("new_post_id"));
				changepost.setChangedate(rs.getString("change_date"));
			
				list.add(changepost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		return list;
	}
	public List findAllByTime(String start,String end) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "select * from `change_dept` where change_date>? and change_date<?";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		ChangeDept changedept = null;
		List<ChangeDept> list = new ArrayList<ChangeDept>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, start);
			pstmt.setString(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()){
				changedept = new ChangeDept();
				changedept.setId(rs.getInt("id"));
				changedept.setEmpid(rs.getInt("emp_id"));
				changedept.setEmpname(rs.getString("emp_name"));
				changedept.setOlddept(rs.getInt("old_dept_id"));
				changedept.setNewdept(rs.getInt("new_dept_id"));
				changedept.setChangedate(rs.getString("change_date"));
			
				list.add(changedept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		return list;
	}
}
