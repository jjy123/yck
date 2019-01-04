package com.parking.service;

import java.util.List;

import com.parking.dao.InfoDao;
import com.parking.entity.Info;

public class InfoService {
	private InfoDao infoDao =new InfoDao();
	//�볡����
	public void Approach(Info info){
		infoDao.insertInfo(info);
	}
	//��������
	public void Appearance(Info info){
		infoDao.updateInfo(info);
	}
	//��ѯ������Ϣ
	public List<Info> findInfoByState(){
		
		return infoDao.selectAllInfo();
		
	}
}
