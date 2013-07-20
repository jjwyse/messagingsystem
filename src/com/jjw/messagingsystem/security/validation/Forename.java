package com.jjw.messagingsystem.security.validation;

import static java.lang.annotation.ElementType.*;

import javax.validation.Payload;

import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Target;
import javax.validation.Constraint;

/**
 * @author jjwyse
 * 
 */
@Target(
{ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ForenameValidator.class)
public @interface Forename
{
    String message() default "{com.jjw.messagingsystem.security.validation.Forename}";

    Class<?>[] groups() default
    {};

    Class<? extends Payload>[] payload() default
    {};
}
