package com.binmma.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.binmma.model.User;

@Controller
public class TestControl {
	@Autowired
	@Qualifier("user")
	private User user;

	@RequestMapping(value = "/testcontrol", method = RequestMethod.GET)
	public ModelAndView testControl() {
		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("msg", user.getName());
		user.setId("1");
		modelAndView.setViewName("MyJsp");
		return modelAndView;
	}

	@RequestMapping(value = "/testcontrol/{version}", method = RequestMethod.GET)
	public String testControl2(@PathVariable("version") String version,
			User user, @RequestParam("ids") Integer ids, Integer id,
			ModelAndView modelAndView, Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession httpSession) {
		String parameter = request.getParameter("id");
		Map<String, Object> asMap = model.asMap();
		boolean containsAttribute = model.containsAttribute("id");
		HttpSession session = request.getSession();
		model.addAttribute("msg", "binmmaa");
		// modelAndView.setViewName("MyJsp");
		// ModelAndView modelAndView = new ModelAndView();
		return "MyJsp";
	}

	@RequestMapping(value = "/testcontrol3", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public ModelAndView testControl3(User user, Integer[] ids, Date date,
			String tset, Integer number) {
//		int i = 5/0;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UploadFile");
//		modelAndView.addObject("msg", "高级参数绑定");
		return modelAndView;
	}

	@RequestMapping("/testcontrol4")
	public void testControl4(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", "request.getRequestDispatche");
		request.getRequestDispatcher("/WEB-INF/jsp/MyJsp.jsp").forward(request,
				response);
//		response.sendRedirect("");

	}
	@RequestMapping("/testcontrol5")
	public void testControl5(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("msg", "request.getRequestDispatche");
//		request.getRequestDispatcher("/WEB-INF/jsp/MyJsp.jsp").forward(request,
//				response);
		response.sendRedirect("testcontrol4.action");

	}
	
	@RequestMapping("/testcontrol6")
	public void testControl6(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", "request.getRequestDispatche 6");
		request.getRequestDispatcher("testcontrol5.action").forward(request,
				response);
//		response.sendRedirect("");
	}
	
	@RequestMapping("/testcontrol7")
	public String testControl7(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", "forward:MyJsp");
//		return "forward:testcontrol3.action";
		return "redirect:testcontrol3.action";
	}
	
	@RequestMapping("/json")
	public @ResponseBody User testJson(@RequestBody User u) {
		User user2 = new User();
		user2.setName("马斌");
		user2.setAge(25);
		return user2;
	}
}
