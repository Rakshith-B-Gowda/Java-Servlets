package com.jsp.servlet.cardb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateCarServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));
		String carModel = req.getParameter("carModel");
		int carPrice = Integer.parseInt(req.getParameter("carPrice"));

		Connection connection = null;
		System.out.println("Start");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb", "root", "tiger");
			PreparedStatement statement = connection.prepareStatement("UPDATE car SET carModel = ? , carPrice = ? WHERE carId = ?");
			
			statement.setString(1, carModel);
			statement.setInt(2, carPrice);
			statement.setInt(3, carId);
			
			int rowsUpdated = statement.executeUpdate();
			
			PrintWriter out = res.getWriter();
			
			if (rowsUpdated > 0) {
				out.print("<h1>"+rowsUpdated+" row updated successfully.</h1>");
			} else {
				out.print("<h1>Updation failed! <br> Invalid CarId</h1>");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
