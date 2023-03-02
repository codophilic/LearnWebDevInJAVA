<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Videos</title>
</head>
<body>
<%
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	if(session.getAttribute("loginusernmae")==null){
		response.sendRedirect("LoginPage.jsp");
	}
%>
<h1> Welcome ${loginusernmae} view Videos Page</h1>

<br>
<br>
<form action="Logout" method='get'>
<input type='submit' value='Logout'>
</form>

</body>
</html>