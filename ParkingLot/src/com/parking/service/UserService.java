package com.parking.service;

import java.util.List;

import com.parking.dao.UserDao;
import com.parking.entity.User;

public class UserService {

	private UserDao userDao =new UserDao();
	//��¼
	public User login(User user){
		//��¼ͨ���û����������ѯ�û��Ƿ����
		return userDao.selectUserByNameAndPassword(user);
		
	}
	//��ȡ�����û���Ϣ
	public List<User> getAllUser(){

		return userDao.selectUser();
		
	}
	//ͨ��idɾ���û���Ϣ
	public void removeUser(User user){
		userDao.deleteUser(user);
	}
	//��ӹ���Ա
	public void addUser(User user){
		userDao.insertUser(user);
	}
	//��������
	public void modifyUser(User user){
		
		userDao.updateUser(user);
	}
	
	
}
