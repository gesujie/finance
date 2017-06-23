package com.jibinfo.finance.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Error404ResponseWrapper responseWrapper = new Error404ResponseWrapper(this, response);
		filterChain.doFilter(request, responseWrapper);
		if (responseWrapper.isFound()) {
			return;
		}
		//String uri = request.getRequestURI();
		//System.out.println(uri);
		response.sendRedirect("/public/err404.jsp");

	}



}
