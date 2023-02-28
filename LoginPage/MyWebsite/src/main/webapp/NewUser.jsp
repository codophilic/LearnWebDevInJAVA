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
	
</body>
</html>