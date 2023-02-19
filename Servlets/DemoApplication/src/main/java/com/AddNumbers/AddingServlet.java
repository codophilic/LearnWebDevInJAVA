package com.AddNumbers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 Create servlet by right click , new -> class , provide package name, class name .
 Extend the class HttpServlet 
 */

public class AddingServlet extends HttpServlet {
	/*
	 Working with Servlet we must use service method.
	 Now to get the request object and its input and provide response object we need to pass
	 both object in the method.(HttpServletRequest req, HttpServletResponse res)
	 
	 Tomcat automatically creates these both object we just provide reference variable.	 
	 
	 */
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException { 
		
		int num1=0;
		int num2=0;
		num1=Integer.parseInt(req.getParameter("num1")); // Get parameter provides value in String so we parse it in Integer.
		num2=Integer.parseInt(req.getParameter("num2")); 
		
		/*
		 getWriter() calls PrintWriter class 
		 */
		PrintWriter out = res.getWriter() ;
		
		out.println("result is "+(num1+num2)); // This won't work when we call servlet from a servlet.
		
	}
}
