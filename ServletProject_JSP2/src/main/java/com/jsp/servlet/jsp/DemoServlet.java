package com.jsp.servlet.jsp;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoServlet extends GenericServlet {
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("n1");
		
		req.setAttribute("key", name);
		RequestDispatcher rd = req.getRequestDispatcher("output.jsp");
		rd.forward(req, res);
		
	}

}
