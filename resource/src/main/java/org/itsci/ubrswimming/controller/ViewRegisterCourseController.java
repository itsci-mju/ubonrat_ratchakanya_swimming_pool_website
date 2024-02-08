package org.itsci.ubrswimming.controller;

import org.itsci.ubrswimming.model.Trainees;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewRegisterCourseController {
	
	
	
	@RequestMapping(value="/ViewRegisterCourse", method=RequestMethod.GET)
	public String ViewRegisterCourse()  {
		return "ViewRegisterCourse";
	}
}
