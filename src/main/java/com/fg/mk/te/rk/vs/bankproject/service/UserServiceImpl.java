package com.fg.mk.te.rk.vs.bankproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fg.mk.te.rk.vs.bankproject.beans.UserClass_A;
import com.fg.mk.te.rk.vs.bankproject.dao.UserDao;

public class UserServiceImpl implements UserService  {
	@Autowired
	public UserDao userDao;
	
	public int RegisterLogin(UserClass_A user) {
		return userDao.RegisterLogin(user);
	}
	
	public UserClass_A validateUser(UserClass_A user) {
		return userDao.validateUser(user);
	}
}
