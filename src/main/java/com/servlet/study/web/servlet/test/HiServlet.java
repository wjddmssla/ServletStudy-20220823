package com.servlet.study.web.servlet.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class HiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HiServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("Hi Servlet");
	}

}
