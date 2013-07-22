package com.jjw.messagingsystem;

public interface MessagingSystemConstantsIF
{
    // Model attributes
    String MODEL_ERROR = "error";

    // Views
    String VIEW_INBOX = "inbox";
    String VIEW_NEW_USER = "newuser";
    String VIEW_REGISTER = "/register";

    // Entities
    String ENTITY_USER = "user";

    // Udacity users' entity properties
    String USER_TYPE = "MessagingSystemUser";
    String USER_FIRSTNAME = "firstName";
    String USER_LASTNAME = "lastName";
    String USER_USERNAME = "userName";
    String USER_EMAIL = "email";
    String USER_ENABLED = "enabled";
    String USER_AUTHORITIES = "authorities";

    // Prefix for Spring MVC
    String REDIRECT = "redirect:";
}
