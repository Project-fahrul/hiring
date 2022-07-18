/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.controller;

import com.gli.hiring.hiring.gli.component.ResponsePayload;
import com.gli.hiring.hiring.gli.model.EmployeeModel;
import com.gli.hiring.hiring.gli.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fahrul
 */
@RestController
@RequestMapping("/employee")
@Api(value = "API to act CRUD to employee",
        description = "This API provides the capability to create, search employee from a Employee Repository", produces = "application/json")
public class EmployeeController {

    @Autowired
    ResponsePayload responsePayload;

    @Autowired
    EmployeeService employeeService;
    
    @ApiOperation(value = "Create employee. The X-Access-Token see in application.properties", produces = "application/json")
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody EmployeeModel employeeModel) {
        return new ResponseEntity<>(responsePayload
                .setStatusSuccess()
                .setData(employeeService.save(employeeModel))
                .getHash(),
                HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get All employee. The X-Access-Token see in application.properties", produces = "application/json")
    @GetMapping
    public ResponseEntity<Object> getEmployee() {
        return new ResponseEntity<>(responsePayload
                .setStatusSuccess()
                .setData(employeeService.getAll())
                .getHash(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get Employee by ID. The X-Access-Token see in application.properties", produces = "application/json")
    @GetMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<Object> getEmployee(@PathVariable String id) {
        return new ResponseEntity<>(responsePayload
                .setStatusSuccess()
                .setData(employeeService.getById(Integer.parseInt(id)))
                .getHash(), HttpStatus.OK);

    }

    
    @ApiOperation(value = "Update employee. The X-Access-Token see in application.properties", produces = "application/json")
    @PutMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<Object> updateEmployee(@RequestBody @Valid EmployeeModel employeeModel, @PathVariable String id) {
        Optional<EmployeeModel> currentEmployeeModel = employeeService.getById(Integer.parseInt(id));
        if(!currentEmployeeModel.isPresent()){
            return new ResponseEntity<>(responsePayload.setStatusError().setEmptyData().getHash(), HttpStatus.BAD_REQUEST);
        }
        EmployeeModel data = employeeModel;
        if(!Objects.nonNull(data.getId())){
            data.setId(Integer.parseInt(id));
        }
        
        return new ResponseEntity<>(responsePayload
                .setStatusSuccess()
                .setData(employeeService.update(data))
                .getHash(), HttpStatus.CREATED);
    }

    
    @ApiOperation(value = "Delete employee by ID. The X-Access-Token see in application.properties", produces = "application/json")
    @DeleteMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<Object> deleteEmployee(@PathVariable String id) {
         employeeService.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>(responsePayload
                .setStatusSuccess()
                .setEmptyData()
                .getHash(), HttpStatus.OK);
    }
}
