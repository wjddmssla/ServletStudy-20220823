package com.servlet.study.web.servlet.repository;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/repository/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		System.out.println("appication repository: " + context.getAttribute("appData"));
		System.out.println();
		
		System.out.println("request repository: " + request.getAttribute("frontFilter"));
		request.setAttribute("backFilter", "후처리 데이터");
		System.out.println();
		
		HttpSession session = request.getSession();
		System.out.println("session repository: " + session.getAttribute("sessionData"));
		
	}

}












