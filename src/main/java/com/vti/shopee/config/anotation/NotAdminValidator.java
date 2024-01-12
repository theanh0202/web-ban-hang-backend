package com.vti.shopee.config.anotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class NotAdminValidator implements ConstraintValidator<NotAdmin,String> {
    @Override
    public void initialize(NotAdmin constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String  name, ConstraintValidatorContext constraintValidatorContext  ) {
        return !name.contains("ADMIN");

    }
}
