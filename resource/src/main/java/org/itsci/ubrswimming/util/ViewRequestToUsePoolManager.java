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
import org.itsci.ubrswimming.model.PoolReservations;
import org.springframework.stereotype.Service;


@Service
public class ViewRequestToUsePoolManager {

	
	public List<PoolReservations> getListRequestUsePool_memid(String memid){
		List<PoolReservations> pslist = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			
		
			String sql = "SELECT  pool_reservations_id,event_name, start_time, end_time, detail, price, document, status, members_id FROM pool_reservations  where members_id ='"+memid+"' order by pool_reservations_id desc limit 1";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int rid = rs.getInt(1);
				String ename = rs.getString(2);
				String start_time = rs.getString(3);
				String end_time = rs.getString(4);
				String detail = rs.getString(5);
				int price = rs.getInt(6);
				String doc = rs.getString(7);
				int status = rs.getInt(8);        
				String mid = rs.getString(9);
				
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
				Login log = new Login();
				log.setMembers_id(mid);
				Members mb = new Members();
				mb.setLogins(log);
				 PoolReservations ps = new PoolReservations(rid, ename, stime, etime, detail, price, doc, status, mb);
				 pslist.add(ps);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pslist;
	}
	
}
