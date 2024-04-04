package lib.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lib.models.User;
import lib.utils.DB_connection;

public class UserDao {
	public void addUser(User user) {
		String query = "INSERT INTO users (firstName, lastName, account, email, password) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = DB_connection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, user.getFname());
			statement.setString(2, user.getLname());
			statement.setString(3, user.getAccount());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getPassword());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean authenticateUser(String email, String password) {
		String query = "SELECT * FROM users WHERE email = ? AND password = ?";
		try (Connection conn = DB_connection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
