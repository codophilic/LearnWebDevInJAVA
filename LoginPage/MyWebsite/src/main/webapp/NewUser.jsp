<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> New User/Register </h3>
	<br>
	<form action = "NewUser" method='post'>
	Enter a new user name:
	<input type='text' name='username'>
	Enter a new password:
	<input type='text' name='password'>
	<input type='submit'>	
	</form>
	<br>
	<br>
	
	<!-- Displaying servlet response -->
	<c:if test="${requestScope.reply=='There already exist a same user name'}">
	There already exist a same user name . Try different user name
	</c:if>
	<c:if test="${requestScope.reply=='Please create a new password'}">
	Please try a new password.
	</c:if>
	<c:if test="${requestScope.reply=='User account created successfully'}">
	Account Created Successfully, go back to home page and login with the user name and password.
	<button onClick="window.location.href='http://localhost:8080/MyWebsite';">
	Home Page 
	</button> 
	</c:if>
	
	
	

	
	
</body>
</html>