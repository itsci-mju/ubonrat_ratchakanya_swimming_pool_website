package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.itsci.ubrswimming.model.Courses;
import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Members;
import org.itsci.ubrswimming.model.PoolUsage;

public class TrainerManager {

	//--- Trainer --- View Teach Schedule
	public List<Courses> ViewTeachSchedule(){
		List<Courses> cou = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			
			
			String sql = "SELECT  * FROM courses where courses_id ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int courses_id = rs.getInt(1);
				String courses_name = rs.getString(2);
				String courses_type = rs.getString(3);
				String description = rs.getString(4);
				int max_day = rs.getInt(5);
				int price = rs.getInt(6);
				
				
				Courses c = new Courses(courses_id, courses_name,description, price,max_day, courses_type); 		
				cou.add(c);
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cou;
	}
}
