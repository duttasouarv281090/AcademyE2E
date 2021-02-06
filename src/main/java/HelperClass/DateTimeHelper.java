package HelperClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeHelper {
	
	public static String getDateTime()
	{
		Calendar date = Calendar.getInstance();
		SimpleDateFormat dateformat=new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
		String date_time = dateformat.format(date.getTime());
		return date_time;
	}

	public static String getTime()
	{
		return getDateTime().substring(0, 11);
	}
}
