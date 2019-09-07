package com.day01.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.day01.entity.User;

public interface UserDao {
	public User getUser(Integer id);
	public int addUser(User user);
	public int updateUser(User user);
	public boolean deleteUser(Integer id);
	public List<User> findAll();
	@MapKey("id")
	public Map<Integer, User> findByMap();
	public List<User> findBydongtai(User user);
	
}
