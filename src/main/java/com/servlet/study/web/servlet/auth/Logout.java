package com.servlet.study.web.servlet.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.study.web.servlet.dto.PrincipalUser;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		PrincipalUser principalUser = (PrincipalUser) session.getAttribute("principal");
		if(principalUser != null) {
			session.invalidate();
		}
		
		response.sendRedirect("/auth/signin");
	}

}
