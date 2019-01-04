package com.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import com.parking.entity.Picture;
import com.parking.utils.SqlUtil;

public class PictureDao {
	public static void main(String[] args) {
		Picture picture =new Picture();
		picture.setId(UUID.randomUUID().toString());
		picture.setName("imgname");
		picture.setUrl("http://localhost:8080/fa");
		PictureDao pictureDao =new PictureDao();
		pictureDao.insertPicture(picture);
	}
	//´æ´¢Í¼Æ¬
	public void insertPicture(Picture picture){
		Connection conn = SqlUtil.ConnectionMysql();
		String sql="insert into t_picture(id,name,url)values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, picture.getId());
			ps.setString(2, picture.getName());
			ps.setString(3, picture.getUrl());
			int rs = ps.executeUpdate();
			System.out.println("½á¹û£º"+rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
