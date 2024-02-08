package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.itsci.ubrswimming.model.Courses;
import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Members;
import org.itsci.ubrswimming.model.PoolUsage;
import org.itsci.ubrswimming.model.RegisterCourses;


public class RecordUsageManager {


	public int insertRecordUsage(PoolUsage pu){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();		
			System.out.println(pu.getTime());
			String sql;
			if (pu.getMembers() == null) {
				 sql = "insert into pool_usage (pool_usage_id ,coupon_no, time, usage_type, adult, child, amount ,price ,gender_men ,gender_gel ,members_id) "
							+ "values('"+pu.getPool_usage_id()+"',"
										+"null,"
										+"null,"	
										+pu.getUsage_type()+","	
										+pu.getAdult()+","							
										+pu.getChild()+","
										+pu.getAmount()+","
										+pu.getPrice()+","
										+pu.getGender_men()+","
										+pu.getGender_gel()+","
										+"null);";
				
			}else {
				 sql = "insert into pool_usage (pool_usage_id ,coupon_no, time, usage_type, adult, child, amount ,price ,gender_men ,gender_gel ,members_id) "
							+ "values('"+pu.getPool_usage_id()+"',"
										+"null,"
										+"null,"	
										+"null,"
										+"null,"						
										+"null,"
										+"null,"
										+"null,"
										+"null,"
										+"null,'"
										+pu.getMembers().getLogins().getMembers_id()+"');";
				
			}
			
									
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
	
	
	/*select เอาค่าา PoolUsage_id มาแสดง เพราะว่าเป็น PK */
	public PoolUsage ShowPoolUsage_id () {
		PoolUsage pus =  new PoolUsage();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT pool_usage_id  FROM pool_usage WHERE pool_usage_id = (SELECT max(pool_usage_id) FROM pool_usage);";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int pool_usage_id = rs.getInt(1)+1;		
	 		 
				 pus = new PoolUsage(pool_usage_id);			 
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pus;
	}
	
}
