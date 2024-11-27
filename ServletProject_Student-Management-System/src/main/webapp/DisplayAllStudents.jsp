<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Details</title>
<link rel="stylesheet" href="./DisplayAllStudents-style.css">
</head>
<body>
	<%
		ResultSet rs = (ResultSet) request.getAttribute("resultSet");
	%>
	
	<h1>Student Details</h1>
	<table>
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Student Email</th>
			<th>Student Age</th>
			<th>Student Course</th>
			<th>Student City</th>
			<th>Actions</th>
		</tr>
		<%
			while(rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("studentId")%></td>
			<td><%=rs.getString("studentName")%></td>
			<td><%=rs.getString("studentEmail")%></td>
			<td><%=rs.getInt("studentAge")%></td>
			<td><%=rs.getString("studentCourse")%></td>
			<td><%=rs.getString("studentCity")%></td>
			<td>
				<a href="find-by-id?studentId=<%=rs.getInt("studentId")%>">UPDATE</a>
				<a href="delete-student?studentId=<%=rs.getInt("studentId")%>">DELETE</a>
			</td>
		</tr>
		
		<% } %>
	    
	</table>
</body>
</html>