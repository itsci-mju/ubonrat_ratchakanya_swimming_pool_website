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
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Member;
import org.itsci.ubrswimming.model.PoolReservation;
import org.itsci.ubrswimming.util.RequestManager;

@Controller
public class JameController {
	@Autowired
	private RequestManager requestm;

	
	@RequestMapping(value="/addMakeEvent", method=RequestMethod.POST)
	public String getRequestToUse2(HttpServletRequest request,HttpSession session) {
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
			log.setMember_id(memberid);
		Member mb = new Member();
			mb.setLogin(log);
		PoolReservation pr = new PoolReservation(0, eventname,sd,ed,detail,0, detail, 1, mb);

		requestm.addRequestToUse(pr);
		return "index";
	}
    
    /*แบบปอร์มขอเข้าใช้สระว่ายน้ำ*/ 
    //อันที่อาจารย์เก่งทำให้
    @RequestMapping(value = "/getRequestToUse", method = RequestMethod.POST)
    public String getRequestToUse(HttpServletRequest request, HttpSession session) {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            Calendar sd = Calendar.getInstance();
            Calendar ed = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));

            String memberid = "";
            String eventname = "";
            String startdate = "";
            int starthour = 0;
            int startminute = 0;
            String enddate = "";
            int endhour = 0;
            int endminute = 0;
            String detail = "";
            String filename = "";

            try {
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        String fieldname = item.getFieldName();
                        String fieldvalue = item.getString();

                        if ("mid".equals(fieldname)) {
                            memberid = fieldvalue;
                        }
                        if ("eventname".equals(fieldname)) {
                            eventname = fieldvalue;
                        }
                        if ("startdate".equals(fieldname)) {
                            startdate = fieldvalue;
                            
                        }
                        if ("starthour".equals(fieldname)) {
                            starthour = Integer.parseInt(fieldvalue);
                            
                        }
                        if ("startminute".equals(fieldname)) {
                            startminute = Integer.parseInt(fieldvalue);
                            
                        }
                        if ("enddate".equals(fieldname)) {
                            enddate = fieldvalue;
                        }
                        if ("endhour".equals(fieldname)) {
                            endhour = Integer.parseInt(fieldvalue);
                        }
                        if ("endminute".equals(fieldname)) {
                            endminute = Integer.parseInt(fieldvalue);
                        }
                        if ("detail".equals(fieldname)) {
                            detail = fieldvalue;
                        }
                    } else {
//                       String fieldname = item.getFieldName();
                        filename = FilenameUtils.getName(item.getName());
//                        InputStream filecontent = item.getInputStream();
                    }
                }
            } catch (FileUploadException ex) {
                ex.printStackTrace();
            }

            String sdate[] = startdate.split("-");
            sd.set(Integer.parseInt(sdate[0]), Integer.parseInt(sdate[1])-1, Integer.parseInt(sdate[1]), starthour, startminute);
            
            String edate[] = enddate.split("-");
            ed.set(Integer.parseInt(edate[0]), Integer.parseInt(edate[1])-1, Integer.parseInt(edate[2]), endhour, endminute);

            Login log = new Login();
            log.setMember_id(memberid);
            Member mb = new Member();
            mb.setLogin(log);
            PoolReservation pr = new PoolReservation(0, eventname, sd, ed, detail, 0, filename, 0, mb);
            requestm.addRequestToUse(pr);
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
	
    
    @RequestMapping(value="/barcode", method=RequestMethod.GET)
   	public String getbarcode() {
   		return "barcode";
   	}
    
    @RequestMapping(value="/qrcode", method=RequestMethod.GET)
   	public String getqrcode() {
   		return "qrcode";
   	}
    
}
