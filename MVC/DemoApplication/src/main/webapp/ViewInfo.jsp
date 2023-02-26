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
<h1>View Employee Information</h1>
<!-- Using JSTL having core tags -->

FirstName: <c:out value="${FirstName}" /><br>
LastName: <c:out value="${LastName}" /><br>
ID: <c:out value="${ID}" /><br>
City: <c:out value="${City}" /><br>
JoiningDate: <c:out value="${JoiningDate}" /><br>

<!-- More examples with core tag using prefix 'c' -->
<c:import url="https://www.google.co.in/" />  <!--  Gettin HTML of a page -->

<c:forEach items="${arr}" var="i"> <!--  For Loops -->
${i}<br>
</c:forEach>



</body>
</html>