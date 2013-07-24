package com.jjw.messagingsystem.form.compose;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.datanucleus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.service.UserServiceIF;

public class ToUserNameValidator implements ConstraintValidator<ToUserName, String>
{
    @Autowired
    UserServiceIF myUserService;

    @Override
    public void initialize(ToUserName toUserName)
    {
    }

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context)
    {
        return !StringUtils.isEmpty(userName) && myUserService.userExists(userName);
    }

}
