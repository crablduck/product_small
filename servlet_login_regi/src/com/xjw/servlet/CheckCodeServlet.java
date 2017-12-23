package com.xjw.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCodeServlet
 */
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int width = 120;
		int height = 50;
		
		//1. 创建画布
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//2. 根据画布创建画笔
		Graphics graphics = bufferedImage.getGraphics();
		//3. 在画布中划分出用来画画的部分
		graphics.fillRect(0, 0, width, height);
		
		//4. 设置背景颜色
		graphics.setColor(Color.BLUE);
		
		//5. 利用随机数进行设置随机的校验码
		Random random = new Random();
		//6. 设置容器，为登录servlet的验证做准备
		StringBuffer ckBuffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			//7. 将num写入画布中
			Font font = new Font("宋体", Font.BOLD, random.nextInt(10)+20);
			graphics.setFont(font);
			String num = String.valueOf(random.nextInt(10));
			graphics.drawString(num, 25*i+15, 20+random.nextInt(15));
			//8. 将num存入容器中
			ckBuffer.append(num);
		}
		
		//9.将容器放到session中去
		request.getSession().setAttribute("checkCode", ckBuffer);
		
		//10.设置干扰线
		for (int i = 0; i < 10; i++) {
			graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			graphics.drawLine(random.nextInt((int) (width*0.3)), random.nextInt((int) (height*0.3)), random.nextInt((int) (width*0.8)), random.nextInt((int) (height*0.8)));
		}
		
		//11. 画出去
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
	}

}
