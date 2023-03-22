package BusinessCode;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.EmployeeDAO;
import DAO.EmployeeDAOImplementation;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/alldata")
public class All extends HttpServlet implements Servlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			EmployeeDAO empdao =  new EmployeeDAOImplementation();
			PrintWriter out = response.getWriter();
			out.println(empdao.getAll());
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
