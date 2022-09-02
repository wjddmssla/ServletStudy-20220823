package com.servlet.study.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import com.servlet.study.web.domain.user.UserRepository;
import com.servlet.study.web.service.UserServiceImpl;

@WebFilter("/*")
public class ServletContextFilter extends HttpFilter implements Filter {
      
	private static final long serialVersionUID = 1L;

	public ServletContextFilter() {
        super();
    }
	
	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext context = fConfig.getServletContext();
		
		context.setAttribute("userRepository", new UserRepository());
		context.setAttribute("userService", new UserServiceImpl((UserRepository)context.getAttribute("userRepository")));
	}

	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
	}



}
