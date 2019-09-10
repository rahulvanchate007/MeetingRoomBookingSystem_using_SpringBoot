<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.util.*,com.MRBSBooking.*,com.MRBSBooking.Bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ACCEPT OR REJECT</title>
</head>
<link rel="stylesheet" type="text/css" href="AdminStyle.css">
<body bgcolor="D3D3D3">
<center>
<h1>BOOKING HISTORY</h1>
<%
ArrayList<MeetingRequest> meetingrequests = (ArrayList<MeetingRequest>)request.getAttribute("list");
%>
<table border="1" align="center">
<thead>
<tr>
<th>ID</th>
<th>START DATE</th>
<th>END DATE</th>
<th>START TIME</th>
<th>ENDTIME</th>
<th>USER</th>
<th>MRNAME</th>
<th>RESOURCE</th>
<th>STATUS</th>
</tr>
</thead>
<tr>
<%
for (MeetingRequest meetingrequest : meetingrequests) {
out.print("<tr><td>" + meetingrequest.getId() + "</td>" + "<td>" + meetingrequest.getStartdate()
+ "</td>" + "<td>" + meetingrequest.getEnddate() + "</td>" + "<td>"
+ meetingrequest.getStarttime() + "</td>" + "<td>" + meetingrequest.getEndtime() + "</td>"
+ "<td>" + meetingrequest.getUser() + "</td>" + "<td>" + meetingrequest.getMrname() + "</td>"
+ "<td>" + meetingrequest.getResource() + "</td>" + "<td>" + meetingrequest.getStatus()
+ "</td>");
}
%>
</tr>
</table>
<br>
<br>

</body>
</html>