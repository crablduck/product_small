package com.xjw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xjw.dbcenter.DBCenter;
import com.xjw.entity.Student;

public class RegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//设置编码过滤器
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		//数据拿到， 且在web.xml配置好了
		String action = req.getParameter("action");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//通过响应里面去获取write的方法
		PrintWriter writer = resp.getWriter();
		
		boolean flag = true;
		if("register".equals(action)){
			List<Student> stu = DBCenter.getStu();
			for (Student student2 : stu) {
				if(student2.getUsername().equals(username)){
					flag = false;
				}
			}
			
			if(flag){
				resp.setHeader("refresh", "3; url=login.jsp");
				writer.write("<span style='color:red'>3</span>秒后，将跳转到<a href='login.jsp'>登录页面</a>");
			}else{
				resp.setHeader("refresh", "3; url=register.jsp");
				writer.write("<span style='color:red'>3</span>秒后跳转<a href='register.jsp'>注册页面</a>，请重新注册");
			}
		}
	}

	
	
	
}
