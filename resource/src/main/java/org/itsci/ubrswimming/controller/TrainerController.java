package org.itsci.ubrswimming.controller;

import javax.servlet.http.HttpServletRequest;

import org.itsci.ubrswimming.util.PromptPayManager;
import org.itsci.ubrswimming.util.TrainerManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TrainerController {

	
	
	@RequestMapping(value="/ViewTeachSchedule", method=RequestMethod.GET)
	public String ViewTeachSchedule() {
		return "ViewTeachSchedule";
	}
	
	
	@RequestMapping(value="/ListCoursesMember", method=RequestMethod.GET)
	public String ListCoursesMember() {
		return "ListCoursesMember";
	}
	
	 @RequestMapping(value="/Check_Attendees", method=RequestMethod.GET)
	   	public String Check_Attendees() {
	   		return "Check_Attendees";
	   	}
	 
	 
	 
	 @RequestMapping(value="/Check_AttendeesABC", method=RequestMethod.POST)
	   	public String getPromptPay(HttpServletRequest  request, Model md) {
		 	String id = request.getParameter("register_courses_id").trim();
		 	String learncount = request.getParameter("text1").trim();
		 	String missclass = request.getParameter("text2").trim();
		 	TrainerManager tn = new TrainerManager();
		 	tn.Update_Check_Attendees(id,learncount,missclass);
		 	
		 	
	   		return "ListCoursesMember";
	   	}
	 
	 @RequestMapping(value="/ViewCourseMemberABC", method=RequestMethod.GET)
	   	public String ViewCourseMember(HttpServletRequest  request) {
		 String id = request.getParameter("couid");
		 System.out.print(id);
		 
		 request.setAttribute("couid", id);
	   		return "ViewCourseMember";
	   	}
	 
}
