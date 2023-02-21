package com.healthplus.processmanagement.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class GenericUtility {
	
	private static long getDays(Date date1, Date date2) {
		long diff = date2.getTime() - date1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public static long getYearsBetween(Date date1, Date date2) {
		return getDays(date1, date2) / 365;
	}

	public static long getDaysBetween(Date date1, Date date2) {
		return getDays(date1, date2);
	}
}
