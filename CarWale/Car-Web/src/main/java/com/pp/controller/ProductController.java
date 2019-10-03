package com.pp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pp.model.Product;
import com.pp.model.User;
import com.pp.repo.ProductRepository1;
import com.pp.service.RegistrationService;
import com.pp.validator.ProductValidator1;


@Controller
public class ProductController {
	
	@Autowired
	private ProductValidator1 productValidator;
	@Autowired
	private ProductRepository1 productRepository;
	
/*	@RequestMapping(value="/addproduct", method=RequestMethod.GET)
	public String viewProduct(Map<String,Object> map,Model model) {
		
		System.out.println("Inside show product  Controller");
		Product product= new Product();
		model.addAttribute("proObject", product);
		
		return "Product";
	}	
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String saveDataforBooking(@ModelAttribute("proObject") Product br,BindingResult result, Model model, HttpServletRequest request) {
		System.out.println("inside savedata product controller");
		productvalidator.validate(br,result);
		if (result.hasErrors()) {
			System.out.println("inside if condition");
			return "Product";
		}
			else {
			productrepositiory.saveDataRepo(br);           //saving data in db
			
			model.addAttribute("proObject", new Product());
			System.out.println("after saving");
			
			List<Product> bl= productrepositiory.fetchDataRepo();         //after saving fetching data 
			System.out.println("after fetching data");
			model.addAttribute("getAllProduct",bl);
			return "Product";
	}
		
}*/
	
	@RequestMapping(value="/addProduct" , method= {RequestMethod.GET,RequestMethod.POST})
	public String viewLogin(@ModelAttribute("proObject") Product pro , BindingResult result, Model model,HttpServletRequest request) {
	
		String method=request.getMethod();
		
		if(("GET").equals(method)){
			System.out.println("Inside Show Product Controller");
			//Product pro=new Product();
			model.addAttribute("proObject", pro);
			return "Product";
		}
		//in else part post logic will be executed
		else {
			System.out.println("Inside save data product controller");
			
			productValidator.validate(pro, result);
			System.out.println("below validate method");
			
			if(result.hasErrors()) {
				System.out.println("Inside If Condition in product controller");
				return "Product";
			}
			
			else{
				productRepository.saveDataRepo(pro); //saving data in db
				model.addAttribute("proObject", new Product());
				System.out.println("After Saving");
				List<Product> procontlist=productRepository.fetchDataRepo();		//after saving fetching data 
				System.out.println("after fetching data");
				model.addAttribute("getAllProduct", procontlist);			
				return "Product";
				
				
			}
		}
	}


	
}


