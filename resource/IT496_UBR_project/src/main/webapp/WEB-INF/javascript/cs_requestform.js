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


    // Script อัพโหลดเอกสาร //
  function uploadFile(regis) { 
    const  labelAlertFile  = document.getElementById("alertfile");
    if(regis.doc.value==("")){
        labelAlertFile.innerText="กรุณาใส่รูปบัตรประชาชน";
        labelAlertFile.style.color="#ff5252";
      }
      else{
        labelAlertFile.innerText="สามารถใช้รูปบัตรประชาชน";
        labelAlertFile.style.color= "#4CAF50";
      }
    }   