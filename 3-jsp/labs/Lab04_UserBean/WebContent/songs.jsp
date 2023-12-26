<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, com.music.model.Song, java.util.Date, java.util.NoSuchElementException" errorPage="errorPage.jsp"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Songs</title>
</head>
<body>
    <%@ include file="header.html" %>
	<h3>Songs Available for Download as of <%= new Date().toString() %></h3>

	<%--
	List<Song> songs = (List<Song>) session.getAttribute("GoFish");
	--%>
	
	<%
	List<Song> songs = (List<Song>) session.getAttribute("Songs");
	%>
	
	<table style="margin: 8px;" cellpadding="9" cellspacing="3" border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Artist</th>
			</tr>
		</thead>
		<tbody>
			<% if (songs != null) { %>
			<%
			for (Song _song : songs) {
			%>
			<tr>
				<td><%=_song.getId()%></td>
				<td><%=_song.getTitle()%></td>
				<td><%=_song.getArtist()%></td>
			</tr>
			<%
			}
			%>
			<% } else {
				throw new NoSuchElementException("The requested attribute was not found in the session"); 
			} %>
		</tbody>
	</table>
</body>
</html>

