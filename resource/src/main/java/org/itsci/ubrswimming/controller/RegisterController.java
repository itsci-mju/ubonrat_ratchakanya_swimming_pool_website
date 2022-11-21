package org.itsci.ubrswimming.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.time.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.itsci.ubrswimming.model.*;
import org.itsci.ubrswimming.util.*;


@Controller
public class RegisterController {
	@Autowired
	private RegisterManager regism;
	
	@RequestMapping(value="/verifyEmail", method=RequestMethod.POST)
	public String verifyEmail(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String email = request.getParameter("email");
		Boolean result = regism.verifyEmail(email);
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
	public String doRegister_student_(@ModelAttribute("student") Student student, Model model) {
		String g ="";
		 if(student.getGender().equalsIgnoreCase("ชาย")) {  
			 g="1";
		 }else {
			 g="0";
		 }

		 String pwd = student.getLogin().getPassword();
		 int mType = 0;
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "1"+g+"0"+Long.toString(unix);
		 
		 BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        String encrypted = bCryptPasswordEncoder.encode(pwd);
		 
	        student.getLogin().setPassword("{bcrypt}" +encrypted);
	        student.getLogin().setStatus(1);
	        student.getLogin().setMember_id(mid);
	        
	        student.setMember_type(mType);
	
	     regism.saveMember(student);
		 
		 model.addAttribute("message", "สมัครสมาชิกสำเร็จ");
		return "index";
	}
	/*
	@RequestMapping(value="/doRegister_officer", method=RequestMethod.POST)
	public String doRegister_officer(HttpServletRequest request,HttpSession session, Model model) {
		Calendar birthdate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		
		String gender ="";
		String g ="";
		 if(request.getParameter("gender").equalsIgnoreCase("male")) {
			 gender = "ชาย";
			 g="1";
		 }else {
			 gender = "หญิง";
			 g="0";
		 }
		 
		 String tel = request.getParameter("phone");
		 
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
		 String per_pic = request.getParameter("image");
		 String pid = request.getParameter("pid");
		 String pid_card = request.getParameter("pid_card");
		 String marriage = request.getParameter("marriage_cer");
		 String officer_card = request.getParameter("officer_card");
		 String affiliation = request.getParameter("affiliation");
		 int mType = 1 ;
		 
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "2"+g+"0"+Long.toString(unix);

		 BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        String encrypted = bCryptPasswordEncoder.encode(pwd);

		 Login log = new Login(email,pwd,1,mid);
		 Member mb = new Member(log,fname,lname,gender
				 				,tel,birthdate,mType
				 				,address,sub_districts,districts,province,post_code
				 				,pid,"",""
				 				,per_pic,"",""
				 				,"",affiliation,officer_card
				 				,marriage,pid_card,"");
		 
		 regism.insertLogins(log);
		 regism.insertMembers(mb);
		 model.addAttribute("message", "สมัครสมาชิกสำเร็จ");
		return "index";
	}
	
	@RequestMapping(value="/doRegister_alumni", method=RequestMethod.POST)
	public String doRegister_alumni(HttpServletRequest request,HttpSession session, Model model) {
		Calendar birthdate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
    
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		
		String gender ="";
		String g ="";
		 if(request.getParameter("gender").equalsIgnoreCase("male")) {
			 gender = "ชาย";
			 g="1";
		 }else {
			 gender = "หญิง";
			 g="0";
		 }
		 
		 String tel = request.getParameter("phone");
		 
		 String bd = request.getParameter("birthdate");
		 String date[] = bd.split("-");
		 		birthdate.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date[2]));
		 		
		 String email = request.getParameter("email");
		 String pwd = request.getParameter("password");
		 String address = request.getParameter("address");
		 String sub_districts = request.getParameter("sub_districts");
		 String districts = request.getParameter("districts");
		 String province = request.getParameter("province");
		 String post_code = request.getParameter("post_code");
		 String per_pic = request.getParameter("image");
		 String pid = request.getParameter("pid");
		 String alumni_card = request.getParameter("alumni_card");
		 
		 int mType = 2;
		 
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "3"+g+"0"+Long.toString(unix);
		 
		  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        String encrypted = bCryptPasswordEncoder.encode(pwd);

		 Login log = new Login(email,encrypted,1,mid);
		 Member mb = new Member(log,fname,lname,gender
				 				,tel,birthdate,mType
				 				,address,sub_districts,districts,province,post_code
				 				,pid,"",""
				 				,per_pic,"",""
				 				,"","",""
				 				,"","",alumni_card);
		 regism.insertLogins(log);
		 regism.insertMembers(mb);
		 model.addAttribute("message", "สมัครสมาชิกสำเร็จ");
		return "index";
	}
	
	@RequestMapping(value="/doRegister_general", method=RequestMethod.POST)
	public String doRegister_general(HttpServletRequest request,HttpSession session, Model model) {
		Calendar birthdate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        
        
		
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		
		String gender ="";
		String g ="";
		 if(request.getParameter("gender").equalsIgnoreCase("male")) {
			 gender = "ชาย";
			 g="1";
		 }else {
			 gender = "หญิง";
			 g="0";
		 }
		 
		 String tel = request.getParameter("phone");
		 
		 String bd = request.getParameter("birthdate");
		 String date[] = bd.split("-");
		 		birthdate.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date[2]));
		 		
		 String email = request.getParameter("email");
		 String pwd = request.getParameter("password");
		 String address = request.getParameter("address");
		 String sub_districts = request.getParameter("sub_districts");
		 String districts = request.getParameter("districts");
		 String province = request.getParameter("province");
		 String post_code = request.getParameter("post_code");
		 String per_pic = request.getParameter("image");
		 String pid = request.getParameter("pid");;
		 String pid_card = request.getParameter("pid_card");
		 String emn = "emn";
		 String emp = "emp";
		 int mType = 3;
		 long b = (long) (birthdate.getTimeInMillis()/(86400000*365.25));
		 long n = (long) ((Calendar.getInstance().getTimeInMillis()-543)/(86400000*365.25));
		 long a = n - b;
		 if(a<13) {
			  mType = 4 ;
		 }
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "4"+g+"0"+Long.toString(unix);

		 BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        String encrypted = bCryptPasswordEncoder.encode(pwd);
		 
		 Login log = new Login(email,encrypted,1,mid);
		 Member mb = new Member(log,fname,lname,gender
				 				,tel,birthdate,mType
				 				,address,sub_districts,districts,province,post_code
				 				,pid,emn,emp
				 				,per_pic,"","","","","",""
				 				,pid_card,"");
	
		 regism.insertLogins(log);
		 regism.insertMembers(mb);
		 model.addAttribute("message", "สมัครสมาชิกสำเร็จ");
		return "index";
	}
	
	@RequestMapping(value="/doRegister_staff", method=RequestMethod.POST)
	public String doRegister_staff(HttpServletRequest request,HttpSession session, Model model) {
		Calendar birthdate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
		
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		
		String gender ="";
		String g ="";
		 if(request.getParameter("gender").equalsIgnoreCase("male")) {
			 gender = "ชาย";
			 g="1";
		 }else {
			 gender = "หญิง";
			 g="0";
		 }
		 
		 String tel = request.getParameter("phone");
		 
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
		 String per_pic = request.getParameter("image");
		 String pid = request.getParameter("pid");
		 String pid_card = request.getParameter("pid_card");
		 String officer_card = request.getParameter("officer_card");
		 String affiliation = request.getParameter("affiliation");
		 int sType = Integer.parseInt(request.getParameter("sType"));
		 
		 int status = 0;
		 int mType = 6;
		 if(sType==(0)){
			//manager
			 mType = 6;
			 status = 4;
		 }else if(sType==(1)) {
			//trainer
			 mType = 5;
			 status = 3;
		 }else {
			 mType= 6;
		 }
		  
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "2"+g+"0"+Long.toString(unix);
		 
		 BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        String encrypted = bCryptPasswordEncoder.encode(pwd);

		 Login log = new Login(email,encrypted,status,mid);
		 Member mb = new Member(log,fname,lname,gender
				 				,tel,birthdate,mType
				 				,address,sub_districts,districts,province,post_code
				 				,pid,"",""
				 				,per_pic,"",""
				 				,"",affiliation,officer_card
				 				,"",pid_card,"");
		 
		 regism.insertLogins(log);
		 regism.insertMembers(mb);
		 model.addAttribute("message", "สมัครสมาชิกสำเร็จ");
		return "index";
	}
	*/
	@RequestMapping(value="/getTimeToCourse", method=RequestMethod.GET)
	public String getTimeToCourse(HttpServletRequest request,HttpSession session, Model model) {
		Calendar now = Calendar.getInstance();
		LocalDate thisDay =LocalDate.now(); // retue BC
		int daytype = Integer.parseInt(request.getParameter("daytype"));
		int learntime = Integer.parseInt(request.getParameter("learntime"));
		
		String reqt = "";
		switch(learntime) {
		case 1:
			reqt = "9:59";
			break;
		case 2:
			reqt = "10:59";
			break;
		case 3:
			reqt = "12:59";
			break;
		case 4:
			reqt = "13:59";
			break;
		case 5:
			reqt = "14:59";
			break;
		case 6:
			reqt = "15:59";
			break;
		default:
			reqt = "9:59";
		}
		
		List<PoolReservation> psv = (List<PoolReservation>)regism.getTimeforCourse(thisDay+" "+reqt);
		
		ArrayList<String> dt = new ArrayList<String>();
		if (psv.size()>0) {
			String[] time = reqt.split(":");
			System.out.println(thisDay.getYear());
			now.set(thisDay.getYear()/*+543*/, thisDay.getMonthValue()-1, thisDay.getDayOfMonth(), Integer.parseInt(time[0]), Integer.parseInt(time[1]));
			System.out.println(psv.size());
			for (PoolReservation p:psv) {
				Calendar st = p.getStart_time();
				Calendar en = p.getEnd_time();
				
				if(/*now.getTimeInMillis()>st.getTimeInMillis() && */now.getTimeInMillis()<en.getTimeInMillis()) {
					String t ="";
					int sd = st.get(Calendar.DAY_OF_MONTH);
					int ed = en.get(Calendar.DAY_OF_MONTH);
					int sm = st.get(Calendar.MONTH);
					int em = en.get(Calendar.MONTH);
					if(sm-em==0&&ed-sd!=0) {
						for(int i=sd;i<=ed;i++) {
							t = i+"-"+(st.get(Calendar.MONTH)+1)+"-"+(st.get(Calendar.YEAR)/*-543*/);
							dt.add(t);
						}
					}else if(sm-em<0){
						double dis_day = Math.ceil((en.getTimeInMillis()-st.getTimeInMillis())/(1000.0*60.0*60.0*24.0));
						System.out.println(dis_day);
						LocalDate stdate = LocalDate.of(st.get(Calendar.YEAR), sm+1, sd);
						for(int i=0;i<=dis_day;i++) {
							t = stdate.getDayOfMonth()+"-"+stdate.getMonthValue()+"-"+(st.get(Calendar.YEAR)/*-543*/);
							dt.add(t);
							stdate = stdate.plusDays(1);
						}
					}else if(sm-em>0){
						double dis_day = Math.ceil((en.getTimeInMillis()-st.getTimeInMillis())/(1000.0*60.0*60.0*24.0));
						System.out.println(dis_day);
						LocalDate stdate = LocalDate.of(st.get(Calendar.YEAR), sm+1, sd);
						for(int i=0;i<=dis_day;i++) {
							t = stdate.getDayOfMonth()+"-"+stdate.getMonthValue()+"-"+stdate.getYear();
							dt.add(t);
							stdate = stdate.plusDays(1);
						}
					}else {
						 t = st.get(Calendar.DAY_OF_MONTH)+"-"+(st.get(Calendar.MONTH)+1)+"-"+(st.get(Calendar.YEAR)/*-543*/);
					}
					dt.add(t);
				}//end if check milli 
			} //end for each psv
		}//end check psv >0 
		
		ArrayList<String> date_for_select = new ArrayList<String>();
		
		LocalDate curDate =LocalDate.now();
		for (int i=0;i<31;i++) {
			//LocalDate x = null;
			if(daytype == 1) {
				switch(curDate.getDayOfWeek().toString()) {
				case "MONDAY":
				case "TUESDAY":
				case "WEDNESDAY":
				case "THURSDAY":
				case "FRIDAY":
					date_for_select.add(curDate.getDayOfMonth()+"-"+curDate.getMonthValue()+"-"+curDate.getYear());
					break;
				case "SATURDAY":
				case "SUNDAY":
					
					break;
				default:
					;
				} // switch
			}else if(daytype == 2){
				switch(curDate.getDayOfWeek().toString()) {
				case "MONDAY":
				case "TUESDAY":
				case "WEDNESDAY":
				case "THURSDAY":
				case "FRIDAY":
					
					break;
				case "SATURDAY":
				case "SUNDAY":
					date_for_select.add(curDate.getDayOfMonth()+"-"+curDate.getMonthValue()+"-"+curDate.getYear());
					break;
				default:
					;
				} // switch
			}else{
				date_for_select.add(curDate.getDayOfMonth()+"-"+curDate.getMonthValue()+"-"+curDate.getYear());
			}// end if
			 curDate = curDate.plusDays(1); // day.next
		}// for loop end
		System.out.println("dt:"+dt);
		System.out.println("bef:"+date_for_select);
		for(int i=0;i<date_for_select.size();i++) {
			 for(int u=0;u<dt.size();u++) {
				 if(date_for_select.get(i).contentEquals(dt.get(u))) {
					 date_for_select.remove(i);
				 }
			 }
		 }
		System.out.println("aft:"+date_for_select);

		model.addAttribute("datesel", date_for_select);
		return "course_register";
	}
	
	@RequestMapping(value="/doCourse_register", method=RequestMethod.POST)
	public String doCourse_register(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		return "index";
	
	}
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
