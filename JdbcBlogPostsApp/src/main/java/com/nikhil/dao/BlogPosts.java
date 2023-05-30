package com.nikhil.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nikhil.util.JavaUtilJdbc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BlogPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public List<BlogPost> getAllBlogPosts() {
		List<BlogPost> blogPosts = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String sqlQuery = "select * from students";

		try {
			connection = JavaUtilJdbc.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareCall(sqlQuery);
			}
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}

			while (resultSet.next()) {
				String title = resultSet.getString(1);
				String content = resultSet.getString(2);

				BlogPost blogPost = new BlogPost(title, content);
				blogPosts.add(blogPost);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JavaUtilJdbc.closeConnection(resultSet, pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return blogPosts;
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BlogPosts blogPosts = new BlogPosts();
		List<BlogPost> allBlogPosts = blogPosts.getAllBlogPosts();
		request.setAttribute("allPosts", allBlogPosts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/posts.jsp");
		dispatcher.forward(request, response);

	}
	
	

}
