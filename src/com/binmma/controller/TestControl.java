package com.binmma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.binmma.model.User;

@Controller
public class TestControl {
	@Autowired
	@Qualifier("user")
	private User user;
	@RequestMapping(value="/testcontrol",method=RequestMethod.GET)
	public ModelAndView testControl(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", user.getName());
		modelAndView.setViewName("MyJsp");
		return modelAndView;
	}
	

}
