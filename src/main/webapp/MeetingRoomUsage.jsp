<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="AdminFunctionalities.jsp" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Meeting Room Usage</title>
</head>
<h1>MEETING ROOM USAGE</h1>
<body>
<%String count=(String)request.getAttribute("status"); out.println("The Resource is used "+count+"times");%>
</body>
</html>