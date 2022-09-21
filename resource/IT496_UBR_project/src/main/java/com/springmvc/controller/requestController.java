package com.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.logins;
import bean.members;
import bean.pool_reservations;
import bean.pool_usage;
import util.memberManager;
import util.requestManager;
@Controller
public class requestController {
	
	@RequestMapping(value="/getRequestToUse", method=RequestMethod.POST)
	public String getRequestToUse(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar sd = Calendar.getInstance();
		Calendar ed = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        
        String memberid = request.getParameter("mid");
        String eventname = request.getParameter("eventname");
		String startdate = request.getParameter("startdate");
		int starthour = Integer.parseInt(request.getParameter("starthour"));
		int startminute = Integer.parseInt(request.getParameter("startminute"));
		String enddate = request.getParameter("enddate");
		int endhour = Integer.parseInt(request.getParameter("endhour"));
		int endminute = Integer.parseInt(request.getParameter("endminute"));
		String detail = request.getParameter("detail");
		String filename = request.getParameter("doc");


		String sdate[] = startdate.split("-");
		 		sd.set(Integer.parseInt(sdate[0]), Integer.parseInt(sdate[1])-1, Integer.parseInt(sdate[2]), starthour, startminute);
		String edate[] = enddate.split("-");
				ed.set(Integer.parseInt(edate[0]), Integer.parseInt(edate[1])-1, Integer.parseInt(edate[2]), endhour, endminute);
				
		logins log = new logins();
			log.setMembers_id(memberid);
		members mb = new members();
			mb.setLogins(log);
		pool_reservations pr = new pool_reservations(0,eventname,sd,ed,detail,0,filename,0,mb);
		requestManager rqm = new requestManager();
		rqm.addRequestToUse(pr);
		return "index";
	}
	
	@RequestMapping(value="/doRecordUsage", method=RequestMethod.POST)
	public String recordUsageService(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        Calendar time = Calendar.getInstance();
        
        int usage_t = Integer.parseInt(request.getParameter("usetype"));
        int q = Integer.parseInt(request.getParameter("q"));
        ArrayList<String> mid = new ArrayList<String>();
        int adult = 0;
        int child = 0;
        int price = 0;
        if(usage_t==0) {
        	for(int i=0;i<=q;i++) {
        		mid.add(request.getParameter("mid"+i));
        		System.out.println("mid"+request.getParameter("mid"+i));
        	}//loop
        }else {
        	for(int i=0;i<=q;i++) {
        		System.out.println("mtype"+request.getParameter("mtype"+i));
        		String mt = request.getParameter("mtype"+i);
        		int mtn = 0; 
        		if(mt != null) {
        			mtn = Integer.parseInt(mt);
        		}
       
        		if(mtn==1) {
//               	 <option value="1" >ผู้ใหญ่</option>
         			adult+= Integer.parseInt(request.getParameter("numbers"+i));
        			price+= 50*Integer.parseInt(request.getParameter("numbers"+i));
        		}else if(mtn==2) {
//                  <option value="2" >เด็ก</option>
        			child+= Integer.parseInt(request.getParameter("numbers"+i));
        			price+= 30*Integer.parseInt(request.getParameter("numbers"+i));
        		}else if(mtn==3) {
//                  <option value="3" >นักศึกษามหาวิทยาลัยแม่โจ้</option>
        			adult+= Integer.parseInt(request.getParameter("numbers"+i));
        			price+= 20*Integer.parseInt(request.getParameter("numbers"+i));
        		}else if(mtn==4) {
//                  <option value="4" >บุคลากรมหาวิทยาลัยแม่โจ้</option>
        			adult+= Integer.parseInt(request.getParameter("numbers"+i));
        			price+= 30*Integer.parseInt(request.getParameter("numbers"+i));
        		}else if(mtn==5) {
//                  <option value="5" >บุตรบุคลากรมหาวิทยาลัยแม่โจ้</option>
        			adult+= Integer.parseInt(request.getParameter("numbers"+i));
        			price+= 20*Integer.parseInt(request.getParameter("numbers"+i));
        		}
        	}//end loop
        }//end else
        System.out.println(mid);
        System.out.println(adult);
        System.out.println(child);
        System.out.println(price);
        String coupon = "coupon";
//        pool_usage_id, coupon_no, time, usage_type, adult, child, amount, price, members_id 
        pool_usage pus = new pool_usage();
        requestManager req = new requestManager();
        if(usage_t==0) {
        	memberManager mn = new memberManager();
        	logins l = new logins();
        	members m = new members();
        	for (int i=0;i<mid.size();i++) {
        		int status = 0;
        		int mtype = 0;
        		try {
        			status = mn.getStatusfromLogin(mid.get(i)).getStatus();
        			mtype = mn.getmtypefromMember(mid.get(i)).getMember_type();
        		} catch (Exception  e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
       
        		if(mid.get(i)!=null&&status==2) {
        			price = 0;
        			l.setMembers_id(mid.get(i));
        			m.setLogins(l);
        			pus = new pool_usage(0,coupon,time,usage_t,0,0,1,price,m);
        			req.recordUsageService_mem(pus);
        		}else if(mid.get(i)!=null){
        			if(mtype == 0) { //20
        				price = 20;
            			l.setMembers_id(mid.get(i));
            			m.setLogins(l);
            			pus = new pool_usage(0,coupon,time,usage_t,0,0,1,price,m);
            			req.recordUsageService_mem(pus);
        			}else if(mtype == 3){ //50
        				price = 50;
            			l.setMembers_id(mid.get(i));
            			m.setLogins(l);
            			pus = new pool_usage(0,coupon,time,usage_t,0,0,1,price,m);
            			req.recordUsageService_mem(pus);
        			}else { // 30
        				price = 30;
            			l.setMembers_id(mid.get(i));
            			m.setLogins(l);
            			pus = new pool_usage(0,coupon,time,usage_t,0,0,1,price,m);
            			req.recordUsageService_mem(pus);
        			} //end add
        		}//end if
        	}///end loop
        }else {
        	int amount = adult+child;
        	pus = new pool_usage(0,coupon,time,usage_t,adult,child,amount,price,null);
        	req.recordUsageService_non(pus);
        }
        
		return "record_usage";
	}
}
