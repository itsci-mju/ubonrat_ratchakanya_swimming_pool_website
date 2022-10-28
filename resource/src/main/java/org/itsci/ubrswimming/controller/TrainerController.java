package org.itsci.ubrswimming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TrainerController {

	
	
	@RequestMapping(value="/ViewTeachSchedule", method=RequestMethod.GET)
	public String ViewTeachSchedule() {
		return "ViewTeachSchedule";
	}
	
	
}
