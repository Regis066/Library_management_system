<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
<h2>Add Book</h2>
    <form action="addBookServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required><br><br>
        <label for="publisher">Publisher:</label>
        <input type="text" id="publisher" name="publisher" required><br><br>
        <label for="publication_date">Publication Date:</label>
        <input type="date" id="publication_date" name="publication_date" required><br><br>
        <label for="subject">Subject:</label>
        <input type="text" id="subject" name="subject" required><br><br>
        <input type="submit" value="Add Book">
    </form>
    <br>
    <p>OR</p>
    <br>
    <p><a href="search.jsp">Search for the book</a></p>

</body>
</html>