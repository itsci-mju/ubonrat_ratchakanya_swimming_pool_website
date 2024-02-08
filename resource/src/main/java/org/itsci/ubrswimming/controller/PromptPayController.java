package org.itsci.ubrswimming.controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.itsci.ubrswimming.util.PromptPayManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@MultipartConfig
public class PromptPayController {

		 @RequestMapping(value="/promptpay", method=RequestMethod.GET)
		   	public String getpromptpay() {
		   		return "promptpay";
		   	}
		 
		 
		 @RequestMapping(value="/PromptPayABC", method=RequestMethod.POST)
		   	public String getPromptPay(HttpServletRequest  request, Model md) {
			 	String img = request.getParameter("registerphoto");
			 	String id = request.getParameter("register_courses_id");
			 	PromptPayManager pm = new PromptPayManager();
			 	int r = pm.UpdateImg(id,img);
			 	
		   		return "ViewRegisterCourse";
		   	}
	 
}
