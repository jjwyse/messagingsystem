package com.jjw.messagingsystem.form.compose;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.datanucleus.util.StringUtils;

public class ToUserNameValidator implements ConstraintValidator<ToUserName, String>
{
    @Override
    public void initialize(ToUserName toUserName)
    {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        return !StringUtils.isEmpty(value);
    }

}
