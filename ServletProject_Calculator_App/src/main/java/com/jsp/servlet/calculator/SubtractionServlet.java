package com.jsp.servlet.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SubtractionServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));

		int sub = num1 - num2;

		PrintWriter out = res.getWriter();
		out.print("<h1 style = text-align : \"center\"; margin-top = 200px>The sub of the number is " + sub
				+ "</h1>");
	}
}