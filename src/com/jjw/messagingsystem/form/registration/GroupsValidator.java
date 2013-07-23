package com.jjw.messagingsystem.form.registration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GroupsValidator implements ConstraintValidator<Groups, String>
{
    public void initialize(Groups constraintAnnotation)
    {
    }

    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        // TODO - check to make sure one of the values is checked
        return true;
    }

}
