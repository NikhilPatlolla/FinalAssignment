package com.nikhil.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.nikhil.util.JavaUtilJdbc;

public class PreparedRealOperation {
	public static void main(String[] args) {
		System.out.println("Please select the kind of operation you want to make to the table");
		System.out.println("Create : c");
		System.out.println("Read: r");
		System.out.println("Update: u");
		System.out.println("Delete: d");

		Set<String> operations = new HashSet<>();
		operations.add("c");
		operations.add("r");
		operations.add("u");
		operations.add("d");

		try (Scanner scan = new Scanner(System.in)) {
			String operation = scan.nextLine();
			operation = operation.toLowerCase();
			if (isValidOperation(operation, operations)) {
				try {
					realOperation(operation);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void realOperation(String s) throws SQLException {

		Connection connection = null;
		PreparedStatement pstmt = null;
		if (s.equals("c")) {
			createARecord(connection, pstmt);
		}
		if (s.equals("r")) {
			readARecord(connection, pstmt);
		}
		if (s.equals("u")) {
			updateARecord(connection, pstmt);
		}
		if (s.equals("d")) {
			deleteARecord(connection, pstmt);
		}
	}

	private static void createARecord(Connection connection, PreparedStatement pstmt) throws SQLException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the firstName");
		String fName = scan.nextLine();

		System.out.println("Enter the LastName");
		String lName = scan.nextLine();

		System.out.println("Enter the Address");
		String address = scan.nextLine();
		System.out.println("Enter the City");
		String city = scan.nextLine();

		String sqlInsertQuery = String
				.format("insert into students(`FirstName`, `LastName`, `Address`, `City`) values(?, ?, ?, ?)");

		try {
			connection = JavaUtilJdbc.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}

			if (pstmt != null) {
				pstmt.setString(1, fName);
				pstmt.setString(2, lName);
				pstmt.setString(3, address);
				pstmt.setString(4, city);
				int rowsAffected = pstmt.executeUpdate();
				System.out.println("the no. of rows affected are" + rowsAffected);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JavaUtilJdbc.closeConnection(null, pstmt, connection); // PreparedStatement is anyway child class of
																	// Statement Class

			if (scan != null) {
				scan.close();
			}
		}

	}

	private static void updateARecord(Connection connection, PreparedStatement pstmt) throws SQLException {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the City");
		String city = scan.nextLine();

		System.out.println("Enter StudentId");
		int id = scan.nextInt();

		String sqlInsertQuery = "update students set City = ? where StudentID = ?";

		try {
			connection = JavaUtilJdbc.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}

			if (pstmt != null) {
				pstmt.setString(1, city);
				pstmt.setInt(2, id);
				int noOFRows = pstmt.executeUpdate();
				System.out.println("the no. of rows affected are" + noOFRows);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JavaUtilJdbc.closeConnection(null, pstmt, connection);

			if (scan != null) {
				scan.close();
			}
		}
	}

	private static void deleteARecord(Connection connection, PreparedStatement pstmt) throws SQLException {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the StudentID to Delete");
		Integer sID = scan.nextInt();

		String sqlInsertQuery = String.format("delete from students where `StudentID` = ?");

		try {
			connection = JavaUtilJdbc.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}

			if (pstmt != null) {
				pstmt.setInt(1, sID);
				int noOFRows = pstmt.executeUpdate();
				System.out.println("the no. of rows affected are" + noOFRows);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JavaUtilJdbc.closeConnection(null, pstmt, connection);

			if (scan != null) {
				scan.close();
			}
		}
	}

	private static void readARecord(Connection connection, PreparedStatement pstmt) throws SQLException {
		String sqlQuery = "select FirstName, LastName, Address, City from Students";
		ResultSet resultSet = null;
		try {
			connection = JavaUtilJdbc.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);
			}

			if (pstmt != null) {

				resultSet = pstmt.executeQuery(sqlQuery);

				if (resultSet != null) {
					System.out.println("\tFirstName\tLastName\tAddress\tCity");
					while (resultSet.next()) {
//                        Integer StudentID = resultSet.getInt(1);
						String firstName = resultSet.getString(1);
						String LastName = resultSet.getString(2);
						String Address = resultSet.getString(3);
						String City = resultSet.getString(4);
						System.out.println("\t" + firstName + "\t" + LastName + "\t" + Address + "\t" + City);
					}
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JavaUtilJdbc.closeConnection(resultSet, pstmt, connection);
		}
	}

	private static boolean isValidOperation(String operation, Set<String> operations) {

		if (operations.contains(operation)) {
			return true;
		}
		return false;

	}
}