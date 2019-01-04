package com.parking.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUtil {

	//远程连接数据库
	/*public static void main(String[] args) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://139.199.163.19:3306/parkinglot?useUnicode=true&characterEncoding=utf8","root","buwangchuxin123");
				String sql="select count(*)n from t_user";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					int count = rs.getInt("n");
					System.out.println("count:"+count);
				}
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}*/
	
	public static Connection  ConnectionMysql(){
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkinglot?useUnicode=true&characterEncoding=utf8",
						"root","root");
				return conn;
			}
			catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
}
