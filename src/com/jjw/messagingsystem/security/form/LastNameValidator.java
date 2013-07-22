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

public class LastNameValidator implements ConstraintValidator<LastName, String>
{
    private static final Pattern VALID = Pattern.compile("[\\p{L}'\\-,.]+");

    public void initialize(LastName constraintAnnotation)
    {
    }

    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        return VALID.matcher(value).matches();
    }
}