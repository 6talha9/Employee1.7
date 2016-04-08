<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="//localhost:8080/Employee/jsp/home.html">Employee Record</a><br>
<h2 >Department Record</h2>
<h3 style="color: red ">${message}</h3>
<form action= "/Employee/jsp/deptinsert.html" method="post">
<!-- Enter id <input type="text" name ="id" maxlength="20"required><br> -->
Enter Name <input type="text" name ="name" maxlength="20"required><br>
<input type="submit" value= "submit"><br></form>
</body>
</html>