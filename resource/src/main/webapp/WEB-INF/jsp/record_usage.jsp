<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="org.itsci.ubrswimming.model.*,org.itsci.ubrswimming.util.*,java.util.*"  %>
    <%@ page import="java.text.SimpleDateFormat,java.util.Calendar,java.util.TimeZone" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/original.css">
<style>
    p{
        margin: 100;
    }
</style>
<body onload="checktypeinput()">
<%@ include file="header.jsp" %>



    <div class="content-record">
        <form action="insertRecordUsage" method="post" name="frm">
            <!-- head -->
        <div class="content-record-head">
            <input type="radio" name="usetype" value="member" id="usetype_m" checked onclick="checktypeinput()"> สมาชิก
            <input type="radio" name="usetype" value="public" id="usetype_f" onclick="checktypeinput()"> บุคคลทั่วไป
        </div>
        <div class="content-record-body">
            <!-- form -->
                <!-- member -->
            <div class="member_c" id="member_a">
                <p class="content-record">รหัสสมาชิก</p>
                <div class="head-input">
                    <i class="bi bi-credit-card-2-front"></i>
                </div>
                <input type="text" name="memberID" id="memberID" placeholder="รหัสสมาชิก" class="tl-input">
            </div>
                <!-- walk in -->
            <div class="walkIn_c" id="walkin_a"> 
                 
                <p class="content-record">จำนวนผู้เข้าใช้</p>
                <div class="gender_m">
                    <div class="head-input">
                         <i class="bi bi-gender-male"></i>
                    </div>
                    <input type="number" name="gender_man" id="gender_man" placeholder="ชาย" min="0" class="ts-input">
                </div>
                <div class="gender_f">
                    <div class="head-input">
                        <i class="bi bi-gender-female"></i>
                    </div>
                    <input type="number" name="gender_gel" id="gender_gel" placeholder="หญิง" min="0" class="ts-input"> 
                </div>
            </div>
                <!-- both --><hr hidden> <br>
           <!-- <div class="both_c">            
                <p>เวลาที่เข้าใช้บริการ</p>
                <div class="head-input">
                    <i class="bi bi-clock"></i>
                </div>
                <input type="time" name="useTime" id="utime" placeholder="เวลาที่เข้าใช้บริการ" class="tl-input">
            </div> -->
                <!-- walk in -->
            <div class="walkIn_c" id="walkin_b"> 
                <p class="content-record">อายุผู้เข้าใช้งาน (จำนวน)</p>
                <div class="under18">
                    <div class="head-input_text">
                        <label> อายุต่ำกว่า 18 ปี 30บาท</label>
                    </div>
                    <input type="number" name="child" id="child" placeholder="&lt 18" min="0" class="tm-input">
                </div>
                <label style="font-size: 3px; margin:0; padding: 0;">&nbsp;</label>
                <div class="upper18">
                    <div class="head-input_text">
                       <label> อายุ 18 ปีขึ้นไป 50บาท</label>
                    </div>
                    <input type="number" name="adult" id="adult" placeholder="&#x2265 18" min="0" class="tm-input">
                </div> <br> 
                
                  <p class="content-record">ราคา</p>
                <div>
                    <div class="head-input">
                    </div>
                    <input type="number" name="price" id="price" placeholder="ราคา" min="0" class="ts-input">
                </div> 
            </div>
            
            <br>
            <input type="submit" value="ยืนยัน" class="btn2submit">
            <input type="reset" value="ยกเลิก" class="btn2reset">
        </div>
        </form>
    </div>
    <%@ include file="footer.jsp" %>
</body>
<script src="js/fc_record.js"></script>
<script>
function checktypeinput(){
    const  um = document.getElementById("usetype_m");
    const  uf = document.getElementById("usetype_f");
    const  mb = document.getElementById("member_a");
    const  wia = document.getElementById("walkin_a");
    const  wib = document.getElementById("walkin_b");
    if(um.checked){
        mb.style.display = "unset"
        wia.style.display = "none"
        wib.style.display = "none"
    }
    else if(uf.checked){
        mb.style.display = "none"
        wia.style.display = "unset"
        wib.style.display = "unset"
    }
}
</script>
<style>
.content-record {
  margin: auto;
  width: 300px;
  max-width: 500px;
}

.content-record-head {
  background-color: #f5f5f5;
  padding-left: 20px;
  font-size: 20px;
}

.content-record-body {
  padding: 20px 60px 20px 60px;
  margin: auto;
  width: 250px;
  max-width: 500px;
  background-color: #f5f5f5;
}

p.content-record {
  float: inline-start;
  margin: 5px 0 5px 0;
}

/* ------------------- manage member page --------------*/
.content-manage {
  margin: auto;
  display: flex;
  justify-content: center;
}

.manage_table th, td {
  padding-top: 10px;
  padding-bottom: 10px;
}

.manage_table th {
  color: rgba(27, 94, 31, 0.7529411765);
  font-weight: normal;
  padding-left: 5px;
  padding-right: 5px;
}

.manage_table td {
  padding-left: 10px;
  padding-right: 10px;
}

.manage_table tr:hover {
  background-color: rgba(230, 230, 230, 0.7);
}

.nametd {
  max-width: 300px;
  width: 300px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.column-table {
  background-color: rgba(230, 230, 230, 0.4);
}

.column-table th {
  background-color: rgba(230, 230, 230, 0.8);
}

.accept {
  transition: 0.5s ease;
}

.accept:hover {
  background-color: #66BB6A;
  color: white;
}
.accept:hover a {
  color: white;
}

.decline {
  transition: 0.5s ease;
}

.decline:hover {
  background-color: rgb(231, 120, 120);
  color: white;
}
.decline:hover a {
  color: white;
}

/* ------------------- record usage page --------------= */
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

td:nth-child(2) {
  text-align: center;
}

input[type=text],
input[type=number],
select,
.select-selected {
  font-family: "Kanit", sans-serif;
  font-size: medium;
  margin: 1px;
  padding: 8px;
  /* box-sizing:border-box; */
  border-radius: 4px;
  border: 1px solid #8a8886;
  color: rgb(50, 49, 48);
  width: calc(100% - 20px);
  min-width: 30px;
  text-overflow: ellipsis;
  outline: currentcolor none 0px;
  background: transparent;
  /* box-shadow: 0 0 1px 1px #e3e3e3; */
}

.select-selected:focus {
  margin: 0;
  border: 2px solid #0078d4;
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
}

input[type=text]:focus,
input[type=number]:focus,
select:focus {
  margin: 0;
  border: 2px solid #0078d4;
}

select:focus {
  margin-right: 0px;
  width: 100%;
}

input::-moz-placeholder {
  color: #605e5c;
  opacity: 1;
}

input:-ms-input-placeholder {
  color: #605e5c;
  opacity: 1;
}

input::placeholder {
  color: #605e5c;
  opacity: 1;
}

input[type=reset],
input[type=button],
input[type=submit] {
  outline: transparent none medium;
  position: relative;
  font-family: "Kanit", sans-serif;
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
  -webkit-user-select: none;
     -moz-user-select: none;
      -ms-user-select: none;
          user-select: none;
}

input[type=reset]:hover {
  background-color: rgb(243, 242, 241);
  color: rgb(32, 31, 30);
}

input[type=reset]:active {
  background-color: rgb(237, 235, 233);
  color: rgb(32, 31, 30);
}

input[type=submit] {
  border: 1px solid #0078d4;
  background-color: #0078d4;
  color: rgb(255, 255, 255);
}

input[type=submit]:hover {
  background-color: #106ebe;
  border: 1px solid #106ebe;
  color: rgb(255, 255, 255);
}

input[type=submit]:active {
  background-color: #005a9e;
  border: 1px solid #005a9e;
  color: rgb(255, 255, 255);
}

input[type=reset]:focus,
input[type=button]:focus,
input[type=submit]:focus {
  /* box-shadow: 0 0 1px 0 #0078d4; */
  outline: 1px solid #0078d4;
}

.checkbox {
  display: block;
  position: relative;
  cursor: pointer;
  -webkit-user-select: none;
     -moz-user-select: none;
      -ms-user-select: none;
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
  border-radius: 4px;
  transition-property: background, border-color;
  transition-duration: 200ms;
  transition-timing-function: cubic-bezier(0.4, 0, 0.23, 1);
}

.checkbox input:focus ~ .checkmark {
  border: 1px solid #0078d4;
  /* box-shadow: 0 0 1px 0 #0078d4; */
  outline: 1px solid #0078d4;
}

.checkbox input:checked ~ .checkmark {
  background-color: #0078d4;
  border: 1px solid #0078d4;
}

.checkbox:hover input:checked ~ .checkmark {
  background-color: #005a9e;
  border: 1px solid #005a9e;
}

.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}

.checkbox input:checked ~ .checkmark:after {
  display: block;
}

.checkbox:hover input ~ .checkmark:after {
  display: block;
  border: solid rgb(96, 94, 92);
  border-width: 0 2px 2px 0;
}

.checkbox:hover input:checked ~ .checkmark:after {
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
  transform: rotate(45deg);
}

.add-row,
.del-row {
  font-family: "Kanit", sans-serif;
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
  font-family: "Kanit", sans-serif;
}

.select-selected {
  cursor: pointer;
  display: block;
}

.select-selected.select-arrow-active {
  margin: 0;
  border: 2px solid #8a8886;
}

.select-selected.select-arrow-active:focus {
  margin: 0;
  border: 2px solid #0078d4;
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
  -webkit-user-select: none;
     -moz-user-select: none;
      -ms-user-select: none;
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
  font-family: "Kanit", sans-serif;
  box-sizing: border-box;
  border-radius: 8px;
  /* box-shadow: rgba(0, 0, 0, 0.133) 0px 3.2px 7.2px 0px, rgba(0, 0, 0, 0.11) 0px 0.6px 1.8px 0px; */
  box-shadow: 0 0 17.9px rgba(0, 0, 0, 0.066), 0 0 33.4px rgba(0, 0, 0, 0.079), 0 100px 80px rgba(0, 0, 0, 0.11);
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

.content-record {
  margin: 0 auto 25px;
  width: 250px;
  background: #f4f3f3;
  border-radius: 8px;
  box-shadow: 0 1.6px 3.6px 0 rgba(0, 0, 0, 0.132), 0 0.3px 0.9px 0 rgba(0, 0, 0, 0.108);
  z-index: 0;
  position: relative;
  
}

.content-record-head {
  display: flex;
  position: relative;
  justify-content: center;
  margin: 0 0 -1px;
  position: relative;
  padding-top: 20px;
  width: 350px;
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

.typeselec:checked + .botton_usetype {
  /* background: white; */
  z-index: 2;
  background: white;
}

.typeselec:focus + .botton_usetype {
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
}

#subbox {
  display: flex;
  justify-content: flex-end;
  gap: 20px;
  padding: 20px 0;
}

@-webkit-keyframes alert-card {
  from {
    background-color: #a80000;
  }
  to {
    background-color: #ff8080;
  }
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
  -webkit-animation: alert-card 250ms linear 4 alternate;
          animation: alert-card 250ms linear 4 alternate;
}

@media (max-width: 767px) {
  .content-record {
    width: 80%;
    min-width: 340px;
  }
}/*# sourceMappingURL=staff_content.css.map */
</style>
</html>