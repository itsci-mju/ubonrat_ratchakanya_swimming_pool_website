<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Document</title>
</head>
<body>
<%@ include file="header.jsp" %>
    <div class="slide">
        <img class="img_slide"src="img/Frame2.png">
    </div>
        <div class="back1" >
            <h3 align="center"  class="h3"><b> อัตราค่าบริการลงสระ คนละ 20 บาท/ครั้ง (แสดงบัตรนักศึกษา หรือรหัสนักศึกษา )</b></h3>
            <p class="p1" align="center">
                สมัครสมาชิกคนละ 200 บาท/ปี (ลงสระฟรี 1 ปี)เอกสารที่ใช้ประกอบการสมัครสมาชิกสระฯ
            </p>
            <p  class="p2">
                1. รูปถ่าย ขนาด 1 นิ้ว จำนวน 2 รูป<br>
                2. สำเนาบัตรนศ.หรือสำเนาเอกสารที่แสดงตัวว่าเป็นนศ. ม.แม่โจ้<br>
                วันจันทร์ - วันศุกร์ เปิดเวลา 09.00 – 17.00 น. (เคาน์เตอร์จ่ายเงินปิดเวลา 16.30 น.)<br>
                วันเสาร์ - วันอาทิตย์ เปิดเวลา 09.00 – 19.00 น. (เคาน์เตอร์จ่ายเงินปิดเวลา 18.30 น.)</p>
               
        </div>   
        <div class="back2" align="center">
            <h2 align="center"  class="c1"><b>คอร์สเรียนสระว่ายน้ำ</h2></b></td>
            <table>
               
                <tr>
                    <td>
                        <h3>คอร์เรียนแบบเดี่ยว</h3>
                        <div class="card" style="width:400px">
                        <img class="card-img-top" src="img/img2.jpg" alt="Card image" style="width:100%">
                        <div class="card-body">
                        <h4 class="card-title">ราคา 2,500 / คน</h4>
                        <p class="card-text">เรียน 10 ชั่วโมง สามารถเลือกวันเรียนเองได้</p>
                        <a href="pre_reg" class="btn btn-primary">สมัครเรียน</a>
                        </div>
                        </div>
                    </td>
                    <td >
                        <h3>คอร์เรียนแบบกลุ่ม</h3>
                        <div class="card" style="width:400px">
                        <img class="card-img-top" src="img/1253.jpg" alt="Card image" style="width:100%;height: 224.1px;">
                        <div class="card-body">
                            <h4 class="card-title">ราคา 1,500 / คน</h4>
                            <p class="card-text">แบบกลุ่ม 3 - 5 คน เรียน 10 ชั่วโมง</p>
                            <a href="pre_reg" class="btn btn-primary">สมัครเรียน</a>
                        </div>
                        </div>
                </td>
                </tr> 
        </table>
    </div>  
   
</body>
<style>
    .slide{
        width: 100%;
        height: 100%;
    }
    .img_slide{
        width: 100%;
        height: 500px;
    }
    .back1{
        background-color: #82d5ee;
        height: 276px;
        margin-top: -28px;
    }
    .h3{
        padding-top: 58px;
    }
    .p2{
        margin-left: 468px;
    }
    .back2{
        margin-top: 50px;
        margin-bottom: 80px;
    }
    .tr1{
        margin-bottom: 40px;
    }
    .paragraph{

    width: 100%;
    height: 370px;
    margin-top: 39px;
    display: flex;
    justify-content: center;
    overflow: hidden;
    }
    .p3{
    font-size: 20px;
    float: left;
    margin: 40px;

    }
    .set-img3{
    float: left;
    }
    .img3{
    height: 300px;
    width: 450px;
    margin: 40px;
    margin-left: 60px;
    border-radius: 10px;
    
    }
    .c1{
        margin-bottom: 50px;
    }
   
</style>
</html>