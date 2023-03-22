package BusinessCode;

import java.io.IOException;
import java.io.PrintWriter;

import DAO.EmployeeDAO;
import DAO.EmployeeDAOImplementation;
import DAO.EmployeeDTO;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/updates")
public class Update extends HttpServlet implements Servlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		
		try {
			
			EmployeeDTO data = new EmployeeDTO(id,name);
			
			EmployeeDAO empdao =  new EmployeeDAOImplementation();
			int status = empdao.update(data);
			
			PrintWriter out = response.getWriter();
			
			if (status==0) out.println("User profile updated");
			else out.println("There is no data for given ID");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
