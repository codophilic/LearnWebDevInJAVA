package com.AddAndSquare;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddAndSquare extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();
		
		int addition = (int) req.getAttribute("addition"); // Type Casting since request is in form of object
		int square = addition * addition;
		out.println("Addition of two number is "+addition+" and its square is "+square);
		
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
