/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.controller;

import com.gli.hiring.hiring.gli.component.ResponsePayload;
import com.gli.hiring.hiring.gli.model.EmployeeModel;
import com.gli.hiring.hiring.gli.service.EmployeeService;
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
public class EmployeeController {

    @Autowired
    ResponsePayload responsePayload;

    @Autowired
    EmployeeService employeeService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody EmployeeModel employeeModel) {
        employeeService.getAll();
        return new ResponseEntity<Object>(responsePayload
                .setStatusSuccess()
                .setData(employeeService.save(employeeModel))
                .getHash(),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getEmployee() {
        return new ResponseEntity<>(responsePayload
                .setStatusSuccess()
                .setData(employeeService.getAll())
                .getHash(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable String id) {
        return new ResponseEntity<>(responsePayload
                .setStatusSuccess()
                .setData(employeeService.getById(Integer.parseInt(id)))
                .getHash(), HttpStatus.ACCEPTED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody @Valid EmployeeModel employeeModel, @PathVariable String id) {
        Optional<EmployeeModel> currentEmployeeModel = employeeService.getById(Integer.parseInt(id));
        if(!currentEmployeeModel.isPresent()){
            return new ResponseEntity<>(responsePayload.setStatusError().setEmptyData(), HttpStatus.BAD_REQUEST);
        }
        EmployeeModel data = currentEmployeeModel.get();
        if(Objects.nonNull(data)){
            data.setId(Integer.parseInt(id));
        }
        
        return new ResponseEntity<>(responsePayload
                .setStatusSuccess()
                .setData(employeeService.update(data))
                .getHash(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable String id) {
         employeeService.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>(responsePayload
                .setStatusSuccess()
                .setEmptyData()
                .getHash(), HttpStatus.ACCEPTED);
    }
}
