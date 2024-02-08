<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <% SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
    	 sdf2.setTimeZone(TimeZone.getTimeZone("GMT+7")); %>
     
     
    
<!DOCTYPE html>
<html>
<head>
<title>ViewTeachSchedule</title>
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

	
	TrainerManager tn = new TrainerManager();	
	List<RegisterCourses> cou = tn.ViewTeachSchedule();
	
	
	
	String couses_type = "";
	String learn_type = "";
	String learn_time = ""; 
	
	%>	
	
	
	<% for(int i=0 ; i<cou.size(); i++) { %>
	
		<%
		 if(cou.get(i).getCourses_id().getCourses_type().equals("1")) {
			couses_type = "แบบเดี่ยว";
		}else {
			couses_type = "แบบกลุ่ม";
		}%>
		
		
		
		
		<%	if(cou.get(i).getLearn_type().equals("1")) {
				learn_type = "วันจันทร์ - วันศุกร์";
			}else if(cou.get(i).getLearn_type().equals("2")) {
				learn_type = "วันเสาร์ - วันอาทิตย์";	
			}else if(cou.get(i).getLearn_type().equals("3")) {
				learn_type = "ทุกวัน";
		}%>
	
		
		
		<%	if(cou.get(i).getLearn_time().equals("1")) {
			learn_time = "10.00 - 11.00 น.";
		}else if (cou.get(i).getLearn_time().equals("2")){
			learn_time = "11.00 - 12.00 น.";
		}else if (cou.get(i).getLearn_time().equals("3")){
			learn_time = "13.00 - 14.00 น.";
		}else if (cou.get(i).getLearn_time().equals("4")){
			learn_time = "14.00 - 15.00 น.";
		}else if (cou.get(i).getLearn_time().equals("5")){
			learn_time = "15.00 - 16.00 น.";
		}else if (cou.get(i).getLearn_time().equals("6")){
			learn_time = "16.00 - 17.00 น.";
		}%>
			
	<form name="frm" method="post" action="ViewTeachSchedule" class="fit">

	<div class="container fit" align="center" >
          
  	<table class="table table-striped"  border="1px">

        <tr>
          <th>รหัสคอร์สเรียน</th>
          <th>ชื่อคอร์สเรียน</th>
          <th>เรียนแบบเดี่ยว-กลุ่ม</th>
          <th>วันที่เริ่มเรียน</th>
          <th>วันที่ต้องการเรียน</th>
          <th>ช่วงเวลาที่เรียน</th>
          <th>ดูรายละเอียดเพิ่มเติม</th>
        </tr>

        <tr>
          <td align="center"><%= cou.get(i).getCourses_id().getCourses_id() %></td>
   		  <td align="center"><%= cou.get(i).getCourses_id().getCourses_name() %></td>
          <td align="center"><%= couses_type %></td>
          <td align="center"><%= sdf2.format(cou.get(i).getStart_learn().getTime()) %></td>
          <td align="center"><%= learn_type %></td>
          <td align="center"><%= learn_time %></td>
          <td align="center"> <a href="ListCoursesMember"  role="button" style=color:blue; >ดูรายละเอียดเพิ่มเติม</a>  </td>
    
        </tr> 
  </table>
</div>
</form>
<%} %>
</body>


</html>