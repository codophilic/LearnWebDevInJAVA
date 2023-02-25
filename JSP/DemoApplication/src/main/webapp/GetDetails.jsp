<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="NameNotFound.jsp" %>
    
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*" %>
    
<!DOCTYPE html>
<html>
<head>
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
	System.out.println(name+" "+name.getClass());
	String query="Select * from Employee where Employee_first_name="+name;
	
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(query);
	rs.next();

%>

ID: <%= rs.getString(1) %>
FirstName: <%= rs.getString(2) %>
LastName: <%= rs.getString(3) %>
City: <%= rs.getString(4) %>
MailID: <%= rs.getString(5) %>
Joining Date: <%= rs.getString(6) %>
</body>
</html>