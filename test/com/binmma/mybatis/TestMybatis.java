package com.binmma.mybatis;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.binmma.mapper.UserMapper;
import com.binmma.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TestMybatis {
	Logger log = LoggerFactory.getLogger(TestMybatis.class);

	private ApplicationContext context;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("classpath:spring-mvc.xml");
	}

	@Test
	public void getUserByID() {
		UserMapper userMapper = context.getBean(UserMapper.class);
		PageHelper.startPage(2, 2);
		List<User> list = userMapper.getUserByIds(Arrays.asList(1,22,23,24,25,26,27,28,29));
		User user2 = list.get(0);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		List<User> list2 = pageInfo.getList();
		User user = list.get(0);
		
		log.error(list.toString());
	}
}
