package org.itsci.ubrswimming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewMemberProfileController {

	@RequestMapping(value="/view_member_profile", method=RequestMethod.GET)
	public String memberprofile() {
		return "view_member_profile";
	}
}
