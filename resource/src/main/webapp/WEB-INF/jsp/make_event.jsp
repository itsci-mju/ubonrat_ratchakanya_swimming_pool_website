<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
//ชื่อกิจกรรม //
function checkEventname(frm){
    const  Eventname = /^[ก-์A-Za-z]{2,30}$/;
    const  labelAlertEventname  = document.getElementById("alertEventname");
    if(frm.eventname.value==("")){
       labelAlertEventname.innerText="กรุณากรอกชื่อกิจกรรม";
       labelAlertEventname.style.color="#ff5252";
      }
      else if(!frm.eventname.value.match(Eventname)){
       labelAlertEventname.style.color="#ff5252";
       labelAlertEventname.innerText="กรุณากรอกชื่อกิจกรรมเป็นภาษาไทยเท่านั้น";
  
        frm.eventname.value = "";
      }
      else{
        labelAlertEventname.innerText="สามารถใช้ชื่อกิจกรรมนี้ได้";
        labelAlertEventname.style.color= "#4CAF50";
      }
    }


// วันที่เริ่มใช้//
function checkStartdate(frm){
    const  today = new Date;
    today.setHours(0,0,0,0);
    alertStartdate = document.getElementById("alertStartdate");

    const  date = new Date(frm.startdate.value)
    if(frm.startdate.value==""){
        alertStartdate.innerText="กรุณากรอก วัน/เดือน/ปี";
        alertStartdate.style.color= "#ff5252";
    }
    else if(date <=today) {
        alertStartdate.innerText="วันที่เริ่มใช้ต้องไม่ใช่วันในอดีต";
        frm.startdate.value= ""
        alertStartdate.style.color= "#ff5252";
    }
    else{
        alertStartdate.innerText="สามารถใช้วันที่เริ่มใช้นี้ได้";
        alertStartdate.style.color= "#4CAF50";
    }
}


// วันที่สิ้นสุดการใช้งาน//
function checkEnddate(frm){
    const  today = new Date;
    today.setHours(0,0,0,0);
    alertEnddate = document.getElementById("alertEnddate");

    const  date = new Date(frm.enddate.value)
    if(frm.enddate.value==""){
        alertEnddate.innerText="กรุณากรอก วัน/เดือน/ปี";
        alertEnddate.style.color= "#ff5252";
    }
    else if(date < today) {
        alertEnddate.innerText="วันที่วันที่สิ้นสุดการใช้งานต้องไม่ใช่วันในอดีต หรือ วันปัจจุบันนี้";
        frm.enddate.value= ""
        alertEnddate.style.color= "#ff5252";
    }
    else{
        alertEnddate.innerText="สามารถใช้วันที่สิ้นสุดการใช้งานนี้ได้";
        alertEnddate.style.color= "#4CAF50";
    }
}



/* record usage service */
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


// รายละเอียด //
function checkDetail(regis){
    const  Detail = /^[ก-์A-Za-z]{2,30}$/;
    const  labelAlertDetail  = document.getElementById("alertDetail");
    if(regis.detail.value==("")){
        labelAlertDetail.innerText="กรุณากรอกรายละเอียด";
        labelAlertDetail.style.color="#ff5252";
      }
      else if(!regis.detail.value.match(Detail)){
        labelAlertDetail.style.color="#ff5252";
        labelAlertDetail.innerText="กรุณากรอกรายละเอียดเป็นภาษาไทยเท่านั้น";
  
        regis.detail.value = "";
      }
      else{
        labelAlertDetail.innerText="สามารถใช้รายละเอียดนี้ได้";
        labelAlertDetail.style.color= "#4CAF50";
      }
    } 


</script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="css/original.css">
<link rel="stylesheet" href="css/register.css">
<body id="nonselect">
 <%@ include file="header.jsp" %>
    <div class="content-request">
        <form action="addMakeEvent" method="post" name="frm">
          <table>
            <tr>
              <td colspan="2">
                <div>
                  <p style="width: 100%; font-size: 34px; margin: 0;" align="center" class="title"> สร้างกิจกรรมของสระว่ายน้ำ </p>
                 
              </div>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <div class="request_input">
                  <input type="text" name="mid" id="mid" hidden="true" readonly value="<%= mb.getLogins().getMembers_id() %>">
              </div>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <div class="form__group field" style="float: left;">
                  <input type="text" class="form__field" placeholder="ชื่อกิจกรรม" name="eventname" id="eventname" style="width: 300px;" onblur="checkEventname(frm)">
                  <label for="eventname" class="form__label">ชื่อกิจกรรม</label>
                  <label class="alert-label" id="alertEventname"></label>
              </div>
            </tr>
            <tr>
              <td>
                <div class="form__group field" style="float: center;">
                  <input type="date" class="form__field" placeholder="วันที่เริ่มใช้" name="startdate" id='startdate' required style="width: 150px;" onblur="checkStartdate(frm)">
                  <label for="startdate" class="form__label">วันที่เริ่มใช้</label>
                  <label class="alert-label" id="alertStartdate"></label>
              	</div>	
              </td>
               
               <td>
                <div class="form__group field" style="float: center;">
                  <input type="date" class="form__field" placeholder="วันที่สิ้นสุดการใช้" name="enddate" id='enddate' required style="width: 150px;" onblur="checkEnddate(frm)">
                  <label for="enddate" class="form__label">วันที่สิ้นสุดการใช้</label>
                  <label class="alert-label" id="alertEnddate"></label>
              	</div>
              </td>    
            </tr>
            
            
            
            <tr>
              <td colspan="2">
                <div class="request_input"> 
                  <label for="detail" style="color: #4CAF50;">รายละเอียด</label><br>
                  <textarea name="detail" id="detail" cols="30" rows="10" class="textarea_det" onblur="checkDetail(frm)" resiz></textarea><br>
                  <label class="alert-label" id="alertDetail"></label>
              </div>
              </td>
            </tr>
            
            <tr>
              <td colspan="2" align="center">
                <div class="request_input">
                  <input type="submit" value="ส่งคำร้อง" class="btn2submit">
                  <input type="reset" value="ยกเลิก" class="btn2reset">
              </div>
              </td>
            </tr>
          </table>
        </form>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>