package com.jsp.servlet.sms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save-updated-student")
public class SaveUpdatedStudentServlet extends HttpServlet {

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
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_student-management-system",
					"root", "tiger");
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE student SET studentName=?,studentEmail=?,studentAge=?,studentCourse=?,studentCity=? WHERE studentId=?");
			statement.setInt(6, studentId);
			statement.setString(1, studentName);
			statement.setString(2, studentEmail);
			statement.setInt(3, studentAge);
			statement.setString(4, studentCourse);
			statement.setString(5, studentCity);

			statement.execute();
			
			resp.sendRedirect("display-all-students");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}









