/**
 * 
 */
package com.jjw.messagingsystem.form.registration;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * Validates that the first name of our form is legit. Shout out to @author Luke Taylor for the regex.
 * 
 * @author Josh Wyse
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
