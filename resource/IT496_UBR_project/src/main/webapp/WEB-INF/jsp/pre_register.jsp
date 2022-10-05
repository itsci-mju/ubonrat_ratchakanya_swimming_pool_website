<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/register.css">
<link rel="stylesheet" href="css/original.css">
<body>
<%@ include file="header.jsp" %>
    <div class="div1">
        <a href="reg_stu">
            <div class="button1" id="student">
            นักศึกษา
            </div>
        </a>
        <a href="reg_ofc">
        <div class="button1" id="officer">
            บุคลากร
        </div>
        </a>
        <a href="reg_aln">
        <div class="button1" id="alumni">
            ศิษย์เก่า
        </div>
        </a>
        <a href="reg_gmb">
        <div class="button1" id="GeneralMember">
            บุคคลภายนอก
        </div>
        </a>
        <a href="reg_stf">
        <div class="button1" id="staff">
            บุคคลากรสระว่ายน้ำ
        </div>
        </a>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>