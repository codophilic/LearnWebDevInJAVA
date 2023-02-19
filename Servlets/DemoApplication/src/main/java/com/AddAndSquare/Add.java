package com.AddAndSquare;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException { 
		
		int num1=0;
		int num2=0;
		num1=Integer.parseInt(req.getParameter("num1")); // Get parameter provides value in String so we parse it in Integer.
		num2=Integer.parseInt(req.getParameter("num2")); 
		
		/*
		 getWriter() calls PrintWriter class 
		 */
		
		int addition = num1+num2;
		
		// Passing the Data in the request object so that the another servlet can access it.
		req.setAttribute("addition", addition);
		
		/*
		 Now to call Square Servlet ,to call a servlet from a servlet there are two methods 
			 1. RequestDispatcher -> interface
			 2. ReDirect
		 */
		RequestDispatcher rd = req.getRequestDispatcher("SquareAndAdd"); // pass the url which will be generated for Square servlet define in web.xml 
		
		rd.forward(req, res); // This will call AddAndSquare servlet.
		
		/*
		 Whole Flow of calling a servlet from a servlet
		 1. From the HTML page it will go and search for url pattern (AddSquare) in Web.xml
		 2. In web.xml the corresponding servlet is com.AddAndSquare.Add;
		 3. This will call Add() method and add methid performs operation.
		 4. Now we want to pass the result(addition variables) to another servlet, we put that
		 	variable in the request object using setAttribute() method.
		 5. The RequestDispatch will Dispact the request object into the provided URL pattern
		 	passed in the argument which is SquareAndAdd.
		 6. Going back to the web.xml it will look for SquareAndAdd url-pattern and will call its respective
		 	servlet.
		 7. The servlet will provide response object back to the AddSquare url.
		 */
	}
		
}
