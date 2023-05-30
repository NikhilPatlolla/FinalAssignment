package com.nikhil.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nikhil.util.JavaUtilJdbc;

public class PostgreSqlUpdate {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		String sqlInsertQuery = null;
		PreparedStatement pstmt = null;
		try {
			connection = JavaUtilJdbc.getJdbcConnection();
			sqlInsertQuery = "INSERT INTO students (name, address) VALUES (?, ?)";
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			if (pstmt != null) {
				String location = "src\\com\\nikhil\\data\\input.txt";
				BufferedReader reader = new BufferedReader(new FileReader(location));
				String line;
				while ((line = reader.readLine()) != null) {

					// Skipping the headers of the file
					if (line.startsWith("NAME")) {
						continue;
					}
					// the lines are separated by a "," in the file
					String[] values = line.split(",");

					// just in case, if the values are with unwanted spaces at either end, we are
					// removing it with the trim() method
					pstmt.setString(1, values[0].trim());
					pstmt.setString(2, values[1].trim());
					pstmt.addBatch();

				}
				reader.close();

				// Uploading the batch to the database
				int[] result = pstmt.executeBatch();

				int successfulUploads = 0;

				for (int i : result) {
					/*
					 * If the value in the result array is greater than or equal to 0, it represents
					 * the number of rows affected by the corresponding SQL statement. A value of 0
					 * indicates that the statement was executed successfully but did not affect any
					 * rows
					 */
					if (i >= 0) {
						successfulUploads++;
					}
				}
				System.out.println("Uploaded count+ " + successfulUploads);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JavaUtilJdbc.closeConnection(null, pstmt, connection);
		}
	}
}
