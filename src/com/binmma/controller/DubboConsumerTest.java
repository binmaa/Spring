package com.binmma.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.binmaa.zk.Provider;

@Controller
@RequestMapping("/dubbo")
public class DubboConsumerTest {
	@Autowired
	private Provider provider;
	
	@RequestMapping("/consumer/{msg}")
	@ResponseBody
	public String consumer(@PathVariable("msg") String msg){
		String providerReturn = provider.provider(msg);
		return providerReturn;
	}

}
