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
<link rel="stylesheet" href="css/register.css">
<body id="nonselect">
 <%@ include file="header.jsp" %>
    <div class="content-request">
        <form action="getRequestToUse" method="post" name="frm">
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
                  <input type="text" name="mid" id="mid" hidden="true" readonly value="<%= mb.getLogins().getMembers_id() %>">
              </div>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <div class="form__group field" style="float: left;">
                  <input type="text" class="form__field" placeholder="ชื่อกิจกรรม" name="eventname" id="eventname" style="width: 300px;">
                  <label for="eventname" class="form__label">ชื่อกิจกรรม</label>
              </div>
            </tr>
            <tr>
              <td>
                <div class="form__group field" style="float: left;">
                  <input type="date" class="form__field" placeholder="วันที่เริ่มใช้" name="startdate" id='startdate' required style="width: 150px;">
                  <label for="startdate" class="form__label">วันที่เริ่มใช้</label>
              </div>
              </td>
              <td>
                <div class="request_input_time">
                  <input type="number" class="req_time" placeholder="เวลา" name="starthour" id='starthour' min="0" max="23" value="10" required> <b style="font-size: 20px;">:</b>
                  <input type="number" class="req_time" placeholder="เวลา" name="startminute" id='startminute' min="0" max="59" value="00" required> <label style="font-size: 20px;">น.</label>
              </div>
              </td>
            </tr>
            <tr>
              <td>
                <div class="form__group field" style="float: left;">
                  <input type="date" class="form__field" placeholder="วันที่สิ้นสุดการใช้" name="enddate" id='enddate' required style="width: 150px;">
                  <label for="enddate" class="form__label">วันที่สิ้นสุดการใช้</label>
              </div>
              </td>
              <td>
                <div class="request_input_time">
                  <input type="number" class="req_time" placeholder="เวลา" name="endhour" id='endhour' min="0" max="23" value="10" required> <b style="font-size: 20px;">:</b>
                  <input type="number" class="req_time" placeholder="เวลา" name="endminute" id='endminute' min="0" max="59" value="00" required> <label style="font-size: 20px;">น.</label>
              </div>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <div class="request_input"> 
                  <label for="detail" style="color: #4CAF50;">รายละเอียด</label><br>
                  <textarea name="detail" id="detail" cols="30" rows="10" class="textarea_det"></textarea>
              </div>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                <div class="request_input">
                  <label for="doc" style="color: #4CAF50;">อัปโหลดเอกสาร (ถ้ามี)</label> <br>
                  <input type="file" name="doc" id="doc" class="req_file form-control">
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
<script src="javascript/fc_record.js"></script>
</html>