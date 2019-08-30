<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="AdminFunctionalities.jsp" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete User</title>
</head>
<body bgcolor="grey">
<center>
<form method="post" action="/delete">
Enter the Username to delete:<br>
<input type="text" name="uname" required><br>
<br>
<br>
<input type="submit" value="delete">
</body>
</html>