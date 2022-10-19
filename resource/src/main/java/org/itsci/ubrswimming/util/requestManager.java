package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.itsci.ubrswimming.bean.logins;
import org.itsci.ubrswimming.bean.members;
import org.itsci.ubrswimming.bean.pool_reservations;
import org.itsci.ubrswimming.bean.pool_usage;

public class requestManager {
	
	public int addRequestToUse(pool_reservations pool){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Calendar sd = pool.getStart_time();
			Calendar ed = pool.getEnd_time();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
	        String startdate = sdf.format(sd.getTime());
	        String enddate = sdf.format(ed.getTime());
	        
			Statement stmt = con.createStatement();
			String table = "pool_reservations";
			String column = "event_name, start_time, end_time, detail, price, document, status, members_id";
			String sql = "insert into "+table+"("+column+") "
						+ "values('"+pool.getEvent_name()+"','"
									+startdate+"','"
									+enddate+"','"
									+pool.getDetail()+"','"
									+pool.getPrice()+"','"
									+pool.getDocument()+"','"
									+pool.getStatus()+"','"
									+pool.getMembers().getLogins().getMembers_id()+"');";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public List<pool_reservations> getListRequestUsePool(){
		List<pool_reservations> pslist = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			
			String table = "pool_reservations";
			String column = "pool_reservations_id, event_name, start_time, end_time, detail, price, document, status, members_id";
			String sql = "select "+ column +" from "+table+";";
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
				logins log = new logins();
				log.setMembers_id(mid);
				members mb = new members();
				mb.setLogins(log);
				 pool_reservations ps = new pool_reservations(rid, ename, stime, etime, detail, price, doc, status, mb);
				 pslist.add(ps);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pslist;
	}
	
	public int updateRequestToUse_manager(pool_reservations pool){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String table = "pool_reservations";
			String setColumn = " price = '"+pool.getPrice()+"', status = '"+pool.getStatus()+"'";
			String where = "pool_reservations_id = '"+pool.getPool_reservations_id()+"'";
			String sql = "update "+table+" set "+setColumn+" where "+where+";";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	// record_usage ------------------->
	public int recordUsageService_mem(pool_usage pus){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
			Statement stmt = con.createStatement();
			String table = "pool_usage";
			String column = "coupon_no, time, usage_type, amount, price, members_id";
			String sql = "insert into "+table+"("+column+") "
						+ "values('"+pus.getCoupon_no()+"','"
									+sdf.format(pus.getTime().getTime())+"','"
									+pus.getUsage_type()+"','"
									+pus.getAmount()+"','"
									+pus.getPrice()+"','"
									+pus.getMembers().getLogins().getMembers_id()+"');";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int recordUsageService_non(pool_usage pus){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
			Statement stmt = con.createStatement();
			String table = "pool_usage";
			String column = "coupon_no, time, usage_type, adult, child, amount, price";
			String sql = "insert into "+table+"("+column+") "
						+ "values('"+pus.getCoupon_no()+"','"
									+sdf.format(pus.getTime().getTime())+"','"
									+pus.getUsage_type()+"','"
									+pus.getAdult()+"','"
									+pus.getChild()+"','"
									+pus.getAmount()+"','"
									+pus.getPrice()+"');";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}



public List<pool_reservations> getListRequestUsePool_memid(String memid){
		List<pool_reservations> pslist = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			
			String table = "pool_reservations";
			String column = "pool_reservations_id, event_name, start_time, end_time, detail, price, document, status, members_id";
			String where = "members_id";
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
				logins log = new logins();
				log.setMembers_id(mid);
				members mb = new members();
				mb.setLogins(log);
				 pool_reservations ps = new pool_reservations(rid, ename, stime, etime, detail, price, doc, status, mb);
				 pslist.add(ps);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pslist;
	}
	
	
	
	
	public pool_reservations getRequestUsePoolReturn(String id){
		pool_reservations pslist = null ;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			
			String table = "pool_reservations";
			String column = "pool_reservations_id, event_name, start_time, end_time, detail, price, document, status, members_id";
			String where = "members_id";
			String sql = "SELECT  pool_reservations_id,event_name, start_time, end_time, detail, price, document, status, members_id FROM pool_reservations where  pool_reservations_id ="+id+"";
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
				logins log = new logins();
				log.setMembers_id(mid);
				members mb = new members();
				mb.setLogins(log);
				pslist = new pool_reservations(rid, ename, stime, etime, detail, price, doc, status, mb);
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pslist;
	}



public int acceptReservations(String pid) {
        ConnectionDB condb = new ConnectionDB();
        Connection con = condb.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "update pool_reservations "
                            + "set status = 1  "
                            + " where pool_reservations_id = '"+pid+"' ";
            int result = stmt.executeUpdate(sql);
            con.close();
            return result; 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1; 
    }
	
	
	
    public int deleteReservations(String prid) {
        ConnectionDB condb = new ConnectionDB();
        Connection con = condb.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "delete from pool_reservations where  pool_reservations_id = '"+prid+"' ";
            int result = stmt.executeUpdate(sql);
            con.close();
            return result; 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

}
