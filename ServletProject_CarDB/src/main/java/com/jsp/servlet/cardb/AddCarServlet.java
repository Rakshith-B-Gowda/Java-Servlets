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

public class AddCarServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));
		String carModel = req.getParameter("carModel");
		String carBrand = req.getParameter("carBrand");
		int carPrice = Integer.parseInt(req.getParameter("carPrice"));
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb", "root", "tiger");
			PreparedStatement statement = connection.prepareStatement("INSERT INTO car VALUES(?,?,?,?)");
			statement.setInt(1, carId);
			statement.setString(2, carModel);
			statement.setString(3, carBrand);
			statement.setInt(4, carPrice);
			
			PrintWriter out = res.getWriter();
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				out.print("<h1>"+rowsInserted+" row inserted successfully.</h1>");
			} else {
				out.print("<h1>Insertion Failed!</h1>");
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
