package Employee.DB.DBConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



// This class can be used to initialize the database connection
public class DBConnection {
	public static Connection ConnectToDB()
		throws SQLException, ClassNotFoundException
	{
		// Initialize all the information regarding
		// Database Connection
		java.lang.Class.forName("com.mysql.jdbc.Driver");
		String DBUrl="jdbc:mysql://localhost:3306/employees"; // Schema name
		String username="root";
		String password="Anime1234#";
			
		Connection con = DriverManager.getConnection(DBUrl,username,password);
//		System.out.println("True");
//		String query="Select * from Employee where Employee_ID=1";
//		
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(query);
//		rs.next();
//
//	System.out.println(rs.getString(2));
		return con;
	}
}
