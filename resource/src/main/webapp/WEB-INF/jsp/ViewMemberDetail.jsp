<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="org.itsci.ubrswimming.model.*,org.itsci.ubrswimming.util.*,java.util.*"  %>
    <%@ page import="java.text.SimpleDateFormat,java.util.Calendar,java.util.TimeZone" %>
    
    
 
    	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewMemberDetail</title>
</head>

<!-- CSS only -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
 

<body>

<%@ include file="header.jsp" %>


		

<%	
		//dateforme
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
		sdf2.setTimeZone(TimeZone.getTimeZone("GMT+7"));
		//Birthdate
		String Birthdate = sdf2.format(mb.getBirthdate().getTime());  

		String address = mb.getAddress();
		String[] parts = address.split("_");

     	ListRegisteredMemberManager rsm = new ListRegisteredMemberManager();	
    	List<Members> mbs =  rsm.getListRegisteredMember();
    	
    	

   
   		String type_name = "" ;

	
	%>	
		
		
		 <% for(int i=0 ; i<mbs.size(); i++) { %>
		
		<%	if(mbs.get(i).getMember_type() == 0) {
				type_name = "ลูกค้าทั่วไปที่ไม่ได้เป็นสมาชิก";
			}else{
				type_name = "สมาชิกสระว่ายน้ำ";
			}%>
			
			
     
      
      
      	
	<form name="frm" method="post" action="ViewMemberDetail" class="fit">
            <div align="center" style="padding-top:25px;" >
            <p style="font-size: 34px; margin: 5;" align="center" class="title">ดูข้อมูลเพิ่มเติม</p>
            <table>      
                <tr>          
                    <td>
                        <div class="form-floating">
                            <input type="text" name="Tname" id="Tname" class="form-control registered" placeholder="ประเภทผู้ใช้" Onblur="form(frm)" 
                            
                            	 style="color:  
                                     
                                     <% if(type_name.equals("ลูกค้าทั่วไปที่ไม่ได้เป็นสมาชิก")) { %> red 
                                     <% }else if (type_name.equals("สมาชิกสระว่ายน้ำ")) { %> green                                     
                                     <% }%>;"
                                          
                            value="<%= type_name %>" readonly>
                            <label for="floating"><b>ประเภทผู้ใช้</b></label>
                          </div>
                    </td>
                </tr>          
                
                <tr>  
                 	<td>
                        <div class="form-floating">
                            <input type="text" name="fname" id="fname" class="form-control registered" placeholder="ชื่อ" Onblur="form(frm)" value="<%= mbs.get(i).getFirstname() %>" readonly>
                            <label for="floating"><b>ชื่อ</b></label>
                          </div>
                    </td>
                	<td>
                        <div class="form-floating">
                            <input type="text" name="lname" id="lname" class="form-control registered" placeholder="นามสกุล" Onblur="form(frm)" value="<%= mbs.get(i).getLastname() %>" readonly>
                            <label for="floating"><b>นามสกุล</b></label>
                          </div>
                    </td>        
                </tr>
                <tr>
                	
            		<td>
                        <div class="form-floating">
                            <input type="text" name="gmail" id="gmail" class="form-control registered" placeholder="อีเมล" Onblur="form(frm)" value="<%= mbs.get(i).getLogins().getEmail() %>"  readonly>
                            <label for="floating"><b>อีเมล</b></label>
                          </div>
                    </td>    
                    <td>
                        <div class="form-floating">
                            <input type="text" name="birthday" id="birthday" class="form-control registered" placeholder="วันเกิด" Onblur="form(frm)" value="<%= Birthdate %>"  readonly>
                            <label for="floating"><b>วันเกิด</b></label>
                          </div>
                    </td>          
                </tr>
                <tr>
               		 <td>
                        <div class="form-floating">
                            <input type="text" name="housenumber" id="housenumber" class="form-control registered"   placeholder="บ้านเลขที่" Onblur="form(frm)" value="<%= parts[0] %>"   readonly>
                            <label for="floating"><b>ที่อยู่</b></label>
                        </div>
                    </td>
               		<td>
                        <div class="form-floating">
                            <input type="text" name="sub_area" id="sub_area" class="form-control registered" placeholder="ตำบล" value="<%= parts[1] %>" readonly Onblur="form(frm)">
                            <label for="floating"><b>ตำบล</b></label>
                        </div>
                    </td>
                              
                </tr>
                <tr>
                	 <td>
                        <div class="form-floating">
                            <input type="text" name="area" id="area" class="form-control registered" placeholder="อำเภอ" value="<%= parts[2] %>" readonly Onblur="form(frm)">
                            <label for="floating"><b>อำเภอ</b></label>
                          </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="province" id="province" class="form-control registered" placeholder="จังหวัด" value="<%= parts[3] %>" readonly Onblur="form(frm)">
                            <label for="floating"><b>จังหวัด</b></label>
                          </div>
                    </td>
                    
                </tr>
                <tr>
                	<td>
                        <div class="form-floating">
                            <input type="text" name="zipcode" id="zipcode" class="form-control registered" placeholder="รหัสไปรษณีย์" value="<%= parts[4] %>" readonly Onblur="form(frm)">
                            <label for="floating"><b>รหัสไปรษณีย์</b></label>
                          </div>
                    </td>
                    <td>
                        <div class="form-floating">
                        <input type="text" name="tel" id="tel" class="form-control registered" placeholder="โทรศัพท์" readonly Onblur="form(frm)" maxlength="10" value="<%= mb.getPhone() %>">
                        <label for="floating"><b>โทรศัพท์</b></label>
                        </div>
                    </td> 
                   
                </tr>
                
               <tr>
               	 <td class="accept"> 
                        <a href="acceptViewMemberDetail?id=<%= mbs.get(i).getLogins().getMembers_id() %>" style="color:blue;">อนุมัติ</a>
                    </td>
                    <td class="decline">
                        <a href="deleteViewMemberDetail?id=<%= mbs.get(i).getLogins().getMembers_id() %>" style="color:red;">ไม่อนุมัติ</a>
                    </td>
               </tr>
               
           

            </table>
        </div>			
        </form>
         <%} %>
</body>


<link rel="stylesheet" href="css/nav.css">
<link href="https://fonts.googleapis.com/css?family=Kanit" rel="stylesheet"/>
 <style>
 	
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