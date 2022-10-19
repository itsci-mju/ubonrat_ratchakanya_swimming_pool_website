package org.itsci.ubrswimming.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.itsci.ubrswimming.model.*;
import org.itsci.ubrswimming.util.*;

@Controller
public class LoginController {

    @Autowired
    private MemberManager memberManager;

    @RequestMapping(value = "/isMemberLogin", method = RequestMethod.POST)
    public String isMemberLogin(HttpServletRequest request, HttpSession session) {
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");
        Login log = memberManager.verifyLoginWEB(email, password);
        session.setAttribute("login", log);
        return "index";
    }

    @RequestMapping(value = "/dologout", method = RequestMethod.GET)
    public String dologout(HttpServletRequest request, HttpSession session) {
        session.removeAttribute("login");
        return "index";
    }
}
