package com.binmma.mapper;

import java.util.List;

import com.binmma.model.QueryVo;
import com.binmma.model.User;


public interface UserMapper {
	public User getUserByID(int id);
	public List<User> getUserByQueryVo(QueryVo queruVo);
	List<User> getUserByUser(User user);
	List<User> getUserByIds(List<Integer> Ids);
	List<User> getUserOrders();
}
