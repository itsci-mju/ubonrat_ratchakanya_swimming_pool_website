<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="org.itsci.ubrswimming.model.*,org.itsci.ubrswimming.util.*,java.util.*"  %>
    <%@ page import="java.text.SimpleDateFormat,java.util.Calendar,java.util.TimeZone" %>
    <%
    	RequestManager req = new RequestManager();    
    	List<PoolReservations> psv = (List<PoolReservations>) req.getListRequestUsePool();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>จัดการแบบฟอร์มขอเข้าใช้งาน</title>
</head>
<link rel="stylesheet" href="css/original.css">
<link rel="stylesheet" href="css/staff_content.css">
<body id="nonselect">
<%@ include file="header.jsp" %>


    <div class="content-manage">
        <table class="manage_table">
            <thead class="column-table">
                <tr>
                	<th style="width: 50px;">
                        รหัสการขอเข้าใช้สระว่ายน้ำ
                    </th>
                    
                    <th style="width: 300px;">
                        ชื่อกิจกรรม
                    </th>
                    <th style="width: 150px;">
                        วันที่ขอใช้
                    </th>
                    <th style="width: 120px;">
                        ถึงวันที่
                    </th>
                    <th style="width: 70px;">
                        เอกสาร
                    </th>
                    <th style="width: 70px;">
                        อนุมัติ
                    </th>
                    <th style="width: 70px;">
                        ลบคำขอ
                    </th>
                </tr>
            </thead>
            <tbody class="column-table">
            <% for(PoolReservations p:psv) { %>
                <tr align="center">
                
                <td align="left">
                        <div class="nametd">
                            <%= p.getPool_reservations_id() %>
                        </div>
                    </td>
                
                    <td align="left">
                        <div class="nametd">
                            <%= p.getEvent_name() %>
                        </div>
                    </td>
                    <td> 
                        <%= sdf.format(p.getStart_time().getTime()) %>
                    </td>
                    <td>
                        <%= sdf.format(p.getEnd_time().getTime()) %>
                    </td>
                    <td>
                        <a href="view_request?id=<%= p.getPool_reservations_id() %>"> <i class="bi bi-file-earmark-text"></i></a>
                    </td>
                    <td class="accept"> 
                        <a href="approve_request?id=<%= p.getPool_reservations_id() %>"> <i class="bi bi-check2-square"></i></a>
                    </td>
                    <td class="decline">
                        <a href="deleteReservations?id=<%= p.getPool_reservations_id() %>"> <i class="bi bi-x-circle"></i></a>
                    </td>
                </tr>
              <% } %>
            </tbody>
          
        </table>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>