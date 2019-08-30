<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="AdminFunctionalities.jsp" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<marquee direction="right" scrollamount=20 behavior="scroll" bgcolor="silver" height=20 >Add a Resource</marquee><br>

<body>
<center>
<form method="post" action="/addresource">
Enter the Resource Name to add:<br>
<input type="text" name="resourcename" required><br>
Enter the Resource number:<br>
<input type="text" name="resourceno" required>
<br>
<input type="submit" value="add">

</form>

</body>
</html>