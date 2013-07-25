package com.jjw.messagingsystem.form.compose;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.datanucleus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.MessagingSystemConstantsIF;
import com.jjw.messagingsystem.service.GroupServiceIF;

/**
 * Validates that if the user enters in a group name to send a message to, that the group is legit.
 * 
 * @author jjwyse
 * 
 */
public class ToGroupNameValidator implements ConstraintValidator<ToGroupName, String>, MessagingSystemConstantsIF
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
        if (!StringUtils.isEmpty(groupName))
        {
            return (groupName.equals(GROUP_ZE_WORLD) || myGroupService.groupExists(groupName));
        }
        return true;
    }
}
