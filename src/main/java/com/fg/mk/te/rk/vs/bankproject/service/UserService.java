package com.fg.mk.te.rk.vs.bankproject.service;

import com.fg.mk.te.rk.vs.bankproject.beans.UserClass_A;

public interface UserService {
	int RegisterLogin(UserClass_A login);

	UserClass_A validateUser(UserClass_A login);
}
