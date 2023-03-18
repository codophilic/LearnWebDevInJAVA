package Division;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DivNum
 */
@WebServlet("/DivNum")
public class DivNum extends HttpServlet implements Servlet {
	private static Logger logs = LogManager.getLogger("DivisionLogs"); // Usually Class Name must be provided.

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * Default  Error and its above level FATAL,OFF is configured
		 * 
		 * The configurations files are created under resources/any folder manually. Which also needs to be configured in CLASSPATH -> 
		 * Java build , Properties
		 */
		
		int n1=Integer.parseInt(request.getParameter("num1"));
		logs.info("User Enter number1");
		int n2=Integer.parseInt(request.getParameter("num2"));
		logs.info("User Enter number2");
		int div=0;
		try {
			div = n1/n2;
			logs.info("Division Took Place");
		}
		catch (Exception e) {
			logs.error("Error occured in division");
		}
		
		PrintWriter out = response.getWriter();
		out.println("Result is "+div);
		logs.info("Code Completed");
	}

}
