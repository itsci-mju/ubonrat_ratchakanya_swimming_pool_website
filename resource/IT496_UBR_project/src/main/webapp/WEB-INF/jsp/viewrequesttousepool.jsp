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

   

      <% 
   requestManager rqm = new requestManager();
    List <pool_reservations>  pr = rqm.getListRequestUsePool_memid(log.getMembers_id());
    
   %>
   <% for(int i=0 ; i<pr.size(); i++) { %>
   

    ชื่อกิจกรรม:	<%= pr.get(i).getEvent_name() %> <br>
    วันที่เริ่มใช้:	<%= sdf2.format(pr.get(i).getStart_time().getTime())%> <br>
   	วันที่สิ้นสุดการใช้ : 	<%= sdf2.format(pr.get(i).getEnd_time().getTime())%> <br>
   	รายละเอียด : <%= pr.get(i).getDetail()%> <br>
	


 	<% }%>
</body>
</html>