<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="org.itsci.ubrswimming.model.*,org.itsci.ubrswimming.util.*,java.util.*"  %>
    <%@ page import="java.text.SimpleDateFormat,java.util.Calendar,java.util.TimeZone" %>
    <%
    
   
    
    	MemberManager mema = new MemberManager();
    	Login log = new Login();
    	Members mb = new Members();
    	String type = null;
    	try{
    			log = (Login)session.getAttribute("login");
    			mb = new Members();
    			mb = mema.getmember(log.getMembers_id());
    			
    			if(log.getStatus()==2){
    				type = "pool";
    			}else if(log.getStatus()==3){
    				type = "trainer";
    			}else if(log.getStatus()==4){
    				type = "manager";
    			}else{
    				type = "web";
    			}
    	}catch (Exception e) {
    		
    	}
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>สระว่ายน้ำอุบลรัตน์ราชกัญญา</title>
</head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script> 
   	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- css.gg -->
<link href='https://css.gg/css' rel='stylesheet'>

<!-- UNPKG -->
<link href='https://unpkg.com/css.gg/icons/all.css' rel='stylesheet'>

<!-- JSDelivr -->
<link href='https://cdn.jsdelivr.net/npm/css.gg/icons/all.css' rel='stylesheet'>


	<!----> 
		<link rel="stylesheet" href="css/main_style.css">
		<link rel="stylesheet" href="css/original.css">             
	
<body>
<header class="header_page">
        <div class="logo_main">
            <img src="img/mju-logo.png" class="logo_img">
        </div>
        <div class="web_name">
            <p class="wn1">สระว่ายน้ำอุบลรัตน์ราชกัญญา</p>
            <p class="wn2">มหาวิทยาลัยแม่โจ้</p>
        </div>
    </header>
    <% if(log != null){ %>
    <!-- still login -->
    
    
    	<%if(log.getStatus()==0){ %>
    	<!--status 0 -->
        <nav class="nav_bar">
        	<ul>
	            <li><a href="index">หน้าแรก</a></li>
	            <li><a href="show_calendar">ปฏิทิน</a></li>
	            <li><a href="doRegisterCourse?mid=<%= log.getMembers_id() %>">คอร์สเรียน</a></li> 
	           
	                      
	            <li class="dropdown">
		            <i class="gg-user"></i>
		            <%= mb.getFirstname() %><%= mb.getLastname() %>		 
		            <ul class="dropdown-content">
				        <li><a href="view_member_profile" style="color:black;">ข้อมูลส่วนตัว</a></li>	                    		                    
					    <li><a href="dologout" style="color:red;">ออกจากระบบ</a></li>
				    </ul>
				</li>
			</ul>
        </nav>
    
    
    	<%}else if(log.getStatus()==1||log.getStatus()==2){ %>
    	<!--web user -->
        <nav class="nav_bar">
        	<ul>
	            <li><a href="index">หน้าแรก</a></li>
	            <li><a href="show_calendar">ปฏิทิน</a></li>       	                    		                    
				<li><a href="doRegisterCourse?mid=<%= log.getMembers_id() %>">คอร์สเรียน</a></li>	 
				<li><a href="ViewRegisterCourse?mid=<%= log.getMembers_id() %>">ดูรายละเอียดคอร์สเรียน</a></li>	
	            <li><a href="gorequest">แบบฟอร์มขอใช้สระน้ำ</a></li>
	            <li><a href="viewrequesttousepool">ดูแบบฟอร์มสระน้ำ</a></li>        
	                    
	            <li class="dropdown">
		            <i class="gg-user"></i>
		            <%= mb.getFirstname() %> <%= mb.getLastname() %>		 
		            <ul class="dropdown-content">
				        <li><a href="view_member_profile" style="color:black;">ข้อมูลส่วนตัว</a></li>	 
			 			<li><a href="ViewEditMemberProfile?mid=<%= log.getMembers_id() %>" style="color:black;">แก้ไขข้อมูลส่วนตัว</a></li> 	 	   					                   		                    
					    <li><a href="dologout" style="color:red;">ออกจากระบบ</a></li>
				    </ul>
				</li>
			</ul>
        </nav>
        
        
        
		<%}else if(log.getStatus()==3){ %>
		<!-- Trainer -->
    	<nav class="nav_bar">
    	<ul>
        	<li><a href="index">หน้าแรก</a></li>
        	<li><a href="show_calendar">ปฏิทิน</a></li>
        	<li><a href="doRegisterCourse?mid=<%= log.getMembers_id() %>">คอร์สเรียน</a></li>
            <li><a href="ViewTeachSchedule">ดูคอร์สเรียนที่สอน</a></li> 
            <!-- 
            
            <li><a href="ListCoursesMember">ดูรายชื่อสมาชิกคอร์สเรียน</a><br></li>
            <li><a href="Check_Attendees">บันทึกการเข้าเรียนนักเรียน</a><br></li>
            <li><a href="ViewCourseMemberABC?couid=<%= log.getMembers_id() %>">ดูข้อมูลสมาชิก</a><br></li> 
            
            -->
            
        	 <li class="dropdown">
	            <i class="gg-user"></i>
	            <%= mb.getFirstname() %><%= mb.getLastname() %>		 
	            <ul class="dropdown-content">
			        <li><a href="view_member_profile" style="color:black;">ข้อมูลส่วนตัว</a></li>	
    		 		<li><a href="ViewEditMemberProfile?mid=<%= log.getMembers_id() %>" style="color:black;">แก้ไขข้อมูลส่วนตัว</a><li>  	 			                            		                    
				    <li><a href="dologout" style="color:red;">ออกจากระบบ</a></li>
			    </ul>
			</li>
			</ul>
    	</nav>
		<%}else if(log.getStatus()==4){ %>
		<!-- Manager -->
    	<nav class="nav_bar">
    	<ul>
        	<li><a href="index">หน้าแรก</a></li>
        	<li><a href="ListRegisteredMember">ดูรายการสมัครสมาชิกมาใหม่</a><br></li>
    		<li><a href="goRecord_usage">บันทึกการเข้าใช้งาน</a></li> 	  	
        	<li><a href="show_calendar">ปฏิทิน</a></li>
        	<li><a href="ViewRegisteredCourse">ดูรายชื่อสมาชิกที่สมัครคอร์สเรียน</a><br></li>
            <li><a href="gomanageform">จัดการแบบฟอร์มขอใช้สระน้ำ</a></li>
            <li><a href="make_event">สร้างกิจกรรมของสระว่ายน้ำ</a></li>
        	<li><a href="ReportPoolUsageStatistics">สถิติการเข้าสระว่ายน้ำ</a></li>
        	 <li class="dropdown">
	            <i class="gg-user"></i>
	            <%= mb.getFirstname() %><%= mb.getLastname() %>		 
	            <ul class="dropdown-content">
			        <li><a href="view_member_profile" style="color:black;">ข้อมูลส่วนตัว</a></li>	  
    		 		<li><a href="ViewEditMemberProfile?mid=<%= log.getMembers_id() %>" style="color:black;">แก้ไขข้อมูลส่วนตัว</a></li>	 	             		                    
				    <li><a href="dologout" style="color:red;">ออกจากระบบ></a></li>
			    </ul>
			</li>
        	</ul>
    	</nav>
		<% }else{ %>
		<!-- not login  -->
    	<nav class="nav_bar">
    	<ul>
        	<li><a href="index">หน้าแรก</a></li>
        	<li><a href="#">คอร์สเรียน</a></li>      	
        	 <li class="dropdown">
	            <i class="gg-user"></i>
	            <%= mb.getFirstname() %><%= mb.getLastname() %>		 
	            <ul class="dropdown-content">
			        <li><a href="goViewprofile" style="color:black;">ข้อมูลส่วนตัว</a></li>	                    		                    
				    <li><a href="dologout" style="color:red;">ออกจากระบบ<i class="gg-log-out"></i></a></li>
			    </ul>
			</li>
			</ul>
    	</nav>
		<%} %>
		
		<!-- 
			อันนี้คือไม่เอารูป
			<div id="profile_pos" class="profile_<%= type %>">
        	<div class="profile_circle">
            	<img src="img/<%= mb.getImage() %>"  class="pimg">
        	</div>
        	 -->
        	
    	</div>
	<%}else{ %>
	<!-- not login -->
		<div class="login_btn">
        	<a href="loginpage" style="color:black;">
            	เข้าสู่ระบบ
        	</a>
    	</div>
    	<div class="regis_btn">
        	<a href="pre_reg" style="color:black;">
           		สมัครสมาชิก
        	</a>
    	</div> 
    
    <!-- not login  -->
    	<nav class="nav_bar">
    		<ul>
	        	<li><a href="index">หน้าแรก</a></li>
        	</ul>
    	</nav>
    <%} %>
</body>

<style>
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
.gg-user{
	margin:5px;
	margin-top:-1px;
}
.gg-log-out{
	margin-top:-20px;
	margin-left:100px;
}
.nav_bar ul li{
    text-decoration: none;
    display: flex;
    margin-right: 10px;
    float: left;
}

.nav_bar a{
    float: right;

}
a{
    text-decoration: none;
}
a:hover{
  text-decoration: none;
  color: white;
}

.dropbtn {
  background-color: #b3edb9;
  color: white;
  margin-top: 13px;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

.dropdown {
  position: relative;
  display: inline-block;
  color: white;
  width: 0px;
  
}

ul .dropdown-content {
  display: none;
  position: absolute; 
  background-color: #b3edb9;
  min-width: 160px;
  border-radius: 4px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
  margin-top: 25px;
}

.dropdown-content a {
  color: rgb(255, 255, 255);
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

ul .dropdown-content a:hover {
    background-color: #b3edb9; 
}

.dropdown:hover .dropdown-content {
  	display: block;
    border-radius: 4px;
}

.dropdown:hover .dropbtn {
  background-color: #00ae3b;

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
</style>
</html>