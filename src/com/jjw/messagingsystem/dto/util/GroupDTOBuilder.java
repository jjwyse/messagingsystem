package com.jjw.messagingsystem.dto.util;

import com.google.appengine.api.datastore.Entity;
import com.jjw.messagingsystem.dto.GroupDTO;

public class GroupDTOBuilder extends MessagingSystemDTOBuilder
{
    public static Entity toEntity(GroupDTO groupDTO)
    {
        Entity groupEntity = new Entity(GROUP_TYPE);

        groupEntity.setProperty(GROUP_NAME, groupDTO.getGroupName());

        return groupEntity;
    }
}
