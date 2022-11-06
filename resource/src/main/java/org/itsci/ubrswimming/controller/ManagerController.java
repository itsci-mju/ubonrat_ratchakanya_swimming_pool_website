package org.itsci.ubrswimming.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.itsci.ubrswimming.model.*;
import org.itsci.ubrswimming.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private RequestManager requestm;
	

	@RequestMapping(value="/getReportStat", method=RequestMethod.GET)
	public String getReportStat() {
		return "ReportPoolUsageStatistics";
	}
	
//	@RequestMapping(value="/ReportPoolUsageStatistics", method=RequestMethod.GET)
//	public String ReportPoolUsageStatistics(HttpServletRequest request,HttpSession session) {
//		return "ReportPoolUsageStatistics";
//	}
//	    
//	@RequestMapping(value="/getSumPrice", method=RequestMethod.GET)
//	public String getSumPrice() {
//		return "ReportPoolUsageStatistics";
//	}
//	
//	@RequestMapping(value="/getSumAmount", method=RequestMethod.GET)
//   	public String getSumAmount() {
//   		return "ReportPoolUsageStatistics";
//   	}  เดี๋ยวมาลบ หาก่อนว่าใช้หน้าไหนบ้าง 
	

	@RequestMapping(value="/make_event", method=RequestMethod.GET)
	public String make_event() {
		return "make_event";
	}
	
	@RequestMapping(value="/view_request", method=RequestMethod.GET)
	public String view_request(HttpServletRequest request,HttpSession session) {
		String pid =request.getParameter("id");
		session.setAttribute("idrequest", pid);
		return "view_request";
	}
	
	@RequestMapping(value="/approve_request", method=RequestMethod.GET)
	public String approve_request(HttpServletRequest request,HttpSession session) {
		int r = -1;
	
		String pid =request.getParameter("id");

        r = requestm.acceptReservation(pid);
        
        request.setAttribute("resultApprove", r);

		return "manage_form";
	}
	
	
    @RequestMapping(value="/deleteReservations",method=RequestMethod.GET)
    public String deleteReservations (HttpServletRequest request,HttpSession session) {
        int r = -1;
        String rpid =request.getParameter("id");
        r = requestm.deleteReservation(rpid);
        request.setAttribute("resultCancel", r);

        return "manage_form";
    }
}
