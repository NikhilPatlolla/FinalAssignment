package com.nikhil.util;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private JdbcUtil() {

	}

	public static Connection getJdbcConnection() throws SQLException {

		Connection connection = null;

		String url = "jdbc:mysql:///enterprisejavabatch";
		String user = "root";
		String password = "root123";

		connection = DriverManager.getConnection(url, user, password);

		if (connection != null) {
			return connection;
		}

		return connection;
	}

	public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
		if(resultSet != null) {
			resultSet.close();
		}
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
	}
}
