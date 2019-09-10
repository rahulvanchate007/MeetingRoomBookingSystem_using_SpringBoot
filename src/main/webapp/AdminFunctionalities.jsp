<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrator Functionalities</title>
</head>
<link rel="stylesheet" type="text/css" href="AdminStyle.css">
<marquee direction="left" scrollamount=15 behavior="slide" bgcolor="grey" >WELCOME FACILITY MANAGER</marquee>
<center>

<div align="right">
<form method="post" action="Login.jsp">
<input type="submit" value="Logout">
</form>
</div>

<div align="left">
<form method="post" action="AdminFunctionalities.jsp">
<input type="submit" value="Back To Home">
</form>
</div>

<h3 id="an"><a href="AddUser.jsp">Add user</a></h3>
<h3 id="an"><a href="DeleteUser.jsp">Delete user</a></h3>
<h3 id="an"><a href="AddMR.jsp">Add a Meeting Room</a></h3>
<h3 id="an"><a href="AddResource.jsp">Add a Resource</a></h3>
<h3 id="an"><a href="/meetingroomselect">Most Used Meeting Room</a></h3>
<h3 id="an"><a href="/resourceselect">Most Used Resource</a></h3>
<h3 id="an"><a href="/view"> View all Bookings</a></h3>
<h3 id="an"><a href="/AcceptReject">Accept or Reject</a></h3>


</body>
</html>