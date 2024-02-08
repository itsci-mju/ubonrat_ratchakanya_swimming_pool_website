package org.itsci.ubrswimming.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itsci.ubrswimming.util.ListRegisteredMemberManager;
import org.itsci.ubrswimming.util.RegisterManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ListRegisteredMemberController {

	
	   @RequestMapping(value="/ListRegisteredMember", method=RequestMethod.GET)
	   	public String ListRegisteredMember() {
	   		return "ListRegisteredMember";
	   	}
	   
	   @RequestMapping(value="/ViewMemberDetail", method=RequestMethod.GET)
	   	public String ViewMemberDetail() {
	   		return "ViewMemberDetail";
	   	}
	   
	   
	   @RequestMapping(value="/acceptViewMemberDetail", method=RequestMethod.GET)
		public String approve_request(HttpServletRequest request,HttpSession session) {
			int r = -1;
		
			String avdt =request.getParameter("id");
			ListRegisteredMemberManager req = new ListRegisteredMemberManager();
	        r = req.acceptViewMemberDetail(avdt);
	        request.setAttribute("resultApprove", r);
			return "ListRegisteredMember";
		}
		
		
	    @RequestMapping(value="/deleteViewMemberDetail",method=RequestMethod.GET)
	    public String deleteReservations (HttpServletRequest request,HttpSession session) {
	        int r = -1;
	        String dvdt =request.getParameter("id");
	        ListRegisteredMemberManager req = new ListRegisteredMemberManager();
	        r = req.deleteViewMemberDetail(dvdt);
	        request.setAttribute("resultCancel", r);

	        return "ListRegisteredMember";
	    }
	  
}
