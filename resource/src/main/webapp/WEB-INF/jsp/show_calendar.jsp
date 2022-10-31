<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<%@ include file="common/header.jsp" %>
<% 
	JameManager jm = new JameManager();
	List<PoolReservations> prs = jm.getPool_reservationsCalendar();	
	
	  SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy,MM,dd");
     sdf2.setTimeZone(TimeZone.getTimeZone("GMT+7")); 
     
	

    %>
	<!-- Demo Styles -->
	<style>
		html, body{
			margin: 0;
			padding: 0;
			
		}
		/* Just an excuse to use CSS Grid 😊 */
		#wrapper{
			padding: 40px;
			display: grid; 
			grid-gap: 40px; 
			grid-template-columns: 1fr 1fr 1fr;
			margin-left: 540px;
		}

		[id^=calendar],
		[id^=calendar] + h3{
			width: 400px;
		}

		[id^=calendar] + h3{
			text-align: center;
		}

		@media only screen and (max-width: 500px){
			#wrapper{
				padding: 1em;
				display: block;
			}
			[id^=calendar],
			[id^=calendar] + h3{
				width: 100%;
				max-width: 400px;
				margin: 1em auto;
			}

			[id^=calendar] + h3{
				display: block;
				margin-bottom: 2em;
			}
		}
	</style>
</head>
<body>


	<div id="wrapper"  >
		<div>
			<div id="calendar"></div>
		</div>
	</div>

	
</body>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="js/mini-event-calendar.js"></script>

	<script>
		var sameDaylastWeek = new Date().setDate(new Date().getDate() - 7);
		var someDaynextMonth = new Date().setDate(new Date().getDate() + 31);

		
		// All dates should be provided in timestamps
	

	    	var sampleEvents = [
	    		
			<% for(PoolReservations s : prs) { %>

			{
			    title:"<%= s.getEvent_name() %>" ,
			    date: new Date(<%= sdf2.format(s.getStart_time().getTime())%>),
			   
			},
			
			<% } %>		
		];

		$(document).ready(function(){
			$("#calendar").MEC({
				events: sampleEvents
			});

			// Make calendar start on monday
			$("#calendar2").MEC({
				from_monday: true,
				events: sampleEvents
			});
		});
	</script>
<link rel="stylesheet" href="css/mini-event-calendar.css">
</html>
