package com.neusoft.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.util.DBUtil;
import com.neusoft.util.Sql;

public class CountDao {
	public int getStartNum1Dao(Date start,int deptId) throws SQLException {
		int num=0;
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = Sql.selectStartNum1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, start);
			pstmt.setInt(2, deptId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				num=rs.getInt(1);
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
		return num;
	}
	public int getStartNum2Dao(Date start,int deptId) throws SQLException {
		int num=0;
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = Sql.selectStartNum2;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, start);
			pstmt.setDate(2, start);
			pstmt.setInt(3, deptId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				num=rs.getInt(1);
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
		return num;
	}
	public int getNewNumDao(Date start,Date end,int deptId) throws SQLException {
		int num=0;
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = Sql.selectNewNum;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, end);
			pstmt.setDate(2, start);
			pstmt.setInt(3, deptId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				num=rs.getInt(1);
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
		return num;
	}
	public int getQuitNum(Date start,Date end,int deptId) throws SQLException {
		int num=0;
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = Sql.selectQuitNum;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, end);
			pstmt.setDate(2, start);
			pstmt.setInt(3, deptId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				num=rs.getInt(1);
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
		return num;
	}
	public int getInNum(Date start,Date end,int deptId) throws SQLException {
		int num=0;
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = Sql.selectChangeIn;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptId);
			pstmt.setDate(2, end);
			pstmt.setDate(3, start);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				num=rs.getInt(1);
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
		return num;
	}
	public int getOutNum(Date start,Date end,int deptId) throws SQLException {
		int num=0;
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = Sql.selectChangeOut;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptId);
			pstmt.setDate(2, end);
			pstmt.setDate(3, start);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				num=rs.getInt(1);
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
		return num;
	}
}
