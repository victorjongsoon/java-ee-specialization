<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.student.core.Student"  %>
<%@ page import="java.util.*"  %>
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
 <input type="submit" value="Get Student">
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

<hr/>  
<form method="get" action="student">
<input type="submit" value="Get All Students"/>
</form>
<%
 if(request.getAttribute("students") != null){
	 Collection<Student> students = (Collection<Student>)request.getAttribute("students");
	 Iterator<Student> iterator = students.iterator();
	 while(iterator.hasNext()){
		 %><div><%=iterator.next()%></div><%
	 }
 }
 %>
</body>
</html>