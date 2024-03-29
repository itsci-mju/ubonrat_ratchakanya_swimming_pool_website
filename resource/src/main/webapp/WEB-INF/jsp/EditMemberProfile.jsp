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
<title>EditMemberProfile</title>
</head>

<!-- CSS only -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>


<body>

<%@ include file="header.jsp" %>

<%	
		
     	String address = mb.getAddress();
     	String[] parts = address.split("_");
     	
     	String mid = request.getParameter("mid");

     	
   %>
      
      	
	<form name="frm" method="POST" action="EditMemberProfile?mid=<%= mid %>" class="fit">
            <div align="center" style="padding-top:25px;" >
            <p style="font-size: 34px; margin: 5;" align="center" class="title">แก้ไขข้อมูลส่วนตัว </p>
            <table>      
                <tr>
                    <td colspan="2" style="text-align: left; display:none;">
                        <div class="form-floating"> 
                            <input type="text" name="id" class="form-control registered" placeholder="id"  value="<%= mb.getLogins().getMembers_id() %>" Onblur="form(frm)" >
                            <label for="floating" >id</label>
                        </div>
                    </td>
                </tr>          
                <tr>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="fname" id="fname" class="form-control registered" placeholder="ชื่อ" Onblur="form(frm)" value="<%= mb.getFirstname() %>" >
                            <label for="floating"><b>ชื่อ</b></label>
                          </div>
                    </td>
                    <td>
                        <div class="form-floating">
                            <input type="text" name="lname" id="lname" class="form-control registered" placeholder="นามสกุล" Onblur="form(frm)" value="<%= mb.getLastname() %>" >
                            <label for="floating"><b>นามสกุล</b></label>
                         </div>
                    </td>
                </tr>
                <tr>                    
                    <td>
                        <div class="form-floating">
                            <input type="text" name="housenumber" id="housenumber" class="form-control registered"   placeholder="บ้านเลขที่" Onblur="form(frm)" value="<%= parts[0] %>"   >
                            <label for="floating"><b>ที่อยู่</b></label>
                        </div>
                    </td>
                     <td>
                        <div class="form-floating">
                            <input type="text" name="sub_area" id="sub_area" class="form-control registered" placeholder="ตำบล" value="<%= parts[1] %>"  Onblur="form(frm)">
                            <label for="floating"><b>ตำบล</b></label>
                        </div>
                    </td>
                </tr>
                <tr>              
                    <td>
                        <div class="form-floating">
                            <input type="text" name="area" id="area" class="form-control registered" placeholder="อำเภอ" value="<%= parts[2] %>"  Onblur="form(frm)">
                            <label for="floating"><b>อำเภอ</b></label>
                          </div>
                    </td>   
                    <td>
                        <div class="form-floating">
                            <input type="text" name="province" id="province" class="form-control registered" placeholder="จังหวัด" value="<%= parts[3] %>"  Onblur="form(frm)">
                            <label for="floating"><b>จังหวัด</b></label>
                          </div>
                    </td>        
                </tr>
                <tr>                    
                    <td>
                        <div class="form-floating">
                            <input type="text" name="zipcode" id="zipcode" class="form-control registered" placeholder="รหัสไปรษณีย์" value="<%= parts[4] %>"  Onblur="form(frm)">
                            <label for="floating"><b>รหัสไปรษณีย์</b></label>
                          </div>
                    </td>
                    <td>
                        <div class="form-floating">
                        <input type="text" name="tel" id="tel" class="form-control registered" placeholder="โทรศัพท์"  Onblur="form(frm)" maxlength="10" value="<%= mb.getPhone() %>">
                        <label for="floating"><b>โทรศัพท์</b></label>
                        </div>
                    </td> 
                </tr> 
                <tr>
                	<td>
		                <input type="submit" value="Submit" class="button1">
		                <input type="reset" value="Reset" class="button2">    
		            </td>
		        </tr>        
            </table>
        </div>			
      </form>
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

.button1 {
  background-color: #008000;
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


.button2 {
  background-color: #ff0000;
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
 </style>



</html>