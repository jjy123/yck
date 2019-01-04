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
		System.out.println("执行servlet");
		InfoService infoService =new InfoService();
		UserService userService =new UserService();
		//获取url更据url判断是何请求
		String url = request.getRequestURI();
		System.out.println("url:"+url);
		//如果url包含login说明是登录请求
		if(url.contains("login")){
			System.out.println("执行login方法");
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
				System.out.println("执行登录成功");
				request.getRequestDispatcher("/servlet/UserServlet/index").forward(request, response);
			}else{
				request.setAttribute("msg", "用户名或密码错误！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else{
			//判断用户是否登录
			User user = (User) request.getSession().getAttribute("user");
			System.out.println("usersession:"+user);
			if(user!=null){
//				说明登录成功
				List<Info> infolist = infoService.findInfoByState();
				System.out.println("infolist:"+infolist);
				request.getSession().setAttribute("infolist",infolist);
				List<User> userlist = userService.getAllUser();
				request.getSession().setAttribute("userlist", userlist);
				System.out.println("userlist:"+userlist);
				if(url.contains("index")){
					request.setAttribute("message","<h1 style='color:red'>欢迎进入停车管理系统</h1>");
					
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				//如果url包含adduser说明是添加管理员请求
				if(url.contains("addUser")){
					String name= request.getParameter("name");
					String password=request.getParameter("password");
					User newuser= new User();
					newuser.setId(UUID.randomUUID().toString());
					newuser.setName(name);
					newuser.setPassword(password);
					userService.addUser(newuser);
					System.out.println("添加用户成功！");
					success = true;
					message = "添加成功";
				}
				
				//如果url包含removeuser说明是移除管理员请求
				if(url.contains("removeUser")){
					String id=request.getParameter("id");
					System.out.println("id:"+id);
					User newuser= new User();
					newuser.setId(id);
					userService.removeUser(newuser);
					success = true;
					message = "删除成功";
				}
				//如果url包含modifyUser说明是修改管理员密码请求
				if(url.contains("modifyUser")){
					String id=request.getParameter("id");
					String password=request.getParameter("password");
					String conpassword=request.getParameter("conpassword");
					System.out.println(id+","+password+","+conpassword);
						User newuser= new User();
						user.setId(id);
						user.setPassword(password);
						userService.modifyUser(user);
						System.out.println("修改成功！");
						success = true;
						message = "修改成功";
				}
				//如果url包含listUser说明是查询所有管理员管理员请求
				if(url.contains("listUser")){
											
				}
			}else{
				/*如果session user =null */
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
			//统一页面跳转
		if(success){
			request.setAttribute("message", message);
			request.getRequestDispatcher("/info.jsp").forward(request, response);
		}
		
	}

}
