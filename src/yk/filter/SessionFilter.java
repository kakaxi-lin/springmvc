package yk.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionFilter implements Filter{
	private String url;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request1, ServletResponse response1,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) request1;
		HttpServletResponse response= (HttpServletResponse) response1;
		System.out.println("filterÀ¹½Ø");
		System.out.println("servletPath:"+request.getServletPath());
		if(this.url.equals(request.getServletPath())){
			chain.doFilter(request, response);
			return;
		}
		if(request.getParameter("k")==null){
			System.out.println("Ã»µÇÂ¼");
			response.sendRedirect("index.jsp");
		}else{
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.url=config.getInitParameter("url");
		System.out.println("url..."+url);
		
	}

}
