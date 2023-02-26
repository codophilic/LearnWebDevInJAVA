package Employee.GetInfo;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Employee.DB.DBConnection.DBConnection; // Importing the DB connection

/*
 Import DB Connection and running the query
 */

@WebServlet("/GetInfo")
public class GetInfo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
		Connection con = DBConnection.ConnectToDB();
		
		String name = request.getParameter("name");
		
		String query="Select * from Employee where Employee_first_name="+"\""+name+"\"";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();

		
		String ID = rs.getString(1);
		String FirstName = rs.getString(2);
		String LastName = rs.getString(3);
		String City = rs.getString(4);
		String MailID = rs.getString(5);
		String JoiningDate = rs.getString(6);
		
		request.setAttribute("MailID", MailID);
		request.setAttribute("City", City);
		request.setAttribute("LastName", LastName);
		request.setAttribute("FirstName", FirstName);
		request.setAttribute("ID", ID);
		request.setAttribute("JoiningDate", JoiningDate);
		//System.out.println(City);
		}
		catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("DB Connection not establish"+e);
		}
		
		int arr[]={1,2,3,4};
		
		request.setAttribute("arr", arr);
		
		RequestDispatcher rd = request.getRequestDispatcher("ViewInfo.jsp");
		rd.forward(request, response);
		
	}


}
