package com.servlet.study.web.servlet.auth.api;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.servlet.study.web.dto.auth.SignupRequestDto;

@WebServlet("/api/v1/auth/signup")
public class SignupApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupApi() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		
		SignupRequestDto signupRequestDto = SignupRequestDto.builder()
				.userId			(request.getParameter("userId"))
				.userPassword	(request.getParameter("userPassword"))
				.userName		(request.getParameter("userName"))
				.userEmail		(request.getParameter("userEmail"))
				.build();
		
		context.setAttribute("userData", signupRequestDto);
		
		System.out.println(signupRequestDto);
		
		Gson jsonUser = new GsonBuilder().setPrettyPrinting().create();
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonUser.toJson(signupRequestDto));
	}

}






