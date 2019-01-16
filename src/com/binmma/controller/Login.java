package com.binmma.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class Login {
	@RequestMapping("tologin")
	public String toLogin(ModelAndView modelAndView, HttpSession httpSession,
			String userName) {
		return "Login";
	}

	@RequestMapping("login")
	public ModelAndView login(ModelAndView modelAndView,
			HttpSession httpSession, String userName,
			HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if ("binmma".equals(userName)) {
			httpSession.setAttribute("userName", userName);
		}
        //返回原url
		Object beforeUrl = httpSession.getAttribute("beforeUrl");
		Object method = httpSession.getAttribute("method");
        if (beforeUrl != null && beforeUrl != "") {
			httpSession.setAttribute("beforeUrl","");
			if ("GET".equals(method.toString())) {
                response.sendRedirect(request.getContextPath()
                        + beforeUrl.toString());
			}else{
				request.getRequestDispatcher((String) beforeUrl).forward(request, response);
			}
		}
		modelAndView.addObject("msg", "登陆成功");
		modelAndView.setViewName("MyJsp");
		return modelAndView;
	}

}
