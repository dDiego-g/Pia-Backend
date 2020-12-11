package com.example.pia.validations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = MontoMinimoValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface MontoMinimo {
	
	String message() default "*El monto minimo deber ser superior a 100.00.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
