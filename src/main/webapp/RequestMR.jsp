<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    <jsp:include page="UserFunctionalities.jsp" />  
<!DOCTYPE html>
<html>
<head>
<br>
<marquee direction="right" scrollamount=20 behavior="scroll" bgcolor="silver" >Request Meeting Room</marquee>
<br>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<form method="post" action="/requestmr">
<!--  Enter the Username for Booking:<br>
<input type="text" name="uname"><br><br> -->
Enter the Start Date:
<input type="date" name="startdate" required><br><br>
Enter the End Date:
<input type="date" name="enddate" required><br><br>
Enter the Start Time:
<input type="time" name="starttime" required><br><br>
Enter the End Time:
<input type="time" name="endtime" required><br><br>

<td>Meeting Room Name:</td>
<td><select name="mrname" >

<%
ArrayList<String> meetingrooms = (ArrayList<String>) request.getAttribute("meetingrooms");
for (String meeting : meetingrooms) {
%>
<option>
<%=meeting%>
</option>
<%
}
%>
</select></td>
</tr><br><br>


<td>Resource No:</td>
<td><select name="resource">

<%
ArrayList<String> resources = (ArrayList<String>) request.getAttribute("resources");
for (String resource : resources) {
%>
<option>
<%=resource%>
</option>
<%
}
%>
</select></td>
</tr><br><br>

<input type="submit" value="REQUEST">
<br>
</form>

</body>
</html>