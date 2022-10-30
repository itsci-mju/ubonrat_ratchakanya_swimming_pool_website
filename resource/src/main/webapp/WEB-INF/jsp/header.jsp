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
<link rel="stylesheet" href="css/main_style.css">
<link rel="stylesheet" href="css/original.css">
<body id="nonselect">
	<div class="content-head">
        <header class="header_page">
            <div class="logo_main">
                <img src="img/mju-logo.png">
            </div>
            <div class="web_name">
                <p class="hp-1">สระว่ายน้ำอุบลรัตน์ราชกัญญา</p>
                <p class="hp-2">มหาวิทยาลัยแม่โจ้</p>
            </div>
        </header>
        <div class="ham-bar">
            <i class="bi bi-list" onclick="openNav() "></i>
        </div>
    </div>
    <div id="mySidenav" class="nav_bar">
        <div class="nav-close-div">
            <!--ห้ามลบ-->
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a> 
        </div>
        <% if(log!=null){ %>
        <!-- still login -->
    		<%if(log.getStatus()==1||log.getStatus()==2){ %>
    	<!-- web user -->
        	<div class="nav-element">
    			<a href="index">หน้าแรก</a>
    			<div class="nav-dropdown">
                	<button data-toggle="dropdown" type="button" class="dropdown-btn">
                    คอร์สเรียน
                    	<i class="bi bi-caret-down-fill" style="font-size: 16px;"></i>
                	</button>
                	<ul class="dropdown-menu">
                    	<li><a href="#">คอร์สเรียนของฉัน</a></li>
                    	<li><a href="gocourse_register">สมัครคอร์สเรียน</a></li>
                	</ul>
            	</div>
            	<a href="#">ปฏิทิน</a>
            	<div class="nav-dropdown">
                	<button data-toggle="dropdown" type="button" class="dropdown-btn">
                    	แบบฟอร์ม
                    	<i class="bi bi-caret-down-fill" style="font-size: 16px;"></i>
                	</button>
                	<ul class="dropdown-menu">
                    	<li><a href="gocourse_register">ขอเข้าใช้งานสระน้ำ</a></li>
                    	<li><a href="#">ประวัติคำร้องขอ</a></li>
                	</ul>
            	</div>
        		<a href="#">บุคลากร</a>
        		<a href="#">ติดต่อเรา</a>
   			</div>
		<%}else if(log.getStatus()==3){ %>
		<!-- Trainer -->
			<div class="nav-element">
    			<a href="index">หน้าแรก</a>
    			<div class="nav-dropdown">
                	<button data-toggle="dropdown" type="button" class="dropdown-btn">
                    คอร์สเรียน
                    	<i class="bi bi-caret-down-fill" style="font-size: 16px;"></i>
                	</button>
                	<ul class="dropdown-menu">
                    	<li><a href="#">ตารางสอน</a></li>
                    	<li><a href="#">คอร์สเรียนที่ได้รับมอบหมาย</a></li>
                	</ul>
            	</div>
            	<a href="#">ปฏิทิน</a>
            	<div class="nav-dropdown">
                	<button data-toggle="dropdown" type="button" class="dropdown-btn">
                    	แบบฟอร์ม
                    	<i class="bi bi-caret-down-fill" style="font-size: 16px;"></i>
                	</button>
                	<ul class="dropdown-menu">
                    	<li><a href="gocourse_register">ขอเข้าใช้งานสระน้ำ</a></li>
                    	<li><a href="#">ประวัติคำร้องขอ</a></li>
                	</ul>
            	</div>
        		<a href="#">บุคลากร</a>
        		<a href="#">ติดต่อเรา</a>
   		</div>
		<%}else if(log.getStatus()==4){ %>
		<!-- Manager -->
		<div class="nav-element">
    			<a href="index">หน้าแรก</a>
    			<a href="goRecord_usage">บันทึกการเข้าใช้งาน</a>
    			<a href="#">ปฏิทิน</a>
    			<a href="#">จัดการคอร์สเรียน</a>
            	<a href="#">จัดการสมาชิก</a>
            	<div class="nav-dropdown">
                	<button data-toggle="dropdown" type="button" class="dropdown-btn">
                    	แบบฟอร์ม
                    	<i class="bi bi-caret-down-fill" style="font-size: 16px;"></i>
                	</button>
                	<ul class="dropdown-menu">
                    	<li><a href="gomanageform">จัดการแบบฟอร์ม</a></li>
                    	<li><a href="#">สร้างกิจกรรม</a></li>
                	</ul>
            	</div>
        		<a href="#">สถิติ</a>
   		</div> 
    	<% } %>
        <div id="profile_pos" class="profile-pool">
            <div class="circle_prof">
            	<img src="img/<%= mb.getImage() %>">
            </div>
            <div class="user-name">
                <%= mb.getFirstname() %>
            </div>
            <div class="logout">
                <a href="#" id="logout">Log out</a>
            </div>
        </div>
        <%}else{ %>
    	<!-- not login  -->
    		<div class="nav-element">
    			<a href="index">หน้าแรก</a>
    			<a href="#">คอร์สเรียน</a>
        		<a href="#">บุคลากร</a>
        		<a href="#">ติดต่อเรา</a>
    			<a href="loginpage">เข้าสู่ระบบ</a>
    			<a href="pre_reg">สมัครสมาชิก</a>
   			</div>
    <%} %>
        <hr><!-- ตัวปิด nav ให้ overflow ไม่ทับตัวสุดท้าย -->
    </div>

</body>
<script>
    function openNav() {
      document.getElementById("mySidenav").style.width = "100%";
    }
    
    function closeNav() {
      document.getElementById("mySidenav").style.width = "0";
    }

window.addEventListener('resize', function(event) {
    if(window.innerWidth>700){
        openNav()
    }else{
        closeNav()
    }
}, true);


function showdropdown(a) {
    a.parentNode.getElementsByClassName('dropdown-menu')[0].classList.add("show");
}
function closedropdown(){
    var i;
        var dropdowns = document.getElementsByClassName("dropdown-menu");
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
}

window.onclick = function(event) {
    if(!event.target.matches('.dropdown-btn')){
        console.log("hmmm")
        closedropdown()
    }else if(event.target.matches('.dropdown-btn')&&(event.target.parentNode.getElementsByClassName('dropdown-menu')[0].classList.contains('show'))){
        closedropdown()
    }
    else{
        showdropdown(event.target)
    }
} 
</script>
<script>
const logout = document.getElementById("logout")
const response = "ต้องการออกจากระบบหรือไม่?";
logout.addEventListener("click",(click)=>{
    // window.confirm(response)
    if (window.confirm(response)) {
window.open("dologout", "_self");
}
});
</script>
</html>