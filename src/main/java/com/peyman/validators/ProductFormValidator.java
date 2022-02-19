package com.peyman.validators;


import com.peyman.data.entities.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductFormValidator implements Validator {

	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		
		return Product.class.equals(paramClass);
	}

	//error code=messages.properties key
	@Override
	public void validate(Object target, Errors errors) {
		
		Product product=(Product) target;
		
		if (product.getProductCategory().equalsIgnoreCase("NONE")) {
			errors.rejectValue("productCategory", "empty", "Please select  a product category");
		}
		/*
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"productPrice","empty","ProductPrice can not be empty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"unitInStock", "empty","UnitInStock can not be empty");
		
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"discount","empty", "Discount can not be empty");*/
		
	}

	
}
