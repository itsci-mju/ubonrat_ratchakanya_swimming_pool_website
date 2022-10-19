package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.ubrswimming.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberManager {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public Login verifyLoginWEB(String em, String pw){
		Session session = sessionFactory.getCurrentSession();
		Query<Login> query = session.createQuery("delete from Login l where l.email=:email", Login.class);
		query.setParameter("email", em);
		Login l = query.getSingleResult();
		return l;
	}
	
	public Login getStatusfromLogin(String mid){
		Login l = null;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select members_id,status from logins where members_id = '" + mid + "';";
			ResultSet rs = stmt.executeQuery(sql); 
			while (rs.next() && rs.getRow()==1) {
				String member_id = rs.getString(1);
				int status = Integer.parseInt(rs.getString(2));
				
				 l = new Login(null,null,status,member_id);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}return l;
	}
	
	public Members getmtypefromMember(String mid){
		Login l = new Login();
		Members m = new Members();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select members_id,member_type from members where members_id = '" + mid + "';";
			ResultSet rs = stmt.executeQuery(sql); 
			while (rs.next() && rs.getRow()==1) {
				String member_id = rs.getString(1);
				int type = Integer.parseInt(rs.getString(2));
				
				 l = new Login(null,null,0,member_id);
				 m.setLogins(l);
				 m.setMember_type(type);
				 System.out.println(m.getMember_type());
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}return m;
	}
	
	
	


public Login getLogin(String members_id){
		Login login = null;
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
				
				login = new Login(email,pwd,status,mid);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}return login;
	}
	
	//// JAMEEEEEEEEEEEEEEEEEEEEEEEE 

	public Members getmember(String memID) {
		Members mb = new Members();
		Login log = new Login();
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
				 mb = new Members(log,firstname,lastname,gender,phone,birthdate,
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
