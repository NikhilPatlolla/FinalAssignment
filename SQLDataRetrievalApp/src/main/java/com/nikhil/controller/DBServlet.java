package com.nikhil.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nikhil.util.JdbcUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DBServlet() {
		System.out.println("Servlet Instantiation");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		out.println("hello there");
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String sqlQuery = "select * from students";

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareCall(sqlQuery);
			}
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {
				out.println("<html>");
				out.println("<head><title>Data from MySQL Database</title></head>");
				out.println("<body>");
				out.println("<h1>Data from MySQL Database</h1>");
				out.println("<table border='1'>");
				out.println("<tr><th>Id</th><th>FirstName</th><th>LastName</th><th>Address</th></tr>");

				while (resultSet.next()) {
					String id = resultSet.getString(1);
					String firstName = resultSet.getString(2);
					String LastName = resultSet.getString(3);
					String address = resultSet.getString(4);

					out.println("<tr><td>" + id + "</td><td>" + firstName + "</td><td>" + LastName + "</td><td>" + address + "</td></tr>");
				}
				
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.closeConnection(resultSet, pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
