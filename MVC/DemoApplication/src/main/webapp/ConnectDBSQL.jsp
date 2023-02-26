<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONNECTED TO MYSQL DB</title>
</head>
<body>
<h1>CONNECTED TO MYSQL DB</h1>
Data for Employee <% out.println((String)request.getParameter("name"));%>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/employees" user='root' password="Anime1234#" />
<sql:query var="rs" dataSource="${db}">Select * from Employee where Employee_first_name=<%="\""+(String)request.getParameter("name")+"\""%></sql:query>
<!-- var -> reference variable for the DB , rs=ResultSet-->
<br>
<br>
<c:forEach items="${rs.rows}" var="i">
<c:out value="${i.Employee_id}"></c:out>:<c:out value="${i.Employee_first_name}"></c:out>:<c:out value="${i.Employee_last_name}"></c:out>
<br>
<br>
<c:out value="${i.Employee_City}"></c:out>:<c:out value="${i.Employee_emailID}"></c:out>:<c:out value="${i.Employee_Joining_date}"></c:out>
</c:forEach>


</body>
</html>