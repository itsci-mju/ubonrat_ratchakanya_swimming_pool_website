package org.itsci.ubrswimming.config;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StringToCalendarConverter implements Converter<String, Calendar> {
    @Override
    public Calendar convert(String source) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(sdf.parse(source));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal;
    }
}
