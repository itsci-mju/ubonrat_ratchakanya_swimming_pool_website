package org.itsci.ubrswimming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BarcodeController {

	 @RequestMapping(value="/barcode", method=RequestMethod.GET)
	   	public String getbarcode() {
	   		return "barcode";
	   	}
	    
}
