<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h3>Welcome Home</h3>
	<br />
	<hr />

	The protocol is:
	</p>
	<%
	out.println(request.getProtocol());
	%>
	<br /> The port is:
	<%
	out.println(request.getServerPort());
	%>
	<br /> The remote address is:
	<%
	out.println(request.getRemoteAddr());
	%>
	<br /> The context path is:
	<%
	out.println(request.getContextPath());
	%>
	<br />

	<!-- Expressions - Example Marked with -->
	<%-- Expressions - Example Marked with <% %> --%>
	<br />
	<hr />
	The current date and time is:
	<p>
		<%
		// format the date
		java.text.Format formatter = new java.text.SimpleDateFormat();
		String prettyDate = formatter.format(new java.util.Date());
		out.println(prettyDate);
		%>
	</p>

	<!-- Expressions - Example Marked with -->
	<%-- Expressions - Example Marked with <%= %> --%>
	<br />
	<hr />
	The current date and time is:
	<p>
		<%= prettyDate %>
	</p>


	<!-- Declarations - Example -->
	<%-- Declarations - Example Marked with <%! %> --%>
	<br />
	<hr />
	<%@ page import='java.text.Format, java.text.SimpleDateFormat'%>
	<%!private Format formatter = new SimpleDateFormat();%>
	The current date and time is:
	<p>
		<%=getDate()%>
	</p>
	
	Formatted dates are nice.
	
	<%!private String getDate() {
		return formatter.format(new java.util.Date());
	}%>

</body>
</html>