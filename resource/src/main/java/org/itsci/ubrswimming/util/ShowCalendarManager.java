package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.itsci.ubrswimming.model.PoolReservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowCalendarManager {
@Autowired

	
	//Calendar 
		public List<PoolReservations> getPool_reservationsCalendar(){
			List<PoolReservations> prs = new ArrayList<>();
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			try {
				Statement stmt = con.createStatement();
				
				String sql = "select event_name,status,start_time from pool_reservations where status = 1";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String event_name = rs.getString(1);
					int status = rs.getInt(2);
					String time = rs.getString(3);
					
					
					Calendar stime = Calendar.getInstance(); 
					
					String date[] = time.split("-");
					String date2[] = date[2].split(" ");
					String date3[] = date2[1].split(":");
					 		stime.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-2, Integer.parseInt(date2[0]), Integer.parseInt(date3[0]), Integer.parseInt(date3[1]));
								
					 		
					PoolReservations pr = new PoolReservations(event_name,stime ,status);		 		
					prs.add(pr);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return prs;
		}
}
