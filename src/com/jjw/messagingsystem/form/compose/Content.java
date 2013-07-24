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
 * The content of a message (i.e. the body of the actual message)
 * 
 * @author jjwyse
 * 
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContentValidator.class)
public @interface Content
{
    String message() default "Invalid content";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
