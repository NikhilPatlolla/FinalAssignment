package com.nikhil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaUtilJdbc {

	// A utility method that creates the connection between the app and db
	public static Connection getJdbcConnection() throws SQLException {

		// declaring the variables
		Connection connection = null;

		String url = "jdbc:postgresql://localhost:5432/enterprisejavabatch";
		String user = "root";
		String password = "root123";

		connection = DriverManager.getConnection(url, user, password);

		if (connection != null) {
			return connection;
		}

		return connection;
	}

	// The Statement class has to be imported from the sql package rather than beans
	public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection)
			throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}

		if (statement != null) {
			statement.close();
		}

		if (connection != null) {
			connection.close();
		}
	}
}