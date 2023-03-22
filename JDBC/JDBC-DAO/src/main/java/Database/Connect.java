package Database;

import java.sql.*;

public class Connect {
	
	private static String DBUrl="jdbc:mysql://localhost:3306/employees"; // LAN IP & Schema name
	private static String username="root";
	private static String password="Hpandya@301";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		    java.lang.Class.forName("com.mysql.jdbc.Driver"); // ---------> 1. Loading and registering Drivers
			
	
			Connection con = DriverManager.getConnection(DBUrl,username,password); // ---------> 2. Connection creation
			// getConnection() is a static method which accepts the URL, username & password params
			
			return con;
		}
}
