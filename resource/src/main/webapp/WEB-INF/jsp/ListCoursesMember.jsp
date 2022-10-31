<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="common/header.jsp" %>

	<% TrainerManager tn = new TrainerManager();	
	List<Trainees> tr = tn.ListCoursesMember();
	
	String student_gender = "" ;

	
	%>	
		
		
		<% for(int i=0 ; i<tr.size(); i++) { %>
		
		<%	if(tr.get(i).getStudent_gender() == 1) {
				student_gender = "ชาย";
			}else{
				student_gender = "หญิง";
			}%>
	<div>	
          <table align="center">
          <tr>
            <td colspan="3">
              <div>
                <p style="width: 100%; font-size: 34px; margin: 0;" align="center" class="title"> ดูรายชื่อสมาชิกที่สมัครคอร์สเรียน </p>  
              </div>
            </td>
          </tr>
          <tr>
            <td>รหัสนักเรียนว่ายน้ำ : <%= tr.get(i).getTrainees_id() %></td> 
          </tr>
          <tr>
            <td>เพศ : <%= student_gender %></td> 
         </tr>
       
         <tr>			 	
			<td>ชื่อ : <%= tr.get(i).getName() %></td>
         </tr>
         <tr>
            <td>อายุ : <%= tr.get(i).getAge() %></td>        	
         </tr>
         <tr>
            <td>เบอร์โทร : <%= tr.get(i).getTel() %></td>      	
         </tr>
          </table>		
	</div><br>
	<%} %>
	<%@ include file="common/footer.jsp" %>
</body>
</html>