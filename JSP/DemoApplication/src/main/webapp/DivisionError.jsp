<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Something Went wrong, denominator cannot be divided by zero</h1>
Exception message <%= exception %>
<br>
Exception message <%= exception.getMessage() %> <!-- Exception is an object which only works in error page, DivisionError.jsp must know that its an error page , that's why we use declarative tag isErrorPage -->
<br>

</body>
</html>