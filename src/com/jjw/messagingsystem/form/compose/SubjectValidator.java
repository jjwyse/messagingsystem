package com.jjw.messagingsystem.form.compose;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.datanucleus.util.StringUtils;

public class SubjectValidator implements ConstraintValidator<Subject, String>
{
    @Override
    public void initialize(Subject subject)
    {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        return !StringUtils.isEmpty(value);
    }
}
