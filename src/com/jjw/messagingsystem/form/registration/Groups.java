package com.jjw.messagingsystem.form.registration;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Represents the groups part of our registration form.
 * 
 * @author jjwyse
 * 
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GroupsValidator.class)
public @interface Groups
{
    String message() default "Invalid group selection";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
