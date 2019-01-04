package com.parking.service;

import com.parking.dao.PictureDao;
import com.parking.entity.Picture;

public class PictureService {

	private PictureDao pictureDao =new PictureDao();
	
	public void addPicture(Picture picture){
		
		pictureDao.insertPicture(picture);
	
	}
	
}
