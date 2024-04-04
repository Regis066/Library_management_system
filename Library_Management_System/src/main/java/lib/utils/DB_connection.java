package lib.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_connection {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/library_system", "root", "mugreg");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
		return conn;

	}

}
