<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="css/original.css">
<link rel="stylesheet" href="css/login.css">
<body onload="showpass()" id="nonselect">
    <div class="login-form" align="center">
        <p style="font-size: 26px; color: #1B5E20;">เข้าสู่ระบบ</p>
        <form action="isMemberLogin" method="post" name="login">
            <table style="text-align: center;">
                <tr>
                    <td colspan="2">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control registered" name="email" id="email" placeholder="Email" style="height:35px; ">
                            <label for="floatingInput" class="placeh" style="padding-top: 3px;">Email</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="form-floating">
                            <input type="password" class="form-control registered" name="pwd" id="pwdbox" placeholder="Password"  style="height:35px;">
                            <label for="floatingPassword" class="placeh" style="padding-top: 3px;">Password</label>
                          </div>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: right; float: right;" >
                            <div class="form-check form-switch">
                                <input type="checkbox" name="show" class="form-check-input" onclick="showpass()">
                                <!--<label class="hinttext"> Show Password</label>--><i id="iconeye" class="bi bi-eye-slash"></i>
                            </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="เข้าสู่ระบบ"  class="btnsubmit btnSite">  
                        <input type="reset" value="ยกเลิก" class="btnreset btnSite">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" >
                        <div style="margin-bottom: 15px;"></div>
                        <label class="hinttext">  ยังไม่บัญชี? <a href="pre_reg"><u>สมัครเลย</u></a> </label>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
<script src="js/fc_showpass.js"></script>
</html>