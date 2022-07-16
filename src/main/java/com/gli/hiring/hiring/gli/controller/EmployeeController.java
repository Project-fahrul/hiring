/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.controller;

import com.gli.hiring.hiring.gli.model.EmployeeModel;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fahrul
 */
@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    
    
    @PostMapping
    public ResponseEntity<EmployeeModel> createEmployee(@Valid @RequestBody EmployeeModel employeeModel){
        return new ResponseEntity<EmployeeModel>(employeeModel, HttpStatus.CREATED);
    }
}
