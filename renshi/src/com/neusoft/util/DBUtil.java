package com.neusoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://rm-uf6m52u8uq2x2sr9po.mysql.rds.aliyuncs.com:3306/group","root","Leiyuan123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
