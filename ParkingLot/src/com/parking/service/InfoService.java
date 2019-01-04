package com.parking.service;

import java.util.List;

import com.parking.dao.InfoDao;
import com.parking.entity.Info;

public class InfoService {
	private InfoDao infoDao =new InfoDao();
	//入场操作
	public void Approach(Info info){
		infoDao.insertInfo(info);
	}
	//出场操作
	public void Appearance(Info info){
		infoDao.updateInfo(info);
	}
	//查询车辆信息
	public List<Info> findInfoByState(){
		
		return infoDao.selectAllInfo();
		
	}
}
