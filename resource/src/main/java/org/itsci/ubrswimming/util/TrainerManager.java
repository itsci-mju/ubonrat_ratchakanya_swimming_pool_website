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
import org.itsci.ubrswimming.model.RegisterCourses;
import org.itsci.ubrswimming.model.Trainees;

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
				
				
				Courses c = new Courses(courses_id, courses_name,description, price ,max_day ,courses_type); 		
				cou.add(c);
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cou;
	}
	
	
	
	
	
	
	
	//--- Trainer --- ListCoursesMember
	public List<Trainees> ListCoursesMember(){
		List<Trainees> tr = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			
			
			String sql = "SELECT  * FROM trainees where trainees_id ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int trainees_id = rs.getInt(1);
				int age  = rs.getInt(2);
				String name  = rs.getString(3);
				int student_gender  = rs.getInt(4);
				String tel  = rs.getString(5);
			
				
				
				Trainees c = new Trainees(trainees_id, name, age, tel, student_gender); 		
				tr.add(c);
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tr;
	}
	
	
	
}
