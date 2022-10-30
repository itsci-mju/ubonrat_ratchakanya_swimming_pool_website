ถ<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/original.css">
<link rel="stylesheet" href="css/staff_content.css">
<style>
    p{
        margin: 0;
    }
</style>
<body onload="checktypeinput()">
<%@ include file="common/header.jsp" %>
    <div class="content-record">
        <form action="getRequestToUse" method="post" name="frm">
            <!-- head -->
        <div class="content-record-head">
            <input type="radio" name="usetype" id="usetype_m" checked onclick="checktypeinput()"> สมาชิก
            <input type="radio" name="usetype" id="usetype_f" onclick="checktypeinput()"> บุคคลทั่วไป
        </div>
        <div class="content-record-body">
            <!-- form -->
                <!-- member -->
            <div class="member_c" id="member_a">
                <p class="content-record">รหัสสมาชิก</p>
                <div class="head-input">
                    <i class="bi bi-credit-card-2-front"></i>
                </div>
                <input type="text" name="memberID" id="mid" placeholder="รหัสสมาชิก" class="tl-input">
            </div>
                <!-- walk in -->
            <div class="walkIn_c" id="walkin_a"> 
                <p class="content-record">จำนวนผู้เข้าใช้</p>
                <div class="gender_m">
                    <div class="head-input">
                         <i class="bi bi-gender-male"></i>
                    </div>
                    <input type="number" name="malenum" id="malenum" placeholder="ชาย" min="0" class="ts-input">
                </div>
                <div class="gender_f">
                    <div class="head-input">
                        <i class="bi bi-gender-female"></i>
                    </div>
                    <input type="number" name="femalenum" id="femalenum" placeholder="หญิง" min="0" class="ts-input"> 
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
                        <label> อายุต่ำกว่า 18 ปี</label>
                    </div>
                    <input type="number" name="ud18" id="ud18" placeholder="&lt 18" min="0" class="tm-input">
                </div>
                <label style="font-size: 3px; margin:0; padding: 0;">&nbsp;</label>
                <div class="upper18">
                    <div class="head-input_text">
                       <label> อายุ 18 ปีขึ้นไป</label>
                    </div>
                    <input type="number" name="up18" id="up18" placeholder="&#x2265 18" min="0" class="tm-input">
                </div>
            </div>
            <br>
            <input type="submit" value="ยืนยัน" class="btn2submit">
            <input type="reset" value="ยกเลิก" class="btn2reset">
        </div>
        </form>
    </div>
    <%@ include file="common/footer.jsp" %>
</body>
<script src="js/fc_record.js"></script>
</html>