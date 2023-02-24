<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	out.print("Hello "+(String)pageContext.getAttribute("name",PageContext.SESSION_SCOPE));	
		
	

/*
<c:out value="${name}" />
*/
%>

</body>
</html>