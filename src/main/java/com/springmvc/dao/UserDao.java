package com.springmvc.dao;

import java.util.List;

import com.springmvc.entities.User;

public interface UserDao {
	public int addUser(User user);

    public int deleteUser(Integer id);

    public int updateUser(User user);

    public User getUser(Integer id);

    public List<User> getUserList();

}
