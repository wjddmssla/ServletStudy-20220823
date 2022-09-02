package com.servlet.study.web.servlet.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/content/type")
public class ContentTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청 URL: " + request.getRequestURL());
		System.out.println("요청 Method: " + request.getMethod());
		System.out.println("요청 param(id): " + request.getParameter("id"));
		System.out.println("요청 param(pw): " + request.getParameter("password"));
		System.out.println("요청 param(email): " + request.getParameter("email"));
		
		request.getRequestDispatcher("/WEB-INF/dispatcher-test.html").forward(request, response);
		
//		response.setContentType("application/json; charset=utf-8");
//		
//		response.getWriter().print("{\"name\":\"박정은\"}");
		
//		response.getWriter().print("<html>");
//		response.getWriter().print("<head>");
//		response.getWriter().print("<title>contentType</title>");
//		response.getWriter().print("</head>");
//		response.getWriter().print("<body>");
//		response.getWriter().print("<h1>ContentType Test!</h1>");
//		response.getWriter().print("</body>");
//		response.getWriter().print("</html>");
	}

}








