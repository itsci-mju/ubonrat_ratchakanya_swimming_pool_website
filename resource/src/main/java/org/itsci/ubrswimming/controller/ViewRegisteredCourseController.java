package org.itsci.ubrswimming.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itsci.ubrswimming.util.RegisterManager;
import org.itsci.ubrswimming.util.RequestManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewRegisteredCourseController {

	@RequestMapping(value="/ViewRegisteredCourse", method=RequestMethod.GET)
	public String ViewRegisteredCourse()  {
		return "ViewRegisteredCourse";
	}
	
	
	
	@RequestMapping(value="/acceptViewRegisteredCourse", method=RequestMethod.GET)
	public String approve_request(HttpServletRequest request,HttpSession session) {
		int r = -1;
	
		String avr =request.getParameter("id");
		RegisterManager req = new RegisterManager();
        r = req.acceptViewRegisteredCourse(avr);
        request.setAttribute("resultApprove", r);
		return "ViewRegisteredCourse";
	}
	
	
    @RequestMapping(value="/deleteViewRegisteredCourse",method=RequestMethod.GET)
    public String deleteReservations (HttpServletRequest request,HttpSession session) {
        int r = -1;
        String dvr =request.getParameter("id");
        RegisterManager req = new RegisterManager();
        r = req.deleteViewRegisteredCourse(dvr);
        request.setAttribute("resultCancel", r);

        return "ViewRegisteredCourse";
    }
	
}
