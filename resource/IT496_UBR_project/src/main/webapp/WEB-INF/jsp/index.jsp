<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="bean.*,util.*,java.util.*"  %>
<%
	memberManager mm = new memberManager();
	members lmb = mm.getmember("001");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>  </title>
</head>
<link rel="stylesheet" href="css/main_style.css">
<link rel="stylesheet" href="css/original.css">
<body id="nonselect">
    <%@ include file="header.jsp" %>
    
   
    <div class="main-content">
    
    	<a href="testVerifyEmail">testVerifyEmail</a>
    	<a href="loginpage">login</a>
    	<% for(int i=0;i<1000;i++) {%>
    	abcdefghijklmnopqrstuvwxyz
    	<%} %>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>