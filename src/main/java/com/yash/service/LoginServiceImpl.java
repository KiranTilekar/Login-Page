package com.yash.service;

import com.yash.dao.*;
import com.yash.model.Login;

public class LoginServiceImpl implements LoginService {
	private LoginDao logindao = new LoginDaoImpl();
	
	@Override
	public boolean authenticateUser(Login user) {
		
		return logindao.authenticateUser(user);
	}

	@Override
	public void registerUser(Login user) {
		logindao.registerUser(user);
	}
	
	

}
