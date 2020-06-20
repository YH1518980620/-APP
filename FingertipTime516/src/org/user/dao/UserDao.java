package org.user.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.user.entity.User;

//数据访问层:增删改查
public class UserDao {
	
	private final String URL="jdbc:mysql://localhost:3306/user";
	private final String USERNAME="root";
	private final String PWD="123456";
	
	public boolean isExist(String uname) {
		return queryUserByUname(uname)==null?false:true;
	}
	
	public boolean addUser(User user) {
		Connection connection=null;
		PreparedStatement pstmt=null;
			try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			String sql="insert into userinformation values(?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getUid());
			pstmt.setString(3, user.getUsex());
			pstmt.setString(4, user.getUpwd());
			int count =pstmt.executeUpdate();
			if(count>0)
				return true;
			else
				return false;
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}finally {
				try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	public User queryUserByUname(String uname) {
		//用户封装
		User user=null;
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			try {
			//a.导入驱动，加载具体的驱动类
			Class.forName("com.mysql.jdbc.Driver");//加载驱动类
			//b.与数据库建立连接
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			//c.发送sql，执行查
			String sql="select * from userinformation where uname=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, uname);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String name=rs.getString("uname");
				String id=rs.getString("uid");
				String sex=rs.getString("usex");
				String pwd=rs.getString("pwd");
				user=new User(name,id,sex,pwd);
			}
			return user;
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
			catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
	}
	
	}
	

