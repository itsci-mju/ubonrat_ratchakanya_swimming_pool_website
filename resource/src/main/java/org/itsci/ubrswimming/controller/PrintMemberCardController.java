package org.itsci.ubrswimming.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.mapping.Set;
import org.itsci.ubrswimming.model.Members;
import org.itsci.ubrswimming.util.ListRegisteredMemberManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrintMemberCardController {
	
	 @RequestMapping(value="/PrintMemberCard", method=RequestMethod.GET)
	   	public String PrintMemberCard(HttpServletRequest request,HttpSession session) {
		 	String mid = request.getParameter("mid"); 
		 	ListRegisteredMemberManager mg = new ListRegisteredMemberManager(); 		 	
			Members mb = mg.ShowIDMember(mid);		
			request.setAttribute("resultMemberByJameMi", mb);
			request.setAttribute("midjame", mid);
			/**/
			Calendar startcarddate = Calendar.getInstance(); 		
			Calendar endcarddate = Calendar.getInstance(); 
			//endcarddate.add(Calendar.YEAR,1);
			
			
			Members mb2 = new Members(startcarddate,endcarddate);		
			mg.editCardTimes(mb2, mid);	
			
			
	   		return "PrintMemberCard";
	   	}
	 
	 
	 	
	 
	 
	 @RequestMapping(value="/PrintMemberCard_Submit_update", method=RequestMethod.POST)
	   	public String PrintMemberCard_Submit_update(HttpServletRequest request,HttpSession session) {
		 	String mid = request.getParameter("mid"); 
	 			 	
		 	Date startcarddate = Calendar.getInstance().getTime(); 
		 	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		 	String strDate = dateFormat.format(startcarddate);
		 	
		 	Calendar endcarddate = Calendar.getInstance();
		 	endcarddate.add(Calendar.YEAR, 1);
		 	Date nextyear = endcarddate.getTime();
		 	
		 	
		 	DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		 	String endDate = dateFormat2.format(nextyear);
		 	
		 	ListRegisteredMemberManager mg = new ListRegisteredMemberManager(); 		 	
	        int r = mg.update_submit_card(strDate ,endDate ,mid);
					
	   		return "ListRegisteredMember";
	   	}
	 
	 
	 

	 
	 
}
