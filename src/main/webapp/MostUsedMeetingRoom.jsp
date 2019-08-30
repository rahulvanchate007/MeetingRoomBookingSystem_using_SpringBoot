<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.example.demo.*,java.util.*"%>
 <jsp:include page="AdminFunctionalities.jsp" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Most Used Meeting Room</title>
</head>
<body>
<form name="Newrequest" style="text-align: center" method="post" action="/mostusedmeetingroom">
<h2 align="center">Resource Usage</h2>
<table align="center">
<td>Resource No:</td>
<td><select name="mrname">

<%
ArrayList<String> resources = (ArrayList<String>) request.getAttribute("meetingrooms");
for (String resource : resources) {
%>
<option>
<%=resource%>
</option>
<%
}
%>
</select></td>
</tr>

</table>
<input type="submit" name="SUBMIT" value="submit">
</form>
</html>