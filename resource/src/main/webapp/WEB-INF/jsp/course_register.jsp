<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="bean.*,util.*,java.util.*"  %>
<%
	ArrayList<String> datesel = new ArrayList<String>();
	if(session.getAttribute("datesel")!=null){
		for(String s:(List<String>)session.getAttribute("datesel")){
			datesel.add(s);
		}
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<form action="getTimeToCourse" name="frm" method="post">
        <p style="font-size: 26px; margin: auto;" align="center">แบบฟอร์มสมัครเรียนว่ายน้ำ </p>
        <div class="">
            <div class="registype-div">
                <input type="radio" name="registype" id="r-self" value="self"> สมัครให้ตนเอง
                <input type="radio" name="registype" id="r-other" value="other"> สมัครให้ผู้อื่น
            </div>
            <div>
                <input type="radio" name="grouptype" id="g-one" value="1"> แบบเดี่ยว
                <input type="radio" name="grouptype" id="g-group" value="2"> แบบกลุ่ม
            </div>
        </div>
        <div class="daytype-div">
            <select name="daytype" id="daytype" class="select_input">
                <option value="" selected disabled hidden required>วันที่ต้องการเรียน</option>
                <option value="1">วันจันทร์ - วันศุกร์</option>
                <option value="2">วันเสาร์ - วันอาทิตย์</option>
                <option value="3">ทุกวัน</option>
            </select>
        </div>
        <div class="learntime-div">
            <select name="learntime" id="learntime" class="select_input">
                <option value="" selected disabled hidden required>ช่วงเวลาที่ต้องการเรียน</option>
                <option value="1">10.00 - 11.00 น.</option>
                <option value="2">11.00 - 12.00 น.</option>
                <option value="3">13.00 - 14.00 น.</option>
                <option value="4">14.00 - 15.00 น.</option>
                <option value="5">15.00 - 16.00 น.</option>
                <option value="6">16.00 - 17.00 น.</option>
            </select>
        </div>
        <div class="date-req-div">
          <select name="datereq" id="datereq" class="select_input">
              <option value="" selected disabled hidden required>วันที่ต้องการเริ่มเรียน</option>
              <% if(datesel!=null){
            	  for(String d:datesel){ %>
              <option value="<%= d %>"><%= d %></option>
              <%}} %>
          </select>
        </div>
        <input type="submit" value="submit">
        </form>
</body>
</html>