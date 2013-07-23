package com.jjw.messagingsystem.form.compose;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author jjwyse
 * 
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ToUserNameValidator.class)
public @interface ToUserName
{
    String message() default "Invalid user name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
