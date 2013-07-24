package com.jjw.messagingsystem.form.compose;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.datanucleus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.service.UserServiceIF;

/**
 * Validates that if the user sends a message to a specific user, that the user name is legit.
 * 
 * @author jjwyse
 * 
 */
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
        if (!StringUtils.isEmpty(userName))
        {
            return myUserService.userExists(userName);
        }
        return true;
    }

}
