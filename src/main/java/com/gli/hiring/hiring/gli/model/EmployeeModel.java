/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import com.gli.hiring.hiring.gli.validator.EnumValidation;
import com.gli.hiring.hiring.gli.validator.PasswordValidation;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 /*
 * @author fahrul
 */
@Data
@Entity
@Table(name = "employee")
public class EmployeeModel implements Serializable {
    
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message="Please enter name")
    @Size(min=3, message="Name should be atleast 3 character")
    @Column(name = "name")
    private String name;
    
    @NotNull(message="Please enter email")
    @Email
    @Column(name = "email")
    private String email;
    
    @NotNull(message="Please enter salary")
    @Column(name = "salary")
    private Double salary;
    
    @NotNull(message="Please enter gender")
    @EnumValidation(enumClass = GenderEnum.class)
    @Column(name = "gender")
    private String gender;
    
    @NotNull(message = "Please enter password")
    @PasswordValidation
    @Column(name = "password")
    private String password;
    
    @NotNull(message = "Please enter address")
    @Column(name = "address")
    private String address;
    

    public static enum GenderEnum{
        MALE, FEMALE
    }

}
