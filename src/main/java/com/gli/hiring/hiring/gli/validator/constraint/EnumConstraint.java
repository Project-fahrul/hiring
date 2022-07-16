/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.validator.constraint;

import com.gli.hiring.hiring.gli.validator.EnumValues;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author fahrul
 */
public class EnumConstraint implements ConstraintValidator<EnumValues, String> {
        
        private List<String> value = null;
        
        @Override
        public void initialize(EnumValues constraintAnnotation) {
            value = new ArrayList<String>();
            Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClass();
            
            Enum[] enumVal = enumClass.getEnumConstants();
            for(Enum e : enumVal){
                value.add(e.toString());
            }
        }

        @Override
        public boolean isValid(String val, ConstraintValidatorContext cvc) {
            return value.contains(val);
        }

    }
