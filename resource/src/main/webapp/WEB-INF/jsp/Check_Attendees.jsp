<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="css/original.css">


</head>
<body>

<% 


	String mid = request.getParameter("mid");
	String register_courses_id = request.getParameter("cid"); 
	String name = request.getParameter("cname"); 
	String learncount = request.getParameter("learncount");
	String missclass = request.getParameter("missclass");
	
%>


<h2 align="center">บันทึกการเข้าเรียนของนักเรียนว่ายน้ำ</h2>
<form name="frm" method="post" action="Check_AttendeesABC?register_courses_id=<%= register_courses_id %>"  class="fit">
																			
																			
																			
<table>
<tr>
	<div>
		<input type="text" value="<%= register_courses_id %>" id="register_courses_id" name="register_courses_id" readonly>
	</div>
</tr>

  <tr>
    <th width="1100px">ชื่อ</th>
    <th width="100px">มาเรียน</th>
    <th width="100px">ชั่วโมง</th>
	  <th width="100px">ขาดเรียน</th>
    <th width="100px">กี่ครั้ง</th>
  </tr>
  <div>
    <tr>
      <td><input type="text" value="<%= name %>" id="name" name="name" readonly></td>
      <td><a onclick="alertAccept()"><div type="button" class="button-17" role="button" id="approve" name="approve">&nbsp;<i class="bi bi-check-lg"></i></div></a><br></td>
      <td> <input type="text" value="<%= learncount %>"  id="text1" name="text1">	</td>
      <td><a onclick="alertCencel()"><button type="button" class="button-18"  role="button" id="cancel" name="cancel">&nbsp;<i class="bi bi-x-lg"></i></button></a><br></td>
      <td> <input type="text" value="<%= missclass %>" id="text2" name="text2">	</td>
    </tr>
  </div>
</table>
  <div align="center">
    <button type="submit" value="Submit" id="submitbro"  class="button button3">Submit</button>
  </div>
  </form>
</body>


<script>



    var Approve = function(){
      var  clicks = parseInt(document.getElementById("text1").value);
      if (clicks == 10 ){
        clicks = 10;
        document.getElementById("text1").value = clicks;
        
       
        
      }else if (clicks <10 ){
        clicks+=1;
        document.getElementById("text1").value = clicks;
        
       
      }
      if(clicks == 10){
        clicks = 10;
        document.getElementById("approve").style.visibility = "hidden";
        document.getElementById("cancel").style.visibility = "hidden";
        

      }
    }


    var clicksx = 0;
        document.getElementById("text2").innerHTML = clicksx;
    var Cencel = function(){
      if (clicksx < 2){
        clicksx+=1;
        document.getElementById("text2").value = clicksx;
      } else if  (clicksx = 3){
        document.getElementById("text1").value++;
        clicksx = 0;
        document.getElementById("text2").value = clicksx;
      }
      if(document.getElementById("text1").value == 10){
        document.getElementById("text1").value = 10;

        document.getElementById("approve").style.visibility = "hidden";
        document.getElementById("cancel").style.visibility = "hidden";
      }
   
      // if(document.getElementById("text2") = 3){
      //   text1+1
      // }
    }

  function alertAccept() {
      let text = "ท่านต้องการเพิ่มเวลาชั่วโมงหรือไม่";
  if (confirm(text) == true) {
    Approve();
  } 
}
function alertCencel() {
      let text = "ท่านต้องการกดปุ่มขาดเรียนหรือไม่";
  if (confirm(text) == true) {
    Cencel();
  } 
}




</script>

<style>

table {
  border-collapse: collapse;
  width: 100%;
  border: 2px solid;
}

th, td {
  text-align: left;
  padding: 8px;
  
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #04AA6D;
  color: rgb(255, 255, 255);
  
}
#text1{
  width: 50px;
}
#text2{
  width: 50px;
}
#submitbro{
  width: 120px;
  height: 50px;
}

</style>
<style type="text/css">
i{
  font-size: 20px;
}
/*button view*/
.button-17 {
  align-items: center;
  appearance: none;
  background-color: #017f3f;
  border-radius: 24px;
  border-style: none;
  box-shadow: rgba(0, 0, 0, .2) 0 3px 5px -1px,rgba(0, 0, 0, .14) 0 6px 10px 0,rgba(0, 0, 0, .12) 0 1px 18px 0;
  box-sizing: border-box;
  color: #fff;
  cursor: pointer;
  display: inline-flex;
  fill: currentcolor;
  font-size: 14px;
  font-weight: 500;
  height: 34px;
  justify-content: center;
  letter-spacing: .25px;
  line-height: normal;
  max-width: 100%;
  overflow: visible;
  padding: 2px 24px;
  position: relative;
  text-align: center;
  text-transform: none;
  transition: box-shadow 280ms cubic-bezier(.4, 0, .2, 1),opacity 15ms linear 30ms,transform 270ms cubic-bezier(0, 0, .2, 1) 0ms;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  width: auto;
  will-change: transform,opacity;
  z-index: 0;
}

.button-17:hover {
  background: #F6F9FE;
  color: #174ea6;
}

.button-17:active {
  box-shadow: 0 4px 4px 0 rgb(60 64 67 / 30%), 0 8px 12px 6px rgb(60 64 67 / 15%);
  outline: none;
}

.button-17:focus {
  outline: none;
  border: 2px solid #4285f4;
}

.button-17:not(:disabled) {
  box-shadow: rgba(60, 64, 67, .3) 0 1px 3px 0, rgba(60, 64, 67, .15) 0 4px 8px 3px;
}

.button-17:not(:disabled):hover {
  box-shadow: rgba(60, 64, 67, .3) 0 2px 3px 0, rgba(60, 64, 67, .15) 0 6px 10px 4px;
}

.button-17:not(:disabled):focus {
  box-shadow: rgba(60, 64, 67, .3) 0 1px 3px 0, rgba(60, 64, 67, .15) 0 4px 8px 3px;
}

.button-17:not(:disabled):active {
  box-shadow: rgba(60, 64, 67, .3) 0 4px 4px 0, rgba(60, 64, 67, .15) 0 8px 12px 6px;
}

.button-17:disabled {
  box-shadow: rgba(60, 64, 67, .3) 0 1px 3px 0, rgba(60, 64, 67, .15) 0 4px 8px 3px;
}
.button-18 {
  align-items: center;
  appearance: none;
  background-color: #d22020;
  border-radius: 24px;
  border-style: none;
  box-shadow: rgba(0, 0, 0, .2) 0 3px 5px -1px,rgba(0, 0, 0, .14) 0 6px 10px 0,rgba(0, 0, 0, .12) 0 1px 18px 0;
  box-sizing: border-box;
  color: #fff;
  cursor: pointer;
  display: inline-flex;
  fill: currentcolor;
  font-size: 14px;
  font-weight: 500;
  height: 34px;
  justify-content: center;
  letter-spacing: .25px;
  line-height: normal;
  max-width: 100%;
  overflow: visible;
  padding: 2px 24px;
  position: relative;
  text-align: center;
  text-transform: none;
  transition: box-shadow 280ms cubic-bezier(.4, 0, .2, 1),opacity 15ms linear 30ms,transform 270ms cubic-bezier(0, 0, .2, 1) 0ms;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  width: auto;
  will-change: transform,opacity;
  z-index: 0;
}

.button-18:hover {
  background: #F6F9FE;
  color: #174ea6;
}

.button-18:active {
  box-shadow: 0 4px 4px 0 rgb(60 64 67 / 30%), 0 8px 12px 6px rgb(60 64 67 / 15%);
  outline: none;
}

.button-18:focus {
  outline: none;
  border: 2px solid #4285f4;
}

.button-18:not(:disabled) {
  box-shadow: rgba(60, 64, 67, .3) 0 1px 3px 0, rgba(60, 64, 67, .15) 0 4px 8px 3px;
}

.button-18:not(:disabled):hover {
  box-shadow: rgba(60, 64, 67, .3) 0 2px 3px 0, rgba(60, 64, 67, .15) 0 6px 10px 4px;
}

.button-18:not(:disabled):focus {
  box-shadow: rgba(60, 64, 67, .3) 0 1px 3px 0, rgba(60, 64, 67, .15) 0 4px 8px 3px;
}

.button-18:not(:disabled):active {
  box-shadow: rgba(60, 64, 67, .3) 0 4px 4px 0, rgba(60, 64, 67, .15) 0 8px 12px 6px;
}

.button-18:disabled {
  box-shadow: rgba(60, 64, 67, .3) 0 1px 3px 0, rgba(60, 64, 67, .15) 0 4px 8px 3px;
}


.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
  </style>
</html>


