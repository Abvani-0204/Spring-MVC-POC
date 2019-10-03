package com.pp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.pp.validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pp.model.Product;
import com.pp.model.User;
import com.pp.service.LoginService;



@Controller
public class LoginController {
	
 
@Autowired
private LoginService loginService;
	
@Autowired
private LoginValidator loginValidator;
	

	
	/*
	@RequestMapping("/ShowLogin")
	public String viewLogin(Map<String,Object> map,Model model) {
		
		System.out.println("Inside Controller");
		
		User user=new User();
		model.addAttribute("userObject",user);
		//map.put("userObject", user);
		
		return "Login";
		
	}
	
	@RequestMapping(value= "/userSignIn" , method=RequestMethod.POST)
	public String signAction(@ModelAttribute("userObject") User user,BindingResult result , Model model) {
		
		System.out.println("Inside login Post Controller");
		
		user= loginService.serviceCheckin(user);
		
		loginValidator.validate(user,result);	
		if(user != null)
		{	System.out.println("Email is:"+user.getEmail());
		System.out.println("Password is:"+user.getPassword());
		
		loginService.userSignIn(user);
		model.addAttribute("proObject", new Product());// to hold product object to get to product page
		return "Product";
		}
		else 
		{ System.out.println("Login controller invalid credentials");
			return "Login";
	}
}*/
	//Third Process of Common Method Merging
	
		@RequestMapping(value="/userSignIn" , method= {RequestMethod.GET,RequestMethod.POST})
		public String viewLogin(@ModelAttribute("userObject") User user , BindingResult result, Model model,HttpServletRequest request) {
		
			String method=request.getMethod();
			
			if(("GET").equals(method)) {
				System.out.println("Inside Login Controller");
				//User user=new User();
				model.addAttribute("userObject", user);
				return "Login";
			}
			//in else part post logic will be executed
			else {
			
				System.out.println("Inside check Login method Controller");
				user=loginService.serviceCheckin(user);	
				loginValidator.validate(user, result);
				
				if(user!=null){
					System.out.println("inside if condition in controller");
					System.out.println("Email is:"+user.getEmail());
					System.out.println("Password is:"+user.getPassword());
				
					loginService.userSignIn(user);
					model.addAttribute("proObject", new Product()); //product obj created to hold the product page for return.
					
					System.out.println("inside if condition before session created in controller");
					
					HttpSession session=request.getSession();
					session.setAttribute("LoginSession",user);
					//return "addProduct.do";
					return "Product";
				}
				else {
					System.out.println("Login controller Invalid Credentials");
					//return "userSignIn.do";
					return "Login";
				}
			}
		}
		
		@RequestMapping(value="/logout")
		public String showLogout(Map<String, Object> map,User user, Model model, HttpServletRequest request, HttpServletResponse httpResponse) {
			System.out.println("Inside logout method in login controller");
			model.addAttribute("userObject", user);
			HttpSession session = request.getSession();
			session.invalidate();
			return "Login";
			//return "redirect:/userSignIn.do";
		}

}