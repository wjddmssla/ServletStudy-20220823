package com.servlet.study.web.servlet.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/signup2")
public class SignupServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get 요청옴?");
		request.getRequestDispatcher("/WEB-INF/views/auth/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post 요청옴?");
		
		String id = request.getParameter("user_id");
		String password = request.getParameter("user_password");
		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + password);
		System.out.println("이름: " + name);
		System.out.println("이메일: " + email);
	}

}








