package com.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.parking.entity.User;
import com.parking.utils.SqlUtil;
/*
 * 添加管理员
 * 修改密码
 * 删除账号
 */
public class UserDao {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		User user= new User();
		/*user.setId(UUID.randomUUID().toString());
		user.setName("张三");
		user.setPassword("123456");
		userDao.insertUser(user);*/
		/*user.setId("bd61b05b-f64e-4968-af90-2a815aca6c45");
		user.setPassword("654321");*/
		/*userDao.updateUser(user);*/
		/*User user= new User();*/
		/*user.setId("a4adbe3c-d5d0-4a22-bb2b-86edabc89b3e");
		userDao.deleteUser(user);*/
		/*user.setName("张三");
		user.setPassword("64321");
		User uu = userDao.selectUserByNameAndPassword(user);
		System.out.println(uu);*/
		/*List<User> userlist = userDao.selectUser();
		
		for (User user2 : userlist) {
			System.out.println(user2);
		}*/
	}

	//添加管理员
	public void insertUser(User user){
		Connection conn= SqlUtil.ConnectionMysql();
		String sql="insert into t_user(id,name,password) values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			int result = ps.executeUpdate();
			System.out.println("结果："+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//删除管理员
	public void deleteUser(User user){
		Connection conn =SqlUtil.ConnectionMysql();
		String sql ="delete from t_user where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,user.getId());
			int result = ps.executeUpdate();
			System.out.println("结果："+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//更改密码
	public void updateUser(User user){
		Connection conn =SqlUtil.ConnectionMysql();
		String sql ="update t_user set password =? where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,user.getPassword());
			ps.setString(2, user.getId());
			int result = ps.executeUpdate();
			System.out.println("结果："+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查询所有用户信息
	public List<User> selectUser(){
		Connection conn =SqlUtil.ConnectionMysql();
		String sql ="select * from t_user";
		User user= null;
		List<User> userlist= new ArrayList<User>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user =new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
		
	}
	//通过用户名密码查询用户是否存在
	public User selectUserByNameAndPassword(User user){
		User user2= new User();
		Connection conn =SqlUtil.ConnectionMysql();
		String sql="select * from t_user where name=? and password=?";
		try {
		
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user2.setId(rs.getString("id"));
				user2.setName(rs.getString("name"));
			}
			/*System.out.println("count:"+count);*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user2;
		
	}
	//用户信息实现分页
	public List<User> selectUserByLimit(User user2){
		User user= null;
		List<User> userlist= new ArrayList<User>();
		Connection conn =SqlUtil.ConnectionMysql();
		String sql="select * from t_user limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user2.getStartpage());
			ps.setInt(2, user2.getPagesize());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user =new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
		
	}
	
}
