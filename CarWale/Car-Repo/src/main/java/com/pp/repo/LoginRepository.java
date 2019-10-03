package com.pp.repo;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.User;

@Repository
public class LoginRepository {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public User userSignIn(User Login)
	{
		System.out.println(Login.getEmail());
		System.out.println(Login.getPassword());
		System.out.println("inside repository's usersignin method");
		return Login;
	}
	
	public List<User> repoCheckin(String email, String password) {
		if (email != null && password != null) {
			//List<User> welcome = template.find("from User us where us.email = ? and us.password = ?\", 2);
			List<User> ls = hibernateTemplate.find("from User us where us.email = ? and us.password = ?", email, password);	
			System.out.println(ls);
		  System.out.println("inside repo's checkin method");
			return ls;
		} else {
			System.out.println("inside loginreository else");
			return null;
		}	   
  }	
	}

