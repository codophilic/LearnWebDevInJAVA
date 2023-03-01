<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Login here</h1>
	<br>
	<form action = "login" method='post'>
	Enter User name:
	<input type='text' name='username'><br>
	Enter Password:
	<input type='text' name='password'><br>
	<input type='submit'>
	</form>
	<c:if test="${requestScope.reply=='User ID not found. Please create a new user ID by clicking on the below button'}">
	User ID not found. Please create a new user.<br>
	<button onClick="window.location.href='http://localhost:8080/MyWebsite';">
	Home Page
	</button>
	</c:if>
	<c:if test="${requestScope.reply=='Wrong password . Re-enter the correct password'}">
	Wrong password . Re-enter the correct password
	</c:if>
	
</body>
</html>