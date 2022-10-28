<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewTeachSchedule</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<% TrainerManager tn = new TrainerManager();	
	List<Courses> cou = tn.ViewTeachSchedule();
	
	
	String couses_type ="";
	
%>	
	
	
	<% for(int i=0 ; i<cou.size(); i++) { %>
	
	<%	if(cou.get(i).getCourses_type().equals("0")) {
			couses_type = "แบบกลุ่ม";
		}else{
			couses_type = "แบบเดี่ยว";
		}%>
	
	<div>	
          <table align="center">
          <tr>
            <td colspan="3">
              <div>
                <p style="width: 100%; font-size: 34px; margin: 0;" align="center" class="title"> ดูคอร์สเรียนที่ครูสอนว่ายน้ำเป็นผู้สอน </p>  
              </div>
            </td>
          </tr>
          <tr>
             <td>รหัสคอร์สเรียน : <%= cou.get(i).getCourses_id() %></td>   	
          </tr>
          <tr>
             <td>ประเภทคอร์สเรียน : <%= couses_type %></td>   	
         </tr>
          <tr>
            <td>ชื่อคอร์สเรียนเรียน : <%= cou.get(i).getCourses_name() %></td>        	
         </tr>
         <tr>			 	
			 <td>คำอธิบาย : <%= cou.get(i).getDescription() %></td>
         </tr>
         <tr>
             <td>จำนวนครั้งสูงสุดต่อคอร์ส : <%= cou.get(i).getMax_day() %></td>       	
         </tr>
         <tr>
             <td>ราคา : <%= cou.get(i).getPrice() %></td>      	
         </tr>
          </table>		
	</div><br>
	<%} %>
</body>
</html>