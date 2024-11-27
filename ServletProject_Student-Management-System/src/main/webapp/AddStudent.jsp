<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Students</title>
<link rel="stylesheet" href="./AddStudent-style.css">
</head>
<body>
	<h1>Enter Student Details</h1>
	<form action="add-student" method="post">
		<input type="number" placeholder="Enter studentId" name="studentId"><br>
		<input type="text" placeholder="Enter studentName" name="studentName"><br>
		<input type="text" placeholder="Enter studentEmail" name="studentEmail"><br>
		<input type="number" placeholder="Enter studentAge" name="studentAge"><br>
		<input type="text" placeholder="Enter studentCourse" name="studentCourse"><br>
		<input type="text" placeholder="Enter studentCity" name="studentCity"><br>
		<input type="submit" value="ADD STUDENT">
	</form>
</body>
</html>