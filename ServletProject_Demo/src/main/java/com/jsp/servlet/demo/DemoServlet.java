package com.jsp.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("firstName");
		
		System.out.println(name);
		
		PrintWriter out = res.getWriter();
		out.print("<h1 style=\"text-align : center; margin : 80px\" >Welcome Home "+name+" !!</h1>");
	}

}







