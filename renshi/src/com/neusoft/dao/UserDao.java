package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.entity.User;
import com.neusoft.util.DBUtil;

public class UserDao {
	/**
	 * 查询是否存在用户名
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public int getCountUsername(String username) throws SQLException{
		int count=0;
		Connection conn=DBUtil.getConnection();
		String sql = "select count(username) from user where username=?";
		PreparedStatement pstmt = null;
		ResultSet  rs=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username); 
			rs = pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		return count;
	}
/**
 * 通过用户名获取密码
 * @param username
 * @return
 * @throws SQLException
 */
	public String getPassword(String username) throws SQLException {
		// TODO Auto-generated method stub
		String password=null;
		Connection conn=DBUtil.getConnection();
		String sql="select password from user where username=?";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			if(rs.next()){
				password=rs.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		return password;
	}
	/**
	 * 新建用户
	 * @param user
	 * @throws SQLException
	 */
	public void newUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConnection();
		String sql="insert into `user` (`username`,`password`,`problem`,`answer`,`phone`)values(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getProblem());
			pstmt.setString(4, user.getAnswer());
			pstmt.setString(5, user.getPhone());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		
	}
	public String[] findPassword(String username) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConnection();
		String []anquan=null;
		ResultSet rs=null;
		String sql="select problem,answer from user where username=?";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				anquan=new String[2];
				anquan[0]=rs.getString(1);
				anquan[1]=rs.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(rs!=null){
				rs.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		return anquan;
	}
	public void changePassword(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConnection();
		String sql="update `user` set `password`=? where `username`=?";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	}
		
}
