package com.nikhil.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.nikhil.util.JdbcUtil;

public class JdbcReadApp {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		Scanner scanner = new Scanner(System.in);

		try {
			connection = JdbcUtil.getJdbcConnection();

			String sqlSelectQuery = "select * from students";

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {
				System.out.println("\tId\tFirstName\tLastName\tAddress\t");
				while (resultSet.next()) {
					String id = resultSet.getString(1);
					String firstName = resultSet.getString(2);
					String LastName = resultSet.getString(3);
					String address = resultSet.getString(4);
					System.out.println("\t" + id + "\t" + firstName + "\t" + LastName + "\t" + address);
				}
			} else {
				System.out.println("Record is not available in the database");
			}

		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeConnection(resultSet, pstmt, connection);
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
