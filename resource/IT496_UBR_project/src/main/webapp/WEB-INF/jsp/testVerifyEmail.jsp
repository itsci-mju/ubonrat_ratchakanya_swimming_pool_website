<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String m =	(String)session.getAttribute("message");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="verifyEmail" method="post" name="frm">
        <input type="text" name="email" id="email">
        <input type="submit" value="ok">
        <label><%= m %></label>
    </form></div>
</body>
</html>