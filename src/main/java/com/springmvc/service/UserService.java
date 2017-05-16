package com.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.entities.User;

public interface UserService {
	 	public int addUser(User user);

	    public int deleteUser(Integer id);

	    public int updateUser(User user);

	    public User getUser(Integer id) ;


	    public List<User> getUserList() ;
}
