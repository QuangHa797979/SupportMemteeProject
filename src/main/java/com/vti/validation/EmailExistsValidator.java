//package com.vti.validation;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//import com.mysql.cj.util.StringUtils;
//import com.vti.service.MenteeService;
//
//public class EmailExistsValidator implements ConstraintValidator<EmailExists, String> {
//
//	private MenteeService service;
//
//	@Override
//	public void initialize(EmailExists annotation) {
//		service = new MenteeService();
//	}
//
//	@Override
//	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
//
//		if (StringUtils.isNullOrEmpty(value)) {
//			return false;
//		}
//
//		return service.isMenteeExistsByUserName(value);
//	}
//}