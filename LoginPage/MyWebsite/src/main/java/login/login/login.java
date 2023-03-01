package login.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet implements Servlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reply="";
		PrintWriter out = response.getWriter();
		
		try {
			java.lang.Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String DBUrl="jdbc:mysql://localhost:3306/userdetailsdb"; // Schema name
		String username="root";
		String password="Anime1234#";
			
		try {
			Connection con = DriverManager.getConnection(DBUrl,username,password);
			String loginusername = request.getParameter("username");
			String loginpassword = request.getParameter("password");
			String query="Select * from user where user_name="+"\""+loginusername+"\"";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			
			try{
				String foundusername=rs.getString(1);
				
				if(loginpassword.equals(rs.getString(2))) {
					
					HttpSession session = request.getSession(); // Created a session which will be through other pages.
					session.setAttribute("loginusernmae",foundusername);
					response.sendRedirect("WelcomePage.jsp");
				}
				else {
					reply ="Wrong password . Re-enter the correct password";
					request.setAttribute("reply",reply);
					request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
				}
			}
			catch (SQLException e) {
				reply="User ID not found. Please create a new user ID by clicking on the below button";
				request.setAttribute("reply",reply);
				request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			out.println("DB Connection Error");
		}

		/*
		 If we write again here (outside of all try catch) a redirect of url method like request dispatcher it will throw error 
		 If all checks are passed successfully , the response is already forward to WelcomePage.jsp
		 */
	}

}
