/**
 * 
 */
package com.jjw.messagingsystem.security.form;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * @author Luke Taylor
 */
public class FirstNameValidator implements ConstraintValidator<FirstName, String>
{
    private static final Pattern VALID = Pattern.compile("[\\p{L}'\\-,.]+");

    public void initialize(FirstName constraintAnnotation)
    {
    }

    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        return VALID.matcher(value).matches();
    }
}
