package org.itsci.ubrswimming.controller;

import java.io.UnsupportedEncodingException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Members;
import org.itsci.ubrswimming.model.PoolUsage;

import org.itsci.ubrswimming.util.RecordUsageManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RecordUsageController {

	
	
	/*----------------------Use Case Register_Course*---------------------------------------/
	/*Insert UseCase insertRecord Usage Service ที่ตั้งชื่อหน้า jsp กับ manager ใช้ชื่อ insertRecordUsage*/ 
	@RequestMapping(value="/insertRecordUsage", method=RequestMethod.POST)
	public String insertRecordUsage(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String gender_man = request.getParameter("gender_man");
		String gender_gel = request.getParameter("gender_gel");
		String child = request.getParameter("child");
		String adult = request.getParameter("adult");
		String price = request.getParameter("price");
		
		
		String usetype = request.getParameter("usetype");
		
		/*แปลงค่าจาก String เป็น Int*/

		
     
		RecordUsageManager rcus = new RecordUsageManager();
		PoolUsage pus = new PoolUsage();
		pus =  rcus.ShowPoolUsage_id();
		
		if (usetype.equals("member")) {
			String memberid = request.getParameter("memberID");
			
			Login log = new Login();
			log.setMembers_id(memberid);
			Members m  = new Members();
			m.setLogins(log);
			
			
			PoolUsage pus2 = new PoolUsage(pus.getPool_usage_id() ,0 , 0 , 0 , 0 , 0 , m);
			
			int p2 = rcus.insertRecordUsage(pus2);
			request.setAttribute("insertRecordUsage", p2);
		    session.setAttribute("PoolUsage", pus2);
		    
		}else {
			
			int gender_man1 = Integer.parseInt(gender_man);
			int gender_gel1 = Integer.parseInt(gender_gel);
			int child1 = Integer.parseInt(child);
			int adult1 = Integer.parseInt(adult);
			int price1 = Integer.parseInt(price);
			
			
			
		PoolUsage pus2 = new PoolUsage(pus.getPool_usage_id() ,adult1 , child1 , price1 , gender_man1 , gender_gel1 , null);
		
		int p2 = rcus.insertRecordUsage(pus2);
		request.setAttribute("insertRecordUsage", p2);
	    session.setAttribute("PoolUsage", pus2);
	    
		}
		
	    return "index";
	}
	
			
}

		
		
