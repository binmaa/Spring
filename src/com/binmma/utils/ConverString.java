package com.binmma.utils;


import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class ConverString implements Converter<String, String> {

	@Override
	public String convert(String source) {
		return source;
	}

}
