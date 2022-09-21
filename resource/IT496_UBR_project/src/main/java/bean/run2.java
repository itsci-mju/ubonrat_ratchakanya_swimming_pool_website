package bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class run2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
		Calendar birthdate = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		birthdate.set(2543, 8, 8);
		
		long b = (long) (birthdate.getTimeInMillis()/(86400000*365.25));
		 long n = (long) ((Calendar.getInstance().getTimeInMillis()-543)/(86400000*365.25));
		 long a = n - b;
		 
		 System.out.println(a);
		
	}

}
