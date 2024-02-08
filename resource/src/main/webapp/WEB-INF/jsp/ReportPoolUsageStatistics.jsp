<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="org.itsci.ubrswimming.model.*,org.itsci.ubrswimming.util.*,java.util.*"  %>
    <%@ page import="java.text.SimpleDateFormat,java.util.Calendar,java.util.TimeZone" %>
    
   
    
    
     
     
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Reportpoolusagestatistics</title>
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
 	ReportPoolUsageStatisticsManager rp = new ReportPoolUsageStatisticsManager();
	List<PoolUsage> pu = rp.getReportPoolUsageStatistics();
	
	//จำนวนสมาชิกสระว่ายน้ำมาแสดง
	String sumMembers_id = rp.getMembers_id();
	System.out.println(sumMembers_id);
	
	
	//จำนวนบุคคลทั่วไปสระว่ายน้ำมาแสดง
	String sumGeneral = rp.getGeneral();
	System.out.println(sumGeneral);
	
	//ราคารวมมาแสดง
	String sumPrice = rp.getSumPrice();
	System.out.println(sumPrice);
	
	
	//จำนวนผู้ชายที่ใช้บริการ
	String SumGender_men = rp.getSumGender_men();
	System.out.println(SumGender_men);
	
	
	//จำนวนผู้หญิงที่ใช้บริการ
	String SumGender_gel = rp.getGender_gel();
	System.out.println(SumGender_gel);
	
    %>
    	

<div class="container fit" align="center" style="padding-top:25px;" >
    <p style="width: 100%; font-size: 34px; margin: 0;" align="center" class="title">สถิติการเข้าใช้งานของผู้ใช้บริการสระว่ายน้ำ</p>
    <table class="table" >           
  <table class="table table-striped"  border="1px">
    <thead >
        <tr>
          <th>รหัสสมาชิกที่เข้าใช้สระ</th>
          <th>จำนวนบุคคลทั่วไปที่เข้าใช้สระ</th>
          <th>ชาย</th>
          <th>หญิง</th>
          <th>เด็ก</th>
          <th>ผู้ใหญ่</th>
          <th>จำนวนเงิน</th>
        
        </tr>
      </thead>
      <tbody>
      <% for(int i=0 ; i < pu.size(); i++) { %>
        <tr >
   		  <td><%= pu.get(i).getMembers().getLogins().getMembers_id() %></td>
          <td><%= pu.get(i).getGender_men() + pu.get(i).getGender_gel()  %></td>
          <td><%= pu.get(i).getGender_men() %></td>
          <td><%= pu.get(i).getGender_gel() %></td>
          <td><%= pu.get(i).getChild() %></td>
          <td><%= pu.get(i).getAdult() %></td>
     	  <td><%= pu.get(i).getPrice() %></td>
        </tr>  
           <% }%>
            
       </tbody>
  </table>
  <div class="under"align="right">
  
  
  
        <div>
          จำนวนสมาชิกที่เข้าใช้สระทั้งหมด :  
          <input type="text" value="<%= sumMembers_id.toString() %>" readonly> 
          คน           
      </div>
      
       <div>
          จำนวนบุคคลทั่วไปที่เข้าใช้สระทั้งหมด :  
          <input type="text" value="<%= sumGeneral.toString() %>" readonly> 
          คน           
      </div>
      
       <div>
          จำนวนผู้ชายที่เข้าใช้บริการสระทั้งหมด :  
          <input type="text" value="<%= SumGender_men.toString() %>" readonly> 
          คน           
      </div>
       <div>
          จำนวนผู้หญิงที่เข้าใช้บริการสระทั้งหมด :  
          <input type="text" value="<%= SumGender_gel.toString() %>" readonly> 
          คน           
      </div>
       <div> 
       	   จำนวนเงินทั้งหมดรวมทั้งหมด : 
          <input type="text" value="<%= sumPrice.toString() %>"readonly>
          บาท
       </div>
       
       
  </div>
</div>
</body>


<style>
.fit{
  padding: 60px;
}


.form-control{
  width: 150px;

}

</style>
</html>