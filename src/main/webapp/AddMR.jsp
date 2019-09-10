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
<marquee direction="right" scrollamount=20 behavior="scroll" bgcolor="silver" height=20 >Add a Meeting Room</marquee><br>
<br>
<center>
<form method="post" action="/addmr">
<br>
Enter the MR Name to add:<br>
<input type="text" name="mrname" required><br>
Enter the MR number:<br>
<input type="text" name="mrno" required>
<br>
<br>
<input type="submit" value="add">

</form>

</body>
</html>