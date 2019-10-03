package com.pp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.pp.model.Product;
import com.pp.model.User;

@Component
public class ProductValidator1 {
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Product pro = (Product) target;
		System.out.println("start product validator method");
		ValidationUtils.rejectIfEmpty(errors, "productName", "error.productName.empty");
		ValidationUtils.rejectIfEmpty(errors, "productDescription", "error.productDescription.empty");
		ValidationUtils.rejectIfEmpty(errors, "productPrice", "error.productPrice.empty");
		ValidationUtils.rejectIfEmpty(errors, "dateOfIssue", "error.dateOfIssue.empty");
		
		System.out.println("end product validator method");

		
	}
}
