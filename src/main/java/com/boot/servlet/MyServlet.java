package com.boot.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/servlet")
public class MyServlet implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("MyServlet-----destroy----start------");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("MyServlet-----ServletConfig----start------");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("MyServlet-----service----start------");
		
	}

	@Override
	public String getServletInfo() {
		System.out.println("MyServlet-----getServletInfo----start------");
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("MyServlet-----destroy----start------");
		
	}
	

}
