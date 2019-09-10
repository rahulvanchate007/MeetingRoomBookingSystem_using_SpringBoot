<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<link rel="stylesheet" type="text/css" href="Loginstyle.css">
<marquee direction="left" scrollamount=10 behavior="scroll" bgcolor="silver" >MEETING ROOM BOOKING SYSTEM</marquee>
<center>

<h2>Login</h2>
<body >

	<form method="post" action="control">
		<br>
		Username:
		<input type="text" name="username" required> <br><br>
		Password:
		<input type="password" name="password" required><br><br>
		<input type="submit" value="LOGIN"><br>
	</form>
	
</body>

</html>
