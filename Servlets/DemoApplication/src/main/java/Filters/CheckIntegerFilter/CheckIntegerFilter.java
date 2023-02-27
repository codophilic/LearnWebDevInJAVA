package Filters.CheckIntegerFilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class CheckIntegerFilter
 */
@WebFilter({ "/CheckIntegerFilter", "/AddNum" })
public class CheckIntegerFilter extends HttpFilter implements Filter {
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
		chain.doFilter(request, response); // Call the next filter (if its a last filter it will call a servlet)
	}


}
