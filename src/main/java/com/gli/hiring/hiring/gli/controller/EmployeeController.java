/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.controller;

import com.gli.hiring.hiring.gli.component.ResponsePayload;
import com.gli.hiring.hiring.gli.model.EmployeeModel;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fahrul
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    ResponsePayload responsePayload;
    
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody EmployeeModel employeeModel){
        return new ResponseEntity<Object>(responsePayload.setStatus("success").setData(employeeModel).getHash(), HttpStatus.CREATED);
    }
}
