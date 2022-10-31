package org.itsci.ubrswimming.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MappingController {

	public MappingController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/loginpage", method=RequestMethod.GET)
	public String goto_login() {
		return "login";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/pre_reg", method=RequestMethod.GET)
	public String loadPreReg() {
		return "pre_register";
	}
	
	@RequestMapping(value="/reg_stu", method=RequestMethod.GET)
	public String regstuForm() {
		return "register_student";
	}
	
	@RequestMapping(value="/reg_ofc", method=RequestMethod.GET)
	public String regofcForm() {
		return "register_officer";
	}
	
	@RequestMapping(value="/reg_aln", method=RequestMethod.GET)
	public String regalnForm() {
		return "register_alumni";
	}
	
	@RequestMapping(value="/reg_gmb", method=RequestMethod.GET)
	public String reggmbForm() {
		return "register_general";
	}
	
	@RequestMapping(value="/reg_stf", method=RequestMethod.GET)
	public String regstfForm() {
		return "register_staff";
	}
	
	@RequestMapping(value="/gorequest", method=RequestMethod.GET)
	public String gorequest() {
		return "request_form";
	}
	
	@RequestMapping(value="/gomanageform", method=RequestMethod.GET)
	public String gomanageform() {
		return "manage_form";
	}
	
	@RequestMapping(value="/goRecord_usage", method=RequestMethod.GET)
	public String goRecord_usage() {
		return "record_usage";
	}
	
	@RequestMapping(value="/gocourse_register", method=RequestMethod.GET)
	public String gocourse_register() {
		return "course_register";
	}
	
	@RequestMapping(value="/getReportStat", method=RequestMethod.GET)
	public String getReportStat(HttpServletRequest request,HttpSession session) {
		return "ReportPoolUsageStatistics";
	}
	
	

}
