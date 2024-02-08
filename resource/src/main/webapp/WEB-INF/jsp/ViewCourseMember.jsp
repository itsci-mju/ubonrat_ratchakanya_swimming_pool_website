<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
	<% 
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
     	sdf2.setTimeZone(TimeZone.getTimeZone("GMT+7"));     	
     %>
     
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewCourseMember</title>
</head>
</head>
<!-- CSS only -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
<body>	
<%@ include file="header.jsp" %>


<% 	

	Login l = (Login) session.getAttribute("login");
	String mid = l.getMembers_id();
	String cid = l.getMembers_id();
	String couid =  (String) request.getAttribute("couid");
	
	TrainerManager tr = new TrainerManager();	
	List<Trainees> tra =  tr.SELECT_FUSION_Trainer_test(mid,couid);
	
	

	String learn_time ="";
	String learn_type ="";
	String grouptype = ""; 
	String gender = "";
	String status = "";
	
%>

	<% for(int i=0 ; i<tra.size(); i++) { %>
	
	<%	if(tra.get(i).getRegister_courses().getLearn_time().equals("1")) {
			learn_time = "10.00 - 11.00 น.";
		}else if (tra.get(i).getRegister_courses().getLearn_time().equals("2")){
			learn_time = "11.00 - 12.00 น.";
		}else if (tra.get(i).getRegister_courses().getLearn_time().equals("3")){
			learn_time = "13.00 - 14.00 น.";
		}else if (tra.get(i).getRegister_courses().getLearn_time().equals("4")){
			learn_time = "14.00 - 15.00 น.";
		}else if (tra.get(i).getRegister_courses().getLearn_time().equals("5")){
			learn_time = "15.00 - 16.00 น.";
		}else if (tra.get(i).getRegister_courses().getLearn_time().equals("6")){
			learn_time = "16.00 - 17.00 น.";
		}%>
		
		
		<%	if(tra.get(i).getRegister_courses().getCourses_id().getCourses_type().equals("0")) {
				grouptype = "แบบเดี่ยว";
			}else {
				grouptype = "แบบกลุ่ม";			
		}%>
		
		
		

		<%	if(tra.get(i).getStudent_gender() == 1) {
				gender = "ชาย";
			}else{
				gender = "หญิง";			
		}%>
		
		
		<%	if(tra.get(i).getRegister_courses().getLearn_type().equals("1")) {
				learn_type = "วันจันทร์ - วันศุกร์";
			}else if(tra.get(i).getRegister_courses().getLearn_type().equals("2")) {
				learn_type = "วันเสาร์ - วันอาทิตย์";	
			}else if(tra.get(i).getRegister_courses().getLearn_type().equals("3")) {
				learn_type = "ทุกวัน";
		}%>
		
	
	

	<form name="frm" method="post" action="ViewCourseMember" class="fit">
            <div align="center" style="padding-top:25px;" >
            <p style="font-size: 34px; margin: 5;" align="center" class="title">ดูรายชื่อสมาชิกที่สมัครคอร์สเรียน</p>
            <table>   
            <tr>
            	<td>
            		<div class="form-floating">
                            <input type="text" name="idss" id="idss" class="form-control registered" value="<%= tra.get(i).getRegister_courses().getRegister_courses_id() %>" readonly>
                            <label for="floating"><b>รหัสฟอร์มเรียนว่ายน้ำ</b></label>
                       </div>
            	</td>
             
             	</tr>   
                <tr>
                	<td>
                        <div class="form-floating"> 
                            <input type="text" name="trainees_id" id="trainees_id" class="form-control registered"  value="<%= tra.get(i).getRegister_courses().getMembers().getLogins().getMembers_id() %>"  readonly>           																													
                            <label for="floating" >รหัสของสมาชิก</label>
                        </div>
                    </td>
                    <td>
                        <div class="form-floating"> 
                            <input type="text" name="learn_type" id="learn_type" class="form-control registered"     value="<%= learn_type %>"  readonly>
                            <label for="floating" >วันที่ต้องการเรียน</label>
                        </div>
                    </td>
                    
                </tr>          
                <tr>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="learn_time" id="learn_time" class="form-control registered"   value="<%= learn_time%>" readonly>
                            <label for="floating"><b>ช่วงเวลาที่ต้องการเรียน</b></label>
                          </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="startdate" id="startdate" class="form-control registered"   value="<%= sdf2.format(tra.get(i).getRegister_courses().getStart_learn().getTime()) %>" readonly>
                            <label for="floating"><b>วันที่ต้องการเริ่มเรียน</b></label>
                          </div>
                    </td>
                    
                </tr>
                <tr>                    
                    <td>
                        <div class="form-floating">
                            <input type="text" name="grouptype" id="grouptype" class="form-control registered"   value="<%= grouptype %>"  readonly>
                            <label for="floating"><b>เรียนแบบ</b></label>
                          </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="fullName0" id="fullName0" class="form-control registered"     value="<%= tra.get(i).getName() %>"   readonly>
                            <label for="floating"><b>ชื่อ - นามสกุล</b></label>
                        </div>
                    </td>
                    
                </tr>
                <tr>
               		<td>
                        <div class="form-floating">
                            <input type="text" name="gender" id="gender" class="form-control registered"  value="<%= gender %>" readonly>
                            <label for="floating"><b>เพศ</b></label>
                        </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="age0" id="age0" class="form-control registered"  value="<%= tra.get(i).getAge() %>" readonly>
                            <label for="floating"><b>อายุ</b></label>
                          </div>
                    </td> 
                              
                </tr>
                <tr>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="tel0" id="tel0" class="form-control registered"  value="<%= tra.get(i).getTel() %>" readonly>
                            <label for="floating"><b>เบอร์โทรศัพท์</b></label>
                          </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="cost" id="cost" class="form-control registered" value="<%= tra.get(i).getRegister_courses().getCourses_id().getPrice() %>" readonly>
                            <label for="floating"><b>ราคา</b></label>
                          </div>
                    </td>
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

  #status{
        color:#ff0000;
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