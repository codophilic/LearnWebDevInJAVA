<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page errorPage="DivisionError.jsp" %>    <!--  If any things goes wrong in this page called Error page -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	
	int num1=0;
	int num2=0;
	num1=Integer.parseInt(request.getParameter("num1")); // Get parameter provides value in String so we parse it in Integer.
	num2=Integer.parseInt(request.getParameter("num2")); 
	double result = num1/num2; // Use try catch to handle this
	out.println("Division is "+result);
	%>
</body>
</html>