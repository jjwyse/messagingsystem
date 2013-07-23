package com.jjw.messagingsystem.form.compose;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.datanucleus.util.StringUtils;

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
