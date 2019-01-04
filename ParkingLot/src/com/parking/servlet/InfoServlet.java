package com.parking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parking.entity.Info;
import com.parking.entity.User;
import com.parking.service.InfoService;

public class InfoServlet extends HttpServlet {

	private boolean success;
	private String message;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		InfoService infoService =new InfoService();
		String url=request.getRequestURI();
//		�ж��û��Ƿ��¼
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			//�볡����
			if(url.contains("approach")){
				System.out.println("ִ��approach����");
				Info info =new Info();
				info.setUrl(request.getParameter("url"));
				info.setId(UUID.randomUUID().toString());
				info.setCardnum(request.getParameter("cardnum"));
				info.setLicensenum(request.getParameter("licensenum"));
				info.setStarttime(request.getParameter("starttime"));
				info.setManager(request.getParameter("manager"));
				info.setState("0");
				System.out.println("info:"+info);
				infoService.Approach(info);
				success = true;
				message = "�볡�ɹ�";
			}
			//��������
			if(url.contains("appearance")){
				System.out.println("ִ��appearance����");
				Info info =new Info();
				info.setCardnum(request.getParameter("cardnum"));
				info.setLicensenum(request.getParameter("licensenum"));
				info.setManager(request.getParameter("manager"));
				info.setEndtime(request.getParameter("endtime"));
				String amount = request.getParameter("amount");
				info.setAmount(Double.parseDouble(amount));
				System.out.println("info:"+info);
				infoService.Appearance(info);
				success = true;
				message = "�����ɹ�";
			}
			//��ѯͣ������ǰ����//��ѯ��ʷ����
			if(url.contains("info")){
				List<Info> infolist = infoService.findInfoByState();
				request.getSession().setAttribute("infolist",infolist);
			}
			
		}
	if(success){
		request.setAttribute("message", message);
		request.getRequestDispatcher("/info.jsp").forward(request, response);
	}	
	
	}

}
