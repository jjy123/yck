package com.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.parking.entity.Info;
import com.parking.utils.SqlUtil;

/*
 * 出场操作
 * 入场操作
 * 停车场车辆查询
 * 停车场历史车辆查询
 * 
 */
public class                           	InfoDao{
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String endtime = sdf.format(new Date());
		InfoDao infodao=new InfoDao();
		Info info =new Info();
		//info.setId(UUID.randomUUID().toString());
		//info.setStarttime(date);
		/*info.setEndtime(endtime);
		info.setCardnum("1118");
		info.setLicensenum("8888");
		info.setAmount(10.8);*/
		//info.setManager("张三");
		info.setState("0");
		/*infodao.insertApproach(info);*/
		/*infodao.updateAppearance(info);*/
	}
	//入场操作
	public void insertInfo(Info info){
	Connection conn = SqlUtil.ConnectionMysql();
	String sql="insert into t_info(id,cardnum,licensenum,starttime,endtime,state,manager,amount,url) values" +
			"(?,?,?,?,?,?,?,?,?)";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, info.getId());
		ps.setString(2, info.getCardnum());
		ps.setString(3, info.getLicensenum());
		ps.setString(4, info.getStarttime());
		ps.setString(5, info.getEndtime());
		ps.setString(6, info.getState());
		ps.setString(7, info.getManager());
		ps.setDouble(8, info.getAmount());
		ps.setString(9, info.getUrl());
		int rs = ps.executeUpdate();
		System.out.println(rs);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	//出场操作
	public void updateInfo(Info info){
		Connection conn= SqlUtil.ConnectionMysql();
		String sql ="update t_info set endtime=?,state=?,amount=? where cardnum=? and licensenum=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,info.getEndtime());
			ps.setString(2, "1");
			ps.setDouble(3, info.getAmount());
			ps.setString(4, info.getCardnum());
			ps.setString(5, info.getLicensenum());
			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置停车状态为出场状态 即 state =1
		//需要设置出场时间
	}
	
	//停车场车辆查询
	public List<Info> selectAllInfo(){
		Info info =null;
		List<Info> infolist=new ArrayList<Info>();
		Connection conn= SqlUtil.ConnectionMysql();
		String sql="select * from t_info";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				info=new Info();
				info.setId(rs.getString("id"));
				info.setCardnum(rs.getString("cardnum"));
				info.setLicensenum(rs.getString("licensenum"));
				info.setManager(rs.getString("manager"));
				info.setStarttime(rs.getString("starttime"));
				info.setEndtime(rs.getString("endtime"));
				info.setState(rs.getString("state"));
				info.setAmount(rs.getDouble("amount"));
				info.setUrl(rs.getString("url"));
				infolist.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infolist;
		
	}
	//实现分页显示
	public List<Info> selectInfoByLimit(Info info2){
		Info info =null;
		List<Info> infolist=new ArrayList<Info>();
		Connection conn =SqlUtil.ConnectionMysql();
		String sql="select * from t_info limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, info2.getStartpage());
			ps.setInt(2, info2.getPagesize());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				info=new Info();
				info.setId(rs.getString("id"));
				info.setCardnum(rs.getString("cardnum"));
				info.setLicensenum(rs.getString("licensenum"));
				info.setManager(rs.getString("manager"));
				info.setStarttime(rs.getString("starttime"));
				info.setEndtime(rs.getString("endtime"));
				info.setState(rs.getString("state"));
				info.setAmount(rs.getDouble("amount"));
				info.setUrl(rs.getString("url"));
				System.out.println(rs.getString("url"));
				System.out.println("info:"+info);
				infolist.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infolist;
		
	}
	
	
}
