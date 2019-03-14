package com.binmma.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ApplicationContext 工具类
 * @author mabin
 *
 */
public class ApplicationContextUtils implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ApplicationContextUtils.applicationContext=applicationContext;
	}
	
	public static Object getBean(String beanName){
		return applicationContext.getBean(beanName);
	}

}
