package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.itsci.ubrswimming.bean.*;

public class memberManager {
	
	public logins verifyLoginWEB(String em,String pw){
		logins l = null;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select email,password,status,members_id from logins where email = '" + em +
					"' and password = '"+pw+"'";
			ResultSet rs = stmt.executeQuery(sql); 
			while (rs.next() && rs.getRow()==1) {
				String email = rs.getString(1);
				String pwd = rs.getString(2);
				int status = Integer.parseInt(rs.getString(3));
				String mid =(rs.getString(4));
				
				 l = new logins (email,pwd,status,mid);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}return l;
	}
	
	public logins getStatusfromLogin(String mid){
		logins l = null;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select members_id,status from logins where members_id = '" + mid + "';";
			ResultSet rs = stmt.executeQuery(sql); 
			while (rs.next() && rs.getRow()==1) {
				String member_id = rs.getString(1);
				int status = Integer.parseInt(rs.getString(2));
				
				 l = new logins (null,null,status,member_id);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}return l;
	}
	
	public members getmtypefromMember(String mid){
		logins l = new logins();
		members m = new members();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select members_id,member_type from members where members_id = '" + mid + "';";
			ResultSet rs = stmt.executeQuery(sql); 
			while (rs.next() && rs.getRow()==1) {
				String member_id = rs.getString(1);
				int type = Integer.parseInt(rs.getString(2));
				
				 l = new logins (null,null,0,member_id);
				 m.setLogins(l);
				 m.setMember_type(type);
				 System.out.println(m.getMember_type());
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}return m;
	}
	
	
	


public logins getLogin(String members_id){
		logins login = null;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select email,password,status,members_id from logins where members_id = '" + members_id +"' ";
			ResultSet rs = stmt.executeQuery(sql); 
			while (rs.next() && rs.getRow()==1) {
				String email = rs.getString(1);
				String pwd = rs.getString(2);
				int status = Integer.parseInt(rs.getString(3));
				String mid =(rs.getString(4));
				
				login = new logins (email,pwd,status,mid);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}return login;
	}
	
	//// JAMEEEEEEEEEEEEEEEEEEEEEEEE 

	public members getmember(String memID) {
		members mb = new members();
		logins log = new logins();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String select = "members_id,firstname,lastname,gender,phone,birthdate,member_type,address,pid,emergency_name,emergency_phone,image,stuid,faculty,stu_card,affiliation,officer_card,marriage_cer,pid_card,alumni_card";
			String from = "members";
			String where = "members_id"+" = '"+ memID + "'";
			String sql = "select "+select+" from "+from+" where "+where;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String member_id = rs.getString(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String gender = rs.getString(4);
				String phone = rs.getString(5);
				String bd = rs.getString(6);
				int member_type = rs.getInt(7);
				String address = rs.getString(8);
				String pid = rs.getString(9);
				String emergency_name = rs.getString(10);
				String emergency_phone = rs.getString(11);
				String image = rs.getString(12);
				String stuid = rs.getString(13);
				String faculty = rs.getString(14);
				String stu_card = rs.getString(15);
				String affliation = rs.getString(16);
				String officer_card = rs.getString(17);
				String marriage_cer = rs.getString(18);
				String pid_card = rs.getString(19);
				String alumni_card = rs.getString(20);
				
				Calendar birthdate = Calendar.getInstance(); 
				String date[] = bd.split("-");
				String date2[] = date[2].split(" ");
				 		birthdate.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date2[0]));
				
				//// JAMEEEEEEEEEEE 	
				log = getLogin(member_id);
				 mb = new members(log,firstname,lastname,gender,phone,birthdate,
							member_type,address,pid,emergency_name,emergency_phone,image,
							stuid,faculty,stu_card,affliation,officer_card,marriage_cer,
							pid_card,alumni_card);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mb;
	}
    



	/*
	public members getallmember() {
		members mb = new members();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from members";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String member_id = rs.getString(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String gender = rs.getString(4);
				String phone = rs.getString(5);
				String birthdate = rs.getString(6);
				String member_type = rs.getString(7);
				String address = rs.getString(8);
				String pid = rs.getString(9);
				String emergency_name = rs.getString(10);
				String emergency_phone = rs.getString(11);
				String image = rs.getString(12);
				String stuid = rs.getString(13);
				String faculty = rs.getString(14);
				String stu_card = rs.getString(15);
				String affliation = rs.getString(16);
				String officer_card = rs.getString(17);
				String marriage_cer = rs.getString(18);
				String pid_card = rs.getString(19);
				String alumni_card = rs.getString(20);
				 mb = new members(member_id,firstname,lastname,gender,phone,birthdate,
							member_type,address,pid,emergency_name,emergency_phone,image,
							stuid,faculty,stu_card,affliation,officer_card,marriage_cer,
							pid_card,alumni_card);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mb;
	}*/
}
