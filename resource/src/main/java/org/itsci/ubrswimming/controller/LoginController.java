package org.itsci.ubrswimming.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.itsci.ubrswimming.model.*;
import org.itsci.ubrswimming.util.*;

@Controller
public class LoginController {

	@RequestMapping(value="/isMemberLogin", method=RequestMethod.POST)
	public String isMemberLogin(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		MemberManager mem = new MemberManager();
		Logins log = mem.verifyLoginWEB(email, password);
			session.setAttribute("login", log);
		return "index";
	}
	
	@RequestMapping(value="/dologout", method=RequestMethod.GET)
	public String dologout(HttpServletRequest request,HttpSession session) {
			session.removeAttribute("login");
		return "index";
	}
}
