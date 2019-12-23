package com.works.mms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginFilter implements Filter {
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private HttpSession session;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if(httpServletRequest.getServletPath().equals("/manage")
				||httpServletRequest.getServletPath().equals("/send")
				||httpServletRequest.getServletPath().equals("/"))
		{
			//已登录
			if(session.getAttribute("user") != null)
			{
				chain.doFilter(request, response);
			}
			//未登录
			else
			{
				System.out.println("拦截"+httpServletRequest.getServletPath());
				request.getRequestDispatcher("/login").forward(request, response);
			}
		}
		else
		{
			chain.doFilter(request, response);
		}

	}

	
	
}
