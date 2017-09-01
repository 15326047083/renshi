package com.neusoft.service;

import java.sql.SQLException;

import com.neusoft.dao.UserDao;
import com.neusoft.entity.User;

public class UserService {
	public int getCountUsername(String username){
		int count=0;
		UserDao userdao=new UserDao();
		try {
			count=userdao.getCountUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public String getPassword(String username) {
		// TODO Auto-generated method stub
		String password=null;
		UserDao userdao=new UserDao();
		try {
			password=userdao.getPassword(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}
	public void newUser(User user) {
		// TODO Auto-generated method stub
		UserDao userdao=new UserDao();
		try {
			userdao.newUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String[] findPassword(String username) {
		// TODO Auto-generated method stub
		String []anquan=null;
		UserDao userdao=new UserDao();
		try {
			
			anquan=userdao.findPassword(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return anquan;
	}
	public void changePassword(String username, String password) {
		// TODO Auto-generated method stub
		UserDao userdao=new UserDao();
		try {
			userdao.changePassword(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
