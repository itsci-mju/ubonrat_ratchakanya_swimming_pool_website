package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Members;
import org.itsci.ubrswimming.model.PoolUsage;

@Service
public class JameManager {
@Autowired	
	

	public List<PoolUsage> getListRequestUsePool_memid(){
		List<PoolUsage> pslist = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			
			String table = "pool_usage";
			String column = "pool_usage_id, coupon_no, time, usage_type, adult, child, amount, price, members_id ";
			String where = "members_id";
			String sql = "SELECT  pool_usage_id ,coupon_no, time, usage_type, adult, child, amount ,price ,members_id  FROM pool_usage";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int pool_usage_id = rs.getInt(1);
				String coupon_no = rs.getString(2);
				String time = rs.getString(3);
				int usage_type = rs.getInt(4);
				int adult = rs.getInt(5);
				int child = rs.getInt(6);
				int amount = rs.getInt(7);
				int price = rs.getInt(8);        
				String mid = rs.getString(9);	
				
				Calendar stime = Calendar.getInstance(); 
				
				String date[] = time.split("-");
				String date2[] = date[2].split(" ");
				String date3[] = date2[1].split(":");
				 		stime.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date2[0]), Integer.parseInt(date3[0]), Integer.parseInt(date3[1]));
										 
				Login log = new Login();
				log.setMembers_id(mid);
				Members mb = new Members();
				mb.setLogins(log);
				PoolUsage pu = new PoolUsage(pool_usage_id, coupon_no, stime, usage_type, adult, child, amount, price ,mb);
				 		
				 pslist.add(pu);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pslist;
	}



	
	/*เอาราคารวมมาแสดง*/
	public String getSumPrice(){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		String sumPrice = ""; 
		try {
			Statement stmt = con.createStatement();			
			String table = "pool_usage";
			String column = "pool_usage_id, coupon_no, time, usage_type, adult, child, amount, price, members_id ";
			String where = "members_id";
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
	
	
	
	/*รวมจำนวนผู้ใช้*/
	public String getSumAmount(){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		String sumAmount = ""; 
		try {
			Statement stmt = con.createStatement();			
			String table = "pool_usage";
			String column = "pool_usage_id, coupon_no, time, usage_type, adult, child, amount, price, members_id ";
			String where = "members_id";
			String sql = "SELECT SUM(amount) FROM pool_usage WHERE amount";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				 sumAmount = rs.getString(1);
		
			}
			con.close();
			return sumAmount;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	}



	
	
}
