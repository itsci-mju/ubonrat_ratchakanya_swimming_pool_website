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
<!-- CSS only -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>

<body>

<%@ include file="header.jsp" %>

      <% 
   	requestManager rqm = new requestManager();
    List <pool_reservations>  pr = rqm.getListRequestUsePool_memid(log.getMembers_id());
    
   %>
   
   
   <% for(int i=0 ; i<pr.size(); i++) { %>
   
   
    <div class="content-request">
        <form action="getRequestToUse" method="post" name="frm" class="fit">
          <table>
            <tr>
              <td colspan="3">
                <div>
                  <p style="width: 100%; font-size: 34px; margin: 0;" align="center" class="title"> ดูกิจกรรมสระว่ายน้ำ </p>  <br>
              </div>
              </td>
            </tr>
            <tr>
            <!-- เหมือนต้อง login เข้ามาก่อนถึงจะเห็นการแสดงผล -->
              <td colspan="2">
                <div class="request_input">
                  <input type="text" name="mid" id="mid" hidden="true" readonly value="<%= mb.getLogins().getMembers_id() %>">
              </div>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <div class="form__group field" style="float: left;">
                  <label for="eventname" class="form__label">ชื่อกิจกรรม</label><br>
                  <input type="text" class="form__field" placeholder="ชื่อกิจกรรม" value="<%= pr.get(i).getEvent_name() %>" style="width: 250px;" readonly><br>
              </div>           
              <td>
                <div class="form__group field" style="float: left;">
                <label for="startdate" class="form__label">วันที่เริ่มใช้</label><br>
                  <input type="text" class="form__field" placeholder="วันที่เริ่มใช้" value="<%= sdf2.format(pr.get(i).getStart_time().getTime())%>" style="width: 250px;" readonly ><br>
              </div>
              </td>              
            </tr>
            
            <tr>
              <td colspan="2">
                <div class="request_input">   
                <label  class="form__label">รายละเอียด</label> <br>               
                  <input type="text" class="form__field" placeholder="รายละเอียด" value="<%= pr.get(i).getDetail()%>" style="width: 250px;" readonly ><br>
              </div>
              </td>           
              <td>
                <div class="form__group field" style="float: left;">
               	  <label  class="form__label">วันที่สิ้นสุดการใช้</label> <br> 
                  <input type="text" class="form__field" placeholder="วันที่สิ้นสุดการใช้" value="<%= sdf2.format(pr.get(i).getEnd_time().getTime())%>" style="width: 250px;" readonly >               
              </div>
              </td>              
            </tr>
               
            <% }%>
          </table>
        </form>
    </div>
  
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