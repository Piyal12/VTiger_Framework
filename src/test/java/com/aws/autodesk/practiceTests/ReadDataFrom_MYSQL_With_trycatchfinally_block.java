package com.aws.autodesk.practiceTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MYSQL_With_trycatchfinally_block {

	public static void main(String[] args) throws SQLException {

		Connection con = null;
		try {

			// Step 1:Register/Load the MySQL Database
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);

			// Step 2:get connect to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");

			// Step 3:Create SQL Statement
			Statement stat = con.createStatement();
			String query = "insert into students_info (regno, firstname, middlename, lastname) values('12', 'Vikrant','V', 'Dharwad');";

			// Step4:ExecuteStatement/Query
			int result = stat.executeUpdate(query);

			if (result == 1) {
				System.out.println("User is Created");
			}
		} catch (Exception e) {
			System.err.println("User not Created");
		} finally {
			// Step5:Close the Connection
			con.close();
		}

	}
}
