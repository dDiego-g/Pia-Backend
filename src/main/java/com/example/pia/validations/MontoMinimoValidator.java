package com.example.pia.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MontoMinimoValidator implements ConstraintValidator<MontoMinimo, Integer> {
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(value == null) {
			value=0;
		}
		return value >= 100;
	}

}
