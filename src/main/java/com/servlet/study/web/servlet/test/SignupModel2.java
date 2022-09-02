package com.servlet.study.web.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/signup/model2")
public class SignupModel2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		
		System.out.println("user_id: " + user_id);
		System.out.println("user_password: " + user_password);
		System.out.println("user_name: " + user_name);
		System.out.println("user_email: " + user_email);
		
		Map<String, String> user = new HashMap<String, String>();
		user.put("user_id", user_id);
		user.put("user_password", user_password);
		user.put("user_name", user_name);
		user.put("user_email", user_email);
		
		
		response.setContentType("application/json; charset=utf-8");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		PrintWriter out = response.getWriter();
		
		out.print(gson.toJson(user));
	}

}






