<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>functions</title>
</head>
<body>
<h1>Use Functions tags</h1>

<c:set var="st" value="${param.txt}" /> <!--  Accepting input from client-->

You Entered String <c:out value="${st}"></c:out> which is ${fn:length(st)}.

Splitting the String

<c:forEach items="${fn:split(st,' ')}" var="s">
<br>
<c:out value="${s}"></c:out>
</c:forEach>
<br>
Get Index of 'h' which is ${fn:indexOf(st,"h")}
<br>
check if a substring 'Hey' in the string ${fn:contains(st,'Hey')}
<br>
<c:if test="${fn:contains(st,'Hey')}">
Yes its present
</c:if>
<br>
LowerCase of sentense is `${fn:toLowerCase(st)}`
</body>
</html>