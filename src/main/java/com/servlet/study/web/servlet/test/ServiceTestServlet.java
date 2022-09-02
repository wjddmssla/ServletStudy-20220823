package com.servlet.study.web.servlet.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/service/test")
public class ServiceTestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("첫 요청 때 한번 호출");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("요청이 들어와서 서비스 실행");
		System.out.println("요청 메소드: " + req.getMethod());
		getServletContext().setAttribute("servletApplicationData", "우리가 저장한 데이터");
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get 요청");
		System.out.println(getServletContext().getAttribute("servletApplicationData"));
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("서블릿 소멸");
	}
	
}










