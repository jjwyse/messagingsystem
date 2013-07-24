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
 * The subject line of a message the user sends
 * 
 * @author jjwyse
 * 
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SubjectValidator.class)
public @interface Subject
{
    String message() default "Invalid subject";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
