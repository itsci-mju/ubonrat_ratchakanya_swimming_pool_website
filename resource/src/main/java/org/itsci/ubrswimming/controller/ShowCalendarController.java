package org.itsci.ubrswimming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ShowCalendarController {

	   
    @RequestMapping(value="/show_calendar", method=RequestMethod.GET)
   	public String getPool_reservationsCalendar() {
   		return "show_calendar";
   	}
    
}
