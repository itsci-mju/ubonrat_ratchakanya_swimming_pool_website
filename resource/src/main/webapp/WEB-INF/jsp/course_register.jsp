<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.itsci.ubrswimming.bean.*,org.itsci.ubrswimming.util.*,java.util.*"  %>
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
%>
<html>
<head>
<meta charset="UTF-8">
<title>Course Register</title>
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
      <form action="getTimeToCourse" name="frm2" method="post">
        <div id="daysch">
          <div class="daytype-div custom-select">
            <select name="daytype" id="daytype">
              <option value="" selected disabled hidden required>วันที่ต้องการเรียน</option>
              <option value="1">วันจันทร์ - วันศุกร์</option>
              <option value="2">วันเสาร์ - วันอาทิตย์</option>
              <option value="3">ทุกวัน</option>
            </select>
          </div>
          <div class="learntime-div custom-select">
            <select name="learntime" id="learntime">
              <option value="" selected disabled hidden required>ช่วงเวลาที่ต้องการเรียน</option>
              <option value="1">10.00 - 11.00 น.</option>
              <option value="2">11.00 - 12.00 น.</option>
              <option value="3">13.00 - 14.00 น.</option>
              <option value="4">14.00 - 15.00 น.</option>
              <option value="5">15.00 - 16.00 น.</option>
              <option value="6">16.00 - 17.00 น.</option>
            </select>
          </div>
          <div class="date-req-div custom-select">
            <select name="datereq" id="datereq">
              <option value="" selected disabled hidden required>วันที่ต้องการเริ่มเรียน</option>
             <% if(datesel!=null){
                for(String d:datesel){ %>
            <option value="<%= d %>"><%= d %></option>
            <%}} %> 
            </select>
          </div>
          <div class="button-area">
            <button type="submit" value="Submit"><i class="bi bi-search"></i>หา</button>
          </div>
          <!-- <input type="submit" value="หา"> -->
        </div>
      </form>
      <hr>
      <!-- ******************************************* Form Detail ********************************************************-->
      <form action="doCourse_register" name="frm" method="post">
      	<div class="hidden">
          <input type="text" name="daytype2" id="daytype2" <% if(dt != null){  %>value="<%= dt %>" <%} %>>
          <input type="text" name="learntime2" id="learntime2" <% if(lt != null){  %>value="<%= lt %>" <%} %>>
          <input type="text" name="datereq2" id="datereq2" >
        </div>
        <div class="gty-div">
          <div class="registype-div">
            <div>รูปแบบการสมัคร</div>
            <input type="radio" name="registype" id="r-self" value="self" class="typeselec" checked>
            <label for="r-self" class="radio"><span class="radiocheckmark"></span>สมัครให้ตนเอง</label>
            <input type="radio" name="registype" id="r-other" value="other" class="typeselec">
            <label for="r-other" class="radio"><span class="radiocheckmark"></span>สมัครให้ผู้อื่น</label>
          </div>
          <div class="grouptype-div">
            <div>แบบ</div>
            <input type="radio" name="grouptype" id="g-one" value="1" class="typeselec" hecked>
            <label for="g-one" class="radio"><span class="radiocheckmark"></span><i class="bi bi-person-fill"></i><span>แบบเดี่ยว</span></label>
            <input type="radio" name="grouptype" id="g-group" value="2" class="typeselec">
            <label for="g-group" class="radio"><span class="radiocheckmark"></span><i class="bi bi-people-fill"></i><span>แบบกลุ่ม</span></label>
          </div>
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
                      <option value="0">ชาย</option>
                      <option value="1">หญิง</option>
                    </select>
                  </div>
                </td>
                <td><input type="number" name="age0" min="1" step="1"></td>
                <td><input type="text" name="tel0" id="tel0" placeholder="เบอร์โทรศัพท์"></td>
                <td><label class="checkbox"><input type="checkbox"><span class="checkmark"></span></label></td>
              </tr>
            </tbody>
            <tfoot>
              <tr>
                <td colspan="5">
                  <button type="button" id="add-row-trainee" class="add-row" tabindex="0">
                    <i class="bi bi-plus-lg"></i>
                    <span>เพิ่ม</span>
                  </button>
                </td>
                <td>
                  <button type="button" id="del-row-trainee" class="del-row" tabindex="0"><i
                      class="bi bi-trash3"></i></button>
                </td>
              </tr>
            </tfoot>
          </table>
        </div>
        <div>
          <label for="cost">ราคา :</label><input type="text" name="cost" id="cost" value="0" readonly><label
            for="cost">บาท</label>
        </div>
        <div class="button-area">
          <input type="submit" value="ยืนยัน">
          <input type="reset" value="ยกเลิก">
        </div>
      </form>
    </div>
  </div>
</body>
<script src="js/fc_course_regis.js"></script>
<script>
const element = document.getElementById("main_submit");
const datereq = document.getElementById("datereq")
const dq = document.getElementById("datereq2")

element.addEventListener("click",(click)=>{
  dq.value = datereq.value
 });
</script>
<style>
   .hiden{
    display: none;
   }
</style>
</html>