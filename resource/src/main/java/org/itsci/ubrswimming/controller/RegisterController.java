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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.itsci.ubrswimming.model.*;
import org.itsci.ubrswimming.util.*;


@Controller
public class RegisterController {

	public RegisterController() {
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
		RegisterManager mm = new RegisterManager();
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
		 int mType = 0;
		 
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "1"+g+"0"+Long.toString(unix);
		 Logins log = new Logins(email,pwd,1,mid);
		 Members mb = new Members(log,fname,lname,gender
				 				,tel,birthdate, mType
				 				,address+"_"+sub_districts+"_"+districts+"_"+province+"_"+post_code
				 				,"","",""
				 				,per_pic,stuid,faculty
				 				,stu_pic,"","","","","");
		 
		 RegisterManager mm = new RegisterManager();
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
		 int mType = 1 ;
		 
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "2"+g+"0"+Long.toString(unix);
		 Logins log = new Logins(email,pwd,1,mid);
		 Members mb = new Members(log,fname,lname,gender
				 				,tel,birthdate,mType
				 				,address+"_"+sub_districts+"_"+districts+"_"+province+"_"+post_code
				 				,pid,"",""
				 				,per_pic,"",""
				 				,"",affiliation,officer_card
				 				,marriage,id_cards,"");
		 
		 RegisterManager mm = new RegisterManager();
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
		 
		 int mType = 2;
		 
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "3"+g+"0"+Long.toString(unix);
		 
		 Logins log = new Logins(email,pwd,1,mid);
		 Members mb = new Members(log,fname,lname,gender
				 				,tel,birthdate,mType
				 				,address+"_"+sub_districts+"_"+districts+"_"+province+"_"+post_code
				 				,pid,"",""
				 				,per_pic,"",""
				 				,"","",""
				 				,"","",alumni_card);
		 
		 RegisterManager mm = new RegisterManager();
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
		 int mType = 3;
		 long b = (long) (birthdate.getTimeInMillis()/(86400000*365.25));
		 long n = (long) ((Calendar.getInstance().getTimeInMillis()-543)/(86400000*365.25));
		 long a = n - b;
		 if(a<13) {
			  mType = 4 ;
		 }
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "4"+g+"0"+Long.toString(unix);
		 
		 Logins log = new Logins(email,pwd,1,mid);
		 Members mb = new Members(log,fname,lname,gender
				 				,tel,birthdate,mType
				 				,address+"_"+sub_districts+"_"+districts+"_"+province+"_"+post_code
				 				,pid,emn,emp
				 				,per_pic,"","","","","",""
				 				,id_cards,"");
		 
		 RegisterManager mm = new RegisterManager();
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
		 int mType = 6;
		 if(sType==(0)){
			 mType = 6;
			 status = 4;
		 }else if(sType==(1)) {
			 mType = 5;
			 status = 3;
		 }else {
			 mType= 6;
		 }
		  
		 
		 long unix = System.currentTimeMillis()/1000;
		 String mid = "2"+g+"0"+Long.toString(unix);
		 
		 Logins log = new Logins(email,pwd,status,mid);
		 Members mb = new Members(log,fname,lname,gender
				 				,tel,birthdate,mType
				 				,address+"_"+sub_districts+"_"+districts+"_"+province+"_"+post_code
				 				,pid,"",""
				 				,per_pic,"",""
				 				,"",affiliation,officer_card
				 				,"",id_cards,"");
		 
		 RegisterManager mm = new RegisterManager();
		 mm.insertLogins(log);
		 mm.insertMembers(mb);
		 session.setAttribute("message", "สมัคครสมาชิกเสร็จสิ้น");
		return "index";
	}
	
	@RequestMapping(value="/getTimeToCourse", method=RequestMethod.POST)
	public String getTimeToCourse(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8"); 
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		
		RegisterManager rm = new RegisterManager();
		List<PoolReservations> psv = (List<PoolReservations>)rm.getTimeforCourse(thisDay+" "+reqt);
		
		ArrayList<String> dt = new ArrayList<String>();
		if (psv.size()>0) {
			String[] time = reqt.split(":");
			System.out.println(thisDay.getYear());
			now.set(thisDay.getYear()/*+543*/, thisDay.getMonthValue()-1, thisDay.getDayOfMonth(), Integer.parseInt(time[0]), Integer.parseInt(time[1]));
			System.out.println(psv.size());
			for (PoolReservations p:psv) {
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

		session.removeAttribute("datesel");
		session.setAttribute("datesel", date_for_select);
		
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
	
}
