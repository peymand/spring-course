package com.peyman.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
   public void initialize(Phone constraint) {

   }

   public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
      if(phoneNumber ==null)
         return false;
      if(phoneNumber.matches("09[1-5][1-9]\\d{7}$"))
         return true;

      return false;
   }
}
