/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gli.hiring.hiring.gli.validator;

import com.gli.hiring.hiring.gli.validator.constraint.PasswordConstraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author fahrul
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = PasswordConstraint.class)
public @interface PasswordValidation {
    String message() default "Please enter valid password";
    Class<? extends Payload>[] payload() default {};
    Class<?>[] groups() default {};
}
