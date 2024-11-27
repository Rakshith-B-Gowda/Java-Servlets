package com.jsp.servlet.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ModulusServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		double mod;
		PrintWriter out = res.getWriter();
		
		if (num2 != 0) {
			 mod = (double)num1 % num2;
			 out.print("<h1 style = text-align : \"center\"; margin-top = 200px>The mod of the number is " + mod
						+ "</h1>");
		} else {
			out.print("<h1 style = text-align : \\\"center\\\"; margin-top = 200px>Can't Divide by 0! </h1>");
		}
	}
}