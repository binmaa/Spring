package com.binmma.customInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Object userName = session.getAttribute("userName");
		//获取请求的uri
		String uri = request.getRequestURI();
		String path = uri.substring(request.getContextPath().length());//去掉项目地址长度的字符
        String query = request.getQueryString();
        String method = request.getMethod();
		if(userName == null){
            if (StringUtils.isNotEmpty(query)) {
                session.setAttribute("beforeUrl", path + "?" + query);
            } else {
                session.setAttribute("beforeUrl", path);
            }
			session.setAttribute("method", method);
			response.sendRedirect(request.getContextPath()+"/user/tologin");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginInterceptor...postHandle");

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginInterceptor...afterCompletion");

	}

}
