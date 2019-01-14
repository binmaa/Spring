package com.binmma.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 日期类型转换
 * S
 * @author 马斌
 *
 */
public class ConverDate implements Converter<String, Date> {
	private final String pattern = "yyyy-MM-dd";

	@Override
	public Date convert(String source) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = dateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
