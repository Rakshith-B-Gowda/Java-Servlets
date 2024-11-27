<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!--Directive Tag-->
    <%@ include file="hello.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Demo</title>
</head>
<body>
	<!--Declarative Tag-->
	<%! 
		int a = 10;
		String name = "Out";
		String[] names = {"Name1", "Name2", "Name3"};
	%>
	
	<!--Expression Tag-->
	<h2><%=a%></h2> 
	<h2><%=name%></h2>
	
	<!--Scriptlet Tag-->
	<%for(String n : names) { %>
		<h3><%=n%></h3> 
	<%} %>

</body>
</html>