package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.itsci.ubrswimming.model.RegisterCourses;

public class PromptPayManager {
	
		public int UpdateImg(String id,String url){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "UPDATE register_courses SET status = 1 , payment_document='"+url+"' WHERE register_courses_id = "+id+";";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
		

}
