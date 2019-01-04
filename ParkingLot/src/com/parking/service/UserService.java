package com.parking.service;

import java.util.List;

import com.parking.dao.UserDao;
import com.parking.entity.User;

public class UserService {

	private UserDao userDao =new UserDao();
	//登录
	public User login(User user){
		//登录通过用户名和密码查询用户是否存在
		return userDao.selectUserByNameAndPassword(user);
		
	}
	//获取所有用户信息
	public List<User> getAllUser(){

		return userDao.selectUser();
		
	}
	//通过id删除用户信息
	public void removeUser(User user){
		userDao.deleteUser(user);
	}
	//添加管理员
	public void addUser(User user){
		userDao.insertUser(user);
	}
	//更改密码
	public void modifyUser(User user){
		
		userDao.updateUser(user);
	}
	
	
}
