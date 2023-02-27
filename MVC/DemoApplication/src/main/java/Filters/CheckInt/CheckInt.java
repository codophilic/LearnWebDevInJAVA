package Filters.CheckInt;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class CheckInt
 */
@WebFilter("/AddNum")
public class CheckInt extends HttpFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		int num1=0;
		int num2=0;
		try{
			num1=Integer.parseInt(request.getParameter("num1"));
		}
		catch(Exception e) {
			PrintWriter out = response.getWriter() ;
			
			out.println("You Entered a string as first number");
		}try{
			num2=Integer.parseInt(request.getParameter("num2"));
		}
		catch(Exception e) {
			PrintWriter out = response.getWriter() ;
			
			out.println("You Entered a string as second number");
		}
  		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
}
