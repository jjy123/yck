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
import com.parking.service.UserService;

public class UserServlet extends HttpServlet {

	private String message;
	private boolean success=false;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("ִ��servlet");
		InfoService infoService =new InfoService();
		UserService userService =new UserService();
		//��ȡurl����url�ж��Ǻ�����
		String url = request.getRequestURI();
		System.out.println("url:"+url);
		//���url����login˵���ǵ�¼����
		if(url.contains("login")){
			System.out.println("ִ��login����");
			String name =request.getParameter("name");
			String password =request.getParameter("password");
			User user= new User();
			user.setPassword(password);
			user.setName(name);
			User usered = userService.login(user);
			System.out.println(user);
			System.out.println(usered);
			if(usered!=null){
				request.getSession().setAttribute("user", usered);
				System.out.println("ִ�е�¼�ɹ�");
				request.getRequestDispatcher("/servlet/UserServlet/index").forward(request, response);
			}else{
				request.setAttribute("msg", "�û������������");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else{
			//�ж��û��Ƿ��¼
			User user = (User) request.getSession().getAttribute("user");
			System.out.println("usersession:"+user);
			if(user!=null){
//				˵����¼�ɹ�
				List<Info> infolist = infoService.findInfoByState();
				System.out.println("infolist:"+infolist);
				request.getSession().setAttribute("infolist",infolist);
				List<User> userlist = userService.getAllUser();
				request.getSession().setAttribute("userlist", userlist);
				System.out.println("userlist:"+userlist);
				if(url.contains("index")){
					request.setAttribute("message","<h1 style='color:red'>��ӭ����ͣ������ϵͳ</h1>");
					
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				//���url����adduser˵������ӹ���Ա����
				if(url.contains("addUser")){
					String name= request.getParameter("name");
					String password=request.getParameter("password");
					User newuser= new User();
					newuser.setId(UUID.randomUUID().toString());
					newuser.setName(name);
					newuser.setPassword(password);
					userService.addUser(newuser);
					System.out.println("����û��ɹ���");
					success = true;
					message = "��ӳɹ�";
				}
				
				//���url����removeuser˵�����Ƴ�����Ա����
				if(url.contains("removeUser")){
					String id=request.getParameter("id");
					System.out.println("id:"+id);
					User newuser= new User();
					newuser.setId(id);
					userService.removeUser(newuser);
					success = true;
					message = "ɾ���ɹ�";
				}
				//���url����modifyUser˵�����޸Ĺ���Ա��������
				if(url.contains("modifyUser")){
					String id=request.getParameter("id");
					String password=request.getParameter("password");
					String conpassword=request.getParameter("conpassword");
					System.out.println(id+","+password+","+conpassword);
						User newuser= new User();
						user.setId(id);
						user.setPassword(password);
						userService.modifyUser(user);
						System.out.println("�޸ĳɹ���");
						success = true;
						message = "�޸ĳɹ�";
				}
				//���url����listUser˵���ǲ�ѯ���й���Ա����Ա����
				if(url.contains("listUser")){
											
				}
			}else{
				/*���session user =null */
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
			//ͳһҳ����ת
		if(success){
			request.setAttribute("message", message);
			request.getRequestDispatcher("/info.jsp").forward(request, response);
		}
		
	}

}
