package org.itsci.ubrswimming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ViewRequestToUsePoolController {

	
	@RequestMapping(value="/viewrequesttousepool", method=RequestMethod.GET)
	public String viewrequesttousepool() {
		return "viewrequesttousepool";
	}
}
