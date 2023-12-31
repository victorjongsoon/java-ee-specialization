<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.student.core.Student"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
</head>
<body>
<h2>Student Search</h2>
<form action="student" method="get">
 Enter Student Id: 
 <select name="id">
   <option>1</option>
   <option>2</option>
   <option>3</option>
   <option>4</option>
   <option>5</option>
 </select>
 
 <BR/>
 <input type="submit" value="Get student">
</form>
<%
 if(request.getAttribute("student") != null){
	 Student student =  (Student) request.getAttribute("student");
	%>
	<div> 
	<%= student.getId()%>:<%=student.getFirstName() %> <%=student.getSurname() %> 
	</div>
	<div>
	Department: <%=student.getDept() %>
	</div>
	<div>
	Fees: $<%=student.getFees() %> 
	</div>
	<%
 }
%>

</body>
</html>