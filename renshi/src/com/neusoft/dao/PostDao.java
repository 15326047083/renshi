package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.entity.Emp;
import com.neusoft.entity.Post;
import com.neusoft.util.DBUtil;

public class PostDao {
	/**
	 * 查找最大id号
	 * @return
	 * @throws SQLException
	 */
	public int selectMaxId() throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "select max(post_id) from post";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		int maxid =0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				maxid =rs.getInt(1);//查出一条数据 
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
		
		return maxid;
	}
	/**
	 * 添加岗位信息
	 * @param post
	 * @throws SQLException 
	 */
	public void insertPost(Post post) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "insert into `post` (`post_id`,`post_name`,`post_type`,`max_ep`,`post_live`)values(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, post.getId());
			pstmt.setString(2, post.getPostname());
			pstmt.setInt(3, post.getPosttype());
			pstmt.setInt(4, post.getMaxep());
			pstmt.setInt(5, 1);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	}
	/**
	 * 获取岗位列表
	 * @return
	 * @throws SQLException
	 */
	public List findAll() throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "select * from post where post_live=1";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Post post = null;
		List<Post> list = new ArrayList<Post>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				post = new Post();
				int id = rs.getInt("post_id");
				String postname = rs.getString("post_name");
				int posttype = rs.getInt("post_type");
				int maxep = rs.getInt("max_ep");
				post.setId(id);
				post.setPostname(postname);
				post.setPosttype(posttype);
				post.setMaxep(maxep);
				list.add(post);
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
	 *  获取需要编辑的数据id 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Post getinfo(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConnection();
		String sql = "select * from post where post_id=? and post_live=1";
		ResultSet rs = null;
		Post post = null;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				post = new Post();
				post.setId(rs.getInt("post_id"));
				post.setPostname(rs.getString("post_name"));
				post.setPosttype(rs.getInt("post_type"));
				post.setMaxep(rs.getInt("max_ep"));
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
		return post;
	}
	/**
	 * 修改岗位信息
	 * @param post
	 * @throws SQLException
	 */
	public void updateInfo(Post post) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "update post set post_name=?,post_type=?,max_ep=? where post_id=? and post_live=1";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,post.getPostname());
			pstmt.setInt(2,post.getPosttype());
			pstmt.setInt(3,post.getMaxep());
			pstmt.setInt(4, post.getId());
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
	 * 删除岗位
	 * @param id
	 * @throws SQLException
	 */
	public void deletePost(int id) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql = "update post set post_live=0 where post_id=?";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	}
	/**
	 * 查找岗位下的员工
	 * @param posttype
	 * @return
	 * @throws SQLException 
	 */
	public List emInPost(int posttype) throws SQLException{
	//	System.out.println("*******111"+posttype);
		List<Post> list = new ArrayList();
		Connection conn=DBUtil.getConnection();
		String sql = "select * from post where post_type=? and post_live=1";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Post post = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, posttype);
			rs = pstmt.executeQuery();
			while(rs.next()){
				post=new Post();
				post.setId(rs.getInt("post_id"));
				post.setPostname(rs.getString("post_name"));
				post.setPosttype(rs.getInt("post_type"));
				post.setMaxep(rs.getInt("max_ep"));
				list.add(post);
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
	public List<Emp> fingEmpById(int id) {
		// TODO Auto-generated method stub
				Connection conn = DBUtil.getConnection();
				List<Emp> list=new ArrayList<Emp>();
				Emp emp=null;
				ResultSet rs=null;
				String sql="select * from `emp_basic_info` where `post_id`=? and `is_quit`=0";
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
	/**
	 * 查询相关数据
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Post findInfo(int id) throws SQLException {
		ResultSet rs =null;
		Connection conn = DBUtil.getConnection();
		String sql="select * from post where post_id=? and post_live=1";
		PreparedStatement pstmt=null;
		Post post=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				post=new Post();
				post.setId(id);
				post.setPostname(rs.getString(2));
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close();
			pstmt.close();
			rs.close();
		}
		return post;
	}
	public String findname(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ResultSet rs=null;
		String name=null;
		String sql="select post_name from `post` where `post_id`=? and `post_live`=1";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				name=rs.getString("post_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close();
			pstmt.close();
		}
		return name;
	}
	public int countPostEmp(int id) {
		// TODO Auto-generated method stub
		int num=0;
		Connection conn = DBUtil.getConnection();
		String sql="select count(*) from `emp_basic_info` where post_id=? and is_quit=0";
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
	public List findCanAddAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConnection();
		String sql = "select * from post where post_live=1";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Post post = null;
		List<Post> list = new ArrayList<Post>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				post = new Post();
				int id = rs.getInt("post_id");
				String postname = rs.getString("post_name");
				int posttype = rs.getInt("post_type");
				int maxep = rs.getInt("max_ep");
				if(maxep>countPostEmp(id)){
					post.setId(id);
					post.setPostname(postname);
					post.setPosttype(posttype);
					post.setMaxep(maxep);
					list.add(post);
				}
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
		return list;
	}
}
