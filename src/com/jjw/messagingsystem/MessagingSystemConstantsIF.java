package com.jjw.messagingsystem;

public interface MessagingSystemConstantsIF
{
    // Model attributes
    String MODEL_ERROR = "error";

    // Views
    String VIEW_INBOX = "inbox";
    String VIEW_LOGIN = "login";
    String VIEW_NEW_USER = "newUser";

    // Entities
    String ENTITY_USER = "user";

    // Entities' properties
    String ENTITY_PROP_FIRST_NAME = "firstName";
    String ENTITY_PROP_LAST_NAME = "lastName";
    String ENTITY_PROP_USERNAME = "userName";

    // Prefix for Spring MVC
    String REDIRECT = "redirect:";
}
