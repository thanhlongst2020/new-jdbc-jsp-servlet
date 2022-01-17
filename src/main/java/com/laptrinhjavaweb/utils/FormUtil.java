package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FormUtil {
	public <T> T toModel(Class<T> tClass, HttpServletRequest request) {
		T object = null;
		return object;
	}
}
