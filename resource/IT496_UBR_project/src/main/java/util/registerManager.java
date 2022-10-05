package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import bean.logins;
import bean.members;

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
	
	
}
