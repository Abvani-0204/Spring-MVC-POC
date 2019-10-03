package com.pp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pp.model.User;

@Component
public class RegistrationValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		System.out.println("start validator method");
		ValidationUtils.rejectIfEmpty(errors, "firstname", "error.firstname.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "error.lastname.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "contact", "error.contact.empty");
		
		/*ValidationUtils.rejectIfEmpty(errors, "firstname", "errorcode.empty", "Enter the lastname");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "errorcode.empty", "Enter the lastname");
		ValidationUtils.rejectIfEmpty(errors, "email", "errorcode.empty", "Enter the email");
		ValidationUtils.rejectIfEmpty(errors, "password", "errorcode.empty", "Enter the password");
		ValidationUtils.rejectIfEmpty(errors, "contact", "errorcode.empty", "Enter the contactNo");
		*/

		if (user.getFirstname().isEmpty() == false && user.getFirstname().length() >= 50) {
			errors.rejectValue("firstname", "firstname.required", "firstname should be less than 11 charactrs");
		}

		if (user.getLastname().isEmpty() == false && user.getLastname().length() >= 50) {
			errors.rejectValue("lastname", "Lastname.required", "Lastname should be less than 11 charactrs");
		}

		if (user.getPassword().length() < 8 || user.getPassword().length() > 11) {
			errors.rejectValue("password", "password.required",
					"password should be GREATER THAN 8 AND less than 11 charactrs");
		}

		if (user.getEmail().isEmpty() == false && !user.getEmail().endsWith("@gmail.com")) {
			errors.rejectValue("email", "email.required", "invalid email.");
		}
		
		if (user.getContact()<999999999l || user.getContact()>9999999999l) {
			errors.rejectValue("contact","Lastname.required", "contact should be of 10  charactrs");
		}
		
		
	}
}
