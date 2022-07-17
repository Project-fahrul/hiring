/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.repository;

import com.gli.hiring.hiring.gli.model.EmployeeModel;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fahrul
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer>{
    Optional<EmployeeModel> findByEmail(String email);
    
  }
