package org.itsci.ubrswimming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QrcodeController {
	
	 @RequestMapping(value="/qrcode", method=RequestMethod.GET)
	   	public String getqrcode() {
	   		return "qrcode";
	   	}

}
