package com.servlet.study.web.servlet.user.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.study.web.service.UserService;
import com.servlet.study.web.service.UserServiceImpl;

@WebServlet("/api/v1/user/management/users")
public class UserManagementApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;

    public UserManagementApi() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	userService = (UserServiceImpl) config.getServletContext().getAttribute("userService");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print(userService.getUserList());
	}
}













