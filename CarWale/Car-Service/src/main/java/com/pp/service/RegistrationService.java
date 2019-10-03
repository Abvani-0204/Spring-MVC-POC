package com.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.model.User;
import com.pp.repo.LoginRepository;
import com.pp.repo.RegistrationRepository;
@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository registrationrepository;
	
	public void register(User register) {

		System.out.println("Inside registration Service Controller");

		System.out.println("Email is:" + register.getEmail());
		System.out.println("Password is:" + register.getPassword());
		System.out.println("firstname :"+register.getFirstname());
		System.out.println("contact:"+ register.getContact());
		System.out.println("lastname:"+register.getLastname());
		registrationrepository.register(register);
	}

}
