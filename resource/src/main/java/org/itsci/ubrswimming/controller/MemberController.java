package org.itsci.ubrswimming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/member")
public class MemberController {

	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String memberprofile() {
		return "member_profile";
	}
	
	@RequestMapping(value="/gocourse_register", method=RequestMethod.GET)
	public String gocourse_register() {
		return "course_register";
	}
	
	@RequestMapping(value="/request_usepool", method=RequestMethod.GET)
	public String viewrequesttousepool() {
		return "viewrequesttousepool";
	}
}
