package com.checkmethod;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckMethod extends HttpServlet {
	/*
	 Depedning on the request method the particular method will get called by service() in 
	 HttpServlet.
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		/*
		 This class will only work for POST request
		 Similarly for GET request we use doGet() method.
		 */
		
		/*
		 When the user enter the submit button on html page , the html page searches for 
		 PostMethod url and from web.xml the request services goes to the respective servlet which 
		 is CheckMethod. 
		 The CheckMethod has parent class HttpServlet, so the request goes to the service() method 
		 in HttpServlet which calls doPost or doget method.
		 */
		PrintWriter out = res.getWriter() ;
		
		out.println("This is a post method and you entered "+req.getParameter("num1"));
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		/*
		 This class will only work for GET request
		 */
		
		/*
		 When the user enter the submit button on html page , the html page searches for 
		 PostMethod url and from web.xml the request services goes to the respective servlet which 
		 is CheckMethod. 
		 The CheckMethod has parent class HttpServlet, so the request goes to the service() method 
		 in HttpServlet which calls doPost or doGet method.
		 */
		PrintWriter out = res.getWriter() ;
		
		out.println("This is a Get method and you entered "+req.getParameter("num1"));
		
	}
}
