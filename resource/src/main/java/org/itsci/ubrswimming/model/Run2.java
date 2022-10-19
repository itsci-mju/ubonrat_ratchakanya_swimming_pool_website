package org.itsci.ubrswimming.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class Run2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
		Calendar birthdate = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		Calendar cur = Calendar.getInstance();
		birthdate.set(2543, 8, 8);
		birthdate.set(2543, 8, 8, 8, 59);
		long b = (long) (birthdate.getTimeInMillis()/(86400000*365.25));
		 long n = (long) ((Calendar.getInstance().getTimeInMillis()-543)/(86400000*365.25));
		 long a = n - b;
		 
		 ArrayList<String> x = new ArrayList<String>();
		 ArrayList<String> y = new ArrayList<String>();
		 x.add("a");
		 x.add("b");
		 x.add("c");
		 x.add("d");
		 y.add("a");
		 y.add("c");
		 y.add("f");
		 y.add("g");
		 System.out.println("before:"+x);
		 for(int i=0;i<x.size();i++) {
			 for(int u=0;u<y.size();u++) {
				 if(x.get(i).contains(y.get(u))) {
					 x.remove(i);
				 }
			 }
		 }

		 System.out.println("after:"+x);
		 System.out.println(y);
		 
	}

}
