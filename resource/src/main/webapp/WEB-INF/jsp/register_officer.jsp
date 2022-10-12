<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String[] facname={"บริหารธุรกิจ",
			"วิทยาศาสตร์",
			"เทคโนโลยีการประมงและทรัพยากรทางน้ำ",
			"ศิลปศาสตร์",
			"สถาปัตยกรรมศาสตร์และการออกแบบสิ่งแวดล้อม",
			"สารสนเทศและการสื่อสาร",
			"ผลิตกรรมการเกษตร",
			"วิศวกรรมและอุตสาหกรรมเกษตร",
			"พัฒนาการท่องเที่ยว",
			"เศรษฐศาสตร์",
			"สัตวศาสตร์และเทคโนโลยี",
			"พยาบาลศาสตร์",
			"สัตวแพทยศาสตร์",
			"วิทยาลัยนานาชาติ",
			"วิทยาลัยพลังงานทดแทน",
			"วิทยาลัยบริหารศาสตร์",
			"มหาวิทยาลัยแม่โจ้-แพร่ เฉลิมพระเกียรติ",
			"มหาวิทยาลัยแม่โจ้-ชุมพร",
			"กองกลาง",
			"กองบริหารทรัพยากรบุคคล",
			"กองคลัง",
			"กองตรวจสอบภายใน",
			"กองเทคโนโลยีดิจิทัล",
			"กองบริหารงานทรัพย์สินและกิจการพิเศษ",
			"กองแผนงาน",
			"ฝ่ายพัฒนาทรัพยากรมนุษย์",
			"กองพัฒนาคุณภาพ",
			"กองพัฒนานักศึกษา",
			"กองวิเทศสัมพันธ์",
			"กองส่งเสริมศิลปวัฒนธรรม",
			"กองกายภาพและสิ่งแวดล้อม",
			"สภาพนักงาน",
			"ฝ่ายสื่อสารองค์กร",
			"ฝ่ายกฏหมาย",
			"ฝ่ายขับเคลื่อนยุทธศาสตร์และโครงการพิเศษ"	
}; 
%>

<html>
<head>
<meta charset="UTF-8">
   <title>Register:Officer</title>
</head>
<link rel="stylesheet" href="css/main_style.css">
<link rel="stylesheet" href="css/original.css">
<link rel="stylesheet" href="css/register_style.css">
<body onload="togglePass()"> 
 <%@ include file="header.jsp" %>
   
<div class="re-content">
    <form action="doRegister_officer" method="post" name="regis">
        <p style="font-size: 26px; margin: auto;" align="center"> สมัครสมาชิก : บุคลากร </p>
        
        <section id="sec_first">
            <!-- First Name -->
        <div class="form__group field">
            <input type="text" class="form__field" placeholder="ชื่อ" name="fname" id='fname' onblur="checkFirstname(regis)">
            <label for="fname" class="form__label">ชื่อ</label>
            <label class="alert-label" id="alertFname"><!-- alert_DonotForgetToDelete --></label>
        </div>

        <!-- Last Name-->
        <div class="form__group field">
            <input type="text" class="form__field" placeholder="นามสกุล" name="lname" id='lname' onblur="checkLastname(regis)">
            <label for="lname" class="form__label">นามสกุล</label>
            <label class="alert-label" id="alertLname"><!-- alert_DonotForgetToDelete --></label>
        </div>

        <!-- Email -->
        <div class="form__group field">
            <input type="text" class="form__field" placeholder="อีเมล" name="email" id='email' onblur="checkEmail(regis)">
            <label for="email" class="form__label">อีเมล</label>
            <label class="alert-label" id="alertEmail"><!-- alert_DonotForgetToDelete --></label>
        </div>

        <!-- Password -->
        <div class="form__group field">
            <i id="iconeye" class="bi bi-eye-slash" onclick="togglePass()" style="cursor: pointer; position: absolute; top: 20px; left: 300px;"></i>
            <input type="password" class="form__field" placeholder="รหัสผ่าน" name="pwd" id='pwd' required onblur="checkPassword(regis)">
            <input type="checkbox" name="eye" id="eye" hidden>
            <label for="pwd" class="form__label">รหัสผ่าน</label>
            <label class="alert-label" id="alertPWD"><!-- alert_DonotForgetToDelete --></label>
        </div>

        <!-- con-Password -->
        <div class="form__group field">
            <input type="password" class="form__field" placeholder="รหัสผ่าน" name="con_pwd" id='con_pwd' onblur="checkPassword(regis)">
            <label for="con_pwd" class="form__label">ยืนยันรหัสผ่าน</label>
            <label class="alert-label" id="alertconPWD"><!-- alert_DonotForgetToDelete --></label>
        </div>
        </section>

        <section id="sec_second">
                <!-- Sex-->
            <div class="form__group field">
                <font class="form__label"> เพศ  </font>
                <input type="radio" name="gender" id="gender_m" value="male" required> ชาย 
                <input type="radio" name="gender" id="gender_f" value="female"> หญิง
                <label class="alert-label" id="alertGender"><!-- alert_DonotForgetToDelete --></label>
            </div> 
             <!-- Tel. Number-->
             <div class="form__group field">
                <input type="tel" class="form__field" placeholder="เบอร์โทรศัพท์" name="tel" id='tel' maxlength="10" onblur="checkTel(regis)">
                <label for="tel" class="form__label">เบอร์โทรศัพท์</label>
                <label class="alert-label" id="alertTelNum"><!-- alert_DonotForgetToDelete --></label>
            </div>
            <!-- Birth date-->
            <div class="form__group field">
                <input type="date" class="form__field" name="birthdate" id='birthdate' value="21-12-1998" onblur="checkBirth(regis)">
                <label for="birthdate" class="form__label">วันเกิด</label>
                <label class="alert-label" id="alertBirth"><!-- alert_DonotForgetToDelete --></label>
            </div>
            <!-- Address-->
            <!-- <textarea name="address" id="address" placeholder="ที่อยู่" cols="30" rows="10"></textarea> -->
            <div class="form__group field">
                <input type="text" class="form__field" placeholder="ที่อยู่" name="address" id='address' onblur="checkAddrss(regis)">
                <label for="address" class="form__label">ที่อยู่บ้านเลขที่</label>
                <label class="alert-label" id="alertAD1"><!-- alert_DonotForgetToDelete --></label>
            </div>
            <div class="form__group field">
                <input type="text" class="form__field" placeholder="ตำบล" name="sub_districts" id='sub_districts' onblur="checkSub_districts(regis)">
                <label for="sub_districts" class="form__label">ตำบล</label>
                <label class="alert-label" id="alertsubD"><!-- alert_DonotForgetToDelete --></label>
            </div>
            <div class="form__group field">
                <input type="text" class="form__field" placeholder="อำเภอ" name="districts" id='districts' onblur="checkDistricts(regis)">
                <label for="districts" class="form__label">อำเภอ</label>
                <label class="alert-label" id="alertDist"><!-- alert_DonotForgetToDelete --></label>
            </div>
            <div class="form__group field">
                <input type="text" class="form__field" placeholder="จังหวัด" name="province"  id='province' onblur="checkProvince(regis)">
                <label for="province" class="form__label">จังหวัด</label>
                <label class="alert-label" id="alertProvince"><!-- alert_DonotForgetToDelete --></label>
            </div>
            <div class="form__group field">
                <input type="text" class="form__field" placeholder="รหัสไปรษณีย์" name="post_code" id='post_code' onblur="checkPost_code(regis)">
                <label for="post_code" class="form__label">รหัสไปรษณีย์</label>
                <label class="alert-label" id="alertPostCode"><!-- alert_DonotForgetToDelete --></label>
            </div>
        </section>
        
        <section id="sec_third">
            <!--  organization   -->
            <div class="form__group field">
            <select name="affiliation" id="affiliation" class="form__field" onblur="checkAffiliation(regis)">
                <option value="" selected disabled hidden>หน่วยงาน/องค์กรที่สังกัด</option>
                <% for(String f : facname) {%>
                <option value="<%= f %>"><%= f %></option>
                <%} %>
            </select>
            <!-- 
                <label for="faculty" class="form__label">คณะ/วิทยาลัยที่สังกัด</label> -->
            <label class="alert-label" id="alertFac"><!-- alert_DonotForgetToDelete --></label>
            </div>
            <!-- personal image profile -->
            <div class="request_input form__group field">
                <label for="per_pic" class="req_file_">รูปหน้าตรง</label> <br>
                <input type="file" name="per_pic" id="per_pic" class="req_file form-control" onblur="uploadPer_pic(regis)">
            <br>
                <label class="alert-label" id="alertperpic"><!-- alert_DonotForgetToDelete --></label>
            </div>
            <!--  image  -->
            <div class="request_input form__group field">
                <label for="doc" class="req_file_">รูปบัตรประชาชน/ข้าราชการ</label> <br>
                <input type="file" name="id_cards" id="id_cards" class="req_file form-control" onblur="uploadId_cards(regis)"> 
            <br>
                <label class="alert-label" id="alertid_cards"><!-- alert_DonotForgetToDelete --></label>
            </div>
            
          <!--  ทะเบียนสมรส  -->
          <div class="request_input form__group field">
            <label for="doc" class="req_file_">ทะเบียนสมรส</label> <br>
            <input type="file" name="marriage" id="marriage" class="req_file form-control" onblur="uploadMarriage(regis)"> 
        <br>
            <label class="alert-label" id="alertmarriage"><!-- alert_DonotForgetToDelete --></label>
        </div>


        <div class="submit_box" style="margin-left: 100px;">
            <input type="reset" value="ยกเลิก" class="reset_btn"> 
            <input type="submit" value="สมัครสมาชิก" class="submit_btn"> 
        </div>
        </section>
</form>
</div>
<%@ include file="footer.jsp" %>
</body>
<script>
//Script หน่วยงาน/องค์กรที่สังกัด //
function checkAffiliation(regis){
	  var labelAlertAffiliation  = document.getElementById("alertFac");
	  if(regis.affiliation.value==("")){
	    labelAlertAffiliation.innerText="กรุณาเลือกหน่วยงาน/องค์กรที่สังกัด";
	    labelAlertAffiliation.style.color="#ff5252";
	  }
	  else{
	    labelAlertAffiliation.innerText="";
	    }
	}


//Script รูปหน้าตรง //
function uploadPer_pic(regis) { 
  const  labelAlertper_pic = document.getElementById("alertperpic");
  if(regis.per_pic.value==("")){
	  labelAlertper_pic.innerText="กรุณาใส่รูปหน้าตรง";
	  labelAlertper_pic.style.color="#ff5252";
    }
    else{
    	labelAlertper_pic.innerText="สามารถใช้รูปหน้าตรงนี้ได้";
    	labelAlertper_pic.style.color= "#4CAF50";
    }
  } 
  
  
//Script รูปบัตรประชาชน/ข้าราชการ//
function uploadId_cards(regis) { 
  const  labelAlertId_cards = document.getElementById("alertid_cards");
  if(regis.id_cards.value==("")){
	  labelAlertId_cards.innerText="กรุณาใส่รูปบัตรนักศึกษา";
	  labelAlertId_cards.style.color="#ff5252";
    }
    else{
    	labelAlertId_cards.innerText="สามารถใช้รูปบัตรนักศึกษานี้ได้";
    	labelAlertId_cards.style.color= "#4CAF50";
    }
  }
  
  
  

//Script ทะเบียนสมรส //
function uploadMarriage(regis) { 
const  labelAlertMarriage = document.getElementById("alertmarriage");
if(regis.marriage.value==("")){
	  labelAlertMarriage.innerText="กรุณาใส่รูปบัตรนักศึกษา";
	  labelAlertMarriage.style.color="#ff5252";
  }
  else{
  	labelAlertMarriage.innerText="สามารถใช้รูปบัตรนักศึกษานี้ได้";
  	labelAlertMarriage.style.color= "#4CAF50";
  }
}  
</script>
<script src="js/reg_progress.js"></script>
<script src="js/fc_showpass.js"></script>
<script src="js/fc_regis.js"></script>
<script src="js/cs_regis.js"></script>
</html>