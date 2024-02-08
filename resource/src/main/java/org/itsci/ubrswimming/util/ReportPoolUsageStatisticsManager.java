package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Members;
import org.itsci.ubrswimming.model.PoolUsage;

public class ReportPoolUsageStatisticsManager {

	
	/*เอาสถิตมาโชว์*/
	public List<PoolUsage> getReportPoolUsageStatistics(){
		List<PoolUsage> rpp = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			
			String sql = "SELECT  pool_usage_id , adult, child, amount ,price ,gender_men ,gender_gel ,members_id  FROM pool_usage";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int pool_usage_id = rs.getInt(1);
				int adult = rs.getInt(2);
				int child = rs.getInt(3);
				int amount = rs.getInt(4);
				int price = rs.getInt(5);        
				int gender_men = rs.getInt(6);
				int gender_gel = rs.getInt(7);
				
				String mid = rs.getString(8);	
				
							 
				Login log = new Login();
				log.setMembers_id(mid);
				Members mb = new Members();
				mb.setLogins(log);
				PoolUsage pu = new PoolUsage(pool_usage_id, adult, child, amount, price ,gender_men ,gender_gel ,mb);
				 		
				rpp.add(pu);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rpp;
	}


	/*รวมจำนวนสมาชิกสระว่ายน้ำ*/
	public String getMembers_id(){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		String sumMembers_id = ""; 
		try {
			Statement stmt = con.createStatement();			
			String sql = "SELECT COUNT(members_id) FROM pool_usage ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sumMembers_id = rs.getString(1);
		
			}
			con.close();
			return sumMembers_id;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	}

	
	
	/*รวมจำนวนบุคคลทั่วไปสระว่ายน้ำ*/
	public String getGeneral(){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		String sumGeneral = ""; 
		try {
			Statement stmt = con.createStatement();			
			String sql = "SELECT SUM(gender_men + gender_gel) FROM pool_usage ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sumGeneral = rs.getString(1);
		
			}
			con.close();
			return sumGeneral;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	}

	
	
	
	/*เอาราคามารวมมาแสดง*/
	public String getSumPrice(){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		String sumPrice = ""; 
		try {
			Statement stmt = con.createStatement();			
			String sql = "SELECT SUM(price) FROM pool_usage WHERE price";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sumPrice = rs.getString(1);
		
			}
			con.close();
			return sumPrice;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	
	/*รวมจำนวนชาย*/
	public String getSumGender_men(){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		String SumGender_men = ""; 
		try {
			Statement stmt = con.createStatement();			
			String sql = "SELECT SUM(gender_men) FROM pool_usage ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				SumGender_men = rs.getString(1);
		
			}
			con.close();
			return SumGender_men;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	}

	
	
	/*รวมจำนวนหญิง*/
	public String getGender_gel(){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		String sumGender_gel = ""; 
		try {
			Statement stmt = con.createStatement();			
			String sql = "SELECT SUM(gender_gel) FROM pool_usage ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sumGender_gel = rs.getString(1);
		
			}
			con.close();
			return sumGender_gel;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	
	



	
}
