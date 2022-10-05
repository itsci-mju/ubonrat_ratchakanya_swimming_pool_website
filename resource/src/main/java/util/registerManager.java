package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import bean.logins;
import bean.members;
import bean.pool_reservations;

public class registerManager {
	
	public boolean verifyEmail(String email){
		Boolean i = true;
		String em = email;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select email from logins where email='"+em+"';";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs.first());
			int s = rs.getRow();
				if(s!=0) {
					i = true;
				}else {
					i = false;
				}
			
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int insertLogins(logins log){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "insert into logins(email,password,status,members_id) "
						+ "values('"+log.getEmail()+"','"
									+log.getPassword()+"','"
									+log.getStatus()+"','"
									+log.getMembers_id()+"');";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int insertMembers(members mb){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Calendar bd = mb.getBirthdate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
	        String  birth =  sdf.format(bd.getTime());
	        
			Statement stmt = con.createStatement();
			String table = "members";
			String column = "members_id, firstname, lastname, gender, phone, birthdate, member_type, address, pid, emergency_name, emergency_phone, image, stuid, faculty, stu_card, affiliation, officer_card, marriage_cer, pid_card, alumni_card";
			String sql = "insert into "+table+"("+column+") "
					+ "values('"+mb.getLogins().getMembers_id()+"','"
								+mb.getFirstname()+"','"
								+mb.getLastname()+"','"
								+mb.getGender()+"','"
								+mb.getPhone()+"','"
								+birth+"','"
								+mb.getMember_type()+"','"
								+mb.getAddress()+"','"
								+mb.getPid()+"','"
								+mb.getEmergency_name()+"','"
								+mb.getEmergency_phone()+"','"
								+mb.getImage()+"','"
								+mb.getStuid()+"','"
								+mb.getFaculty()+"','"
								+mb.getStu_card()+"','"
								+mb.getAffiliation()+"','"
								+mb.getOfficer_card()+"','"
								+mb.getMarriage_cer()+"','"
								+mb.getPid_card()+"','"
								+mb.getAlumni_card()+"');";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public List<pool_reservations> getTimeforCourse(String rqdate){
		List<pool_reservations> pslist = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			
			String table = "pool_reservations";
			String column = "start_time, end_time, status";
			String sql = "select "+ column +" from "+table+
						" having (start_time > '"+rqdate+"' or end_time > '"+rqdate+"')"+
						" and status = '1';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String start_time = rs.getString(1);
				String end_time = rs.getString(2);
				int status = rs.getInt(3);        
				
				Calendar stime = Calendar.getInstance(); 
				Calendar etime = Calendar.getInstance(); 
				
				String date[] = start_time.split("-");
				String date2[] = date[2].split(" ");
				String date3[] = date2[1].split(":");
				 		stime.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date2[0]), Integer.parseInt(date3[0]), Integer.parseInt(date3[1]));
				String date4[] = end_time.split("-");
				String date5[] = date4[2].split(" ");
				String date6[] = date5[1].split(":");
						 etime.set(Integer.parseInt(date4[0]), Integer.parseInt(date4[1])-1, Integer.parseInt(date5[0]), Integer.parseInt(date6[0]), Integer.parseInt(date6[1]));
				
				pool_reservations ps = new pool_reservations();
				ps.setStart_time(stime);
				ps.setEnd_time(etime);
				ps.setStatus(status);
				 pslist.add(ps);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pslist;
	}
}
