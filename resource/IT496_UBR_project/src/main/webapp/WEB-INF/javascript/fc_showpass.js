// login
function showpass() {
    var pwdbox = document.getElementById("pwdbox");
    var ic = document.getElementById("iconeye");
     if (login.show.checked) {
        pwdbox.type = "text";
        ic.className = "bi bi-eye";
    } else {
        pwdbox.type = "password";
        ic.className = "bi bi-eye-slash";
        }
}

function openForm() {
    document.getElementById("myLoginForm").style.display = "block";
  }
  
  function closeForm() {
    document.getElementById("myLoginForm").style.display = "none";
  }

// register
function togglePass(){
    var eye = document.getElementById("eye");
    var pwdbox = document.getElementById("pwd");
    var ic = document.getElementById("iconeye");
    if(eye.checked) {
       pwdbox.type = "text";
       ic.className = "bi bi-eye";
       eye.checked = false;
    }else{
        pwdbox.type = "password";
        ic.className = "bi bi-eye-slash";
        eye.checked = true;
    }
}