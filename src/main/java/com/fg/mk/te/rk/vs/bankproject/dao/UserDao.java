package com.fg.mk.te.rk.vs.bankproject.dao;

import com.fg.mk.te.rk.vs.bankproject.beans.UserClass_A;

public interface UserDao {
	int RegisterLogin(UserClass_A login);

	UserClass_A validateUser(UserClass_A login);
}
