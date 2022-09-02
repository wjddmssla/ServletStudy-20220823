package com.servlet.study.web.servlet.user.api;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.study.web.service.UserService;

@WebServlet("/api/v1/user/delete")
public class UserDeleteApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	
    public UserDeleteApi() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	userService = (UserService) config.getServletContext().getAttribute("userService");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userCode = request.getParameter("userCode");
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(userService.deleteUser(Integer.parseInt(userCode)));
		
	}

}










