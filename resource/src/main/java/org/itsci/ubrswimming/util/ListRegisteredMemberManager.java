package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Members;

public class ListRegisteredMemberManager {

	
	
	public List<Members> getListRegisteredMember(){
		List<Members> mbr = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();	
			String sql = "SELECT * FROM members m INNER JOIN logins l  ON m.members_id =  l.members_id where status = 0 ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				String member_id = rs.getString(1);
				String address = rs.getString(2);
				String affliation = rs.getString(3);
				String alumni_card = rs.getString(4);
				String birthdate = rs.getString(5);
				String emergency_name = rs.getString(6);
				String emergency_phone = rs.getString(7);
				String faculty = rs.getString(8);
				String firstname = rs.getString(9);
				String gender = rs.getString(10);
				String image = rs.getString(11);
				String lastname = rs.getString(12);
				String marriage_cer = rs.getString(13);
				int member_type = rs.getInt(14);
				String officer_card = rs.getString(15);
				String phone = rs.getString(16);							
				String pid = rs.getString(17);
				String pid_card = rs.getString(18);
				String stu_card = rs.getString(19);		
				String stuid = rs.getString(20);
				String startcarddate = rs.getString(21);
				String endcarddate = rs.getString(22);
				String members_id = rs.getString(23);
				
	
				String email = rs.getString(24);
				/*ที่เว้นไว้เพราะว่า members_id มี 2 ตัวเลยนับข้ามไปใช้อันเดียว คือ (23)แทน*/
				String password = rs.getString(26);
				int status = rs.getInt(27);
				
				Calendar bd = Calendar.getInstance(); 
				String date[] = birthdate.split("-");
				String date2[] = date[2].split(" ");
				 		bd.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date2[0]));
				 		
				Calendar scd = Calendar.getInstance(); 
				String datescd[] = startcarddate.split("-");
				String datescd2[] = datescd[2].split(" ");
					scd.set(Integer.parseInt(datescd[0]), Integer.parseInt(datescd[1])-1, Integer.parseInt(datescd2[0]));
						
				Calendar ecd = Calendar.getInstance(); 
				String dateecd[] = endcarddate.split("-");
				String dateecd2[] = dateecd[2].split(" ");
					ecd.set(Integer.parseInt(dateecd[0]), Integer.parseInt(dateecd[1])-1, Integer.parseInt(dateecd2[0]));
				
				
				
				Login log = new Login();
				log.setMembers_id(member_id);
				Members mb = new Members();
				mb.setLogins(log);
				
				
				Login l2 = new Login(email,password,status, members_id);
				Members mb2 = new Members(log,firstname,lastname,gender,phone,bd,
						member_type,address,pid,emergency_name,emergency_phone,image,
						stuid,faculty,stu_card,affliation,officer_card,marriage_cer,
						pid_card,alumni_card,scd,ecd);
				mb2.setLogins(l2);
				mbr.add(mb2);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mbr;
	}
	
	
	
	
	
	
	public List<Members> getListRegisteredMemberForManagerApproveStatus1(){
		List<Members> mbrs = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();	
			String sql = "SELECT * FROM members m INNER JOIN logins l  ON m.members_id =  l.members_id where status = 1 ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				String member_id = rs.getString(1);
				String address = rs.getString(2);
				String affliation = rs.getString(3);
				String alumni_card = rs.getString(4);
				String birthdate = rs.getString(5);
				String emergency_name = rs.getString(6);
				String emergency_phone = rs.getString(7);
				String faculty = rs.getString(8);
				String firstname = rs.getString(9);
				String gender = rs.getString(10);
				String image = rs.getString(11);
				String lastname = rs.getString(12);
				String marriage_cer = rs.getString(13);
				int member_type = rs.getInt(14);
				String officer_card = rs.getString(15);
				String phone = rs.getString(16);							
				String pid = rs.getString(17);
				String pid_card = rs.getString(18);
				String stu_card = rs.getString(19);		
				String stuid = rs.getString(20);
				String startcarddate = rs.getString(21);
				String endcarddate = rs.getString(22);
				String members_id = rs.getString(23);
				
	
				String email = rs.getString(24);
				/*ที่เว้นไว้เพราะว่า members_id มี 2 ตัวเลยนับข้ามไปใช้อันเดียว คือ (23)แทน*/
				String password = rs.getString(26);
				int status = rs.getInt(27);
				
				Calendar bd = Calendar.getInstance(); 
				String date[] = birthdate.split("-");
				String date2[] = date[2].split(" ");
				 		bd.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date2[0]));
				 		
				Calendar scd = Calendar.getInstance(); 
				String datescd[] = startcarddate.split("-");
				String datescd2[] = datescd[2].split(" ");
					scd.set(Integer.parseInt(datescd[0]), Integer.parseInt(datescd[1])-1, Integer.parseInt(datescd2[0]));
						
				Calendar ecd = Calendar.getInstance(); 
				String dateecd[] = endcarddate.split("-");
				String dateecd2[] = dateecd[2].split(" ");
					ecd.set(Integer.parseInt(dateecd[0]), Integer.parseInt(dateecd[1])-1, Integer.parseInt(dateecd2[0]));
				
				
				
				Login log = new Login();
				log.setMembers_id(member_id);
				Members mb = new Members();
				mb.setLogins(log);
				
				
				Login l3 = new Login(email,password,status, members_id);
				Members mb3 = new Members(log,firstname,lastname,gender,phone,bd,
						member_type,address,pid,emergency_name,emergency_phone,image,
						stuid,faculty,stu_card,affliation,officer_card,marriage_cer,
						pid_card,alumni_card,scd,ecd);
				mb3.setLogins(l3);
				mbrs.add(mb3);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mbrs;
	}
	
	
	
	
	
	/*อันนี้ในส่วน กดยืนยัน และยกเลิก ViewMemberDetail */
	public int acceptViewMemberDetail(String avdt) {
        ConnectionDB condb = new ConnectionDB();
        Connection con = condb.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "update logins "
                            + "set status = 1  "
                            + " where members_id = '"+avdt+"' ";
            int result = stmt.executeUpdate(sql);
            con.close();
            return result; 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1; 
    }
	
	
	
    public int deleteViewMemberDetail(String dvdt) {
        ConnectionDB condb = new ConnectionDB();
        Connection con = condb.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "update logins "
                    + "set status = 0 "
                    + " where members_id = '"+dvdt+"' ";
            int result = stmt.executeUpdate(sql);
            con.close();
            return result; 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }
    
    
    
    
    
    
    public List<Members> getListPrintMemberCard(String mid){
		List<Members> mbr = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();	
			String sql = "SELECT * FROM members m INNER JOIN logins l  ON m.members_id =  l.members_id where l.members_id = '"+mid+"'; ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				String member_id = rs.getString(1);
				String address = rs.getString(2);
				String affliation = rs.getString(3);
				String alumni_card = rs.getString(4);
				String birthdate = rs.getString(5);
				String emergency_name = rs.getString(6);
				String emergency_phone = rs.getString(7);
				String faculty = rs.getString(8);
				String firstname = rs.getString(9);
				String gender = rs.getString(10);
				String image = rs.getString(11);
				String lastname = rs.getString(12);
				String marriage_cer = rs.getString(13);
				int member_type = rs.getInt(14);
				String officer_card = rs.getString(15);
				String phone = rs.getString(16);							
				String pid = rs.getString(17);
				String pid_card = rs.getString(18);
				String stu_card = rs.getString(19);		
				String stuid = rs.getString(20);
				String startcarddate = rs.getString(21);
				String endcarddate = rs.getString(22);
				String members_id = rs.getString(23);
				
	
				String email = rs.getString(24);
				/*ที่เว้นไว้เพราะว่า members_id มี 2 ตัวเลยนับข้ามไปใช้อันเดียว คือ (23)แทน*/
				String password = rs.getString(26);
				int status = rs.getInt(27);
				
				Calendar bd = Calendar.getInstance(); 
				String date[] = birthdate.split("-");
				String date2[] = date[2].split(" ");
				 	bd.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date2[0]));
				 		
				Calendar scd = Calendar.getInstance(); 
				String datescd[] = startcarddate.split("-");
				String datescd2[] = datescd[2].split(" ");
					scd.set(Integer.parseInt(datescd[0]), Integer.parseInt(datescd[1])-1, Integer.parseInt(datescd2[0]));
						
				Calendar ecd = Calendar.getInstance(); 
				String dateecd[] = endcarddate.split("-");
				String dateecd2[] = datescd[2].split(" ");
					scd.set(Integer.parseInt(dateecd[0]), Integer.parseInt(dateecd[1])-1, Integer.parseInt(dateecd2[0]));
				
				
				
				Login log = new Login();
				log.setMembers_id(member_id);
				Members mb = new Members();
				mb.setLogins(log);
				
				
				
				
				Login l2 = new Login(email,password,status, members_id);
				Members mb2 = new Members(log,firstname,lastname,gender,phone,bd,
						member_type,address,pid,emergency_name,emergency_phone,image,
						stuid,faculty,stu_card,affliation,officer_card,marriage_cer,
						pid_card,alumni_card,scd,ecd);
				mb2.setLogins(l2);
				mbr.add(mb2);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mbr;
	}
    
    
    
    
    
    
    
    
    public Members ShowIDMember(String mid){
		Members mbr = new Members();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();	
			String sql = "SELECT  firstname , lastname , startcarddate , endcarddate FROM members where members_id = '"+mid+"' ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				String firstname = rs.getString(1);
				String lastname = rs.getString(2);
				String startcarddate = rs.getString(3);
				String endcarddate = rs.getString(4);
				
				if (startcarddate.equals("0000-00-00 00:00:00")) {										
					mbr.setFirstname(firstname);
					mbr.setLastname(lastname);
				
				}else {
					
					Calendar scd = Calendar.getInstance(); 
					String datescd[] = startcarddate.split("-");
					String datescd2[] = datescd[2].split(" ");				
						scd.set(Integer.parseInt(datescd[0]), Integer.parseInt(datescd[1])-1, Integer.parseInt(datescd2[0]));
							
					Calendar ecd = Calendar.getInstance();
					/*ติดปัญหาตรงวันที่ 29 กมภา หาวิธีเอา*/
					ecd.add(Calendar.YEAR, 1); 
					String dateecd[] = endcarddate.split("-");
					String dateecd2[] = dateecd[2].split(" ");
						ecd.set(Integer.parseInt(dateecd[0]), Integer.parseInt(dateecd[1])-1, Integer.parseInt(dateecd2[0]));
						
					mbr = new Members(firstname,lastname,scd,ecd);
				}
		
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mbr;
	}
    
    
    
    
    public int editCardTimes(Members emb, String mid) {
        ConnectionDB condb = new ConnectionDB();
        Connection con = condb.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "update Members set  "
            		+ "startcarddate = '" + emb.getStartcarddate()		  
                    + "',endcarddate ='"+ emb.getEndcarddate()
                    + "' where members_id = '" + mid + "'";
            int result = stmt.executeUpdate(sql);
            con.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    
    
    
    
    public int update_submit_card(String startcarddate, String endcarddate , String mid) {
        ConnectionDB condb = new ConnectionDB();
        Connection con = condb.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "update members set  "
            		+ "startcarddate = '" + startcarddate		  
                    + "',endcarddate ='"+ endcarddate
                    + "' where members_id = '" + mid + "'";
            int result = stmt.executeUpdate(sql);
            con.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
	
}
