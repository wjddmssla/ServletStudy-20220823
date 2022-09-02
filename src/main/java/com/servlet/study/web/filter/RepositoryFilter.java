package com.servlet.study.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/repository/*")
public class RepositoryFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public RepositoryFilter() {
        super();
    }

    public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("전처리");
		request.setAttribute("frontFilter", "전처리 데이터");
		
		chain.doFilter(request, response);
		
		System.out.println("후처리");
		System.out.println(request.getAttribute("backFilter"));
	}

	public void destroy() {
		
	}
	
}



