package com.boot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*")  
public class CrsfFilter implements Filter {
	  private FilterConfig filterConfig;
	  private String[] trust;
	  private String[] notfilter;
	  private String isStartFilter;
	  private String errinfo = "";
	  

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;

	    this.trust = filterConfig.getInitParameter("trust").split(",");
	    this.notfilter = filterConfig.getInitParameter("notfilter").split(",");
	    this.isStartFilter = filterConfig.getInitParameter("isStartFilter");
		System.out.println("filter-----init--CCCC--start------");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter----CrsfFilter---CCCC---start------");
		chain.doFilter(request, response);
	
	}

	@Override
	public void destroy() {}

}
