package com.binmma.utils;


import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class ConverInt implements Converter<String, Integer> {

	@Override
	public Integer convert(String source) {
		return Integer.valueOf(source)-1;
	}

}
