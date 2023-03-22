package BusinessCode;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.EmployeeDAOImplementation;
import DAO.EmployeeDTO;
import DAO.EmployeeDAO;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/getthedatas")
public class GetData extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			EmployeeDAO empdao =  new EmployeeDAOImplementation();
			EmployeeDTO data = empdao.get(id);
			
			PrintWriter out = response.getWriter();
			
			if (data == null) out.println("User does not exists");
			else out.println(data);
			empdao.finalize();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
