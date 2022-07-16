/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.model;

import com.gli.hiring.hiring.gli.validator.EnumValues;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
 /*
 * @author fahrul
 */
@Data
public class EmployeeModel {
    @Size(min=3, message="Name should be atleast 3 character")
    private String name;
    
    @Email
    private String email;
    
    @NotNull(message="Please enter salary")
    private Double salary;
    
    @NotNull(message="Please enter gender")
    @EnumValues(enumClass = GenderEnum.class)
    private String gender;

    public static enum GenderEnum{
        MALE, FEMALE
    }
}
