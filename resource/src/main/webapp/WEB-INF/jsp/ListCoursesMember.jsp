<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListCoursesMember</title>
</head>

<!-- CSS only -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>


<body>
<%@ include file="header.jsp" %>

	<% 	
	/*String mid = request.getParameter("mid");*/
	Login l = (Login) session.getAttribute("login");
	String mid = l.getMembers_id();
	String cid = l.getMembers_id();
	
	TrainerManager tn = new TrainerManager();	
	List<Trainees> tra = tn.SELECT_FUSION_Trainer(mid);
	

	
	String student_gender = "" ;

	
	%>	
		
		
		<% for(int i=0 ; i<tra.size(); i++) { %>
		
		<%	if(tra.get(i).getStudent_gender() == 1) {
				student_gender = "ชาย";
			}else{
				student_gender = "หญิง";
			}%>
		

       
	<form name="frm" method="post" action="ListCoursesMember" class="fit">
            <div align="center" style="padding-top:25px;" >
            <p style="font-size: 34px; margin: 5;" align="center" class="title"> ดูรายชื่อสมาชิกที่สมัครคอร์สเรียน </p>
            <table>   
            <tr>
            	<td>
            		 <div class="form-floating">
                           <input type="text" name="idss" id="idss" class="form-control registered" value="<%= tra.get(i).getRegister_courses().getRegister_courses_id() %>" readonly>
                           <label for="floating"><b>รหัสนักเรียนว่ายน้ำ</b></label>
                     </div>
            	</td>
            	<td>
                     <div class="form-floating"> 
                            <input type="text" name="name" id="name" class="form-control registered"   value="<%= tra.get(i).getName() %>"  readonly>                      																													
                           <label for="floating" >ชื่อ</label>
                     </div>
                 </td>
             </tr>   
                 
                 <tr>
                
                    <td>
                        <div class="form-floating"> 
                            <input type="text" name="learn_count" id="learn_count" class="form-control registered"   value="<%= tra.get(i).getRegister_courses().getLearn_count() %>"  readonly>             																													
                            <label for="floating" >เรียนไปทั้งหมดกี่ครั้ง</label>
                        </div>
                    </td>
                     <td>
                        <div class="form-floating"> 
                            <input type="text" name="missclass" id="missclass" class="form-control registered"   value="<%= tra.get(i).getRegister_courses().getMiss_class() %>"  readonly>             																													
                            <label for="floating" >ขาดเรียนทั้งหมดกี่ครั้ง</label>
                        </div>
                    </td>
                 <tr>
	                      <td>
	                        	 <a href="Check_Attendees?cid=<%= tra.get(i).getRegister_courses().getRegister_courses_id() %>  
	                        	 				&&cname=<%= tra.get(i).getName() %>
	                        	 				&&learncount=<%= tra.get(i).getRegister_courses().getLearn_count() %>  
	                        	 				&&missclass=<%= tra.get(i).getRegister_courses().getMiss_class() %> 
	                        	 		 "	
	                        	 				  
	                        	 				
	                        	 				class="btn btn-success" role="button">บันทึกการเข้าเรียน</a>
	                      </td>      
	                      
	                      
	                      <td>
	                        	 <a href="ViewCourseMemberABC?couid=<%= tra.get(i).getRegister_courses().getRegister_courses_id() %> " 
	                        	 			    class="btn btn-warning" role="button">ดูสมาชิกที่สมัครคอร์สเรียนว่ายน้ำ</a>
	                      </td>
	                                     
                     </tr>               
                </tr> 
                
             
                
            </table>
         </div>
     </form>
                        
	
	<%} %>
</body>
<style>
 
 
 	html{
		background-color: rgb(255 255 255);
	}
	
	.button {
		  background-color: #00CCFF;
		  border: none;
		  color: white;
		  padding: 16px 32px;
		  text-align: center;
		  font-size: 16px;
		  margin: 4px 2px;
		  opacity: 0.6;
		  transition: 0.3s;
		  display: inline-block;
		  text-decoration: none;
		  cursor: pointer;
}	
 	
*{
   margin: 0;
   padding: 0;
   box-sizing: border-box;
   font-family: 'Kanit', sans-serif;
}

 
/*-------------------------*//* Body font */


@import url('https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css');

.fit {
  background-color: #B2EBF2;
    border-radius: 10px;
    margin-left: 420px;
    margin-right: 460px;
    margin-top: 15px;
    margin-bottom: 100px;
    padding: 57px;
    padding-top: 30px;
    display: flex;
    justify-items: center;
}


.form-control{
  margin: 5px;

}
td{
  padding:5px;
}
 </style>
</html>