/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.validator.constraint;

import com.gli.hiring.hiring.gli.validator.PasswordValidation;
import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;

/**
 *
 * @author fahrul
 */
public class PasswordConstraint implements ConstraintValidator<PasswordValidation, String>{

    @Override
    public boolean isValid(String password, ConstraintValidatorContext cvc) {
        if(password == null){
        cvc.disableDefaultConstraintViolation();
        cvc.buildConstraintViolationWithTemplate("Password should be filled").addConstraintViolation();
            return false;
        }
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 200),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1)
        ));
        
        RuleResult res = validator.validate(new PasswordData(password));
        if(res.isValid())
               return true;
        List<String> errArray = validator.getMessages(res);
        String errorMessage = String.join(",", errArray);
        cvc.disableDefaultConstraintViolation();
        cvc.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
        return false;
    }
    
}
