<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
 </head>
<body>
    <jsp:include page="header.jsp" /> 
	<h3>Welcome to Simple Song Service</h3>
	<p>
	Your browser information: ${header["user-agent"]} <br>
	Your IP and port are: ${header["host"]} <br>
	</p>
	<br>
	
	<hr>
	<h3>Please enter your user name</h3>
	<form action="welcome.jsp" method="post">
	<label	for="username">User Name:</label>
		<input type="text" name="name"> <br/>
			<input type="text" name="ip" value='${header["host"]}'> <br/><br/>
		<input type="submit" value="Next">
	</form>
</body>
</html>