<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ReqestForm</title>
</head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="css/original.css">
<link rel="stylesheet" href="css/register.css">
<body id="nonselect">
 <%@ include file="header.jsp" %>
    <div class="content-request">
        <form action="getRequestToUse" method="post" name="frm" enctype="multipart/form-data">
          <table>
            <tr>
              <td colspan="2">
                <div>
                  <p style="width: 100%; font-size: 34px; margin: 0;" align="center" class="title"> แบบฟอร์มขอเข้าใช้งาน </p>
                  <p style="width: 100%; font-size: 26px; margin: 0;" align="center" class="title"> สระว่ายน้ำอุบลรัตน์ราชกัญญา </p>
              </div>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <div class="request_input">
                  <input type="hidden" name="mid" id="mid" readonly value="<%= mb.getLogins().getMembers_id() %>">
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
                <div class="form__group field" style="float: left;">
                  <input type="date" class="form__field" placeholder="วันที่เริ่มใช้" name="startdate" id='startdate' required style="width: 150px;" onblur="checkStartdate(frm)">
                  <label for="startdate" class="form__label">วันที่เริ่มใช้</label>
                  <label class="alert-label" id="alertStartdate"></label>
              </div>
              </td>
              <td>
                <div class="request_input_time">  
                  <input type="number" class="req_time" placeholder="เวลา" name="starthour" id='starthour' min="0" max="23" value="09" maxlength="2" required  onblur="checkStarthour(frm)"> <b style="font-size: 20px;">:</b>
                  <input type="number" class="req_time" placeholder="เวลา" name="startminute" id='startminute' min="0" max="59" value="00" required maxlength="2" onblur="checkStartminute(frm)"> <label style="font-size: 20px;">น. <br></label>    
                </div>
                  <label class="alert-label" id="alertStarthour"></label>
                  <label class="alert-label" id="alertStartminute"></label>
              </td>
            </tr>
            <tr>
              <td>
                <div class="form__group field" style="float: left;">
                  <input type="date" class="form__field" placeholder="วันที่สิ้นสุดการใช้" name="enddate" id='enddate' required style="width: 150px;" onblur="checkEnddate(frm)">
                  <label for="enddate" class="form__label">วันที่สิ้นสุดการใช้</label>
                  <label class="alert-label" id="alertEnddate"></label>
              </div>
              </td>
              <td>    
                <div class="request_input_time">
                  <input type="number" class="req_time" placeholder="เวลา" name="endhour" id='endhour' min="0" max="23" value="09" required maxlength="2" onblur="checkEndhour(frm)"> <b style="font-size: 20px;">:</b>
                  <input type="number" class="req_time" placeholder="เวลา" name="endminute" id='endminute' min="0" max="59" value="00" required maxlength="2" onblur="checkEndminute(frm)"> <label style="font-size: 20px;">น.</label>
                </div>
                <label class="alert-label" id="alertEndhour"></label>
                <label class="alert-label" id="alertEndminute"></label>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <div class="request_input"> 
                  <label for="detail" style="color: #4CAF50;">รายละเอียด</label><br>
                  <textarea name="detail" id="detail" cols="30" rows="10" class="textarea_det" onblur="checkDetail(frm)"></textarea><br>
                  <label class="alert-label" id="alertDetail"></label>
              </div>
              </td>
            </tr>
            
            
              <tr>
              <td colspan="2">
                <div class="request_input">
                  <label for="doc" style="color: #4CAF50;">อัปโหลดเอกสาร (ถ้ามี)</label> <br>
                  <input type="file" class="form-control" name="photo" id="photo" value="" onchange="return OnUploadCheck()" accept=".jpg, .jpeg, .png, .gif" />		
				  <input type="text" value="" id="registerphoto" name="registerphoto">
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
    
    <div class="bt1">				
		<button  onclick="Checkinput()">อัปโหลด</button>
	</div>
		
    <%@ include file="footer.jsp" %>
</body>
<script src="javascript/cs_requestform.js"></script>

<script src="https://www.gstatic.com/firebasejs/7.7.0/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/7.7.0/firebase-storage.js"></script>
<script src="https://www.gstatic.com/firebasejs/4.2.0/firebase.js"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>

   //paste here your copied configuration code
   const firebaseConfig = {
		   apiKey: "AIzaSyB2pF_-EDCtyh4idqoh_8kbMgYhbVe7kTg",
		   authDomain: "projectfinal-a13e5.firebaseapp.com",
		   projectId: "projectfinal-a13e5",
		   storageBucket: "projectfinal-a13e5.appspot.com",
		   messagingSenderId: "695099707523",
		   appId: "1:695099707523:web:b8a1f019b12c29735bcbb6",
		   measurementId: "G-XR562S2KW8"
   };

   // Initialize Firebase
   firebase.initializeApp(firebaseConfig);
   console.log(firebase);
      function uploadImage() {
	      const ref = firebase.storage().ref();
	      const file = document.querySelector("#photo").files[0];
	      const name = +new Date() + "-" + file.name;
	      const metadata = {
	         contentType: file.type
	      };
	      const task = ref.child(name).put(file, metadata);task
	      .then(snapshot => snapshot.ref.getDownloadURL())
	      .then(url => {
	      console.log(url);
	      alert('image uploaded successfully');
	      document.getElementById("registerphoto").value = url;
	      
	      
	   })
	   .catch(console.error);
	   }

   
function OnUploadCheck() {
	var extall = "jpg,jpeg,gif,png";
	file = $('input[name="photo"]').val();
	ext = file.split('.').pop().toLowerCase();
	if (parseInt(extall.indexOf(ext)) < 0) {
		alert('กรุณาเลือกไฟล์ประเภทรูปภาพ ที่เป็นนามสกุล : ' + extall);
		$('input[name="photo"]').val("");
		return false;

	}
	return true;
}

	
function Checkinput(){
	var urlfinal
    const ref = firebase.storage().ref();
    const file = document.querySelector("#photo").files[0];
    const name = +new Date() + "-" + file.name;
    const metadata = {
       contentType: file.type
    };
    const task = ref.child(name).put(file, metadata);task
    .then(snapshot => snapshot.ref.getDownloadURL())
    .then(url => {
    console.log(url);
    urlfinal = url
    alert('image uploaded successfully');
    document.getElementById("registerphoto").value = url;
    
 })
 .catch(console.error);

   // Thread.sleep(5000);
	// console.log(document.getElementById("photo").value);
	 files = $('input[name="photo"]').val();
		if(files == "" || files === null){
			alert("กรูณาอัปโหลดรูปภาพ");
			return false;
		}

}


//ชื่อกิจกรรม //
function checkEventname(frm){
    const  Eventname = /^[ก-์A-Za-z0-9]{2,30}$/;
    const  labelAlertEventname  = document.getElementById("alertEventname");
    if(frm.eventname.value==("")){
       labelAlertEventname.innerText="กรุณากรอกชื่อกิจกรรม";
       labelAlertEventname.style.color="#ff5252";
      }
      else if(!frm.eventname.value.match(Eventname)){
       labelAlertEventname.style.color="#ff5252";
       labelAlertEventname.innerText="กรุณากรอกชื่อกิจกรรมเป็นภาษาไทยหรือภาษาอังกฤษเท่านั้น"
  
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

// เวลา1 //
function checkStarthour(frm){
    const  Starthour = /^[0-9]{1,2}$/;
    const  labelAlertStarthour  = document.getElementById("alertStarthour");
    const sh = frm.starthour.value;
    if(sh==("")){
        labelAlertStarthour.innerText="กรุณากรอกเวลา";
        labelAlertStarthour.style.color="#ff5252";
      }
    else if(sh<9 || sh >19){
        labelAlertStarthour.style.color="#ff5252";
        labelAlertStarthour.innerText="เวลาต้องไม่ต่ำกว่า 9 นาฬิกาและต้องไม่เกิน 19 นาฬิกา";
  
        frm.starthour.value = "";
      }
      else{
        labelAlertStarthour.innerText="สามารถใช้เวลานี้ได้";
        labelAlertStarthour.style.color= "#4CAF50";
      }
    } 

// นาที1 //
function checkStartminute(frm){
  const  Startminute = /^[0-9]{1,2}$/;
  const  labelAlertStartminute  = document.getElementById("alertStartminute");
  const sm = frm.startminute.value;
    if(sm==("")){
    labelAlertStartminute.innerText="กรุณากรอกนาที";
    labelAlertStartminute.style.color="#ff5252";
    }
    else if(sm<0 || sm >59){
      labelAlertStartminute.style.color="#ff5252";
      labelAlertStartminute.innerText="นาทีต้องไม่ต่ำกว่า 0 นาทีและต้องไม่เกิน 59 นาที";

      frm.startminute.value = "";
    }
    else{
      labelAlertStartminute.innerText="สามารถใช้นาทีนี้ได้";
      labelAlertStartminute.style.color= "#4CAF50";
    }
  }


  // เวลา2 //
function checkEndhour(frm){
  const  Endhour = /^[0-9]{1,2}$/;
  const  labelAlertEndhour  = document.getElementById("alertEndhour");
  const eh = frm.endhour.value;
    if(eh==("")){
    labelAlertEndhour.innerText="กรุณากรอกเวลา";
    labelAlertEndhour.style.color="#ff5252";
    }
    else if(eh<9 || eh >19){
      labelAlertEndhour.style.color="#ff5252";
      labelAlertEndhour.innerText="เวลาต้องไม่ต่ำกว่า 9 นาฬิกาและต้องไม่เกิน 19 นาฬิกา";

      frm.endhour.value = "";
    }
    else{
      labelAlertEndhour.innerText="สามารถใช้เวลานี้ได้";
      labelAlertEndhour.style.color= "#4CAF50";
    }
  } 


// นาที2 //
function checkEndminute(frm){
const  Endminute = /^[0-9]{1,2}$/;
const  labelAlertEndminute  = document.getElementById("alertEndminute");
const em = frm.endminute.value;
if(em==("")){
  labelAlertEndminute.innerText="กรุณากรอกนาที";
  labelAlertEndminute.style.color="#ff5252";
  }
  else if(em<0 || em >59){
    labelAlertEndminute.style.color="#ff5252";
    labelAlertEndminute.innerText="นาทีต้องไม่ต่ำกว่า 0 นาทีและต้องไม่เกิน 59 นาที";

    frm.endminute.value = "";
  }
  else{
    labelAlertEndminute.innerText="สามารถใช้นาทีนี้ได้";
    labelAlertEndminute.style.color= "#4CAF50";
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
    const  Detail = /^[ก-์A-Za-z0-9]{2,30}$/;
    const  labelAlertDetail  = document.getElementById("alertDetail");
    if(regis.detail.value==("")){
        labelAlertDetail.innerText="กรุณากรอกรายละเอียด";
        labelAlertDetail.style.color="#ff5252";
      }
      else if(!regis.detail.value.match(Detail)){
        labelAlertDetail.style.color="#ff5252";
        labelAlertDetail.innerText="กรุณากรอกรายละเอียดเป็นภาษาไทยหรือภาษาอังกฤษเท่านั้น";
  
        regis.detail.value = "";
      }
      else{
        labelAlertDetail.innerText="สามารถใช้รายละเอียดนี้ได้";
        labelAlertDetail.style.color= "#4CAF50";
      }
    } 


    // Script อัพโหลดเอกสาร //
  function uploadFile(regis) { 
    const  labelAlertFile  = document.getElementById("alertfile");
    if(regis.doc.value==("")){
        labelAlertFile.innerText="กรุณาใส่เอกสารเพิ่มเติม";
        labelAlertFile.style.color="#ff5252";
      }
      else{
        labelAlertFile.innerText="สามารถใช้เอกสารเพิ่มเติมนี้ได้";
        labelAlertFile.style.color= "#4CAF50";
      }
    }   
</script>
<style>
.bt1{
         margin-left: 720px;
         margin-right: 500px;
    }
</style>
</html>