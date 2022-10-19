<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="org.itsci.ubrswimming.bean.*,org.itsci.ubrswimming.util.*,java.util.*"  %>
    <%@ page import="java.text.SimpleDateFormat,java.util.Calendar,java.util.TimeZone" %>
    
   
    
      <% SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
     		SimpleDateFormat sdf3 = new SimpleDateFormat("hh:mm");
     sdf2.setTimeZone(TimeZone.getTimeZone("GMT+7")); %>
     
     
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
 <%@ include file="header.jsp" %>
 
 <% 
	jameManager jm = new jameManager();
	List<pool_usage> listpu = jm.getListRequestUsePool_memid();
	
	/*ราคารวมมาแสดง*/
	String sumPrice = jm.getSumPrice();
	System.out.println(sumPrice);
	
	
	
	/*รวมจำนวนผู้ใช้*/
	String sumAmount = jm.getSumAmount();
	System.out.println(sumAmount);
	
	
    %>
    	

<div class="container fit" align="center" style="padding-top:25px;" >
    <p style="font-size: 26px; padding-left: 20px; color:#353b48;">สถิติการเข้าใช้งานของผู้ใช้บริการสระว่ายน้ำ
    <table class="table">           
  <table class="table table-striped">
    <thead >
        <tr>
          <th>วันที่</th>
          <th>ประเภท</th>
          <th>จำนวนคน</th>
          <th>ค่าบริการ</th>
          <th>จำนวนเงิน</th>
          <th>เวลา</th>
        </tr>
      </thead>
      <tbody>
      <% for(int i=0 ; i < listpu.size(); i++) { %>
        <tr >
          <td><%= sdf2.format(listpu.get(i).getTime().getTime()) %></td>
   <!-- ค้างไว้ก่อนกำลังคิดปรึกษาอู๋ -->       <td><%= listpu.get(i).getUsage_type() %></td>
          <td><%= listpu.get(i).getAmount() %></td>
          <td><%= listpu.get(i).getPrice() %></td>
          <td><%= listpu.get(i).getPrice() %></td>
          <td><%= sdf3.format(listpu.get(i).getTime().getTime()) %></td>
        </tr>  
           <% }%>
            
       </tbody>
  </table>
  <div class="under"align="right">
        <div> รายได้รวม
          <input type="text" value="<%= sumPrice.toString() %>">
          บาท
       </div>
       <div>
          จำนวนผู้ใช้บริการ
          <input type="text" value="<%= sumAmount.toString() %>">
          คน
      </div>
  </div>
</div>
</body>


<style>
.fit{
  padding: 60px;
}
</style>
</html>