<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="org.itsci.ubrswimming.model.*,org.itsci.ubrswimming.util.*,java.util.*"  %>
    <%@ page import="java.text.SimpleDateFormat,java.util.Calendar,java.util.TimeZone" %>
    <%
    	RequestManager req = new RequestManager();
    
    	List<PoolReservation> psv = (List<PoolReservation>) req.getListRequestUsePool();
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
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
<%@ include file="common/header.jsp" %>
    <div class="content-manage">
        <table class="manage_table">
            <thead class="column-table">
                <tr>
                    <th style="width: 300px;">
                        ชื่อ
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
            <% for(PoolReservation p:psv) { %>
                <tr align="center">
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
            <tfoot class="column-table"> 
                <tr>
                    <td colspan="6" style="background-color: rgb(230, 230, 230,0.8);">
                        &nbsp;
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
    <%@ include file="common/footer.jsp" %>
</body>
</html>