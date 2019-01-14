package com.binmma.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomeException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		String parameter = request.getParameter("id");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg","系统异常");
		modelAndView.setViewName("MyJsp");
		return modelAndView;
	}

}
