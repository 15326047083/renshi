package com.neusoft.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neusoft.entity.Emp;
import com.neusoft.util.DBUtil;
import com.neusoft.util.Sql;

public class TryDao {
	public void registTryDao(Emp e) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt=null;
		String sql = Sql.addTry;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getMaxIdDao());
			pstmt.setString(2, e.getName());
			System.out.println(e.getHiredate());
			pstmt.setDate(3, e.getHiredate());
			pstmt.setDate(4, e.getWorkDate());
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
	public ArrayList<Emp> QuarryAllDao() throws SQLException{
		ArrayList<Emp> list = new ArrayList<Emp>();
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Emp e = null;
		String sql=Sql.quarryTry;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				e = new Emp();
				e.setId(rs.getInt(2));
				e.setName(rs.getString(3));
				e.setHiredate(rs.getDate(4));
				e.setWorkDate(rs.getDate(5));
				e.setIsPeriod(rs.getInt(6));
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
		String sql=Sql.quarryTryById;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				e = new Emp();
				e.setId(rs.getInt(2));
				e.setName(rs.getString(3));
				e.setHiredate(rs.getDate(4));
				e.setWorkDate(rs.getDate(5));
				e.setIsPeriod(rs.getInt(6));
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
	public void changeWorkDateDao(int id,Date date) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt=null;
		String sql = Sql.changeWorkDate;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, date);
			pstmt.setDate(2, date);
			pstmt.setInt(3, id);
			pstmt.setInt(4, id);
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
	public void tryPassDao(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt=null;
		String sql = Sql.tryPass;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, id);
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
	public void tryQuitDao(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt=null;
		String sql = Sql.tryQuit;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, id);
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
}
