package org.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.user.entity.User;
import org.user.service.UserService;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("uname");
		String id=request.getParameter("uid");
		String sex=request.getParameter("usex");
		String pwd=request.getParameter("upwd");
		User user=new User(name,id,sex,pwd);
		
		//先设置响应编码，在out之前设置
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out=response.getWriter();
		
		UserService userService=new UserService();
		boolean result = userService.addUser(user);
		if(result) {
			out.println("增加成功！");
		}else {
			out.println("增加失败！");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
