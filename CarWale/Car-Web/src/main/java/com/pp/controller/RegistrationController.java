package com.pp.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pp.model.User;
import com.pp.service.RegistrationService;
import com.pp.validator.RegistrationValidator;



@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private RegistrationValidator registrationValidator;

	
	
/*@RequestMapping("/ShowRegistration")
	public String viewRegistration(Map<String, Object> map, Model model) {
		System.out.println("inside view registration");
		User user = new User();
		model.addAttribute("userR", user);
		//map.put("userR",user);
		return "Registration";
	}
	
	@RequestMapping(value= "/register" , method=RequestMethod.POST)
	public String signAction(@ModelAttribute("userR") User user,BindingResult result ,Model model,Map<String, Object> map, HttpServletRequest request) 
	{
		System.out.println("inside controller validate method");	
		
		registrationValidator.validate(user,result);
		if (result.hasErrors()) {
			System.out.println("inside if condition");
			return "Registration";
		} else {
			System.out.println("inside else condition");

		System.out.println("Inside Post register Controller");
		System.out.println("Email is:"+user.getEmail());
		System.out.println("Password is:"+user.getPassword());
		System.out.println("firstname :"+user.getFirstname());
		System.out.println("contact:"+ user.getContact());
		System.out.println("lastname:"+user.getLastname());
	    RegistrationService.register(user);	
	    model.addAttribute("userObject", new User());
		return "Login";
		}

}*/
	//Third Process of Common Method Merging
	@RequestMapping(value="/ShowRegistration" , method= {RequestMethod.GET,RequestMethod.POST})
	public String viewRegistration(@ModelAttribute("userObjectR") User user , BindingResult result, Model model,HttpServletRequest request) {
		String method=request.getMethod();
		if(("GET").equals(method)) {
			System.out.println("Inside register Controller");
			//User user=new User();
			model.addAttribute("userObjectR", user);
			return "Registration";
		} 
		//in else part post logic will be executed
		else {
			System.out.println("Inside Post Registration Controller");
			registrationValidator.validate(user,result);
			System.out.println("below validate method");
			if (result.hasErrors()) {
				System.out.println("inside if condition");
				return "Registration";
			} 
			else {
			System.out.println("FirstName is:"+user.getFirstname());
			System.out.println("LastName is:"+user.getLastname());
			System.out.println("Contact No. is:"+user.getContact());
			System.out.println("Email is:"+user.getEmail());
			System.out.println("Password is:"+user.getPassword());
				
			registrationService.register(user);
			model.addAttribute("userObject", new User());
			return "Login";		
			}	
		}
	}

}
