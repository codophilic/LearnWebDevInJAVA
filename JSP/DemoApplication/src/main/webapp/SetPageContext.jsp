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
	String name=(String)request.getParameter("name");
	out.println("Welcome "+name);
	pageContext.setAttribute("name",name,PageContext.SESSION_SCOPE);
	out.println("Scope Set");
	//response.sendRedirect("GetPageContext.jsp");
	
	/*
	Session Scope and be accessed multiple times within same session
	
	Page Scope can be accessible within the same page
	
	Reques scope works when the page call multiple JSPs
	
	Application Scope always present whenever we create new session or use same session . Always stays
	*/
%>
</body>
</html>