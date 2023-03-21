package Employees.ConnectDB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//  This is Java files and not Servlet which accepts request response

// This class can be used to initialize the database connection
public class DBConnection {
	public static Connection ConnectToDB()
		throws SQLException, ClassNotFoundException
	{
		// Initialize all the information regarding
		// Database Connection
		
		
		java.lang.Class.forName("com.mysql.jdbc.Driver"); // ---------> 1. Loading and registering Drivers
		
		/*
		 * Suppose there are statements in a static block in class A which needs to be executed when jvm loads class A. 
		 * So these statements gets executed since it is inside a static block when we call
		 * 
		 * Class.forName("A"); -> Loads class A, executes static block statements of class A
		 * 
		 * In JDBC, the DriverManager , register the drivers of the loaded class
		 * 
		 * DriverManager.registerDriver(new ClassName); e.g DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 * 
		 * The Driver() method , internally it has a static block which automatically register the Drivers
		 * 
		 * So, when we say Class.forName("com.mysql.jdbc.Driver"); 
		 * 
		 * -> forName , loads the drivers
		 * -> Driver() static block , register the drivers.
		 * 
		 */
		
		
		String DBUrl="jdbc:mysql://localhost:3306/employees"; // LAN IP & Schema name
		String username="root";
		String password="Hpandya@301";
			
		Connection con = DriverManager.getConnection(DBUrl,username,password); // ---------> 2. Connection creation
		// getConnection() is a static method which accepts the URL, username & password params
		

		return con;
	}
}
