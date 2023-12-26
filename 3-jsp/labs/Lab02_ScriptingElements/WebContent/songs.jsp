<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, com.music.model.Song" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Available Songs</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<%-- INSERT CODE AFTER THIS LINE TO PRINT OUT A LIST OF SONGS --%>
<div class="container mt-5">
    <table class="table table-bordered">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Artist</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Song> songs = (List<Song>) session.getAttribute("Songs");
                for (Song _song : songs) {
            %>
            <tr>
                <td><%= _song.getId() %></td>
                <td><%= _song.getTitle() %></td>
                <td><%= _song.getArtist() %></td>
            </tr>
            <% 
                }
            %>
        </tbody>
    </table>
</div>

<div class="text-center">
    <a href="/Lab02_ScriptingElements/index.jsp" class="btn btn-primary">Home</a>
</div>


</body>
</html>
