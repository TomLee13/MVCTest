/*
 * A model class that is used to create the connection with MySQL database.
 */
package com.tom.model;

import java.sql.*;

public class DatabaseConnection {
	public static Connection initializeDatabase() 
	        throws SQLException, ClassNotFoundException { 
	        // Initialize all the information regarding 
	        // Database Connection 
	        String dbDriver = "com.mysql.jdbc.Driver"; 
	        String dbURL = "jdbc:mysql://localhost:3306/"; 
	        // Database name to access 
	        String dbName = "menagerie";
	        String dbUsername = "root"; 
	        String dbPassword = "Tay-nina-13"; 
	  
	        Class.forName(dbDriver); 
	        Connection conn = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword); 
	        System.out.println("Connected successfully");
	        return conn; 
	    } 
}
