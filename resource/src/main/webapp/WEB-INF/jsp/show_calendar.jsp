<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<%@ include file="header.jsp" %>
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
			<div id="calendar" ></div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="src/mini-event-calendar.js"></script>

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
</body>


<style>



	.mini-cal{
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;

    font-family: Verdana, sans-serif;
    padding-bottom: 1.2em;
    background: #22252e;
    color: #fff;
    
}




#calTitle{
    display: flex;
    justify-content: space-between;
    -ms-align-items: center;
    align-items: center;
    font-size: 1.12em;
    text-align: center;
    padding: 0.4em 1em;
    padding-top: 0.8em;
}

#calTitle button{
    outline: none;
    display: block;
    border: 0.1em solid #ddd;
    border: none;
    padding: 0;
    width: 40px;
    height: 40px;
    line-height: 60px;
    border-radius: 50%;
    background-color: rgba(0, 0, 0, 0.1);
}

#calTitle button svg{
    width: 30px;
    height: 30px;
}

#calTitle button:hover{
    background: rgba(255,255,255,0.1);
}

#calThead, #calTbody{
    display: flex;
    flex-wrap: wrap;
    padding: 0.1em;
}

#calThead{
    color: #fff;
    margin-top: 0.4em;
    align-items: center;
    text-align: center;
    font-size: 0.88em;
}

#calThead > div, #calTbody .a-date{
    box-sizing: border-box;
    flex: 1;
    min-width: calc(100% / 7);
    max-width: calc(100% / 7);
    width: calc(100% / 7);
    text-align: center;
    padding: 0;
}

#calThead > div{
    font-size: 1.1em;
    padding: 0.2em 0.2em;
}

#calTbody{
    color: #ddd;
}

#calTbody .a-date > span{
    display: block;
    font-size: 1em;
}

#calTbody .a-date{
    cursor: default;
    padding: 0;
    position: relative;
    background-color: transparent;
    color: inherit;
    padding: 1em;
    border: 0.1em solid transparent;
    outline: none;
    font-size: 0.9em;
}

#calTbody .a-date.blurred{
    opacity: 0.5;
    pointer-events: none;
}
/*จุดสีที่ mark*/
#calTbody .a-date.event:before{
    content: '';
    position: absolute;
    top: 0.2em;
    right: 0;
    left: 0;
    margin: auto;
    background-color: #23ff40;
    width: 0.3em;
    height: 0.3em;
    border-radius: 50%;
}

#calTbody .a-date.current{
    border-color: #fffc23;
    outline: none;
    outline: 0;
}

#calTbody .a-date.focused,
#calTbody .a-date:active{
    background: #3f4042;
}

#calTbody .a-date.current.event.focused{
    background-color: #fffc23;
    color: #000;
}

#calTFooter{
    display: flex;
    justify-content: space-between;
    -ms-align-items: center;
    align-items: center;
    font-size: 1.1em;
    padding: 0 1em;
    margin-top: 0.5em;
}

#calTFooter #calLink{
    font-size: 0.8em;
    display: inline-block;
    padding: 0.6em 0.8em;
    flex-shrink: 0;
    text-decoration: none;
    color: #fffc23;
}

#calTFooter #calLink:hover{
    background-color: #555;
}

#calTFooter #eventTitle{
    margin: 0;
    margin-right: 0.1em;
    font-weight: normal;
    font-size: 0.95em;
    white-space: nowrap;
    overflow: hidden;
    -ms-text-overflow: ellipsis;
    text-overflow: ellipsis;
}

</style>

<script>
(function( $ ) {
	var calenderTpl = `
		<div id="calTitle">
			<button type="button" class="month-mover prev">
				<svg fill="#FFFFFF" height="30" viewBox="0 0 24 24" width="30" xmlns="http://www.w3.org/2000/svg">
					<path d="M15.41 7.41L14 6l-6 6 6 6 1.41-1.41L10.83 12z"/>
				</svg>
			</button>
			<div id="monthYear"></div>
			<button type="button" class="month-mover next">
				<svg fill="#FFFFFF" height="30" viewBox="0 0 24 24" width="30" xmlns="http://www.w3.org/2000/svg">
					<path d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"/>
				</svg>
			</button>
		</div>
		<div>
			<div id="calThead"></div>
			<div id="calTbody"></div>
		</div>
		<div id="calTFooter">
			<h3 id="eventTitle">ไม่มีกิจกรรมในวันนี้</h3>
		</div>
	`;
	var weekDaysFromSunday = '<div>S</div><div>M</div><div>T</div><div>W</div><div>T</div><div>F</div><div>S</div>';
	var weekDaysFromMonday = '<div>M</div><div>T</div><div>W</div><div>T</div><div>F</div><div>S</div><div>S</div>';
	var shortMonths = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul","Aug", "Sep", "Oct", "Nov", "Dec"];

    $.fn.miniEventCalendar = $.fn.MEC = function(options) {
    	var settings = $.extend({
			calendar_link : "",
    		events: [],
			from_monday: false,
			onMonthChanged: null
        }, options );

		var miniCalendar = this;

        miniCalendar.addClass('mini-cal').html(calenderTpl);

		var thead = miniCalendar.find("#calThead");
		var tbody = miniCalendar.find("#calTbody");
		var calTitle = miniCalendar.find("#monthYear");
		var calFooter = miniCalendar.find("#calTFooter");
        var eventTitle = miniCalendar.find("#eventTitle");


		var today = new Date();
		var curMonth = today.getMonth();
		var curYear = today.getFullYear();

        eventTitle.text("ไม่มีกิจกรรมในวันนี้");


		if(settings.from_monday)
			thead.html(weekDaysFromMonday);
		else
			thead.html(weekDaysFromSunday);

		if(!settings.calendar_link.length && !settings.events.length)
			calFooter.css("display", "none");

		miniCalendar.find(".month-mover").each(function(){
			var mover = $(this);
			mover.bind("click", function(e){
				e.preventDefault();
				if(mover.hasClass("next"))
					viewNextMonth();
				else
					viewPrevMonth();
			});
		});

		miniCalendar.on("click touchstart", ".a-date", function(e){
			e.preventDefault(); 
			$(".a-date").removeClass('focused');
		    if(!$(this).hasClass('blurred')){
				showEvent($(this).data('event'));
				$(this).focus();
				$(this).addClass('focused');
			}
		});

		function populateCalendar(month, year, onInit) {
			tbody.html("");
			calTitle.text(shortMonths[month] + " " + year);
			eventTitle.text("สามารถดูกิจกรรมได้ตามวันที่");



			curMonth = month;
			curYear = year;

			var ldate = new Date(year, month);
			var dt = new Date(ldate);
			var weekDay = dt.getDay();

			if(settings.from_monday)
				weekDay = dt.getDay() > 0 ? dt.getDay() - 1 : 6;

			if(ldate.getDate() === 1)
				tbody.append(lastDaysOfPrevMonth(weekDay));

			while (ldate.getMonth() === month) {
     			dt = new Date(ldate);

     			var isToday = areSameDate(ldate, new Date());
     			var event = null;
     			var eventIndex = settings.events.findIndex(function(ev) {
		     		return areSameDate(dt, new Date(ev.date));
		     	});

		        if(eventIndex != -1){
		        	event = settings.events[eventIndex];

		        	if(onInit && isToday)
		        		showEvent(event);
		        }

     			tbody.append(dateTpl(false, ldate.getDate(), isToday, event, onInit && isToday));

     			ldate.setDate(ldate.getDate() + 1);

     			var bufferDays = 43 - miniCalendar.find(".a-date").length;

		        if(ldate.getMonth() != month){
		        	for(var i = 1; i < bufferDays; i++){
						tbody.append(dateTpl(true, i));
					}
				}
			}
			 
			if(settings.onMonthChanged){
				settings.onMonthChanged(month, year);
			}
 		}

 		function lastDaysOfPrevMonth(day){
 			if(curMonth > 0){
				var monthIdx = curMonth - 1;
				var yearIdx = curYear;
			}
			else{
     			if(curMonth < 11){
     				var monthIdx = 0;
     				var yearIdx = curYear + 1;
     			}else{
     				var monthIdx = 11;
     				var yearIdx = curYear - 1;
     			}
     		}
     		
     		var prevMonth = getMonthDays(monthIdx, yearIdx);
     		var lastDays = "";
        	for (var i = day; i > 0; i--)
     			lastDays += dateTpl(true, prevMonth[prevMonth.length - i]);

        	return lastDays;
 		}

		function dateTpl(blurred, date, isToday, event, isSelected){
			var tpl = "<div class='a-date blurred'><span>"+date+"</span></div>";

			if(!blurred){
				var hasEvent = event && event !== null;
		        var cls = isToday ? "current " : "";
		        cls += hasEvent && isSelected ? "focused " : "";
		        cls += hasEvent ? "event " : "";
		        
		        var tpl ="<button type='button' class='a-date "+cls+"' data-event='"+JSON.stringify(event)+"'><span>"+date+"</span></button>";
			}

			return tpl;
		}

		function showEvent(event){
			if(event && event !== null && event !== undefined){
				eventTitle.text(event.title);

			}else{
				eventTitle.text("ไม่มีกิจกรรมในวันนี้");
			
			}
		}

		function viewNextMonth(){
			var nextMonth = curMonth < 11 ? curMonth + 1 : 0;
			var nextYear = curMonth < 11 ? curYear : curYear + 1;

			populateCalendar(nextMonth, nextYear);
		}

		function viewPrevMonth(){
			var prevMonth = curMonth > 0 ? curMonth - 1 : 11;
			var prevYear = curMonth > 0 ? curYear : curYear - 1;
			
			populateCalendar(prevMonth, prevYear);
		}

		function areSameDate(d1, d2) {
			return d1.getFullYear() == d2.getFullYear()
		        && d1.getMonth() == d2.getMonth()
		        && d1.getDate() == d2.getDate();
		}

		function getMonthDays(month, year) {
			var date = new Date(year, month, 1);
			var days = [];
			while (date.getMonth() === month) {
				days.push(date.getDate());
				date.setDate(date.getDate() + 1);
			}
			return days;
		}

		populateCalendar(curMonth, curYear, true);

        return miniCalendar;
    };
 
}( jQuery ));
</script>


</html>
