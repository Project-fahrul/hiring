/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gli.hiring.hiring.gli.validator;

import com.gli.hiring.hiring.gli.validator.constraint.EnumConstraint;
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
@Constraint(validatedBy = EnumConstraint.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD})
public @interface EnumValidation {

    Class<? extends Enum<?>> enumClass();

    String message() default "Please enter gender wih MALE or Female";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
