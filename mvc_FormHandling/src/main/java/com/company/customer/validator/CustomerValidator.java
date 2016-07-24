package com.company.customer.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.company.customer.model.Customer;

public class CustomerValidator implements Validator{

	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return Customer.class.isAssignableFrom(clazz);

	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"required.userName", "El campo Nombre de Usuario es Necesario.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
				"required.address", "El campo direccion es Necesarios.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "El campo clave es Necesarios.");
			
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"required.confirmPassword", "El campo clave es Necesarios.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", 
				"required.sex", "El campo sexo es Necesarios.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "favNumber", 
				"required.favNumber", "El campo Numero es Necesarios.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "javaSkills", "required.javaSkills","El campo Skill es Necesarios.");
		
		Customer cust = (Customer)target;
		
		if(!(cust.getPassword().equals(cust.getConfirmPassword()))){
			errors.rejectValue("password", "notmatch.password");
		}
		
		if(cust.getFavFramework().length==0){
			errors.rejectValue("favFramework", "required.favFrameworks");
		}

		if("NONE".equals(cust.getCountry())){
			errors.rejectValue("country", "required.country");
		}
		
	}
	
}