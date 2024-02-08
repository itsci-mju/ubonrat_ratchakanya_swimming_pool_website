package org.itsci.ubrswimming.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Members;
import org.itsci.ubrswimming.util.EditMemberProfileManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EditMemberProfileController {

	
	@RequestMapping(value="/ViewEditMemberProfile", method=RequestMethod.GET)
	public String ViewEditMemberProfile(HttpServletRequest request, Model md, HttpSession session) {
		String mid = request.getParameter("mid");
		request.setAttribute("mid", mid);
		return "EditMemberProfile";
	}
	

	 @RequestMapping(value="/EditMemberProfile", method=RequestMethod.POST)
	    public String EditMemberProfile(HttpServletRequest request, Model md, HttpSession session) {
	    	try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
	
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			
			String housenumber = request.getParameter("housenumber");
			String sub_area = request.getParameter("sub_area");    
			String area = request.getParameter("area");
	        String province = request.getParameter("province");
	        String zipcode = request.getParameter("zipcode");
	        String tel = request.getParameter("tel");
	     
	        String mid = request.getParameter("mid");

	        
	        String address = housenumber+"_"+sub_area+"_"+area+"_"+province+"_"+zipcode;
	        Members re = new Members(fname,lname,tel,address);
	        EditMemberProfileManager sm = new EditMemberProfileManager();
	        
	 
	        int r = sm.editProfile(re,mid);
	        request.setAttribute("Editresult", r);
	        session.setAttribute("Members", re);
	        return "index";
	      }
}
