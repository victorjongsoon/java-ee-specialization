<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
 </head>
<body>
    <%@ include file="header.html" %>
	<h3>Welcome to Simple Song Service</h3>
	<br>
	<%
	  out.println("Your browser information:" + request.getHeader("User-Agent"));
	  out.println("Your IP address is:" + request.getRemoteAddr());
	%>
	
	<hr>
	<h3>Please enter your user name</h3>
	<form action="welcome.jsp">
	<label	for="username">User Name:</label>
		<input type="text" name="username"> <br/><br/>
		<input type="submit" value="Next">
	</form>
</body>
</html>