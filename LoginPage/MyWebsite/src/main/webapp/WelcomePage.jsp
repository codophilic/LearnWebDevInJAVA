<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<!-- Checking if the user directly accessing login -->
<%
	if(session.getAttribute("loginusernmae")==null){
		response.sendRedirect("LoginPage.jsp");
	}
%>
<h1>Welcome ${loginusernmae}</h1>

<h2>Contents of our website</h2>

<a href="Video.jsp"> Watch Videos here</a>
<br>
<br>
<a href="Images.jsp"> Watch Images here</a>
<br>
<br>

<form action="Logout" method='get'>
<input type='submit' value='Logout'>
</form>
<br>
<br>

</body>
</html>