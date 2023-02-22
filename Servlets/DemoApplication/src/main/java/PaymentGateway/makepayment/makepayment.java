package PaymentGateway.makepayment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class makepayment extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter() ; // Object is provided by Tomcat
		int money = Integer.parseInt(req.getParameter("money")); 
		/*
		 GetParameter takes data from URL url=datavalue
		 */
		
		out.println("Payment of "+money+" completed successfully");
	}
}
