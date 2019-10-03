package com.pp.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.User;

@Repository
public class RegistrationRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
   public void register(User register) {
		if(register!=null && register.getContact()!=0)
			
		{
		System.out.println("Inside registration  Repository Controller");
		System.out.println("Email is : "+register.getEmail());
		System.out.println("Password is : "+register.getPassword());
		System.out.println("firstname :"+register.getFirstname());
		System.out.println("contact:"+ register.getContact());
		System.out.println("lastname:"+register.getLastname());
		hibernateTemplate.save(register);
		System.out.println("registration succesfull");
		}
		else
		{
			System.out.println("unsuccesfull registration");
		}
}
}
