package com.journaldev.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journaldev.spring.repository.LoginRepository;

@Component
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public LoginRepository getLoginRepository() {
		return loginRepository;
	}

	public void setLoginRepository(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	
}
