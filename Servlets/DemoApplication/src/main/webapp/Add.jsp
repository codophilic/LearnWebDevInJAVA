<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition of two Numbers</title>
</head>
<body bgcolor='yellow'>
	<%
	
	int num1=0;
	int num2=0;
	num1=Integer.parseInt(request.getParameter("num1")); // Get parameter provides value in String so we parse it in Integer.
	num2=Integer.parseInt(request.getParameter("num2")); 
	out.println("Addition is "+(num1+num2));
	%>

</body>
</html>