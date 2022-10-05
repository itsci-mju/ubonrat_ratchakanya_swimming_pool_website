<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="bean.*,util.*,java.util.*"  %>
<%
	memberManager mm = new memberManager();
	members lmb = mm.getmember("001");
	
	//poolreservationsManager pr = new poolreservationsManager();
	//pool_reservations lpm = pr
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
     
     <% if (lmb == null ){ %>
    	 
    <% }else{%>
    	 <a href="memberprofile">ดูข้อมูลส่วนตัว</a> <br>
    	 <a href="viewrequesttousepool">ดูผลการทำเรื่องขอเข้าใช้สระว่ายน้ำ</a> <br>
    	 
    	 <a href="make_event">สร้างกิจกรรมของสระว่ายน้ำ</a> <br>
    	 <a href="ReportPoolUsageStatistics">สถิติการเข้าใช้งานของผู้ใช้บริการสระว่ายน้ำ</a><br>
    	 
     
    	<a href="barcode">BarCode</a><br>
    	
    	<a href="qrcode">QrCode</a>
    	<%}%>
    	
    	 </div>
    
    <%@ include file="footer.jsp" %>
</body>
</html>