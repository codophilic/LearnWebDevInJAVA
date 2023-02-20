package Amazon.CheckoutPayment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckoutPayment extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int money = Integer.parseInt(req.getParameter("money")); 
		/*
		 The getparameter takes the data from the URL
		 */
		
		if(money>=2000) {
			res.sendRedirect("PaymentGateway?money="+money); // URL Rewriting
			/*
			 The method in servlet PaymentGateway is post method, so when the response of CheckoutPayment goes
			 to the browser, the doPost method in servlet PaymentGateway makes the browser url has
			 /DemoApplicatin/PaymentGateway?money=(valueEntered by User).
			  
			 From this URL The method in servlet PaymentGateway takes data by getParameter() method.
			 */
		}
		else {
			PrintWriter out = res.getWriter() ;
			
			out.println("You have Entered "+money+" wrong payment. Right payment is >=2000");
		}
		
	}
}
