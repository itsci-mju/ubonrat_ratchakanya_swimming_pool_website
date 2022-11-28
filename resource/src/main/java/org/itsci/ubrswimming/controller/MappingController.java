package org.itsci.ubrswimming.controller;

import org.itsci.ubrswimming.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "common/login";
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
	public String regstuForm(Model model) {
		model.addAttribute("student", new Student());
		return "register_student";
	}
	
	@RequestMapping(value="/reg_ofc", method=RequestMethod.GET)
	public String regofcForm(Model model) {
		model.addAttribute("officer", new Officer());
		return "register_officer";
	}

	@RequestMapping(value="/reg_aln", method=RequestMethod.GET)
	public String regalnForm(Model model) {
		model.addAttribute("alumni", new Alumni());
		return "register_alumni";
	}
	
	@RequestMapping(value="/reg_gmb", method=RequestMethod.GET)
	public String reggmbForm(Model model) {
		model.addAttribute("general", new General());
		return "register_general";
	}
	
	@RequestMapping(value="/reg_stf", method=RequestMethod.GET)
	public String regstfForm(Model model) {
		model.addAttribute("staff", new Staff());
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
	
	@RequestMapping(value="/show_calendar", method=RequestMethod.GET)
   	public String getPool_reservationsCalendar() {
   		return "show_calendar";
   	}
	
	@RequestMapping(value="/gocourse_register_test", method=RequestMethod.GET)
	public String gocourse_register_test() {
		return "course_register";
	}
	

}
