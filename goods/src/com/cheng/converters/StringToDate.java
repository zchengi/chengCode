package com.cheng.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDate implements Converter<String, Date> {

	/*
	 * 将字符串类型时间转换为date类型事件
	 */
	@Override
	public Date convert(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//如果日期格式不正确，不进行转换，如：2014-21321-11
		dateFormat.setLenient(false);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
