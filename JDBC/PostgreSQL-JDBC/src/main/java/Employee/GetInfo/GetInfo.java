package Employee.GetInfo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class GetInfo
 */
@WebServlet("/GetInfo")
public class GetInfo extends HttpServlet implements Servlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			java.lang.Class.forName("org.postgresql.Driver");
			
			
			
			
			String DBUrl="jdbc:postgresql://localhost:5432/employees"; // Schema name
			String username="postgres";
			String password="Hpandya@301";
				
			Connection con = DriverManager.getConnection(DBUrl,username,password);
			PrintWriter out = response.getWriter();
			out.println("PostgreSQL DB Connected ");
			
			int id  = Integer.parseInt(request.getParameter("id"));
			
			String query="Select * from employee where id="+"\'"+id+"\'";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();

			
			String ID = rs.getString(1);
			String Emlployeeusername = rs.getString(2);
			
			out.println(ID+" : "+Emlployeeusername);
			
			st.close();
			con.close();
			rs.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
