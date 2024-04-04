<%@page import="lib.models.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Books</title>
</head>


<body>
	<h2>Search Books</h2>
	<form action="search" method="get">
		<label for="keyword">Keyword:</label> <input type="text" id="keyword"
			name="keyword" required><br>
		<br> <input type="submit" value="Search">
	</form>
	<p>Logged in as <%= session.getAttribute("email") %>. <a href="logout">Logout</a></p>
	
	<%
	List<Book> books = (List<Book>)request.getAttribute("books");
	if(books != null && !books.isEmpty()){
		for(Book book : books){
			%>
            <table border=1>
            <tr>
            <th>Name</th>
            <th>Author</th>
            <th>Publisher</th>
            <th>Publication Date</th>
            <th>Subject</th>
            </tr>
            <tr>
            <td><%= book.getName() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getPublisher() %></td>
            <td><%= book.getPublicationDate() %></td>
            <td><%= book.getSubject() %></td>
            </tr>
            </table>
			<%
		}
	}
	
	%>
</body>

</html>