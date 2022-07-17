/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.service;

import com.gli.hiring.hiring.gli.model.EmployeeModel;
import com.gli.hiring.hiring.gli.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fahrul
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    //save
    public EmployeeModel save(EmployeeModel employee){
        return employeeRepository.save(employee);
    }
    
    //get
    public List<EmployeeModel> getAll(){
        List<EmployeeModel> d = (List<EmployeeModel>) employeeRepository.findAll();
        return d;
    }
    
    //get by id
    public Optional<EmployeeModel> getById(Integer id){
        return employeeRepository.findById(id);
    }
    
    //update
    public EmployeeModel update(EmployeeModel employee){
        return employeeRepository.save(employee);
    }
    
    //delete
    public void deleteById(Integer id){
        employeeRepository.deleteById(id);
    } 

    public Optional<EmployeeModel> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
