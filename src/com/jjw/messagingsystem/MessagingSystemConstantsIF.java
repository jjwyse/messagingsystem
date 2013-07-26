package com.jjw.messagingsystem;

/**
 * Common place to store all of our constants
 * 
 * @author jjwyse
 * 
 */
public interface MessagingSystemConstantsIF
{
    // Model attributes
    String MODEL_ERROR = "error";
    String MODEL_MESSAGES = "messages";

    // Views
    String VIEW_DISABLED = "disabled";
    String VIEW_INBOX = "inbox";
    String VIEW_REGISTER = "registration";

    // Entities
    String ENTITY_USER = "user";

    // Groups
    String GROUP_ZE_WORLD = "zeWorld"; // group that represents all users

    // Udacity users' entity properties
    String USERS_TYPE = "Users";
    String USERS_FIRSTNAME = "firstName";
    String USERS_LASTNAME = "lastName";
    String USERS_USERNAME = "userName";
    String USERS_EMAIL = "email";
    String USERS_GROUPS = "groups";
    String USERS_ENABLED = "enabled";
    String USERS_AUTHORITIES = "authorities";

    // Udacity messages' entity properties
    String MESSAGES_TYPE = "Messages";
    String MESSAGES_ID = "messageId";
    String MESSAGES_FROM_USERNAME = "fromUserName";
    String MESSAGES_TO_USERNAME = "toUserName";
    String MESSAGES_TO_GROUPNAME = "toGroupName";
    String MESSAGES_CONTENT = "content";
    String MESSAGES_SUBJECT = "subject";
    String MESSAGES_DATE = "date";
    String MESSAGES_IS_READ = "isRead";

    // Udacity groups' entity properties
    String GROUPS_TYPE = "Groups";
    String GROUPS_NAME = "groupName";

    // Udacity usersmessagesxref entity properties
    String USERSMESSAGESXREF_TYPE = "UsersMessagesXref";

    // Prefix for Spring MVC
    String REDIRECT = "redirect:";
}
