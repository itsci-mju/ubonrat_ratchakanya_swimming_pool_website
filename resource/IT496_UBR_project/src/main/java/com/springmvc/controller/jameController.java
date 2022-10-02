package com.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.logins;
import bean.members;
import bean.pool_reservations;
import bean.pool_usage;
import util.jameManager;
import util.requestManager;

@Controller
public class jameController {
	
	
	@RequestMapping(value="/memberprofile", method=RequestMethod.GET)
	public String memberprofile() {
		return "memberprofile";
	}
	
	
	
	@RequestMapping(value="/viewrequesttousepool", method=RequestMethod.GET)
	public String viewrequesttousepool() {
		return "viewrequesttousepool";
	}
	
	
	
	
	@RequestMapping(value="/addMakeEvent", method=RequestMethod.POST)
	public String getRequestToUse(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar sd = Calendar.getInstance();
		Calendar ed = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        
        String memberid = request.getParameter("mid");
        String eventname = request.getParameter("eventname");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");		
		String detail = request.getParameter("detail");
		


		String sdate[] = startdate.split("-");
		 		sd.set(Integer.parseInt(sdate[0]), Integer.parseInt(sdate[1])-1, Integer.parseInt(sdate[2]));
		String edate[] = enddate.split("-");
				ed.set(Integer.parseInt(edate[0]), Integer.parseInt(edate[1])-1, Integer.parseInt(edate[2]));
				
		logins log = new logins();
			log.setMembers_id(memberid);
		members mb = new members();
			mb.setLogins(log);
		pool_reservations pr = new pool_reservations(0, eventname,sd,ed,detail,0, detail, 1, mb);
		
		
		
		requestManager rqm = new requestManager();
		rqm.addRequestToUse(pr);
		return "index";
	}
	
	
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
        requestManager req = new requestManager();
        r = req.acceptReservations(pid);
        
        request.setAttribute("resultApprove", r);

		return "manage_form";
	}
	
	
    @RequestMapping(value="/deleteReservations",method=RequestMethod.GET)
    public String deleteReservations (HttpServletRequest request,HttpSession session) {
        int r = -1;
        String rpid =request.getParameter("id");
        requestManager req = new requestManager();
        r = req.deleteReservations(rpid);
        request.setAttribute("resultCancel", r);

        return "manage_form";
    }
    
    
    
  
    @RequestMapping(value="/ReportPoolUsageStatistics", method=RequestMethod.GET)
	public String ReportPoolUsageStatistics(HttpServletRequest request,HttpSession session) {
    	
		return "ReportPoolUsageStatistics";
	}
    
    
    @RequestMapping(value="/getSumPrice", method=RequestMethod.GET)
	public String getSumPrice() {
		return "ReportPoolUsageStatistics";
	}
    
    
    
    
    @RequestMapping(value="/getSumAmount", method=RequestMethod.GET)
   	public String getSumAmount() {
   		return "ReportPoolUsageStatistics";
   	}
    
    
    
    @RequestMapping(value="/barcode", method=RequestMethod.GET)
   	public String getbarcode() {
   		return "barcode";
   	}
    
    
    
    @RequestMapping(value="/qrcode", method=RequestMethod.GET)
   	public String getqrcode() {
   		return "qrcode";
   	}
    
    
 
    
  
}
