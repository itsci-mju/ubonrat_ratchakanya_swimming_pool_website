package com.springmvc.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.*;
import util.*;


@Controller
public class registerController {

	public registerController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// --> Student Register form
	// --> สมัคครสมาชิกของนักศึกษา
	/*
	@RequestMapping(value="/doRegister_student", method=RequestMethod.POST)
	public ModelAndView doRegister_student(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 int message = 0; 
	 ModelAndView mav = new ModelAndView("login"); 
	 if (ServletFileUpload.isMultipartContent(request)) { 
	 try { 
	 List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request); 
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		String birthdate = request.getParameter("birthdate");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String sub_districts = request.getParameter("sub_districts");
		String districts = request.getParameter("districts");
		String province = request.getParameter("province");
		String post_code = request.getParameter("post_code");
		String pwd = request.getParameter("pwd");
		String per_pic = request.getParameter("per_pic");
		String stu_pic = request.getParameter("stu_pic");
		String stuid = request.getParameter("stuid");
		String faculty = request.getParameter("faculty");
	 members mb = new members("", fname, lname, gender, tel, birthdate, "นักศึกษา", address, "", "", "", per_pic, stuid, faculty, stu_pic, "", "", "", "", "");
	 logins log = new logins(email, pwd, 1, "");
	 
	 
	 
			 /*
			 members(String member_id, String firstname, String lastname, int gender, String phone, String birthdate,
				String member_type, String address, String pid, String emergency_name, String emergency_phone, String image,
				String stuid, String faculty, String stu_card, String affliation, String officer_card, String marriage_cer,
				String pid_card, String alumni_card);  */
	/*
	 siteManager mm = new siteManager(); 
	 loginbean log = new loginbean(uname,pwd,3,0);
	 mm.insertLogin(log);
	 message =  (mm.insertCanteen(ct));
	 String   path = request.getSession().getServletContext().getRealPath("/")+"\\WEB-INF/images";
	 data.get(7).write(new File(path + File.separator + image))
	 } catch (Exception e) { 
		 e.printStackTrace(); 
		 
		 } 
		 } 
		 
		 mav.addObject("message", message); 
		 return mav; 
		 }
	*/
	@RequestMapping(value="/testVerifyEmail", method=RequestMethod.GET)
	public String testVerifyEmail() {
	
		return "testVerifyEmail";
	}
	
	@RequestMapping(value="/verifyEmail", method=RequestMethod.POST)
	public String verifyEmail(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String email = request.getParameter("email");
		registerManager mm = new registerManager();
		Boolean result = mm.verifyEmail(email);
		session.removeAttribute("message");
		if(result) {
			session.setAttribute("message", "อีเมลนี้เคยถูกใช้งานแล้ว");
			session.setMaxInactiveInterval(200);
		}else {
			session.setAttribute("message", "ใช้ได้");
			session.setMaxInactiveInterval(200);
		}
		return "pre_register";
	}
	
	@RequestMapping(value="/doRegister_student", method=RequestMethod.POST)
	public String doRegister_student(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar birthdate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		String gender ="";
		String g ="";
		 if(request.getParameter("gender").equalsIgnoreCase("male")) {
			 gender = "ชาย";
			 g="1";
		 }else {
			 gender = "หญิง";
			 g="0";
		 }
		 
		 String tel = request.getParameter("tel");
		 
		 String bd = request.getParameter("birthdate");
		 String date[] = bd.split("-");
		 		birthdate.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date[2]));
		 		
		 String email = request.getParameter("email");
		 String pwd = request.getParameter("pwd");
		 String address = request.getParameter("address");
		 String sub_districts = request.getParameter("sub_districts");
		 String districts = request.getParameter("districts");
		 String province = request.getParameter("province");
		 String post_code = request.getParameter("post_code");
		 String per_pic = request.getParameter("per_pic");
		 String stu_pic = request.getParameter("stu_pic");
		 String stuid = request.getParameter("stuid");
		 String faculty = request.getParameter("faculty");
		 int mType = 1;
		 
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "1"+g+"0"+Long.toString(unix);
		 logins log = new logins(email,pwd,1,mid);
		 members mb = new members(log,fname,lname,gender
				 				,tel,birthdate, mType
				 				,address+"_"+sub_districts+"_"+districts+"_"+province+"_"+post_code
				 				,"","",""
				 				,per_pic,stuid,faculty
				 				,stu_pic,"","","","","");
		 
		 registerManager mm = new registerManager();
		 mm.insertLogins(log);
		 mm.insertMembers(mb);
		 
		 session.setAttribute("message", "สมัคครสมาชิกเสร็จสิ้น รอการอนุมัติ");
		return "index";
	}
	
	@RequestMapping(value="/doRegister_officer", method=RequestMethod.POST)
	public String doRegister_officer(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar birthdate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        
        
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		String gender ="";
		String g ="";
		 if(request.getParameter("gender").equalsIgnoreCase("male")) {
			 gender = "ชาย";
			 g="1";
		 }else {
			 gender = "หญิง";
			 g="0";
		 }
		 
		 String tel = request.getParameter("tel");
		 
		 String bd = request.getParameter("birthdate");
		 String date[] = bd.split("-");
		 		birthdate.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date[2]));
		 		
		 String email = request.getParameter("email");
		 String pwd = request.getParameter("pwd");
		 String address = request.getParameter("address");
		 String sub_districts = request.getParameter("sub_districts");
		 String districts = request.getParameter("districts");
		 String province = request.getParameter("province");
		 String post_code = request.getParameter("post_code");
		 String per_pic = request.getParameter("per_pic");
		 String pid = "identify";
		 String id_cards = request.getParameter("id_cards");
		 String marriage = request.getParameter("marriage");
		 String officer_card = "บัตรข้าราชการ";
		 String affiliation = request.getParameter("affiliation");
		 int mType = 2;
		 
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "2"+g+"0"+Long.toString(unix);
		 logins log = new logins(email,pwd,1,mid);
		 members mb = new members(log,fname,lname,gender
				 				,tel,birthdate,mType
				 				,address+"_"+sub_districts+"_"+districts+"_"+province+"_"+post_code
				 				,pid,"",""
				 				,per_pic,"",""
				 				,"",affiliation,officer_card
				 				,marriage,id_cards,"");
		 
		 registerManager mm = new registerManager();
		 mm.insertLogins(log);
		 mm.insertMembers(mb);
		 session.setAttribute("message", "สมัคครสมาชิกเสร็จสิ้น รอการอนุมัติ");
		return "index";
	}
	
	@RequestMapping(value="/doRegister_alumni", method=RequestMethod.POST)
	public String doRegister_alumni(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar birthdate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        
        
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		String gender ="";
		String g ="";
		 if(request.getParameter("gender").equalsIgnoreCase("male")) {
			 gender = "ชาย";
			 g="1";
		 }else {
			 gender = "หญิง";
			 g="0";
		 }
		 
		 String tel = request.getParameter("tel");
		 
		 String bd = request.getParameter("birthdate");
		 String date[] = bd.split("-");
		 		birthdate.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date[2]));
		 		
		 String email = request.getParameter("email");
		 String pwd = request.getParameter("pwd");
		 String address = request.getParameter("address");
		 String sub_districts = request.getParameter("sub_districts");
		 String districts = request.getParameter("districts");
		 String province = request.getParameter("province");
		 String post_code = request.getParameter("post_code");
		 String per_pic = request.getParameter("per_pic");
		 String pid = "identify";
		 String alumni_card = request.getParameter("alumni_card");
		 int mType = 3;
		 
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "3"+g+"0"+Long.toString(unix);
		 
		 logins log = new logins(email,pwd,1,mid);
		 members mb = new members(log,fname,lname,gender
				 				,tel,birthdate,mType
				 				,address+"_"+sub_districts+"_"+districts+"_"+province+"_"+post_code
				 				,pid,"",""
				 				,per_pic,"",""
				 				,"","",""
				 				,"","",alumni_card);
		 
		 registerManager mm = new registerManager();
		 mm.insertLogins(log);
		 mm.insertMembers(mb);
		 session.setAttribute("message", "สมัคครสมาชิกเสร็จสิ้น รอการอนุมัติ");
		return "index";
	}
	
	@RequestMapping(value="/doRegister_general", method=RequestMethod.POST)
	public String doRegister_general(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar birthdate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        
        
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		String gender ="";
		String g ="";
		 if(request.getParameter("gender").equalsIgnoreCase("male")) {
			 gender = "ชาย";
			 g="1";
		 }else {
			 gender = "หญิง";
			 g="0";
		 }
		 
		 String tel = request.getParameter("tel");
		 String bd = request.getParameter("birthdate");
		 String date[] = bd.split("-");
		 		birthdate.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date[2]));
		 		
		 String email = request.getParameter("email");
		 String pwd = request.getParameter("pwd");
		 String address = request.getParameter("address");
		 String sub_districts = request.getParameter("sub_districts");
		 String districts = request.getParameter("districts");
		 String province = request.getParameter("province");
		 String post_code = request.getParameter("post_code");
		 String per_pic = request.getParameter("per_pic");
		 String pid = "identify";
		 String id_cards = request.getParameter("id_cards");
		 String emn = "emn";
		 String emp = "emp";
		 int mType = 4;
		 
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "4"+g+"0"+Long.toString(unix);
		 
		 logins log = new logins(email,pwd,1,mid);
		 members mb = new members(log,fname,lname,gender
				 				,tel,birthdate,mType
				 				,address+"_"+sub_districts+"_"+districts+"_"+province+"_"+post_code
				 				,pid,emn,emp
				 				,per_pic,"","","","","",""
				 				,id_cards,"");
		 
		 registerManager mm = new registerManager();
		 mm.insertLogins(log);
		 mm.insertMembers(mb);
		 session.setAttribute("message", "สมัคครสมาชิกเสร็จสิ้น รอการอนุมัติ");
		return "index";
	}
	
	@RequestMapping(value="/doRegister_staff", method=RequestMethod.POST)
	public String doRegister_staff(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar birthdate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");		
		String gender ="";
		String g ="";
		 if(request.getParameter("gender").equalsIgnoreCase("male")) {
			 gender = "ชาย";
			 g="1";
		 }else {
			 gender = "หญิง";
			 g="0";
		 }
		 
		 String tel = request.getParameter("tel");
		 
		 String bd = request.getParameter("birthdate");
		 String date[] = bd.split("-");
		 		birthdate.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date[2]));
		 		
		 String email = request.getParameter("email");
		 String pwd = request.getParameter("pwd");
		 String address = request.getParameter("address");
		 String sub_districts = request.getParameter("sub_districts");
		 String districts = request.getParameter("districts");
		 String province = request.getParameter("province");
		 String post_code = request.getParameter("post_code");
		 String per_pic = request.getParameter("per_pic");
		 String pid = "รหัสบัตรประชาชน";
		 String id_cards = request.getParameter("id_cards");
		 String officer_card = "บัตรข้าราชการ";
		 String affiliation = request.getParameter("affiliation");
		 int sType = Integer.parseInt(request.getParameter("sType"));
		 
		 int status = 0;
		 int mType = 0;
		 if(sType==(0)){
			 mType = 5;
			 status = 4;
		 }else if(sType==(1)) {
			 mType = 6;
			 status = 3;
		 }else {
			 mType=0;
		 }
		  
		 
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "2"+g+"0"+Long.toString(unix);
		 
		 logins log = new logins(email,pwd,status,mid);
		 members mb = new members(log,fname,lname,gender
				 				,tel,birthdate,mType
				 				,address+"_"+sub_districts+"_"+districts+"_"+province+"_"+post_code
				 				,pid,"",""
				 				,per_pic,"",""
				 				,"",affiliation,officer_card
				 				,"",id_cards,"");
		 
		 registerManager mm = new registerManager();
		 mm.insertLogins(log);
		 mm.insertMembers(mb);
		 session.setAttribute("message", "สมัคครสมาชิกเสร็จสิ้น");
		return "index";
	}
	
}