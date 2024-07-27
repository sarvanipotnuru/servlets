package dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;


//jdbc 2 connections driver loading and creating connection are written here

public class employedb {
private static String driver = "com.mysql.cj.jdbc.Driver";
private static String url = "jdbc:mysql://localhost:3306/employe";
private static String username = "root";
private static String password = "root";
private static Connection conn;
//to implement try catch method we have to give method so I gave getConnection() method is used
public static Connection getConnection(){
	try {
		Class.forName(driver);
		 conn = DriverManager.getConnection(url, username, password);
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
	return conn;
	
}
}
