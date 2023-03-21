package Employees.FetchDB;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;
import Employees.ConnectDB.*;
/**
 * Servlet implementation class FetchDB
 */
@WebServlet("/FetchDB")
public class FetchDB extends HttpServlet implements Servlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			Connection con = DBConnection.ConnectToDB(); // ---------> 2. Connection creation
			
			String roll = request.getParameter("roll");
			
			String query="Select * from Employee where Employee_id="+"\""+roll+"\"";
			
			Statement st = con.createStatement(); // ---------> 3. Create Statement
			/*
			 * Statement is an Interface 
			 */
			
			
			ResultSet rs = st.executeQuery(query); // ---------> 4. Execute the Query
			/*
			 * The output provides the whole table , where to fetch particular value of the row
			 * we use next() method to bring the pointer to the respective row.
			 * 
			 * ResultSet stores the chunk of table in a tabular structure
			 * 
			 * name | roll <----- pointer rs
			 *------------------
			 * Harsh| 1 <------rs (using next())
			 * Meet	| 2
			 *
			 *
			 */
			
			rs.next(); // Currently pointer is at table headings

			
			String Nameusingnumber = rs.getString(2); 
			String NameusingColumnName = rs.getString("Employee_name"); // ---------> 5. Process the result
			int userID = rs.getInt("Employee_id");
			

			
			System.out.println(NameusingColumnName);
			PrintWriter out = response.getWriter();
			out.println("Data Found "+NameusingColumnName);
			

			
			out.println("Printing All Data");
			
			/*
			 * We can use normal create statement, but there is good option of using prepared statement when we have multiple 
			 * values. In create statement , we have to use string formatting based query, whereas in Prepared statement
			 * we need just pass ? mark as our argument in the query
			 */
			
			String UserName="Dimple";
			int UserID=6;
			String insert="insert into Employee values (?,?);";
			
			
			PreparedStatement pst = con.prepareStatement(insert);
			/*
			 * Before executing the query we need to replace the question marks
			 */
			
			pst.setInt(1, UserID); // replace first question mark by UserID
			pst.setString(2, UserName); // replace second question mark by UserName
			
			pst.executeUpdate();
			
			// st.executeQuery(insert) // This method returns an integer which represents number of rows affected just like in SQL output when we insert.
			
			
			/*
			 * In PrepareStatement we don't need to pass the query in the execute query parameter. It takes the query from prepare statement
			 */
			
			query="Select * from Employee";
			ResultSet rsall = st.executeQuery(query);
			while(rsall.next()) {
				out.println(rsall.getInt(1)+" : "+rsall.getString(2));
			}
			
			
			
			
			st.close();
			con.close(); // ---------> 6. Closing connection
			}
			catch (Exception e) {
				PrintWriter out = response.getWriter();
				out.println("DB Connection not establish"+e);
			}
		
		
		
		
		
		
		
	}


}
