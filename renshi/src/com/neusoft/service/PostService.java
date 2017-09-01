package com.neusoft.service;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.dao.DeptDao;
import com.neusoft.dao.PostDao;
import com.neusoft.entity.Emp;
import com.neusoft.entity.Post;
public class PostService {
	/**
	 * 查找最大id
	 * @return
	 */
	public int selectMaxId(){
		PostDao postdao = new PostDao();
		int maxid=0;
		try {
			maxid =postdao.selectMaxId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxid;
	}
	/**
	 * 添加岗位信息
	 * @param post
	 */
	public void insertPost(Post post){
		PostDao postdao = new PostDao();
		try {
			postdao.insertPost(post);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 获取岗位列表
	 * @return
	 */
	public List findAll(){
		PostDao postdao = new PostDao();
		List list =null;
		try {
			list=postdao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 获取需要编辑的数据id 
	 * @param id
	 * @return
	 */
	public Post getinfo(int id){
		PostDao userdao = new PostDao();
		Post post = null;
		try {
			post = userdao.getinfo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}
	/**
	 * 修改岗位信息
	 * @param post
	 */
	public void updatePost (Post post){
		PostDao userdao = new PostDao();
		try {
			userdao.updateInfo(post);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除岗位
	 * @param id
	 * @throws SQLException
	 */
	public void deletePost(int id){
		PostDao postdao = new PostDao();
		try {
			postdao.deletePost(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 查找岗位下的员工
	 * @param posttype
	 * @return
	 */
	public List emInPost(int posttype){
		
		PostDao postdao = new PostDao();
		List list =null;
		try {
			list = postdao.emInPost(posttype);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List fingEmpById(int id){
		PostDao postdao=new PostDao();
		List<Emp> list=null;
		list=postdao.fingEmpById(id);
		return list;
	}
	public Post findInfo(int id) {
		PostDao postdao = new PostDao();
		Post post=new Post();
		try {
			post=postdao.findInfo(id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}	
	public String findname(int id){
		PostDao postdao=new PostDao();
		String name=null;
		try {
			name = postdao.findname(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	public int countPostEmp(int id) {
		// TODO Auto-generated method stub
		int num=0;
		PostDao postdao=new PostDao();
		num=postdao.countPostEmp(id);
		return num;
	}
	public List findCanAddAll(){
		PostDao postdao = new PostDao();
		List list =null;
		try {
			list=postdao.findCanAddAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
