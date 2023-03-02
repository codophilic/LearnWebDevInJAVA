<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FileUpload</title>
</head>
<body>
Upload your files here <br><br>
<form action="upload" method='post' encdtype="multipart/form-data">
<br>
<input type="file" name="file" multiple/>
<br>
<input type="submit"/>

</form>
</body>
</html>