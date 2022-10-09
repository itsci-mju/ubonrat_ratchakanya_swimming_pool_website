// ชื่อ //
function checkFirstname(regis){
    var Firstname = /^[ก-์A-Za-z]{2,30}$/;
    var labelAlertfname  = document.getElementById("alertFname");
    if(regis.fname.value==("")){
      labelAlertfname.innerText="กรุณากรอกชื่อ";
      labelAlertfname.style.color="#ff5252";
      }
      else if(!regis.fname.value.match(Firstname)){
        labelAlertfname.style.color="#ff5252";
        labelAlertfname.innerText="กรุณากรอกชื่อเป็นภาษาไทย และภาษาอังกฤษเท่านั้น";

        regis.fname.value = "";
      }
      else{
        labelAlertfname.innerText="สามารถใช้ชื่อนี้ได้";
        labelAlertfname.style.color= "#4CAF50";
      }
    } 
    
// นามสกุล //
function checkLastname(regis){
    var Lastname = /^[ก-์A-Za-z]{2,30}$/;
    var labelAlertlname  = document.getElementById("alertLname");
    if(regis.lname.value==("")){
      labelAlertlname.innerText="กรุณากรอกนามสกุล";
      labelAlertlname.style.color="#ff5252";
      }
      else if(!regis.lname.value.match(Lastname)){
        labelAlertlname.style.color="#ff5252";
        labelAlertlname.innerText="กรุณากรอกนามสกุลเป็นภาษาไทย และภาษาอังกฤษเท่านั้น";
        
        regis.lname.value = "";
      }
      else{
        labelAlertlname.innerText="สามารถใช้นามสกุลนี้ได้";
        labelAlertlname.style.color= "#4CAF50";
      }
    }  

// อีเมล //
function checkEmail(regis){
  var Email = /^([A-Za-z0-9._-]{5,50})([@]{1})([A-Za-z0-9._-]{5,50})$/;
  var labelAlertemail  = document.getElementById("alertEmail");
  if(regis.email.value==("")){
    labelAlertemail.innerText="กรุณากรอกอีเมล";
    labelAlertemail.style.color="#ff5252";
    }
    else if(!regis.email.value.match(Email)){
      labelAlertemail.style.color="#ff5252";
      labelAlertemail.innerText="อีเมลต้องเป็นตัวอักษรภาษาอังกฤษหรือตัวเลขมีความยาวตั้งแต่ 5 – 50 ตัวอักษรเท่านั้น";
      
    }
    else{
      labelAlertemail.innerText="สามารถใช้อีเมลนี้ได้";
      labelAlertemail.style.color= "#4CAF50";
    }
  }    

  // รหัสผ่าน //
function checkPassword(regis){
  var Password = /^[A-Za-z0-9]{6,16}$/;
  var labelAlertpass  = document.getElementById("alertPWD");
  var labelAlertcon  = document.getElementById("alertconPWD");
  if(regis.pwd.value==("")){
    labelAlertpass.innerText="กรุณากรอกรหัสผ่าน";
    labelAlertpass.style.color="#ff5252";
    }
    else if(!regis.pwd.value.match(Password)){
      labelAlertpass.style.color="#ff5252";
      labelAlertpass.innerText="กรุณาใช้รหัสผ่านเป็นอักษรภาษาอังกฤษหรือตัวเลข 6-16 ตัวเท่านั้น";
      
      regis.pwd.value = "";
    }
    else{
      labelAlertpass.innerText="สามารถใช้รหัสผ่านนี้ได้";
      labelAlertpass.style.color= "#4CAF50";
    }
  
  if(regis.con_pwd.value==("")){
    labelAlertcon.innerText="กรุณากรอกรหัสผ่านอีกครั้ง";
    labelAlertcon.style.color="#ff5252";
  }else if(regis.con_pwd.value!=regis.pwd.value){
    labelAlertcon.innerText="รหัสผ่านไม่ตรงกัน";
    labelAlertcon.style.color="#ff5252";
  }else{
    labelAlertcon.innerText="รหัสผ่านตรงกัน";
    labelAlertcon.style.color= "#4CAF50";
  }

  }   

// เบอร์โทร //
function checkTel(regis){
    var Tel = /^0[0-9]{9}$/;
    var labelAlertphone  = document.getElementById("alertTelNum");
    if(regis.tel.value==("")){
      labelAlertphone.innerText="กรุณากรอกเบอร์โทรศัพท์";
      labelAlertphone.style.color="#ff5252";
      }
      else if(!regis.tel.value.match(Tel)){
        labelAlertphone.style.color="#ff5252";
        labelAlertphone.innerText="กรุณากรอกเบอร์โทรศัพท์ตัวเลข 10 ตัวเลขและต้องขึ้นต้นด้วย 0 เท่านั้น";
        
        regis.tel.value = "";
      }
      else{
        labelAlertphone.innerText="สามารถใช้เบอร์โทรศัพท์นี้ได้";
        labelAlertphone.style.color= "#4CAF50";
      }
    }  

// วันเกิด //
    function checkBirth(regis){
        var today = new Date;
        today.setHours(0,0,0,0);
        alertBirth = document.getElementById("alertBirth");
    
        var date = new Date(regis.birthdate.value)
        if(regis.birthdate.value==""){
          alertBirth.innerText="กรุณากรอก วัน/เดือน/ปี";
        }
        else if(date >=today) {
          alertBirth.innerText="วัน/เดือน/ปี ต้องไม่ใช่ปัจจุบันหรืออนาคต";
            regis.birthdate.value= ""
        }
    }
    
 


// ที่อยู่ //
function checkAddrss(regis){
    var Addrss = /^[0-9\/]{1,9}$/;
    var labelAlertadd  = document.getElementById("alertAD1");
    if(regis.address.value==("")){
      labelAlertadd.innerText="กรุณากรอกบ้านเลขที่";
      labelAlertadd.style.color="#ff5252";
      }
      else if(!regis.address.value.match(Addrss)){
        labelAlertadd.style.color="#ff5252";
        labelAlertadd.innerText="กรุณากรอกบ้านเลขที่ที่มีความยาวตั้งแต่ 1 – 9 ตัวอักษร เท่านั้น";
        
        regis.address.value = "";
      }
      else{
        labelAlertadd.innerText="สามารถใช้บ้านเลขที่นี้ได้";
        labelAlertadd.style.color= "#4CAF50";
      }
    } 

// ตำบล //
function checkSub_districts(regis){
    var Sub_districts = /^[ก-์]{3,50}$/;
    var labelAlertadd8  = document.getElementById("alertsubD");
    if(regis.sub_districts.value==("")){
        labelAlertadd8.innerText="กรุณากรอกตำบล";
        labelAlertadd8.style.color="#ff5252";
      }
      else if(!regis.sub_districts.value.match(Sub_districts)){
        labelAlertadd8.style.color="#ff5252";
        labelAlertadd8.innerText="กรุณากรอกตำบลเป็นตัวอักษรภาษาไทยเท่านั้น";
        
        regis.sub_districts.value = "";
      }
      else{
        labelAlertadd8.innerText="สามารถใช้ตำบลนี้ได้";
        labelAlertadd8.style.color= "#4CAF50";
      }
    }  

 // อำเภอ //
function checkDistricts(regis){
    var Districts = /^[ก-์]{3,50}$/;
    var labelAlertadd9  = document.getElementById("alertDist");
    if(regis.districts.value==("")){
        labelAlertadd9.innerText="กรุณากรอกอำเภอ";
        labelAlertadd9.style.color="#ff5252";
      }
      else if(!regis.districts.value.match(Districts)){
        labelAlertadd9.style.color="#ff5252";
        labelAlertadd9.innerText="กรุณากรอกอำเภอเป็นตัวอักษรภาษาไทยเท่านั้น";
        
        regis.districts.value = "";
      }
      else{
        labelAlertadd9.innerText="สามารถใช้อำเภอนี้ได้";
        labelAlertadd9.style.color= "#4CAF50";
      }
    }  

// จังหวัด //
    function checkProvince(regis){
        var Province = /^[ก-์]{3,50}$/;
        var labelAlertadd10  = document.getElementById("alertProvince");
        if(regis.province.value==("")){
            labelAlertadd10.innerText="กรุณากรอกจังหวัด";
            labelAlertadd10.style.color="#ff5252";
          }
          else if(!regis.province.value.match(Province)){
            labelAlertadd10.style.color="#ff5252";
            labelAlertadd10.innerText="กรุณากรอกจังหวัดเป็นตัวอักษรภาษาไทยเท่านั้น";
            
            regis.province.value = "";
          }
          else{
            labelAlertadd10.innerText="สามารถใช้จังหวัดนี้ได้";
            labelAlertadd10.style.color= "#4CAF50";
          }
        }      

// รหัสไปรษณีย์ //
    function checkPost_code(regis){
        var Post_code = /^[0-9]{5}$/;
        var labelAlertadd11  = document.getElementById("alertPostCode");
        if(regis.post_code.value==("")){
            labelAlertadd11.innerText="กรุณากรอกรหัสไปรษณีย์";
            labelAlertadd11.style.color="#ff5252";
          }
          else if(!regis.post_code.value.match(Post_code)){
            labelAlertadd11.style.color="#ff5252";
            labelAlertadd11.innerText="กรุณากรอกรหัสไปรษณีย์เป็นตัวเลข 5 ตัวให้ถูกต้อง";
            
            regis.post_code.value = "";
          }
          else{
            labelAlertadd11.innerText="สามารถใช้รหัสไปรษณีย์นี้ได้";
            labelAlertadd11.style.color= "#4CAF50";
          }
        }   

      
    
// รหัสนักศึกษา //
function checkStuid(regis){
    var Stuid = /^[0-9]{10}$/;
    var labelAlertadd12  = document.getElementById("alertStuID");
    if(regis.stuid.value==("")){
        labelAlertadd12.innerText="กรุณากรอกรหัสนักศึกษา";
        labelAlertadd12.style.color="#ff5252";
      }
      else if(!regis.stuid.value.match(Stuid)){
        labelAlertadd12.style.color="#ff5252";
        labelAlertadd12.innerText="กรุณากรอกรหัสนักศึกษาเป็นตัวเลข 10 ตัวเลขเท่านั้น";
        
        regis.stuid.value = "";
      }
      else{
        labelAlertadd12.innerText="สามารถใช้รหัสนักศึกษานี้ได้";
        labelAlertadd12.style.color= "#4CAF50";
      }
    } 
    
    
    // select option คณะ/วิทยาลัยที่สังกัด//
function checkFac(regis){
  var labelAlertFac  = document.getElementById("alertFac");
  if(regis.faculty.value==("")){
    labelAlertFac.innerText="กรุณาเลือกคณะ/วิทยาลัยที่สังกัด";
    labelAlertFac.style.color="#ff5252";
  }
  else{
    labelAlertFac.innerText="";
    labelAlertFac.style.color= "#4CAF50";
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
  
  
  
//Script รูปบัตรนักศึกษา //
function uploadStu_pic(regis) { 
  const  labelAlertStu_pic = document.getElementById("alertstupic");
  if(regis.stu_pic.value==("")){
	  labelAlertStu_pic.innerText="กรุณาใส่รูปบัตรนักศึกษา";
	  labelAlertStu_pic.style.color="#ff5252";
    }
    else{
    	labelAlertStu_pic.innerText="สามารถใช้รูปบัตรนักศึกษานี้ได้";
    	labelAlertStu_pic.style.color= "#4CAF50";
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
    