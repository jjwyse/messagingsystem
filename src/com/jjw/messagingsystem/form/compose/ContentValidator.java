package com.jjw.messagingsystem.form.compose;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.datanucleus.util.StringUtils;

/**
 * Validates the content section of a message that the user sends in via the ComposeForm
 * 
 * @author jjwyse
 * 
 */
public class ContentValidator implements ConstraintValidator<Content, String>
{
    @Override
    public void initialize(Content content)
    {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        return !StringUtils.isEmpty(value);
    }
}
