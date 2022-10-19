package org.itsci.ubrswimming.controller;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.imageio.ImageIO;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Members;
import org.itsci.ubrswimming.model.PoolReservations;
import org.itsci.ubrswimming.util.MemberManager;
import org.itsci.ubrswimming.util.RequestManager;

@Controller
public class JameController {
	
	
	@RequestMapping(value="/memberprofile", method=RequestMethod.GET)
	public String memberprofile() {
		return "memberprofile";
	}
	
	
	
	@RequestMapping(value="/viewrequesttousepool", method=RequestMethod.GET)
	public String viewrequesttousepool() {
		return "viewrequesttousepool";
	}
	
	
	
	
	@RequestMapping(value="/addMakeEvent", method=RequestMethod.POST)
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
		String enddate = request.getParameter("enddate");		
		String detail = request.getParameter("detail");
		


		String sdate[] = startdate.split("-");
		 		sd.set(Integer.parseInt(sdate[0]), Integer.parseInt(sdate[1])-1, Integer.parseInt(sdate[2]));
		String edate[] = enddate.split("-");
				ed.set(Integer.parseInt(edate[0]), Integer.parseInt(edate[1])-1, Integer.parseInt(edate[2]));
				
		Login log = new Login();
			log.setMembers_id(memberid);
		Members mb = new Members();
			mb.setLogins(log);
		PoolReservations pr = new PoolReservations(0, eventname,sd,ed,detail,0, detail, 1, mb);
		
		
		
		RequestManager rqm = new RequestManager();
		rqm.addRequestToUse(pr);
		return "index";
	}
	
	
	@RequestMapping(value="/make_event", method=RequestMethod.GET)
	public String make_event() {
		return "make_event";
	}
	
	
	
	@RequestMapping(value="/view_request", method=RequestMethod.GET)
	public String view_request(HttpServletRequest request,HttpSession session) {
		String pid =request.getParameter("id");
		session.setAttribute("idrequest", pid);
		return "view_request";
	}
	
	
	
	@RequestMapping(value="/approve_request", method=RequestMethod.GET)
	public String approve_request(HttpServletRequest request,HttpSession session) {
		int r = -1;
	
		String pid =request.getParameter("id");
        RequestManager req = new RequestManager();
        r = req.acceptReservations(pid);
        
        request.setAttribute("resultApprove", r);

		return "manage_form";
	}
	
	
    @RequestMapping(value="/deleteReservations",method=RequestMethod.GET)
    public String deleteReservations (HttpServletRequest request,HttpSession session) {
        int r = -1;
        String rpid =request.getParameter("id");
        RequestManager req = new RequestManager();
        r = req.deleteReservations(rpid);
        request.setAttribute("resultCancel", r);

        return "manage_form";
    }

@RequestMapping(value="/getRequestToUse", method=RequestMethod.POST ,consumes =  MediaType.MULTIPART_FORM_DATA_VALUE)
	public String getRequestToUse(@RequestParam("doc") MultipartFile file, ServletRequest request,HttpSession session) {
		
			try {
				request.setCharacterEncoding("UTF-8");
				
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
						
				Login log = new Login();
					log.setMembers_id(memberid);
				Members mb = new Members();
					mb.setLogins(log);
				PoolReservations pr = new PoolReservations(0,eventname,sd,ed,detail,0,file.getOriginalFilename(),0,mb);
				RequestManager rqm = new RequestManager();
				rqm.addRequestToUse(pr);
				
				
				String Givefile =  file.getOriginalFilename();
				if (!file.isEmpty()) {
					String original_file_name = file.getOriginalFilename();
					String type_image = original_file_name.substring(original_file_name.lastIndexOf("."));				
					String path =  "D:\\project\\resource\\src\\main\\webapp\\WEB-INF\\image";
					//String path = request.getServletContext().getRealPath("/") + "image";
					System.out.println(path);
					System.out.println(original_file_name);	
					
					File uploadPic;
					uploadPic = convert(file, path + "/" + Givefile);

					BufferedImage image = ImageIO.read(uploadPic);
					int width = 0;
					int height = 0;

					if (image.getWidth() > image.getHeight()) {
						width = 400;
						height = 400;
					} else {
						width = 400;
						height = 400;
					}

					BufferedImage imageWrite = getScaledInstance(image, width, height,
							RenderingHints.VALUE_RENDER_QUALITY, true);

					if (type_image.equalsIgnoreCase(".png")) {
						ImageIO.write(imageWrite, "jpg", new File(path + "/" + Givefile));
					} else if (type_image.equalsIgnoreCase(".jpeg")) {
						ImageIO.write(imageWrite, "jpg", new File(path + "/" + Givefile));
					} else {
						ImageIO.write(imageWrite, "jpg", new File(path + "/" + Givefile));
					}
				} else {
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return "index";
	}
	
	
	public static BufferedImage getScaledInstance(BufferedImage img, int targetWidth, int targetHeight, Object hint,
			boolean higherQuality) {
		int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB
				: BufferedImage.TYPE_INT_ARGB;
		BufferedImage ret = (BufferedImage) img;
		int w, h;
		if (higherQuality) {
			w = img.getWidth();
			h = img.getHeight();
		} else {
			w = targetWidth;
			h = targetHeight;
		}
		do {
			if (higherQuality && w > targetWidth) {
				w /= 2;
				if (w < targetWidth) {
					w = targetWidth;
				}
			}
			if (higherQuality && h > targetHeight) {
				h /= 2;
				if (h < targetHeight) {
					h = targetHeight;
				}
			}
			BufferedImage tmp = new BufferedImage(w, h, type);
			Graphics2D g2 = tmp.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_RENDERING, hint);
			g2.drawImage(ret, 0, 0, w, h, null);
			g2.dispose();
			ret = tmp;
		} while (w != targetWidth || h != targetHeight);
		return ret;
	}
	public static File convert(MultipartFile file, String path) throws IOException {
		System.out.println(path);
		File convFile = new File(path);
		System.out.println(path + file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
	
	@RequestMapping(value="/doRecordUsage55", method=RequestMethod.POST)
	public String recordUsageService(HttpServletRequest request,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
		
		String mid = request.getParameter("mid");
		
		Calendar time = Calendar.getInstance();
		int usage_t = Integer.parseInt(request.getParameter("usetype"));
		String coupon = "";
		int adult = Integer.parseInt(request.getParameter("adult"));
		int child = Integer.parseInt(request.getParameter("child"));
		int amount = adult+child;
		int price = 0;
		// calculate price 
		if (usage_t==0) {
			MemberManager mm = new MemberManager();
			int t = mm.getmember(mid).getMember_type();
			price=0;
		}else {
			price=(child*30)+(adult*50);
		}
			
		return "record_usage";
	}
    
    
    
  
    @RequestMapping(value="/ReportPoolUsageStatistics", method=RequestMethod.GET)
	public String ReportPoolUsageStatistics(HttpServletRequest request,HttpSession session) {
    	
		return "ReportPoolUsageStatistics";
	}
    
    
    @RequestMapping(value="/getSumPrice", method=RequestMethod.GET)
	public String getSumPrice() {
		return "ReportPoolUsageStatistics";
	}
    
    
    
    
    @RequestMapping(value="/getSumAmount", method=RequestMethod.GET)
   	public String getSumAmount() {
   		return "ReportPoolUsageStatistics";
   	}
    
    
    
    @RequestMapping(value="/barcode", method=RequestMethod.GET)
   	public String getbarcode() {
   		return "barcode";
   	}
    
    
    
    @RequestMapping(value="/qrcode", method=RequestMethod.GET)
   	public String getqrcode() {
   		return "qrcode";
   	}
    
    
 
    
  
}
