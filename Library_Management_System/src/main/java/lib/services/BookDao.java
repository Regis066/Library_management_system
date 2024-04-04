package lib.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lib.models.Book;
import lib.utils.DB_connection;

public class BookDao {
	public void addBook(Book book) {
		String query = "INSERT INTO books (name, author, publisher, publication_date, subject) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = DB_connection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, book.getName());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getPublisher());
			statement.setDate(4, book.getPublicationDate());
			statement.setString(5, book.getSubject());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Book> searchBooks(String keyword) {
		List<Book> books = new ArrayList<>();
		String query = "SELECT * FROM books WHERE name LIKE ? OR author LIKE ?";
		try (Connection conn = DB_connection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, "%" + keyword + "%");
			statement.setString(2, "%" + keyword + "%");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setName(resultSet.getString("name"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setPublicationDate(resultSet.getDate("publication_date"));
				book.setSubject(resultSet.getString("subject"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

}
