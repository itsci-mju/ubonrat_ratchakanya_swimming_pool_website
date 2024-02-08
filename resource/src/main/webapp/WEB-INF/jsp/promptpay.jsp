<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<% 
	String mid = request.getParameter("mid");
	String register_courses_id = request.getParameter("cid"); 

%>

<form method="post" action="PromptPayABC" name="frm">
<div  align="center">
	<div>
		<input type="text" value="<%= register_courses_id %>" id="register_courses_id" name="register_courses_id" readonly>
	</div>

	<div>
		<img src="img/promptpay.jpg">
	</div>
	
	<div>
		<input type="file" class="form-control" name="photo" id="photo" value="" onchange="return OnUploadCheck()" accept=".jpg, .jpeg, .png, .gif" />		
		<input type="text" value="" id="registerphoto" name="registerphoto">
	</div>
	
	  <div class="button-area">  	  
         <input type="submit" value="ยืนยัน" >
        
       </div>
</div>
</form>
 
  <div class="bt1">
    <button  onclick="Checkinput()">อัปโหลด</button>
 </div>
 



<style>
	html{
		background-color: rgb(255 255 255);
	}
	
	.button {
		  background-color: #00CCFF;
		  border: none;
		  color: white;
		  padding: 16px 32px;
		  text-align: center;
		  font-size: 16px;
		  margin: 4px 2px;
		  opacity: 0.6;
		  transition: 0.3s;
		  display: inline-block;
		  text-decoration: none;
		  cursor: pointer;
	}
	.bt1{
         margin-left: 730px;
         margin-right: 500px;
    }
	

	
</style>

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



</script>
</body>
</html>