/**
 * 
 */
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
 * The last name part of our registration field.
 * 
 * @author Josh Wyse
 */

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LastNameValidator.class)
public @interface LastName
{
    String message() default "Invalid last name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}