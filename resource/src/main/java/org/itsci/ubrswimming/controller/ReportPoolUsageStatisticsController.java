package org.itsci.ubrswimming.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportPoolUsageStatisticsController {



	  @RequestMapping(value="/ReportPoolUsageStatistics", method=RequestMethod.GET)
		public String ReportPoolUsageStatistics(HttpServletRequest request,HttpSession session) {
			return "ReportPoolUsageStatistics";
		}
	    
	    
	   
	    
}
