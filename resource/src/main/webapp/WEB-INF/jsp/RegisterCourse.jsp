<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.itsci.ubrswimming.model.*,org.itsci.ubrswimming.util.*,java.util.*"  %>
 <%
	ArrayList<String> datesel = new ArrayList<String>();
	if(session.getAttribute("datesel")!=null){
		for(String s:(List<String>)session.getAttribute("datesel")){
			datesel.add(s);
		}
	}
	
	String dt = (String)request.getAttribute("daytype_cookie");
	String lt = (String)request.getAttribute("learntime_cookie");
	Cookie[] ck = request.getCookies();
	for (int i = 0;i<ck.length;i++){
		System.out.println("name:"+ck[i].getName()+"\n value:"+ck[i].getValue());
	}
	

	String mid = request.getParameter("mid");
		
%> 
	
	
<html>
<head>
<link rel="stylesheet" href="css/original.css">
<link rel="stylesheet" href="css/register.css">
<meta charset="UTF-8">
<title>RegisterCourse</title>
</head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<link rel="stylesheet" href="css/original.css">
<link rel="stylesheet" href="css/main_style.css">
<link rel="stylesheet" href="css/courses.css">

<body>
  <%@ include file="header.jsp" %>
  <div class="course-content">
    <p style="font-size: 26px; margin: auto;" align="center">แบบฟอร์มสมัครเรียนว่ายน้ำ </p>
    <div class="section_area">
      <!-- ******************************************* DAY SELLECT ********************************************************-->
      <form action="insertRegisterCourse?mid=<%= mid %>" name="frm2" method="post">
        <div id="daysch">
          <div class="daytype-div custom-select">
            <select name="learn_type" id="learn_type">
              <option value="" selected disabled hidden required>วันที่ต้องการเรียน</option>
              <option value="1">วันจันทร์ - วันศุกร์</option>
              <option value="2">วันเสาร์ - วันอาทิตย์</option>
              <option value="3">ทุกวัน</option>
            </select>
          </div>
          <div class="learntime-div custom-select">
            <select name="learn_time" id="learn_time">
              <option value="" selected disabled hidden required>ช่วงเวลาที่ต้องการเรียน</option>
              <option value="1">10.00 - 11.00 น.</option>
              <option value="2">11.00 - 12.00 น.</option>
              <option value="3">13.00 - 14.00 น.</option>
              <option value="4">14.00 - 15.00 น.</option>
              <option value="5">15.00 - 16.00 น.</option>
              <option value="6">16.00 - 17.00 น.</option>
            </select>
          </div>
          
             <div class="form__group field" style="float: left;">
                  <input type="date" class="form__field" placeholder="วันที่ต้องการเริ่มเรียน" name="startdate" id='startdate' required style="width: 150px;" onblur="checkStartdate(frm2)">
                  <label for="startdate"  class="form__label">วันที่ต้องการเริ่มเรียน</label>
                  <label class="alert-label" id="alertStartdate"></label>
              </div>
         
          <!--<div class="date-req-div custom-select">
            <select name="datereq" id="datereq">
              <option value="" selected disabled hidden required>วันที่ต้องการเริ่มเรียน</option>
             <% if(datesel!=null){
                for(String d:datesel){ %>
            <option value="<%= d %>"><%= d %></option>
           <%}} %> 
            </select>
          </div>-->
          
          <!--<div class="button-area">
            		<button type="submit" value="Submit"><i class="bi bi-search"></i>หา</button>
          		</div> -->
         	
          <!-- <input type="submit" value="หา"> -->
        </div>
        
       
      	<!--<div class="hidden">
          <input type="text" name="daytype2" id="daytype2" <% if(dt != null){  %>value="<%= dt %>" <%} %>>
          <input type="text" name="learntime2" id="learntime2" <% if(lt != null){  %>value="<%= lt %>" <%} %>>
          <input type="text" name="datereq2" id="datereq2" >
        </div> --> 
         
        <div class="gty-div">
   
            <div class="grouptype-div">
		        <div>แบบ</div>
			        <input type="radio" name="grouptype" id="g-one" value="2500" class="typeselec" onclick="myFunction(this.value); single();" checked>
			        <label for="g-one" class="radio"><span class="radiocheckmark" > </span><i class="bi bi-person-fill"></i><span>แบบเดี่ยว</span></label>
			        <input type="radio" name="grouptype" id="g-group" value="1500" class="typeselec" onclick="myFunction(this.value); group();">
			        <label for="g-group" class="radio"><span class="radiocheckmark" > </span><i class="bi bi-people-fill"></i><span>แบบกลุ่ม</span></label>
        	</div>
        <div class="name-div">
          <table id="cregis">
            <thead>
              <tr>
                <th class="numb-head">#</th>
                <th class="name-head">ชื่อ - นามสกุล</th>
                <th class="sex-head">เพศ</th>
                <th class="age-head">อายุ</th>
                <th class="tel-head">เบอร์โทรศัพท์</th>
                <th class="del">ลบ</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td><span id="Numb0">1</span></td>
                <td><input type="text" name="fullName0" id="fullName0" placeholder="ชื่อ - นามสกุล"> </td>
                <td>
                  <div class="custom-select">
                    <select name="gender0" id="gender0" class="sononmem">
                      <option value="" selected disabled hidden required>เพศ</option>
                      <option value="1">ชาย</option>
                      <option value="0">หญิง</option>
                    </select>
                  </div>
                </td>
                <td><input type="number" name="age0" id="age0" min="1" step="1"></td>
                <td><input type="text" name="tel0" id="tel0" placeholder="เบอร์โทรศัพท์"></td>
                <td><label class="checkbox"><input type="checkbox"><span class="checkmark"></span></label></td>
              </tr>
            </tbody>
            <tfoot>
              <tr id="buttonaddrow" hidden>
                <td colspan="5">
                  <button type="button" id="add-row-trainee" class="add-row" tabindex="0" onclick="addrow()">
                    <i class="bi bi-plus-lg"></i>
                    <span>เพิ่ม</span>
                  </button>
                </td>
                <td>
                  <button type="button" id="del-row-trainee" class="del-row" tabindex="0" >
                  <i class="bi bi-trash3"></i></button>
                      
                </td>
              </tr>
            </tfoot>
          </table>
        </div>
        <div>
          <label for="cost">ราคา :</label>
          <input type="text" name="cost" id="cost" value="2500" readonly>       
        </div><br>
          
        
        <div class="button-area">
          <input type="submit" value="ยืนยัน">
          <input type="reset" value="ยกเลิก">
        </div>
      
        
      </form>
      <hr>
      <!-- ******************************************* Form Detail ********************************************************-->
     
    </div>
  </div>
</body>


<script src="js/fc_regis_course.js"></script> 
<script>
	
	// วันที่ต้องการเริ่มเรียน//
	function checkStartdate(frm){
	    const  today = new Date;
	    today.setHours(0,0,0,0);
	    alertStartdate = document.getElementById("startdate");

	    const  date = new Date(frm2.startdate.value)
	    if(frm2.startdate.value==""){
	    	alertStartdate.innerText="กรุณากรอก วัน/เดือน/ปี";
	    	alertStartdate.style.color= "#ff5252";
	    }
	    else if(date < today) {
	    	alertStartdate.innerText="วันที่ต้องการเริ่มเรียนต้องไม่ใช่วันในอดีต";
	        frm2.startdate.value= ""
	        alertStartdate.style.color= "#ff5252";
	    }
	    else{
	    	alertStartdate.innerText="สามารถใช้วันที่ต้องการเริ่มเรียนนี้ได้";
	    	alertStartdate.style.color= "#4CAF50";
	    }
	}
	
	function myFunction(grouptype) {
		  document.getElementById("cost").value = grouptype;
		}
	
	
	function single() {
		  document.getElementById("buttonaddrow").hidden = true;
		  var tableSize = $("#cregis tbody tr").length;
		  for (let i = 0; i<tableSize; i++){
			 
				  $("#cregis tbody tr").remove();
		 
			  createNewInput2($("#cregis tbody"), 0)
			  count_trainee = 0;
		  }
		}
	
	
	function group() {
		  document.getElementById("buttonaddrow").hidden = false;	  
		}
 
	
	function addrow() {
		 var tableSize = $("#cregis tbody tr").length;
		 document.getElementById("cost").value = 1500*(tableSize+1);  
		}
	
	
	
	function delrow() {
		 tableSize = $("#cregis tbody tr").length;
		 document.getElementById("cost").value = 1500*(tableSize+1); 
		 console.log(tableSize)
		}
	
</script>






<style>
   .hiden{
    display: none;
   }
  
   
   /* Body font */
@import url('https://fonts.googleapis.com/css2?family=Kanit:wght@300&display=swap');

@import url("bootstrap-icons-1.8.3/bootstrap-icons.css");

/* width */
::-webkit-scrollbar {
    width: 10px;
  }
  
  /* Track */
  ::-webkit-scrollbar-track {
    background:transparent; 
  }
   
  /* Handle */
  ::-webkit-scrollbar-thumb {
    background: #4fc3f7; 
  }
  
  /* Handle on hover */
  ::-webkit-scrollbar-thumb:hover {
    background: #01579B; 
  }

*{
  font-family: 'Kanit', sans-serif;
}

body{
    font-family: 'Kanit', sans-serif;
    font-size: 18px;
    margin: 0;
}

#nonselect{
    -webkit-user-select: none;  /* Chrome all / Safari all */
    -moz-user-select: none;     /* Firefox all */
    -ms-user-select: none;      /* IE 10+ */
    user-select: none;          /* Likely future */ 
}
.canselect{
    -webkit-user-select: text;  /* Chrome all / Safari all */
    -moz-user-select: text;     /* Firefox all */
    -ms-user-select: text;      /* IE 10+ */
    user-select: text;          /* Likely future */ 
}

a{
    text-decoration:none;
}


[type="button"]:not(:disabled), [type="reset"]:not(:disabled), [type="submit"]:not(:disabled), button:not(:disabled) {
  cursor: pointer;
}

[type="file"]:not(:disabled){
  cursor: pointer;
}


#footer, .nav_bar, .header_page {
  display: flex;
  justify-content: center;
}

a:active, a:hover, a:visited {
  color: white;
}

html {
  color: #0277BD;
  background-color: rgb(0, 0, 0);
}

[class*=-content] {
  padding: 20px;
}

/* --------------------- Header --------------------------*/
.content-head {
  display: block !important;
  overflow-x: hidden;
  z-index: 1;
}

.header_page {
  order: 1;
  margin: 0;
  padding: 5px;
  width: 100%;
  max-width: 100%;
  max-height: 100px;
  background-color: rgb(255, 255, 255);
  transition: 0.7s ease;
}

.logo_main {
  margin: 10px;
  width: -webkit-fit-content;
  width: -moz-fit-content;
  width: fit-content;
  float: left;
}
.logo_main img {
  height: 70px;
  transition: 0.5s ease;
}

.web_name {
  margin-top: 10px;
}
.web_name p {
  margin: 0;
}
.web_name p.hp-1 {
  color: #0277BD; /* do not change now */
  font-size: 24px;
}
.web_name p.hp-2 {
  color: #0277BD; /* do not change now */
  font-size: 20px;
}

/* --------------------- nav bar--------------------------------*/
.nav_bar {
  position: -webkit-sticky;
  position: sticky;
  order: 2;
  top: 0;
  width: 100%;
  background-color: #4fc3f7;
  white-space: nowrap;
}
.nav_bar div {
  display: flex;
}
.nav_bar a {
  font-size: 20px;
  margin: 3px 10px 0px 10px;
  border: 0;
  border-bottom: 4px solid transparent;
  list-style-type: none;
  transition: 0.3s ease;
  color: white;
}
.nav_bar hr {
  display: none;
}

.ham-bar {
  display: none;
}

.content-head {
  display: flex;
}

.closebtn {
  display: none;
}

#profile_pos {
  display: block !important;
  position: fixed;
  top: 45px;
  right: 30px;
  padding: 2px;
  border-radius: 90px;
  background-color: #4fc3f7;
  float: right;
  width: 50px;
  height: 50px;
  overflow: hidden;
  transition: 0.5s ease;
}
#profile_pos .circle_prof {
  border-radius: 90px;
  width: 50px !important;
  height: 50px !important;
  max-width: 60px;
  max-height: 60px;
  background-color: transparent;
  overflow: hidden;
  float: left;
}
#profile_pos .circle_prof img {
  height: 50px !important;
}
#profile_pos .user-name {
  margin-top: 2px;
  margin-bottom: 0;
  padding-left: 5px;
  padding-right: 3px;
  width: 190px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  color: white;
}
#profile_pos .logout {
  float: left;
}
#profile_pos .logout a {
  margin: 0;
  padding: 0;
  font-size: 14px;
  padding-left: 5px;
  color: white;
}

#profile_pos:hover {
  width: 250px;
}

[class*=profile-] {
  border: solid 3px;
  border-top-color: #4fc3f7;
  border-right-color: #4fc3f7;
  border-left-color: #4fc3f7;
  transition: 0.3s ease;
}

[class*=profile-]:hover {
  border: solid 3px;
  border-top-color: #4fc3f7;
  border-right-color: #4fc3f7;
  border-bottom-color: #4fc3f7;
}

.profile-manager {
  border-bottom-color: #ab47bc;
}

.profile-manager:hover {
  border-left-color: #ab47bc;
}

.profile-trainer {
  border-bottom-color: #99ff33;
}

.profile-trainer:hover {
  border-left-color: #99ff33;
}

.profile-pool {
  border-bottom-color: #ffb300;
}

.profile-pool:hover {
  border-left-color: #ffb300;
}

.profile-web {
  border-bottom-color: #4fc3f7;
}

.profile-web:hover {
  border-left-color: #4fc3f7;
}

/*----------------- dropdown ------------------*/
.nav-dropdown [type=button] {
  color: white;
  background-color: transparent;
  width: -webkit-fit-content;
  width: -moz-fit-content;
  width: fit-content;
  border: 0;
  font-size: 20px;
  margin: 3px 10px 0px 10px;
  border-bottom: 4px solid transparent;
  transition: 0.3s ease;
}
.nav-dropdown [type=button]:hover {
  color: white;
}
.nav-dropdown ul.dropdown-menu {
  z-index: 1;
  position: absolute;
  top: 45px;
  margin-left: -30px;
  display: none;
  overflow: hidden;
  list-style-type: none;
  margin-top: -3px;
  transition: 0.3s ease;
  border-radius: 3px;
}
.nav-dropdown ul.dropdown-menu li {
  min-width: 200px;
  padding: 5px;
  text-decoration: none;
  transition: 0.3s ease;
  background-color: white;
}
.nav-dropdown ul.dropdown-menu li a {
  margin: 2px 0 5px 30px;
  color: #01579B;
  font-size: 22px;
}
.nav-dropdown ul.dropdown-menu li:hover {
  background-color: #ddd;
}

/*----------------- phone ------------------*/
@media only screen and (max-width: 700px) {
  [class*=-content] {
    margin-top: 90px;
  }
  .header_page {
    position: fixed;
    top: 0;
    justify-content: left;
  }
  .header_page .logo_main img {
    height: 55px;
  }
  .header_page .web_name [class*=hp-] {
    font-size: 18px;
  }
  .ham-bar {
    position: fixed;
    top: 0;
    right: 0;
    background-color: #0277BD;
    color: rgb(255, 255, 255);
    width: -webkit-max-content;
    width: -moz-max-content;
    width: max-content;
    padding: 10px;
    font-size: 2.5rem;
    display: block;
    transition: 0.5s ease;
  }
  .nav_bar {
    display: flex;
    flex-wrap: wrap;
    justify-content: left;
    height: 100%; /* 100% Full-height */
    width: 0; /* 0 width - change this with JavaScript */
    max-width: 450px;
    position: fixed;
    z-index: 1; /* Stay on top */
    top: 0;
    right: 0;
    background-color: #111; /* Black*/
    overflow: scroll !important;
    overflow-x: hidden !important; /* Disable horizontal scroll */
    padding-top: 20px; /* Place content 60px from the top */
    transition: 0.5s; /* 0.5 second transition effect to slide in the sidenav */
  }
  .nav_bar div {
    display: block;
  }
  .nav_bar hr {
    display: block;
    margin-top: 50px;
    color: transparent;
  }
  .nav_bar div.nav-element {
    order: 2;
    margin-top: 50px;
  }
  .nav_bar div.nav-element a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #0277BD;
    display: block;
    transition: 0.3s;
  }
  .nav_bar div.nav-element a:hover {
    color: white;
  }
  .nav_bar div.nav-close-div {
    order: 0;
  }
  .nav_bar div.nav-close-div .closebtn {
    padding-left: 20px;
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
  }
  .nav_bar div.nav-close-div .closebtn:hover {
    font-size: 48px;
  }
  .nav_bar div.nav-close-div a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #0277BD;
    display: block;
  }
  .nav_bar div.nav-close-div a:hover {
    color: white;
  }
  .nav_bar .closebtn {
    padding-left: 20px;
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
  }
  .nav_bar .closebtn:hover {
    font-size: 48px;
  }
  .nav_bar #profile_pos {
    order: 1;
    position: relative;
    padding: 5px;
    margin: auto;
    border-radius: 5px;
    background-color: #4fc3f7;
    width: 80%;
    height: 60px;
    overflow: hidden;
    transition: 0.5s ease;
  }
  .nav_bar #profile_pos .circle_prof {
    margin-top: 5px;
    border-radius: 90px;
    width: 50px;
    height: 50px;
    max-width: 60px;
    max-height: 60px;
    background-color: transparent;
    overflow: hidden;
    float: left;
  }
  .nav_bar #profile_pos .circle_prof img {
    height: 50px;
  }
  .nav_bar #profile_pos .user-name {
    margin-top: 2px;
    margin-bottom: 0;
    padding-left: 5px;
    padding-right: 3px;
    width: 190px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    color: white;
  }
  .nav_bar #profile_pos .logout {
    float: left;
  }
  .nav_bar #profile_pos .logout a {
    margin: 0;
    padding: 0;
    font-size: 14px;
    padding-left: 5px;
    color: white;
  }
  .nav_bar [class*=profile-] {
    border-bottom-color: #4fc3f7;
  }
  .nav_bar .profile-manager {
    border-left-color: #ab47bc;
  }
  .nav_bar .profile-trainer {
    border-left-color: #99ff33;
  }
  .nav_bar .profile-pool {
    border-left-color: #ffb300;
  }
  .nav_bar .profile-web {
    border-left-color: #4fc3f7;
  }
  .nav-dropdown [type=button] {
    margin: 8px 8px 8px 32px;
    padding-left: 10px;
    font-size: 25px;
    color: #0277BD;
    display: block;
    background-color: transparent;
    width: -webkit-fit-content;
    width: -moz-fit-content;
    width: fit-content;
    border: 0;
  }
  .nav-dropdown [type=button]:hover {
    color: white;
  }
  .nav-dropdown ul.dropdown-menu {
    z-index: 1;
    position: relative !important;
    display: none;
    overflow: hidden;
    list-style-type: none;
    margin-top: -3px;
    transition: 0.3s ease;
    margin: 0;
    top: 0;
  }
  .nav-dropdown ul.dropdown-menu li {
    text-decoration: none;
    transition: 0.3s ease;
    background-color: transparent;
  }
  .nav-dropdown ul.dropdown-menu li a {
    margin: 2px 0 5px 30px;
    padding: 0;
    color: #01579B;
    font-size: 18px;
  }
  .nav-dropdown ul.dropdown-menu li:hover {
    background-color: rgba(221, 221, 221, 0.089);
  }
}
.show {
  display: block !important;
}

/* --------------------- footer --------------------------------*/
#footer {
  height: 100px;
  width: 100%;
  background-color: #01579B;
  color: white;
}

.ftter {
  height: 100px;
  width: 100%;
  margin-top: 15px;
  height: -webkit-fit-content;
  height: -moz-fit-content;
  height: fit-content;
}

/* mouse over link */
/* selected link *//*# sourceMappingURL=main_style.css.map */



body {
  background: #d5d5d5;
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center;
}

.isHidden {
  display: none;
  /* hide radio buttons */
}

hr {
  text-align: center;
  width: 80%;
  background: rgb(204, 204, 204) none repeat scroll 0% 0%;
  border: 0px none;
  height: 1px;
}

table {
  width: 100%;
}

thead tr th {
  text-align: left;
  border-bottom: 1px solid rgb(237, 235, 233);
  border-collapse: separate;
  border-spacing: 5px 5px;
}

th.del {
  width: 8%;
  min-width: 28px;
  text-align: center;
}

th.number {
  width: 25%;
}

td:nth-last-child {
  text-align: center;
}

th.sex-head {
  width: 10%;
}

th.age-head {
  width: 8%;
}

th.tel-head {
  width: 20%;
}

input[type="text"],
input[type="number"],
select,
.select-selected {
  font-family: 'Kanit', sans-serif;
  font-size: medium;
  margin: 0;
  padding: 0 8px;
  /* box-sizing:border-box; */
  border-radius: 4px;
  border: 0;
  color: rgb(50, 49, 48);
  width: calc(100% - 20px);
  min-width: 30px;
  text-overflow: ellipsis;
  outline: #8a8886 solid 1px;
  background: transparent;
  height: 3em;
  /* box-shadow: 0 0 1px 1px #e3e3e3; */
}

select {
  margin-right: 1px;
  width: calc(100% - 2px);
}

/* Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

/* Firefox */
input[type=number] {
  -moz-appearance: textfield;
  text-align: right;
}

input[type="text"]:focus,
input[type="number"]:focus,
select:focus,
.select-selected:focus {
  outline: #0078d4 solid 2px;
}

/* select:focus {
  margin-right: 0px;
  width: 100%;
} */

input::placeholder {
  color: #605e5c;
  opacity: 1;
}


input[type="reset"],
input[type="button"],
input[type="submit"],
button[type="submit"] {
  outline: transparent none medium;
  position: relative;
  font-family: 'Kanit', sans-serif;
  font-size: medium;
  box-sizing: border-box;
  border: 1px solid #8a8886;
  display: inline-block;
  text-decoration: none;
  text-align: center;
  cursor: pointer;
  padding: 0px 16px;
  border-radius: 4px;
  min-width: 80px;
  height: 32px;
  background-color: rgb(255, 255, 255);
  color: rgb(50, 49, 48);
  user-select: none;
}

input[type="reset"]:hover {
  background-color: rgb(243, 242, 241);
  color: rgb(32, 31, 30);
}

input[type="reset"]:active {
  background-color: rgb(237, 235, 233);
  color: rgb(32, 31, 30);
}

input[type="submit"],
button[type="submit"] {
  border: 1px solid #0078d4;
  background-color: #0078d4;
  color: rgb(255, 255, 255);
}

input[type="submit"]:hover,
button[type="submit"]:hover {
  background-color: #106ebe;
  border: 1px solid #106ebe;
  color: rgb(255, 255, 255);
}

input[type="submit"]:active,
button[type="submit"]:active {
  background-color: #005a9e;
  border: 1px solid #005a9e;
  color: rgb(255, 255, 255);
}


input[type="submit"]:focus,
button[type="submit"]:focus {
  /* box-shadow: 0 0 1px 0 #0078d4; */
  outline: 1px solid #FFF;
  outline-offset: -4px;
  /* box-shadow:inset 0px 0px 0px 2px #fff; */
}

input[type="reset"]:focus,
input[type="button"]:focus {
  outline: 1px solid #0078d4;
  outline-offset: -4px;
}


.checkbox {
  display: block;
  position: relative;
  cursor: pointer;
  user-select: none;
}

.checkbox input {
  /* position: absolute; */
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}


.checkmark {
  position: absolute;
  top: 0;
  left: 20%;
  height: 25px;
  width: 25px;
  border: 1px solid #8a8886;
  /* outline: #8a8886 solid 1px ; */
  border-radius: 4px;
  transition-property: background, border-color;
  transition-duration: 200ms;
  transition-timing-function: cubic-bezier(0.4, 0, 0.23, 1);
}

.checkbox input:focus~.checkmark {
  border: 1px solid #0078d4;
  /* box-shadow: 0 0 1px 0 #0078d4; */
  outline: #0078d4 solid 1px;
}

.checkbox input:checked~.checkmark {
  background-color: #0078d4;
  border: 1px solid #0078d4;
}

.checkbox input:focus:checked~.checkmark {
  background-color: #0078d4;
  border: 1px solid #0078d4;
}

.checkbox:hover input:checked~.checkmark {
  background-color: #005a9e;
  border: 1px solid #005a9e;
}

.checkbox:hover input:focus:checked~.checkmark {
  background-color: #005a9e;
  border: 1px solid #005a9e;
  outline: #005a9e solid 1px;
}

.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}

.checkbox input:checked~.checkmark:after {
  display: block;
}

.checkbox:hover input~.checkmark:after {
  display: block;
  border: solid rgb(96, 94, 92);
  border-width: 0 2px 2px 0;
}


.checkbox:hover input:checked~.checkmark:after {
  display: block;
  border: solid white;
  border-width: 0 2px 2px 0;
}

.checkbox .checkmark:after {
  left: 9px;
  top: 5px;
  width: 5px;
  height: 10px;
  border: solid white;
  border-width: 0 2px 2px 0;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
}


/* Customize the label (the container) */
.radio {
  display: inline-block;
  position: relative;
  padding: 10px 30px;
  cursor: pointer;
  background: #f3f2f1;
  min-width: 100px;
  /* min-height: 100px; */
  text-align: center;
}

.typeselec:checked+.radio {
  background: #f3f2f1;
  outline: 1px solid #0078d4;
}

.typeselec:focus+.radio {
  outline: 2px solid #0078d4;
}

.typeselec:hover+.radio {
  outline: 1px solid #005a9e;
}

.typeselec:hover:focus+.radio {
  outline: 2px solid #005a9e;
}

/* Create a custom radio button */
.radio .radiocheckmark {
  position: absolute;
  top: 10px;
  left: 8px;
  height: 20px;
  width: 20px;
  background-color: #fff;
  border-radius: 50%;
}

/* Style the indicator (dot/circle) */
.radio .radiocheckmark::before {
  top: 5px;
  left: 5px;
  width: 10px;
  height: 10px;
  border-radius: 50%;
  background: transparent;
  content: "";
  position: absolute;
  display: block;
}

.typeselec:checked+.radio .radiocheckmark {
  outline: 1px solid #0078d4;
}

.typeselec:focus+.radio .radiocheckmark,
.typeselec:hover+.radio .radiocheckmark {
  outline: 1px solid #005a9e;
}

.typeselec:checked+.radio .radiocheckmark::before,
.typeselec:focus+.radio .radiocheckmark::before {
  background: #0078d4;
}

.typeselec:checked:hover+.radio .radiocheckmark::before {
  background: #005a9e;
}

.typeselec+.radio i {
  font-size: 50px;
}

.typeselec:checked+.radio i,
.typeselec:focus+.radio i {
  color: #0078d4;
}

.typeselec:checked+.radio i {
  color: #005a9e;
}

.typeselec+.radio span:last-child{
  display: block;
}

.add-row,
.del-row {
  font-family: 'Kanit', sans-serif;
  font-size: medium;
  padding: 15px 0px;
  width: 100%;
  text-align: left;
  border: 0;
  cursor: pointer;
  background: transparent;
}

.add-row:hover {
  background: rgb(243, 242, 241);
}

.add-row:active {
  background: rgb(237, 235, 233);
}

.add-row:disabled {
  color: #a19f9d;
  background: #f3f2f1;
  cursor: default;
}

.add-row:disabled i {
  color: #a19f9d;
}

.add-row i {
  color: #0078d4;
}


.add-rowspan {
  font-size: medium;
}

.del-row {
  text-align: center;
  padding: 15px 0px;
  cursor: pointer;
  color: #d83b01;
}

.del-row:hover {
  color: white;
  background: #d83b01;
  cursor: pointer;
}

.del-row:active {
  color: white;
  background: #a80000;
  cursor: pointer;
}


/* ----------- dropdown ----------- */
.custom-select {
  position: relative;
  font-family: 'Kanit', sans-serif;
}

.select-selected {
  cursor: pointer;
  display: block;
  display: flex;
  align-items: center;
}

/*style the arrow inside the select element:*/
.select-selected:after {
  position: absolute;
  content: "";
  top: 10px;
  right: 14px;
  width: 10px;
  height: 10px;
  border: 0px solid rgb(96, 94, 92);
  border-width: 0 2px 2px 0;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
}

/*point the arrow upwards when the select box is open (active):*/
.select-selected.select-arrow-active:after {
  top: 18px;
  border-width: 2px 0 0 2px;
}

/*style the items (options), including the selected item:*/
.select-items div {
  padding: 8px 16px;
  border: 1px solid transparent;
  border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
  cursor: pointer;
  user-select: none;
}

/*style items (options):*/
.select-items {
  position: absolute;
  background-color: #fafafa;
  top: 110%;
  left: 0;
  right: 0;
  z-index: 99;

  font-family: 'Kanit', sans-serif;
  box-sizing: border-box;
  border-radius: 8px;
  /* box-shadow: rgba(0, 0, 0, 0.133) 0px 3.2px 7.2px 0px, rgba(0, 0, 0, 0.11) 0px 0.6px 1.8px 0px; */
  box-shadow: 0 0 17.9px rgba(0, 0, 0, .066), 0 0 33.4px rgba(0, 0, 0, .079), 0 100px 80px rgba(0, 0, 0, .11);
  outline: transparent none medium;
  width: 100%;
  transition: top cubic-bezier(0.1, 0.9, 0.2, 1) 200ms;

  display: flex;
  flex-direction: column;
  gap: 2px;
}

/*hide the items when the select box is closed:*/
.select-hide {
  display: none;
}

.select-hide2 {
  top: 100%;
}

.select-items botton {
  padding: 10px 20px;
  cursor: pointer;
}

.select-items botton:hover,
.same-as-selected {
  background-color: rgb(243, 242, 241);
}

.same-as-selected::before {
  content: "";
  position: absolute;
  left: 0.4rem;
  height: 1.5rem;
  width: 0.2rem;
  background: #0078d4;
  display: block;
  border-radius: 2px;
}

.select-items botton:active {
  background-color: rgb(237, 235, 233);
}

.select-items botton:first-child {
  border-radius: 8px 8px 0 0;
}

.select-items botton:last-child {
  border-radius: 0 0 8px 8px;
}

.course-content {
  margin: 0 auto 25px;
  width: 790px;
  background: #f4f3f3;
  border-radius: 8px;
  box-shadow: 0 1.6px 3.6px 0 rgba(0, 0, 0, .132), 0 .3px .9px 0 rgba(0, 0, 0, .108);
  z-index: 0;
  position: relative;
  top: 5vh;
}

.content-record-head {
  display: flex;
  position: relative;
  justify-content: center;
  margin: 0 0 -1px;
  position: relative;
  padding-top: 20px;
}

.botton_usetype {
  cursor: pointer;
  display: inline-block;
  padding: 10px;
  border-color: #cccccc #cccccc currentcolor;
  border-style: solid solid none;
  border-width: 1px 1px medium;
  border-radius: 4px 4px 0 0;
  padding: 3px 12px;
  margin-left: -1px;
  background: #faf9f8;
}

.typeselec {
  opacity: 0;
  height: 0;
  width: 0;
  margin: -2px;
  padding: 0;
  border: 0;
}

.typeselec:checked+.botton_usetype {
  /* background: white; */
  z-index: 2;
  background: white;
}

.typeselec:focus+.botton_usetype {
  border-color: #0078d4 #0078d4 currentcolor;
  outline: 1px solid #0078d4;
}

.section_area {
  position: relative;
  z-index: 1;
  background: white;
  padding: 20px;
  border-color: rgb(204, 204, 204);
  border-style: solid;
  border-width: 1px 0 0 0;
  border-radius: 0 0 8px 8px;
  /* background-image: url(ii.webp); */
  background-position: right;
  animation-name: MOVE-BG;
  animation-duration: 600ms;
  animation-timing-function: linear;
  animation-iteration-count: infinite;
  animation-direction: alternate;
}

@keyframes MOVE-BG {
  from {
    background-position: left;
  }

  to {
    background-position: right;
  }
}

#subbox {
  display: flex;
  justify-content: flex-end;
  gap: 20px;
  padding: 20px 0;
}

.button-area {
  display: flex;
  justify-content: flex-end;
  gap: 20px;
  padding: 20px 0;
}

@keyframes alert-card {
  from {
    background-color: #a80000;
  }

  to {
    background-color: #ff8080;
  }
}

#content-alert {
  color: white;
  display: none;
  background: #a80000;
  padding: 8px;
  font-size: small;
  animation: alert-card 250ms linear 4 alternate;
}

.gty-div {
  display: flex;
  flex-direction: column;
  gap: 5px;
  padding: 2em 0;
}

#daysch{
  display: flex;
  flex-direction: column;
  gap: 5px;
}

@media(max-width: 767px) {
  .course-content {
    width: 95%;
    min-width: 340px;
  }
}
</style>
</html>