package com.jjw.messagingsystem.form.registration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.datanucleus.util.StringUtils;

/**
 * Validates that the user entered at least one group into their registration form.
 * 
 * @author jjwyse
 * 
 */
public class GroupsValidator implements ConstraintValidator<Groups, String>
{
    public void initialize(Groups constraintAnnotation)
    {
    }

    public boolean isValid(String groups, ConstraintValidatorContext context)
    {
        return !StringUtils.isEmpty(groups);
    }

}
