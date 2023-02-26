<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page errorPage="NameNotFound.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	java.lang.Class.forName("com.mysql.jdbc.Driver");
	String DBUrl="jdbc:mysql://localhost:3306/employees"; // Schema name
	String username="root";
	String password="Anime1234#";
		
	Connection con = DriverManager.getConnection(DBUrl,username,password);
	String name = request.getParameter("name");
	
	String query="Select * from Employee where Employee_first_name="+"\""+name+"\"";
	//System.out.println(query);
	
	
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(query);
	rs.next();

%>

ID: <%= rs.getString(1) %><br>
FirstName: <%= rs.getString(2) %><br>
LastName: <%= rs.getString(3) %><br>
City: <%= rs.getString(4) %><br>
MailID: <%= rs.getString(5) %><br>
Joining Date: <%= rs.getString(6) %><br>
</body>
</html>