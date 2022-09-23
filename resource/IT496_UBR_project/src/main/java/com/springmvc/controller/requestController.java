package com.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.logins;
import bean.members;
import bean.pool_reservations;
import util.memberManager;
import util.requestManager;
@Controller
public class requestController {
	
	@RequestMapping(value="/getRequestToUse", method=RequestMethod.POST)
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
		int starthour = Integer.parseInt(request.getParameter("starthour"));
		int startminute = Integer.parseInt(request.getParameter("startminute"));
		String enddate = request.getParameter("enddate");
		int endhour = Integer.parseInt(request.getParameter("endhour"));
		int endminute = Integer.parseInt(request.getParameter("endminute"));
		String detail = request.getParameter("detail");
		String filename = request.getParameter("doc");


		String sdate[] = startdate.split("-");
		 		sd.set(Integer.parseInt(sdate[0]), Integer.parseInt(sdate[1])-1, Integer.parseInt(sdate[2]), starthour, startminute);
		String edate[] = enddate.split("-");
				ed.set(Integer.parseInt(edate[0]), Integer.parseInt(edate[1])-1, Integer.parseInt(edate[2]), endhour, endminute);
				
		logins log = new logins();
			log.setMembers_id(memberid);
		members mb = new members();
			mb.setLogins(log);
		pool_reservations pr = new pool_reservations(0,eventname,sd,ed,detail,0,filename,0,mb);
		requestManager rqm = new requestManager();
		rqm.addRequestToUse(pr);
		return "index";
	}
	
	@RequestMapping(value="/doRecordUsage", method=RequestMethod.POST)
	public String recordUsageService(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
		
		String mid = request.getParameter("mid");
		
		Calendar time = Calendar.getInstance();
		int usage_t = Integer.parseInt(request.getParameter("usetype"));
		String coupon = "";
		int adult = Integer.parseInt(request.getParameter("adult"));
		int child = Integer.parseInt(request.getParameter("child"));
		int amount = adult+child;
		int price = 0;
		// calculate price 
		if (usage_t==0) {
			memberManager mm = new memberManager();
			int t = mm.getmember(mid).getMember_type();
			price=0;
		}else {
			price=(child*30)+(adult*50);
		}
			
		return "record_usage";
	}
}
