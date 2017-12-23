package com.xjw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xjw.dbcenter.DBCenter;
import com.xjw.entity.Student;

public class LoginServlet extends HttpServlet{

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码格式
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");

				//获得到请求里的数据
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String checkcode = request.getParameter("checkcode");
				
				//取出存放的校验码
				//StringBuffer sb = CheckCode.sb;
				StringBuffer sb = (StringBuffer) request.getSession().getAttribute("checkCode");
				if(sb.toString().equals(checkcode)){//验证校验码
					//判断是否可以登录
					List<Student> list = DBCenter.getStu();
					boolean bool = false;//记录登录状态(false--登录失败，true--登录成功)
					for (Student stu : list) {
						if(stu.getUsername().equals(username) && stu.getPassword().equals(password)){
							bool = true;
						}
					}

					//依据登录的布尔值来去做具体操作
					if(bool){//登录成功 --- 跳转到详情页面
						
						//跳转 --- 重定向
						response.sendRedirect("index.jsp");
						
						
					}else{//登录失败 --- 跳转到欢迎页面
						PrintWriter writer = response.getWriter();
						response.setHeader("refresh", "3;url=login.jsp");
						writer.write( "登录失败，<span style='color:red'>3</span>秒后跳转到<a href='login.jsp'>登录页面</a>");
					}
				}else{
					PrintWriter writer = response.getWriter();
					response.setHeader("refresh", "3;url=login.jsp");
					writer.write( "校验码失败，<span style='color:red'>3</span>秒后跳转到<a href='login.jsp'>登录页面</a>");
				}
	}

	
	
	
}
