package com.cheng.interceptors;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor2 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 192.*.*.*
		// 10.*.*.*
		System.out.println(request.getRemoteAddr().toString());
		System.out.println("preHandle-------------");
		boolean bool = Pattern.matches("(192.*.*.*)|(10.*.*.*)", request
				.getRemoteAddr().toString());
		if (bool) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle-------------");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion-------------");
	}

}
