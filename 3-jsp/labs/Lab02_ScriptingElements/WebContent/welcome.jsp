<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Song Site</title>
</head>
<body>

	<h3>Welcome to Simple Song Service</h3>
	<br>
	<hr>
	<p><%="Welcome " + request.getParameter("username")%></p>

	<!-- Declaration -->

	<%!private String discountCode = "VIPCUST100";

	private String getDiscountCode() {
		return discountCode;
	}%>

	<!-- Expression -->
	<div>
		Use this code to get an additional 10% discount:
		<h4><%=getDiscountCode()%></h4>
	</div>

	<a href="SongServlet">Show All Songs</a>




</body>
</html>