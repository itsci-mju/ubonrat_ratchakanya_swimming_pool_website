package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.itsci.ubrswimming.model.Courses;
import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Members;
import org.itsci.ubrswimming.model.PoolReservations;
import org.itsci.ubrswimming.model.RegisterCourses;
import org.itsci.ubrswimming.model.Trainees;

public class RegisterManager {
	
	public boolean verifyEmail(String email){
		Boolean i = true;
		String em = email;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select email from logins where email='"+em+"';";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs.first());
			int s = rs.getRow();
				if(s!=0) {
					i = true;
				}else {
					i = false;
				}
			
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int insertLogins(Login log){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "insert into logins(email,password,status,members_id) "
						+ "values('"+log.getEmail()+"','"
									+log.getPassword()+"','"
									+log.getStatus()+"','"
									+log.getMembers_id()+"');";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int insertMembers(Members mb){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Calendar bd = mb.getBirthdate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
	        String  birth =  sdf.format(bd.getTime());
	        
			Statement stmt = con.createStatement();
			String table = "members";
			String column = "members_id, firstname, lastname, gender, phone, birthdate, member_type, address, pid, emergency_name, emergency_phone, image, stuid, faculty, stu_card, affiliation, officer_card, marriage_cer, pid_card, alumni_card";
			String sql = "insert into "+table+"("+column+") "
					+ "values('"+mb.getLogins().getMembers_id()+"','"
								+mb.getFirstname()+"','"
								+mb.getLastname()+"','"
								+mb.getGender()+"','"
								+mb.getPhone()+"','"
								+birth+"','"
								+mb.getMember_type()+"','"
								+mb.getAddress()+"','"
								+mb.getPid()+"','"
								+mb.getEmergency_name()+"','"
								+mb.getEmergency_phone()+"','"
								+mb.getImage()+"','"
								+mb.getStuid()+"','"
								+mb.getFaculty()+"','"
								+mb.getStu_card()+"','"
								+mb.getAffiliation()+"','"
								+mb.getOfficer_card()+"','"
								+mb.getMarriage_cer()+"','"
								+mb.getPid_card()+"','"
								+mb.getAlumni_card()+"');";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public List<PoolReservations> getTimeforCourse(String rqdate){
		List<PoolReservations> pslist = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			
			String table = "pool_reservations";
			String column = "start_time, end_time, status";
			String sql = "select "+ column +" from "+table+
						" having (start_time > '"+rqdate+"' or end_time > '"+rqdate+"')"+
						" and status = '1';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String start_time = rs.getString(1);
				String end_time = rs.getString(2);
				int status = rs.getInt(3);        
				
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
				
				PoolReservations ps = new PoolReservations();
				ps.setStart_time(stime);
				ps.setEnd_time(etime);
				ps.setStatus(status);
				 pslist.add(ps);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pslist;
	}
	
	
	
	/*----------------------Use Case Register_Course*---------------------------------------/
	/*Insert UseCase Register_Course ในส่วนของ learn_count ,learn_time ,learn_type*/ 
	public int insertRegisterCourse1(RegisterCourses regcours, String mid){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		String pattern = "YYYY-MM-dd HH:mm:ss";
		
        Date DD = regcours.getStart_learn().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
		try {
			Statement stmt = con.createStatement();
			String sql = "insert into register_courses(register_courses_id ,learn_count,miss_class ,learn_time ,learn_type ,payment_document ,reason ,start_learn ,status ,courses_id ,members_id,member_id) "
						+ "values('"+regcours.getRegister_courses_id()+"','"
									+regcours.getLearn_count()+"','"
									+regcours.getMiss_class()+"','"
									+regcours.getLearn_time()+"','"	
									+regcours.getLearn_type()+"','"	
									+regcours.getPayment_document()+"','"
									+regcours.getReason()+"','"											
									+sdf.format(DD)+"','"														
									+regcours.getStatus()+"','"											
									+regcours.getCourses_id().getCourses_id()+"','"											
									+mid+"','"
									+""+"');";
			
									
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
	
	public int insertRegisterCourse2(Trainees tr){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "insert into trainees (trainees_id ,age ,name ,student_gender ,tel ,register_courses_id) "
						+ "values('"+tr.getTrainees_id()+"','"
									+tr.getAge()+"','"
									+tr.getName()+"','"	
									+tr.getStudent_gender()+"','"	
									+tr.getTel()+"','"							
									+tr.getRegister_courses().getRegister_courses_id()+"');";
			
									
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
	
	/*อันนี้คือค่า register_courses_id เอาเลขมาแสดง เพราะว่า register_courses_id ค่าคือ null หาค่า auto ไม่เจอ */
	public RegisterCourses SELECT_RegisterCourse2_1 () {
		RegisterCourses rg =  new RegisterCourses();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM register_courses WHERE register_courses_id = (SELECT max(register_courses_id) FROM register_courses);";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int register_courses_id = rs.getInt(1);		
				int learn_count = rs.getInt(2);		
				int miss_class = rs.getInt(3);
				String learn_time = rs.getString(4);
				String learn_type = rs.getString(5);
				String payment_document = rs.getString(6);
				String reason = rs.getString(7);				
				String start_learn = rs.getString(8);
				int status = rs.getInt(9);
				int courses_id = rs.getInt(10);			
				String members_id = rs.getString(11);
				String trainer_id = rs.getString(12);
				String member_id = rs.getString(13);
				
				Calendar sl = Calendar.getInstance(); 
				String date[] = start_learn.split("-");
				String date2[] = date[2].split(" ");
				 		sl.set(Integer.parseInt(date[0]), Integer.parseInt(date[1])-1, Integer.parseInt(date2[0]));
			
				 Login log = new Login();	 	
				 log.setMembers_id(members_id);
				 Members mb = new Members();
				 mb.setLogins(log);
				 	 
				 Courses c = new Courses();
				 c.setCourses_id(courses_id);
				 		 
				 rg = new RegisterCourses(register_courses_id,  sl,  learn_time,  learn_type, payment_document,  status,  reason,  learn_count, miss_class, mb, c);			 
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rg;
	}
	
	
	
	/*เอาราคาของ usecase  register_course มาแสดง*/
	public int insertRegisterCourse3(Courses c){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "insert into courses (courses_id ,courses_name ,courses_type ,description ,max_day ,price) "
						+ "values('"+c.getCourses_id()+"','"
									+c.getCourses_name()+"','"
									+c.getCourses_type()+"','"	
									+c.getDescription()+"','"	
									+c.getMax_day()+"','"							
									+c.getPrice()+"');";	
									
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
	
	
	/*SELECT ฟิวชั่นรวมร่าง  */
	
	public List <Trainees> SELECT_FUSION (String mid) {
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
				 RegisterCourses rg2 = new RegisterCourses(register_courses_id,  sl,  learn_time,  learn_type, payment_document,  status,  reason,  learn_count, miss_class, mb, c2 );			 					
				 Trainees t2 = new Trainees (name,age,tel,student_gender, rg2);
				 
				 t.add(t2);
				
				 
				 
				 	}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	/*---------------------------------------------------------------------------------*/
	


	
	
	
	
	
	/*UseCase ViewRegisterCourse ให้แสดงทั้งหมด ให้ manager เห็นแล้วให้ อนุมัติ หรือไม่อนุมัติ ให้มาโชว์เฉพาะ status = 1   =1 หมายความว่าสมาชิกชำระเงินเสร็จแล้ว*/
	
	
	
	public List <Trainees> SELECT_FUSION_ForManager() {
		List <Trainees> t =  new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM trainees t INNER JOIN register_courses r  ON r.register_courses_id =  t.register_courses_id JOIN courses c ON c.courses_id = r.courses_id  WHERE status = 1 ;";
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
				 
				 t.add(t2);
				
				 
				 
				 	}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	
	/*---------------------------------------------------------------------------------*/
	
	/*อันนี้ในส่วน กดยืนยัน และยกเลิก viewregisteredCourse */
	public int acceptViewRegisteredCourse(String avr) {
        ConnectionDB condb = new ConnectionDB();
        Connection con = condb.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "update register_courses "
                            + "set status = 2  "
                            + " where register_courses_id = '"+avr+"' ";
            int result = stmt.executeUpdate(sql);
            con.close();
            return result; 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1; 
    }
	
	
	
    public int deleteViewRegisteredCourse(String dvr) {
        ConnectionDB condb = new ConnectionDB();
        Connection con = condb.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "update register_courses "
                    + "set status = 3 "
                    + " where register_courses_id = '"+dvr+"' ";
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
