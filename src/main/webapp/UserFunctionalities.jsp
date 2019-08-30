<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Functionalities</title>
</head>
<body>
<marquee direction="left" scrollamount=15 behavior="slide" bgcolor="gray" >WELCOME USER</marquee>
<center>

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