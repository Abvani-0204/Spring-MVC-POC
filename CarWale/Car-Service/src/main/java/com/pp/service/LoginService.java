package com.pp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.model.User;
import com.pp.repo.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	public User userSignIn(User login) {
		
	System.out.println("Inside Service Controller");
	
	System.out.println("Email is:"+login.getEmail());
	System.out.println("Password is:"+login.getPassword());
	
	loginRepository.userSignIn(login);
	return login;
	}
	
	public User serviceCheckin(User login) {
		{
			List<User> list = loginRepository.repoCheckin(login.getEmail(), login.getPassword());
					System.out.println("inside service checkin method");
	
			if (list != null && !list.isEmpty()) {	           //query output List from Login repo doesnt hold anything that's y else part is executed
				return list.get(0);                            //				
			}
		else {
			System.out.println("wrong email & password");
			return null;
		}
	  } 
	}
	
}
	

