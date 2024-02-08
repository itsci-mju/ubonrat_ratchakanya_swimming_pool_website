<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PrintMemberCard</title>
</head>
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400" rel="stylesheet">


<body align="center">

<%@ include file="header.jsp" %>
	<%
		Login l = (Login) session.getAttribute("login");
		String mid = (String) request.getAttribute("midjame");
	
		
		ListRegisteredMemberManager rsm = new ListRegisteredMemberManager();	
		List<Members> mbs =  rsm.getListPrintMemberCard(mid);
		
		Members mb2 = (Members) request.getAttribute("resultMemberByJameMi");
		
		
		
		//dateforme
 		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
		sdf2.setTimeZone(TimeZone.getTimeZone("GMT+7"));
		//StartCardDate
		String StartCardDate;
		//EndCardDate
		String EndCardDate;
		
		if (mb2.getStartcarddate() == null){
			Calendar scd = Calendar.getInstance(); 
			StartCardDate = sdf2.format(scd.getTime());
			
			Calendar ecd = Calendar.getInstance();
			ecd.add(Calendar.YEAR, 1); 
			
			EndCardDate = sdf2.format(ecd.getTime());  
		}else{
			StartCardDate = sdf2.format(mb2.getStartcarddate().getTime());
			EndCardDate = sdf2.format(mb2.getEndcarddate().getTime());  
		}
	
		
		
	%>
	
	
	 <% for(int i=0 ; i<mbs.size(); i++) { %>
	 
	 
<form name="frm" method="post" action="PrintMemberCard_Submit_update?mid=<%= mid %> &StartCardDate=<%= StartCardDate %>  &EndCardDate=<%= EndCardDate %>" class="fit">
<div class="Wrap">
    <div class="Base">
        <div class="Inner-wrap">

            <!--   Logo SVG -->

            <svg class="Logo" version="1.1" xmlns="http://www.w3.org/2000/svg"
                xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 97.814 97.063"
                style="enable-background:new 0 0 97.814 97.063;" xml:space="preserve">
                <g id="The_x5F_Chase_x5F_Manhattan_x5F_Bank">
                    <path class="Logo" style="fill-rule:evenodd;clip-rule:evenodd;" d="M31.534,0.148c11.888,0.129,20.426,0,32.226,0c1.625,0,3.551-0.332,4.912,0
						c1.078,0.264,2.74,2.468,3.714,3.475C80.6,12.116,89.026,20.218,97.064,28.66c-21.246-0.112-47.055,0.218-65.77-0.12
						c-0.103-8.506-0.225-18.47,0-28.033C31.289,0.302,31.384,0.196,31.534,0.148z" />
                    <path class="Logo" style="fill-rule:evenodd;clip-rule:evenodd;"
                        d="M28.778,66.037c-8.482-0.125-19.476,0.192-28.392-0.119
						c-0.203-8.306-0.12-18.252-0.12-27.674c0-2.727-0.6-6.873,0-9.345c0.19-0.783,2.35-2.674,3.355-3.714
						c8.015-8.298,17.314-16.974,25.038-24.798c0.102-0.023,0.112,0.046,0.119,0.119C28.671,24.725,29.012,43.838,28.778,66.037z" />
                    <path class="Logo" style="fill-rule:evenodd;clip-rule:evenodd;"
                        d="M69.39,30.937c9.529,0.098,18.895-0.152,28.033,0.119
						c0.106,9.001,0.204,17.434,0.12,27.314c-0.022,2.579,0.62,6.92,0,9.584c-0.274,1.178-2.454,2.654-3.475,3.714
						c-8.182,8.494-16.734,16.807-24.918,24.679c-0.192-18.602-0.095-42.894-0.12-65.051C69.098,31.123,69.218,31.003,69.39,30.937z" />
                    <path class="Logo" style="fill-rule:evenodd;clip-rule:evenodd;" d="M66.515,68.193c0.309,9.83,0.309,19.073,0,28.513
						c-10.081,0.189-19.016-0.092-28.272,0.12c-2.423,0.055-6.684,0.57-9.105-0.12c-0.847-0.241-2.667-2.308-3.713-3.354
						c-8.051-8.05-16.983-16.943-24.56-24.679c-0.079-0.081-0.112-0.206-0.119-0.359c0.097-0.023,0.119-0.12,0.239-0.12
						C23.242,68.233,44.12,68.237,66.515,68.193z" />
                </g>             
            </svg>

            <!-- Card Chip SVG -->
            <div>
              <h1>บัตรสมาชิกสระว่ายน้ำ</h1>
          </div>
            <div style="text-align:center;">
                <svg id="barcode" viewBox="10 10 1600 190" preserveAspectRatio="xMaxYMax meet"></svg>
            </div>
           
            <div>
                <h3>ชื่อ-สกุล : <%= mb2.getFirstname() %> - <%= mb2.getLastname() %></h3>
            </div>
            <div>
                <h3>วันที่ออกบัตร : <%= StartCardDate %> </h3>
            </div>
            <div>
                <h3>บัตรหมดอายุ : <%= EndCardDate %> </h3>
            </div>
			 <div>
                <td><button type="submit" >ยืนยัน</button></td>
                <td><button type="reset" >ยกเลิก</button></td>          
            </div>
            

        </div>
         <%} %>
    </div>
</div>
</form>
</body>

<style>

/* Shoutout to Maite Rosalie for the gold svg gradient which can be seen here below. */

/* https://codepen.io/maiterosalie/pen/ppRRLV?q=gold+gradient&limit=all&type=type-pens */


html {
    background: #252526;
    font-family: 'Roboto', sans-serif;
    font-weight: 400;
}
.form-control{
    color: none;
    text-align: center;
}

.Wrap {
    display: flex;
    justify-content: center;
    align-items: center;
}

.Base {
    background: #ccc;
    height: 378px;
    width: 595px;
    border-radius: 15px;
}

.Inner-wrap {
    background-color: #0c0014;
    background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='100%25' height='100%25' viewBox='0 0 1600 800'%3E%3Cg %3E%3Cpolygon fill='%230d1838' points='1600%2C160 0%2C460 0%2C350 1600%2C50'/%3E%3Cpolygon fill='%230e315d' points='1600%2C260 0%2C560 0%2C450 1600%2C150'/%3E%3Cpolygon fill='%230f4981' points='1600%2C360 0%2C660 0%2C550 1600%2C250'/%3E%3Cpolygon fill='%231062a6' points='1600%2C460 0%2C760 0%2C650 1600%2C350'/%3E%3Cpolygon fill='%23117aca' points='1600%2C800 0%2C800 0%2C750 1600%2C450'/%3E%3C/g%3E%3C/svg%3E");
    background-size: auto 147%;
    background-position: center;
    position: relative;
    height: 100%;
    width: 100%;
    border-radius: 13px;
    padding: 20px 40px;
    box-sizing: border-box;
    color: #fff;
}

p {
    margin: 0;
    font-size: 1.1em;
}

/* Controls top right logo */

.Logo {
    position: absolute;
    height: 80px;
    width: 80px;
    right: 0;
    top: 0;
    padding: inherit;
    fill: #117aca;
}

/* Controls chip icon */

.Chip {
    height: 80px;
    margin: 40px 0 25px 0;
}

.gold path {
    fill: url(#gold-gradient);
}

svg {
    display: block;
}

/* Controls name size */

.Logo-name {
    transform: scale(.5);
    margin-left: -75px;
}

.Card-number p {
    text-align: center;
}

.Card-number {
    margin-top: -25px;
    display: flex;
    justify-content: center;
    color: rgba(255, 255, 255, 0.9);
}

ul {
    padding: 0;
}

ul li {
    list-style: none;
    float: left;
    margin: 0px 10px;
    font-size: 1.1em;
}

#first-li {
    margin-left: 0;
}

#last-li {
    margin-right: 0;
}

.Expire {
    font-size: .75em;
    text-align: center;
}

.Expire h4 {
    font-weight: 400;
    color: #aaa;
    margin: 0;
    /*   word-spacing: 9999999px; */
    text-transform: uppercase;
}

.Expire p {
    font-size: 1.55em;
    color: rgba(255, 255, 255, 0.9);
}

.Name h3 {
    position: absolute;
    bottom: 0;
    left: 18%;
    text-transform: uppercase;
    font-weight: 400;
    font-size: 1.35em;
    color: rgba(255, 255, 255, 0.85);
}

.Visa {
    width: 115px;
    position: absolute;
    bottom: -145px;
    right: 0;
    padding: inherit;
}

.center {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 50%;
}



</style>
</html>