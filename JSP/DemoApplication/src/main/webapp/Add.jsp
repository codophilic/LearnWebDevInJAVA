<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.lang.Math" %>    <!-- Directive Tag to import packages -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition of two numbers</title>
</head>
<body bgcolor='yellow'>
<%!
	String wlc = "Welcome!!";
	String Hello = "Hello";
	
%> <!-- DeclarationNot scriptlet Tag which defines instance variable in a class -->
<h1>
	<%
	out.println("Hello");
	%> <!-- Scriptlet tag which a part of service method of HttpServlet class -->
</h1>
<h2> <%= Hello %> Addition of two numbers</h2> <!-- Expression tag -->
	<%
	
	int num1=0;
	int num2=0;
	num1=Integer.parseInt(request.getParameter("num1")); // Get parameter provides value in String so we parse it in Integer.
	num2=Integer.parseInt(request.getParameter("num2")); 
	int result = num1+num2;
	out.println("Addition is "+result+" "+wlc);
	out.println("Square of result is "+Math.pow(result,2)+" "+wlc);
	%><!-- Scriptlet tag which a part of service method of HttpServlet class -->
</body>
</html>