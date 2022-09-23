<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="bean.*,util.*,java.util.*"  %>
    <%@ page import="java.text.SimpleDateFormat,java.util.Calendar,java.util.TimeZone" %>
    <%
    	memberManager mema = new memberManager();
    	logins log = new logins();
    	members mb = new members();
    	String type = null;
    	try{
    			log = (logins)session.getAttribute("login");
    			mb = new members();
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
    	<%if(log.getStatus()==1||log.getStatus()==2){ %>
    	<!--web user -->
        <nav class="nav_bar">
            <span><a href="index">หน้าแรก</a></span>
            <span><a href="#">ปฏิทิน</a></span>
            <span><a href="#">คอร์สเรียน</a></span>
            <span><a href="gorequest">แบบฟอร์ม</a></span>
            <span><a href="#">บุคลากร</a></span>
            <span><a href="#">ติดต่อเรา</a></span>
        </nav>
		<%}else if(log.getStatus()==3){ %>
		<!-- Trainer -->
    	<nav class="nav_bar">
        	<span><a href="index">หน้าแรก</a></span>
        	<span><a href="#">ปฏิทิน</a></span>
        	<span><a href="#">คอร์สเรียน</a></span>
        	<span><a href="#">บุคลากร</a></span>
        	<span><a href="#">ติดต่อเรา</a></span>
    	</nav>
		<%}else if(log.getStatus()==4){ %>
		<!-- Manager -->
    	<nav class="nav_bar">
        	<span><a href="index">หน้าแรก</a></span>
        	<span><a href="goRecord_usage">บันทึกการเข้าใช้งาน</a></span>
        	<span><a href="#">ปฏิทิน</a></span>
        	<span><a href="#">จัดการคอร์สเรียน</a></span>
        	<span><a href="#">จัดการสมาชิก</a></span>
            <span><a href="gomanageform">จัดการแบบฟอร์ม</a></span>
        	<span><a href="#">สถิติ</a></span>
    	</nav>
		<% }else{ %>
		<!-- not login  -->
    	<nav class="nav_bar">
        	<span><a href="index">หน้าแรก</a></span>
        	<span><a href="#">คอร์สเรียน</a></span>
        	<span><a href="#">ปฏิทิน</a></span>
        	<span><a href="#">บุคลากร</a></span>
        	<span><a href="#">ติดต่อเรา</a></span>
    	</nav>
		<%} %>
		<div id="profile_pos" class="profile_<%= type %>">
        	<div class="profile_circle">
            	<img src="img/<%= mb.getImage() %>"  class="pimg">
        	</div>
        	<div class="profile_name"><%= mb.getFirstname() %></div>
        	<div class="logout">
            	<a href="dologout">Log out</a>
        	</div>
    	</div>
	<%}else{ %>
	<!-- not login -->
		<div class="login_btn">
        	<a href="loginpage">
            	เข้าสู่ระบบ
        	</a>
    	</div>
    	<div class="regis_btn">
        	<a href="pre_reg">
           		สมัครสมาชิก
        	</a>
    	</div> 
    
    <!-- not login  -->
    	<nav class="nav_bar">
        	<span><a href="index">หน้าแรก</a></span>
        	<span><a href="#">คอร์สเรียน</a></span>
        	<span><a href="#">บุคลากร</a></span>
        	<span><a href="#">ติดต่อเรา</a></span>
    	</nav>
    <%} %>
 

</body>
</html>