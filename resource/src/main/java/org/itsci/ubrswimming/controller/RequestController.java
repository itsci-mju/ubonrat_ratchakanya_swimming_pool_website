package org.itsci.ubrswimming.controller;

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

import org.itsci.ubrswimming.model.Logins;
import org.itsci.ubrswimming.model.Members;
import org.itsci.ubrswimming.model.PoolUsage;
import org.itsci.ubrswimming.util.MemberManager;
import org.itsci.ubrswimming.util.RequestManager;
@Controller
public class RequestController {
	

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
        PoolUsage pus = new PoolUsage();
        RequestManager req = new RequestManager();
        if(usage_t==0) {
        	MemberManager mn = new MemberManager();
        	Logins l = new Logins();
        	Members m = new Members();
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
        			pus = new PoolUsage(0,coupon,time,usage_t,0,0,1,price,m);
        			req.recordUsageService_mem(pus);
        		}else if(mid.get(i)!=null){
        			if(mtype == 0) { //20
        				price = 20;
            			l.setMembers_id(mid.get(i));
            			m.setLogins(l);
            			pus = new PoolUsage(0,coupon,time,usage_t,0,0,1,price,m);
            			req.recordUsageService_mem(pus);
        			}else if(mtype == 3){ //50
        				price = 50;
            			l.setMembers_id(mid.get(i));
            			m.setLogins(l);
            			pus = new PoolUsage(0,coupon,time,usage_t,0,0,1,price,m);
            			req.recordUsageService_mem(pus);
        			}else { // 30
        				price = 30;
            			l.setMembers_id(mid.get(i));
            			m.setLogins(l);
            			pus = new PoolUsage(0,coupon,time,usage_t,0,0,1,price,m);
            			req.recordUsageService_mem(pus);
        			} //end add
        		}//end if
        	}///end loop
        }else {
        	int amount = adult+child;
        	pus = new PoolUsage(0,coupon,time,usage_t,adult,child,amount,price,null);
        	req.recordUsageService_non(pus);
        }
        
		return "record_usage";
	}
}
