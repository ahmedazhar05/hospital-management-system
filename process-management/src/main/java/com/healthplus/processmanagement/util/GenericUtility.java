package com.healthplus.processmanagement.util;

import java.util.Date;

public class GenericUtility {

	public int getYearsBetween(Date date, Date date2) {
		return date2.getYear() - date.getYear();
	}
}
