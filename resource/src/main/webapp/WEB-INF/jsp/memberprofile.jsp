<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="bean.*,util.*,java.util.*"  %>
    <%@ page import="java.text.SimpleDateFormat,java.util.Calendar,java.util.TimeZone" %>
    
 
    	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberprofile</title>
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
		String Birthdate= sdf2.format(mb.getBirthdate().getTime());  
		
		
     	String address = mb.getAddress();
     	String[] parts = address.split("_");
    	
   %>
      
      	
	<form name="frm" method="post" action="goedit" class="fit">
            <div align="center" style="padding-top:25px;" >
            <p style="font-size: 26px; padding-left: 20px; color:#353b48;">ข้อมูลส่วนตัว
            <table>      
                <tr>
                    <td colspan="2" style="text-align: left; display:none;">
                        <div class="form-floating"> 
                            <input type="text" name="id" class="form-control registered" placeholder="id"  value="<%= mb.getLogins().getMembers_id() %>" Onblur="form(frm)" readonly>
                            <label for="floating">id</label>
                        </div>
                    </td>
                </tr>          
                <tr>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="fname" id="fname" class="form-control registered" placeholder="ชื่อ" Onblur="form(frm)" value="<%= mb.getFirstname() %>" readonly>
                            <label for="floating">ชื่อ</label>
                          </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="lname" id="lname" class="form-control registered" placeholder="นามสกุล" Onblur="form(frm)" value="<%= mb.getLastname() %>" readonly>
                            <label for="floating">นามสกุล</label>
                          </div>
                    </td>
                </tr>
                <tr>                    
                    <td>
                        <div class="form-floating">
                            <input type="text" name="birthday" id="birthday" class="form-control registered" placeholder="วันเกิด" Onblur="form(frm)" value="<%= Birthdate %>"  readonly>
                            <label for="floating">วันเกิด</label>
                          </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="housenumber" id="housenumber" class="form-control registered"   placeholder="บ้านเลขที่" Onblur="form(frm)" value="<%= parts[0] %>"   readonly>
                            <label for="floating">ที่อยู่</label>
                        </div>
                    </td>
                </tr>
                <tr>
               <td>
                        <div class="form-floating">
                            <input type="text" name="sub_area" id="sub_area" class="form-control registered" placeholder="ตำบล" value="<%= parts[1] %>" readonly Onblur="form(frm)">
                            <label for="floating">ตำบล</label>
                        </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="area" id="area" class="form-control registered" placeholder="อำเภอ" value="<%= parts[2] %>" readonly Onblur="form(frm)">
                            <label for="floating">อำเภอ</label>
                          </div>
                    </td>           
                </tr>
                <tr>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="province" id="province" class="form-control registered" placeholder="จังหวัด" value="<%= parts[3] %>" readonly Onblur="form(frm)">
                            <label for="floating">จังหวัด</label>
                          </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="zipcode" id="zipcode" class="form-control registered" placeholder="รหัสไปรษณีย์" value="<%= parts[4] %>" readonly Onblur="form(frm)">
                            <label for="floating">รหัสไปรษณีย์</label>
                          </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="form-floating">
                        <input type="text" name="tel" id="tel" class="form-control registered" placeholder="โทรศัพท์" readonly Onblur="form(frm)" maxlength="10" value="<%= mb.getPhone() %>">
                        <label for="floating">โทรศัพท์</label>
                        </div>
                    </td> 
                </tr>

            </table>
        </div>			
        </form>
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