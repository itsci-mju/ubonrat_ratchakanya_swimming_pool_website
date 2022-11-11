<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>สระว่ายน้ำอุบลรัตน์ราชกัญญา</title>
</head>
<link rel="stylesheet" href="css/main_style.css">
<link rel="stylesheet" href="css/original.css">
<style>
	.nav_bar {
		z-index: 800;
	}

	.dropdown-menu {
		z-index: 800;
	}
</style>

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
		<div class="nav-element">
			<a href="index">หน้าแรก</a>
		</div>

		<security:authorize access="isAuthenticated()">
			<!-- still login -->
			<security:authorize access="hasRole('web') || hasRole('pool')">
				<!-- web user -->
				<div class="nav-element">
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
							<li><a href="gorequest">ขอเข้าใช้งานสระน้ำ</a></li>
							<li><a href="#">ประวัติคำร้องขอ</a></li>
						</ul>
					</div>
					<a href="#">บุคลากร</a>
					<a href="#">ติดต่อเรา</a>
				</div>
			</security:authorize>
			<security:authorize access="hasRole('trainer')">
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
							<li><a href="#">ขอเข้าใช้งานสระน้ำ</a></li>
							<li><a href="#">ประวัติคำร้องขอ</a></li>
						</ul>
					</div>
					<a href="#">บุคลากร</a>
					<a href="#">ติดต่อเรา</a>
				</div>
			</security:authorize>
			<security:authorize access="hasRole('manager')">
				<!-- Manager -->
				<div class="nav-element">
					<a href="index">หน้าแรก</a>
					<a href="goRecord_usage">บันทึกการเข้าใช้งาน</a>
					<a href="show_calendar">ปฏิทิน</a>
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
					<a href="getReportStat">สถิติ</a>
				</div>
			</security:authorize>
			<div id="profile_pos" class="profile-pool">
				<div class="circle_prof">
					<img src="img/prof.png>">
				</div>
				<div class="user-name">
					<security:authentication property="principal.username" />
				</div>
					<div class="logout">
						<!--  Logout here -->
						<button id="logout">
							Log out
						</button>
					</div>
			</div>
		</security:authorize>
		<security:authorize access="!isAuthenticated()">
			<!-- not login  -->
			<div class="nav-element">
				<a href="gocourse_register_test">คอร์สเรียน</a>
				<a href="#">บุคลากร</a>
				<a href="#">ติดต่อเรา</a>
				<a href="loginpage">เข้าสู่ระบบ</a>
				<a href="pre_reg">สมัครสมาชิก</a>
			</div>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			เข้าสู่ระบบแล้ว
		</security:authorize>
		<security:authorize access="!isAuthenticated()">
			ยังไม่ได้เข้าสู่ระบบ
		</security:authorize>
			อะไร?
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

	window.addEventListener('resize', function (event) {
		if (window.innerWidth > 700) {
			openNav()
		} else {
			closeNav()
		}
	}, true);


	function showdropdown(a) {
		a.parentNode.getElementsByClassName('dropdown-menu')[0].classList.add("show");
	}
	function closedropdown() {
		var i;
		var dropdowns = document.getElementsByClassName("dropdown-menu");
		for (i = 0; i < dropdowns.length; i++) {
			var openDropdown = dropdowns[i];
			if (openDropdown.classList.contains('show')) {
				openDropdown.classList.remove('show');
			}
		}
	}

	window.onclick = function (event) {
		if (!event.target.matches('.dropdown-btn')) {
			console.log("hmmm")
			closedropdown()
		} else if (event.target.matches('.dropdown-btn') && (event.target.parentNode.getElementsByClassName('dropdown-menu')[0].classList.contains('show'))) {
			closedropdown()
		}
		else {
			showdropdown(event.target)
		}
	} 
</script>
<script>
	const logout = document.getElementById("logout")
	const response = "ต้องการออกจากระบบหรือไม่?";
	logout.addEventListener("click", (click) => {
		// window.confirm(response)
		if (window.confirm(response)) {
			window.open("${pageContext.request.contextPath}/logout", "_self");
		}
	});
</script>

</html>