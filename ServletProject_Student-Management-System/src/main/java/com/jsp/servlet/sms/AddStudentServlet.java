package com.jsp.servlet.sms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int studentId = Integer.parseInt(req.getParameter("studentId"));
		String studentName = req.getParameter("studentName");
		String studentEmail = req.getParameter("studentEmail");
		int studentAge = Integer.parseInt(req.getParameter("studentAge"));
		String studentCourse = req.getParameter("studentCourse");
		String studentCity = req.getParameter("studentCity");
		
		Connection connection = null;
		
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servlet_student-management-system", "root", "tiger");
			PreparedStatement statement = connection.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?,?)");
			statement.setInt(1, studentId);
			statement.setString(2, studentName);
			statement.setString(3, studentEmail);
			statement.setInt(4, studentAge);
			statement.setString(5, studentCourse);
			statement.setString(6, studentCity);
			
			statement.execute();
			
			resp.sendRedirect("index.jsp");
			
		} catch (SQLException|IOException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
	}
}
















