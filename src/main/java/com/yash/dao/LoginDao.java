package com.yash.dao;

import com.yash.model.Login;

public interface LoginDao {

	boolean authenticateUser(Login user);

	void registerUser(Login user);

}
