package com.nikhil.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nikhil.util.JavaUtilJdbc;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		try {
			updateDatabase(title, content);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Redirect to a confirmation page or any other desired response
		response.sendRedirect("confirmation.html");
	}

	private void updateDatabase(String title, String content) throws SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String sqlInsertQuery = "insert into students(`title`, `blog`) values(?, ?)";
		try {
			connection = JavaUtilJdbc.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}

			if (pstmt != null) {
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				int rowsAffected = pstmt.executeUpdate();
				System.out.println("the no. of rows affected are" + rowsAffected);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JavaUtilJdbc.closeConnection(null, pstmt, connection); // PreparedStatement is anyway child class of
		}
	}
}
