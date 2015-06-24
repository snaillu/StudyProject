package com.snail.springrecips.sequence1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePrefixGenerator implements PrefixGenerator {
	private DateFormat formatter;
	
	public void setFormatter(String pattern) {
		this.formatter = new SimpleDateFormat(pattern);
	}

	public String getPrefix() {
		return formatter.format(new Date());
	}

}
