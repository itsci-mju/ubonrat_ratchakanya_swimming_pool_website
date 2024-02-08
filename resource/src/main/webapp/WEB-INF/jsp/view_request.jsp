<!-- หน้าดูเอกสาร ของ manager คือดูข้อมูล -->
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="org.itsci.ubrswimming.model.*,org.itsci.ubrswimming.util.*,java.util.*"  %>
    <%@ page import="java.text.SimpleDateFormat,java.util.Calendar,java.util.TimeZone" %>
    
     <% SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
     sdf2.setTimeZone(TimeZone.getTimeZone("GMT+7")); %>
     

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- CSS only -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>

<body>

<%@ include file="header.jsp" %>

<% RequestManager rqm = new RequestManager();

	String id = (String) session.getAttribute("idrequest");
    PoolReservations pr = rqm.getRequestUsePoolReturn(id);
   %>
   
   
   		<form name="frm" method="post" action="#" class="fit">
            <div align="center" style="padding-top:25px;" >
            <p style="font-size: 26px; padding-left: 20px; margin-top: 30px; color:#353b48;" >ดูข้อมูลเอกสาร
   				<table>
   				      <img src ="<%=pr.getDocument()%>" style="width:260px; height:300px; margin-left: 1%; margin-top:40px;"> 				  
 				</table>
 			</div>
 		</form>
</body>


<link rel="stylesheet" href="css/nav.css">
 <style>
 	@import url('https://fonts.googleapis.com/css2?family=Mitr:wght@200;300;400;500;600;700;800;900&display=swap');
*{
   margin: 0;
   padding: 0;
   box-sizing: border-box;
   font-family: 'Mitr', sans-serif;
}


/*-------------------------*//* Body font */


@import url('https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css');
body{
	background-color: #FFFFFF;
	}
.fit {
	background-color: #B2EBF2;
	border-radius: 10px;
	margin-left: 440px;
	margin-right: 410px;
	margin-top: 20px;
	margin-bottom: 99px;
	padding: 100px;
	padding-top: 30px;
	display: flex;
	justify-items: center;     
}


 </style>

</html>