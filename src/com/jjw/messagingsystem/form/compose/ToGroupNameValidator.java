package com.jjw.messagingsystem.form.compose;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.datanucleus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.service.GroupServiceIF;

public class ToGroupNameValidator implements ConstraintValidator<ToGroupName, String>
{
    @Autowired
    GroupServiceIF myGroupService;

    @Override
    public void initialize(ToGroupName toGroupName)
    {
    }

    @Override
    public boolean isValid(String groupName, ConstraintValidatorContext context)
    {
        return !StringUtils.isEmpty(groupName) && myGroupService.groupExists(groupName);
    }
}
