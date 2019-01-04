package com.parking.servlet;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.parking.entity.Picture;
import com.parking.service.PictureService;
@MultipartConfig
public class UpLoadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contextPath = request.getContextPath();

		PictureService pictureService =new PictureService();
		String newFileName="";
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println("ִ��uploadservlet");
		Part part=request.getPart("file");//part�����ȡ�ͻ����ϴ����ļ����������ϱ����@MuilPartConfig
		String upload = request.getServletContext().getRealPath("upload");
		String filename=getFileName(part);
		newFileName = UUID.randomUUID().toString()+filename;
		System.out.println("filename2:"+newFileName);

		File file = new File(upload, newFileName);
		file.createNewFile();
		String target = file.getAbsolutePath();
		part.write(target);
		//��ͼƬ��Ϣ���浽���ݿ�
		String url = contextPath + "/upload/" + newFileName;
		Picture picture  =new Picture();
		picture.setId(UUID.randomUUID().toString());
		picture.setName(newFileName);
		picture.setUrl(url);
		pictureService.addPicture(picture);
		//����ɹ�����json����
		response.setContentType("application/json; charset=utf-8");
		 //ƴ��json����
		String jsonStr = "{\"success\":\"true\",\"url\":\""+url+"\"}";
		 //������д������
		response.getWriter().write(jsonStr);
	}
	public String getFileName(Part part){
		String header=part.getHeader("Content-Disposition");
		System.out.println("�ļ�ͷ��Ϣ:"+header);
		String filename=header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
		System.out.println("�ļ�����"+filename);
		return filename;
	}

}
