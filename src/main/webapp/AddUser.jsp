<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="AdminFunctionalities.jsp" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<form method="post" action="/add">
Enter the Username to add:<br>
<input type="text" name="uname" required><br>
Enter the password:<br>
<input type="password" name="pwd" required>
<br>
<br>
<input type="submit" value="add">

</form>
</body>
</html>