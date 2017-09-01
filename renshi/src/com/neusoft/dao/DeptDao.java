package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.neusoft.entity.Dept;
import com.neusoft.entity.Emp;
import com.neusoft.util.DBUtil;

public class DeptDao {
	/**
	 * 新建部门
	 * @param dept
	 * @throws SQLException
	 */
	public void NewDept(Dept dept) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql="insert into `dept` (`id`,`name`,`type`,`phone`,`fax`,`info`,`sdept`,`date`)values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getId());
			pstmt.setString(2, dept.getName());
			pstmt.setString(3, dept.getType());
			pstmt.setString(4, dept.getPhone());
			pstmt.setString(5, dept.getFax());
			pstmt.setString(6, dept.getInfo());
			pstmt.setString(7, dept.getSdept());
			pstmt.setString(8, dept.getDate());
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
	 * 获取数据库中最大id
	 * @return
	 * @throws SQLException
	 */
	public int selectMaxId() throws SQLException{
		int id=0;
		Connection conn=DBUtil.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select max(id) from dept";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				id=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close();
			pstmt.close();
			rs.close();
		}
		return id;
	}
	/**
	 * 获取数据库列表
	 * @return
	 * @throws SQLException
	 */
	public List findAll(String sql1) throws SQLException{
		ResultSet rs =null;
		Connection conn = DBUtil.getConnection();
		String sql="select * from dept where dept_live=1"+sql1;
		PreparedStatement pstmt=null;
		Dept dept=null;
		List<Dept> list=new ArrayList<Dept>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				dept=new Dept();
				int id=rs.getInt("id");
				dept.setId(id);
				String type=rs.getString("type");
				dept.setType(type);
				String name=rs.getString("name");
				dept.setName(name);
				dept.setDate(rs.getString("date"));
				dept.setFax(rs.getString("fax"));
				dept.setSdept(rs.getString("sdept"));
				dept.setInfo(rs.getString("info"));
				dept.setPhone(rs.getString("phone"));
				list.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close();
			pstmt.close();
			rs.close();
		}
		return list;
	}
	/**
	 * 查询相关数据
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Dept findInfo(int id) throws SQLException {
		ResultSet rs =null;
		Connection conn = DBUtil.getConnection();
		String sql="select * from dept where id=? and dept_live=1";
		PreparedStatement pstmt=null;
		Dept dept=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				dept=new Dept();
				dept.setId(id);
				dept.setName(rs.getString(2));
				dept.setType(rs.getString(3));
				dept.setPhone(rs.getString(4));
				dept.setFax(rs.getString(5));
				dept.setInfo(rs.getString(6));
				dept.setSdept(rs.getString(7));
				System.out.println(dept.getFax());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close();
			pstmt.close();
			rs.close();
		}
		return dept;
	}
	/**
	 * 修改
	 * @param dept
	 * @throws SQLException
	 */
	public void updateDept(Dept dept) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="update dept set name=?,type=?,phone=?,fax=?,info=?,sdept=? where id=? and dept_live=1";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dept.getName());
			pstmt.setString(2, dept.getType());
			pstmt.setString(3, dept.getPhone());
			pstmt.setString(4, dept.getFax());
			pstmt.setString(5, dept.getInfo());
			pstmt.setString(6, dept.getSdept());
			pstmt.setInt(7, dept.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close();
			pstmt.close();
		}
	}
	/**
	 * 删除
	 * @param id
	 * @throws SQLException
	 */
	public void delDept(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql="update `dept` set `dept_live`=0 where `id`=?";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close();
			pstmt.close();
		}
	}
	/**
	 * 根据部门名称获取id
	 * @param name
	 * @return
	 */
	public int findId(String name) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		int id=0;
		ResultSet rs=null;
		String sql="select `id` from `dept` where `name`=? and `dept_live`=1";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				id=rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	/**
	 * 根据id获取信息
	 * @param id
	 * @return
	 */
	public List<Emp> fingEmpById(int id) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		List<Emp> list=new ArrayList<Emp>();
		Emp emp=null;
		ResultSet rs=null;
		String sql="select * from `emp_basic_info` where `emp_dept`=? and `is_quit`=0";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				emp=new Emp();
				emp.setId(rs.getInt("emp_id"));
				emp.setName(rs.getString("emp_name"));
				if(rs.getInt("emp_sex")==1){
					emp.setSex("男");
				}else{
					emp.setSex("女");
				}
				emp.setBirthday(rs.getDate("emp_birthday"));
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public String findname(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ResultSet rs=null;
		String name=null;
		String sql="select name from `dept` where `id`=? and dept_live=1";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				name=rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close();
			pstmt.close();
			rs.close();
		}
		return name;
	}
	public int countDeptEmp(int id) {
		// TODO Auto-generated method stub
		int num=0;
		Connection conn = DBUtil.getConnection();
		String sql="select count(*) from `emp_basic_info` where emp_dept=? and is_quit=0";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				num=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
}
