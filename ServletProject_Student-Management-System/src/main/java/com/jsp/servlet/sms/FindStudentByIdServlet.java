package com.jsp.servlet.sms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/find-by-id")
public class FindStudentByIdServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int studentId = Integer.parseInt(req.getParameter("studentId"));
		
		//JDBC Logic
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servlet_student-management-system", "root", "tiger");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM student WHERE studentId = ? ");
			statement.setInt(1, studentId);
			ResultSet resultSet = statement.executeQuery();
			
			req.setAttribute("resultSet", resultSet);
			RequestDispatcher rd = req.getRequestDispatcher("UpdateStudent.jsp");
			rd.forward(req, resp);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}















