<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="bean.*,util.*,java.util.*"  %>
    <%@ page import="java.text.SimpleDateFormat,java.util.Calendar,java.util.TimeZone" %>
    
     <% SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
     sdf2.setTimeZone(TimeZone.getTimeZone("GMT+7")); %>
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="header.jsp" %>

<% requestManager rqm = new requestManager();

	String id = (String) session.getAttribute("idrequest");
    pool_reservations pr = rqm.getRequestUsePoolReturn(id);
   %>
   
  
    ชื่อกิจกรรม:	<%= pr.getEvent_name() %> <br>
    วันที่เริ่มใช้:	<%= sdf2.format(pr.getStart_time().getTime())%> <br>
   	วันที่สิ้นสุดการใช้ : 	<%= sdf2.format(pr.getEnd_time().getTime())%> <br>
   	รายละเอียด : <%= pr.getDetail()%> <br>
	
 
</body>
</html>