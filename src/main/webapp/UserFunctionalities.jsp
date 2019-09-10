<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Functionalities</title>
</head>
<link rel="stylesheet" type="text/css" href="UserStyle.css">
<body>
<marquee direction="left" scrollamount=15 behavior="slide" bgcolor="gray" >WELCOME USER</marquee>
<center>

<div align="right">
<form method="post" action="Login.jsp">
<input type="submit" value="Logout">
</form>
</div>

<div align="left">
<form method="post" action="UserFunctionalities.jsp">
<input type="submit" value="Back To Home">
</form>
</div>

<h2>To Request a Meeting Room, Click here:</h2>
<form method="post" action="/meetingrequest">
<input type="submit" name="operation" value="request">
</form>

<h2>To Cancel a Request, Click here:</h2>
<form action="/cancelview">
<input type="submit" name="operation" value="cancel"><br>
</form>

</body>
</html>