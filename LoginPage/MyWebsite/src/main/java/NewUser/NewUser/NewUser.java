package NewUser.NewUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet implements Servlet {

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
			String newusername = request.getParameter("username");
			String newpassword = request.getParameter("password");
			String query="Select * from user where user_name="+"\""+newusername+"\"";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			try{
				String dup=rs.getString(1);
				reply= "There already exist a same user name "+dup;
			}
			catch (SQLException e) {
				String query1="Select * from user where user_password="+"\""+newpassword+"\"";
				ResultSet rs1 = st.executeQuery(query1);
				rs1.next();
				try {
					String dup=rs1.getString(2);
					reply ="Please set a new password";
				}
				catch (SQLException e2) {
					PreparedStatement pst = con.prepareStatement("insert into user values(?, ?)");
					pst.setString(1, newusername);
					pst.setString(2,newpassword);
					pst.executeUpdate();
					reply ="User account created successfully";
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("reply",reply);
		
	}
}
