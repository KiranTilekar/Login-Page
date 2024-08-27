package com.yash.service;

import com.yash.model.Login;

public interface LoginService {

	boolean authenticateUser(Login user);

	void registerUser(Login user);

}
