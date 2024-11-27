package com.jsp.servlet.cardb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DisplayCarServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb", "root", "tiger");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM car WHERE carId = ?");
			statement.setInt(1, carId);
			
			ResultSet resultSet = statement.executeQuery();
			PrintWriter out = res.getWriter();
			while (resultSet.next()) {
				out.print("<h1>Car ID: "+resultSet.getInt("carId")+" </h1>");
				out.print("<h1>Car Model: "+resultSet.getString("carModel")+" </h1>");
				out.print("<h1>Car Brand: "+resultSet.getInt("carBrand")+" </h1>");
				out.print("<h1>Car Price: "+resultSet.getInt("carPrice")+" </h1>");
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
