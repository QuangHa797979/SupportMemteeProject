package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.service.MenteeService;

public class EmailNotExistsValidator implements ConstraintValidator<EmailNotExists, String> {

	@Autowired
	private MenteeService service;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

		if (value == null || value.equals("")) {
			return true;
		}

		return !service.isMenteeExistsByEmail(value);
	}
}