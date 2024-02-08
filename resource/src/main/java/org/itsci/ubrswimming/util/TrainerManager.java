package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;

import org.itsci.ubrswimming.model.Courses;
import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Members;
import org.itsci.ubrswimming.model.PoolUsage;
import org.itsci.ubrswimming.model.RegisterCourses;
import org.itsci.ubrswimming.model.Trainees;

public class TrainerManager {

	
	
	//--- Trainer --- View Teach Schedule
	public List<RegisterCourses> ViewTeachSchedule (){
		List<RegisterCourses> cou = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();			
			String sql = "SELECT * FROM courses c INNER JOIN register_courses rc  ON rc.courses_id =  c.courses_id";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				int courses_id = rs.getInt(1);
				String courses_name = rs.getString(2);
				String courses_type = rs.getString(3);
				String description = rs.getString(4);
				int max_day = rs.getInt(5);
				int price = rs.getInt(6);
				
				
				int register_courses_id = rs.getInt(7);
				int learn_count = rs.getInt(8);
				int miss_class = rs.getInt(9);
				String learn_time = rs.getString(10);
				String learn_type = rs.getString(11);
				String payment_document = rs.getString(12);
				String reason = rs.getString(13);
				String start_learn = rs.getString(14);
				int status = rs.getInt(15);
				
				String members_id = rs.getString(17);
				String trainer_id = rs.getString(18);
		
				
				Calendar sl = Calendar.getInstance(); 
				String date[] = start_learn.split("-");
				String date2[] = date[2].split(" ");
					sl.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date2[0]));
					
					Login log = new Login();	 	
					 log.setMembers_id(members_id);
					 Members mb = new Members();
					 mb.setLogins(log);

						
				Courses c2 = new Courses(courses_id, courses_name,description, price ,max_day ,courses_type); 	
				RegisterCourses rc2 = new RegisterCourses(register_courses_id,  sl,  learn_time,  learn_type, payment_document,  status,  reason,  learn_count, miss_class, mb, c2 );	
				
				rc2.setCourses_id(c2);
				cou.add(rc2);			
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cou;
	}
	
	
	

	
/*SELECT ฟิวชั่นรวมร่าง 2 Trainer  */
	
	public List <Trainees> SELECT_FUSION_Trainer (String mid) {
		List <Trainees> t =  new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM trainees t INNER JOIN register_courses r  ON r.register_courses_id =  t.register_courses_id JOIN courses c ON c.courses_id = r.courses_id  where members_id = '"+mid+"';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				int trainees_id = rs.getInt(1);	
				int age = rs.getInt(2);
				String name = rs.getString(3);
				int student_gender = rs.getInt(4);
				String tel = rs.getString(5);
				
				/*--------------*/
				int register_courses_id = rs.getInt(6);	
				
				int register_courses_id2 = rs.getInt(7);
				
				int learn_count = rs.getInt(8);
				int miss_class = rs.getInt(9);
				String learn_time = rs.getString(10);
				String learn_type = rs.getString(11);
				String payment_document = rs.getString(12);
				String reason = rs.getString(13);				
				String start_learn = rs.getString(14);
				int status = rs.getInt(15);
				int courses_id = rs.getInt(16);			
				String members_id = rs.getString(17);
				String trainer_id = rs.getString(18);
				String member_id = rs.getString(19);
				
				/*--------------*/	
				int courses_id2 = rs.getInt(20);	
				String courses_name = rs.getString(21);
				String courses_type = rs.getString(22);
				String description = rs.getString(23);		
				int max_day = rs.getInt(24);	
				int price = rs.getInt(25);
				
				Calendar sl = Calendar.getInstance(); 
				String date[] = start_learn.split("-");
				String date2[] = date[2].split(" ");
				 		sl.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date2[0]));
			
				 Login log = new Login();	 	
				 log.setMembers_id(members_id);
				 Members mb = new Members();
				 mb.setLogins(log);
				 	 
				 Courses c2 = new Courses(courses_id,courses_name ,description , price , max_day , courses_type);
				 RegisterCourses rg2 = new RegisterCourses(register_courses_id,  sl,  learn_time,  learn_type, payment_document,  status,  reason,  learn_count,  miss_class, mb, c2 );			 					
				 Trainees t2 = new Trainees (name,age,tel,student_gender, rg2);
				 
				 t.add(t2);
				
				 
				 
				 	}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	

	
	public int Update_Check_Attendees(String id,String learn_count,String miss_class){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "UPDATE register_courses SET learn_count= "+learn_count.trim()+" , miss_class="+miss_class.trim()+" WHERE register_courses_id = "+id.trim()+";";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
	
	
	
	/*UseCase ViewCourseMember ของ Trainer*/
	public Trainees SELECT_FUSION_ViewCourseMember() {
		Trainees t =  new Trainees();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM trainees t INNER JOIN register_courses r  ON r.register_courses_id =  t.register_courses_id JOIN courses c ON c.courses_id = r.courses_id ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				int trainees_id = rs.getInt(1);	
				int age = rs.getInt(2);
				String name = rs.getString(3);
				int student_gender = rs.getInt(4);
				String tel = rs.getString(5);
				
				/*--------------*/
				int register_courses_id = rs.getInt(6);	
				
				int register_courses_id2 = rs.getInt(7);
				
				int learn_count = rs.getInt(8);
				int miss_class = rs.getInt(9);
				
				String learn_time = rs.getString(10);
				String learn_type = rs.getString(11);
				String payment_document = rs.getString(12);
				String reason = rs.getString(13);				
				String start_learn = rs.getString(14);
				int status = rs.getInt(15);
				int courses_id = rs.getInt(16);			
				String members_id = rs.getString(17);
				String trainer_id = rs.getString(18);
				String member_id = rs.getString(19);
				
				/*--------------*/	
				int courses_id2 = rs.getInt(20);	
				String courses_name = rs.getString(21);
				String courses_type = rs.getString(22);
				String description = rs.getString(23);		
				int max_day = rs.getInt(24);	
				int price = rs.getInt(25);
				
				Calendar sl = Calendar.getInstance(); 
				String date[] = start_learn.split("-");
				String date2[] = date[2].split(" ");
				 		sl.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date2[0]));
			
				 Login log = new Login();	 	
				 log.setMembers_id(members_id);
				 Members mb = new Members();
				 mb.setLogins(log);
				 	 
				 Courses c2 = new Courses(courses_id,courses_name ,description , price , max_day , courses_type);
				 RegisterCourses rg2 = new RegisterCourses(register_courses_id,  sl,  learn_time,  learn_type, payment_document,  status,  reason,  learn_count,miss_class,  mb, c2 );			 					
				 Trainees t2 = new Trainees (name,age,tel,student_gender, rg2);
				 
		 
				 	}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	
	
	
	
	/*ลองเทส ViewCourseMember*/
	
	public List <Trainees> SELECT_FUSION_Trainer_test (String mid , String id) {
		List <Trainees> t =  new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM trainees t INNER JOIN register_courses r  ON r.register_courses_id =  t.register_courses_id JOIN courses c ON c.courses_id = r.courses_id  where members_id = '"+mid+"' and t.register_courses_id = '"+id+"';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				int trainees_id = rs.getInt(1);	
				int age = rs.getInt(2);
				String name = rs.getString(3);
				int student_gender = rs.getInt(4);
				String tel = rs.getString(5);
				
				/*--------------*/
				int register_courses_id = rs.getInt(6);	
				
				int register_courses_id2 = rs.getInt(7);
				
				int learn_count = rs.getInt(8);
				int miss_class = rs.getInt(9);
				String learn_time = rs.getString(10);
				String learn_type = rs.getString(11);
				String payment_document = rs.getString(12);
				String reason = rs.getString(13);				
				String start_learn = rs.getString(14);
				int status = rs.getInt(15);
				int courses_id = rs.getInt(16);			
				String members_id = rs.getString(17);
				String trainer_id = rs.getString(18);
				String member_id = rs.getString(19);
				
				/*--------------*/	
				int courses_id2 = rs.getInt(20);	
				String courses_name = rs.getString(21);
				String courses_type = rs.getString(22);
				String description = rs.getString(23);		
				int max_day = rs.getInt(24);	
				int price = rs.getInt(25);
				
				Calendar sl = Calendar.getInstance(); 
				String date[] = start_learn.split("-");
				String date2[] = date[2].split(" ");
				 		sl.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date2[0]));
			
				 Login log = new Login();	 	
				 log.setMembers_id(members_id);
				 Members mb = new Members();
				 mb.setLogins(log);
				 	 
				 Courses c2 = new Courses(courses_id,courses_name ,description , price , max_day , courses_type);
				 RegisterCourses rg2 = new RegisterCourses(register_courses_id,  sl,  learn_time,  learn_type, payment_document,  status,  reason,  learn_count,  miss_class, mb, c2 );			 					
				 Trainees t2 = new Trainees (name,age,tel,student_gender, rg2);
				 
				 t.add(t2);
				
				 
				 
				 	}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	
}
