<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Record Usage</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<style>
  p {
    margin: 0;
  }
</style>
<link rel="stylesheet" href="css/original.css">
<link rel="stylesheet" href="css/staff_content.css">

<body>
  <div class="content-record">
    <form action="doRecordUsage" method="post" name="frm">
      <section id="form_head">
        <div class="content-record-head">
          <input type="radio" name="usetype" id="usetype_m" value="0" checked class="typeselec">
          <label for="usetype_m" class="botton_usetype">สมาชิกเว็บไซต์</label>
          <input type="radio" name="usetype" id="usetype_f" value="1" class="typeselec">
          <label for="usetype_f" class="botton_usetype">บุคคลทั่วไป</label>
          <input type=hidden name="q" value="0">
        </div>
      </section>
      <div class="section_area">
        <div id="content-alert">
          <i class="bi bi-exclamation-circle"></i>
          <span id="content-alert-text"></span>
        </div>
        <section id="member_section">
          <table id="member_w">
            <thead>
              <tr>
                <th class="id">รหัสสมาชิก</th>
                <th class="del">ลบ</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td><input type="text" name="mid0" placeholder="รหัสสมาชิก"></td>
                <td><label class="checkbox"><input type="checkbox"><span class="checkmark"></span></label></td>
              </tr>
            </tbody>
            <tfoot>
              <tr>
                <td>
                  <button type="button" id="add-row-mem" class="add-row" tabindex="0">
                    <i class="bi bi-plus-lg"></i>
                    <span>เพิ่ม</span>
                  </button>
                </td>
                <td>
                  <button type="button" id="del-row-mem" class="del-row" tabindex="0"><i
                      class="bi bi-trash3"></i></button>
                </td>
              </tr>
            </tfoot>
          </table>
        </section>
        <section id="nonmember_section">
          <table id="walkin">
            <thead>
              <tr>
                <th class="type">ประเภทผู้เข้าใช้</th>
                <th class="number">จำนวนผู้เข้าใช้</th>
                <th class="del">ลบ</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>
                  <div class="custom-select">
                    <select name="mtype0" class="sononmem">
                      <option value="1" selected>ผู้ใหญ่</option>
                      <option value="2">เด็ก</option>
                      <option value="3">นักศึกษามหาวิทยาลัยแม่โจ้</option>
                      <option value="4">บุคลากรมหาวิทยาลัยแม่โจ้</option>
                      <option value="6">บุตรบุคลากรมหาวิทยาลัยแม่โจ้</option>
                    </select>
                  </div>
                </td>
                <td><input type="number" name="numbers0" min="1" step="1"></td>
                <td><label class="checkbox"><input type="checkbox"><span class="checkmark"></span></label></td>
              </tr>
            </tbody>
            <tfoot>
              <tr>
                <td colspan="2">
                  <button type="button" id="add-row-non" class="add-row" tabindex="0">
                    <i class="bi bi-plus-lg"></i>
                    <span>เพิ่ม</span>
                  </button>
                </td>
                <td>
                  <button type="button" id="del-row-non" class="del-row" tabindex="0"><i
                      class="bi bi-trash3"></i></button>
                </td>
              </tr>
            </tfoot>
          </table>
        </section>
        <section id="subbox">
          <input type="submit" value="ยืนยัน" class="btn2submit">
          <input type="reset" value="ยกเลิก" class="btn2reset">
        </section>
      </div>
    </form>
  </div>
</body>
<script src="js/fc_record.js"></script>
</html>