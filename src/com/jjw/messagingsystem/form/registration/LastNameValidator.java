/**
 * 
 */
package com.jjw.messagingsystem.form.registration;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validates that the last name field of our registration form is legit. Shout out to @author Luke Taylor for the regex.
 * 
 * @author jjwyse
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