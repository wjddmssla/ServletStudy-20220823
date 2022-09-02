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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.study.web.servlet.dto.PrincipalUser;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*")
public class AuthenticationFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public AuthenticationFilter() {
        super();
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession();
		
		String uri = httpServletRequest.getRequestURI();
		
		if(!uri.contains("static") && !uri.contains("index") && !uri.contains("auth/signin") && !uri.contains("auth/signup")) {
			
			PrincipalUser principalUser = (PrincipalUser) session.getAttribute("principal");
			
			if(principalUser == null) {
				if(!uri.contains("auth/signin")) {
					session.setAttribute("preUri", uri);
				}
				
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("<html>");
				stringBuilder.append("<body>");
				stringBuilder.append("<script>");
				stringBuilder.append("alert(\"로그인 후 접근 할 수 있습니다.\");");
				stringBuilder.append("location.replace(\"/auth/signin\");");
				stringBuilder.append("</script>");
				stringBuilder.append("</body>");
				stringBuilder.append("</html>");
				
				response.setContentType("text/html; charset=utf-8");
				response.getWriter().print(stringBuilder.toString());
				return;	
				
			}else if(uri.contains("auth")) {
				String preUri = (String) session.getAttribute("preUri");
				if(preUri == null) {
					httpServletResponse.sendRedirect("/index");
				}else {
					httpServletResponse.sendRedirect(preUri);
				}
				session.setAttribute("preUri", null);
				return;
			}
			
		}
			
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
