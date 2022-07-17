/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.respository;

import com.gli.hiring.hiring.gli.model.EmployeeModel;
import com.gli.hiring.hiring.gli.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

/**
 *
 * @author fahrul
 */
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private EmployeeModel model;
    private String email;

    @BeforeEach
    public void setupModel() {
        email = "fahrulputraap40@gmail.com";
        model = new EmployeeModel();
        model.setEmail(email);
        model.setGender("MALE");
        model.setName("Fahrul");
        model.setSalary(new Double(1222));
        model.setPassword("Fahrul12345678#");
        model.setAddress("Sleman, Yogyakarta");
    }

    @Test
    @DisplayName("Create Employee")
    public void CreateEmployee() {
        model = employeeRepository.save(model);
        employeeRepository.flush();
        Optional<EmployeeModel> employeeModel = employeeRepository.findByEmail(email);
        Assert.assertTrue(employeeModel.isPresent());
        Assert.assertEquals(model, employeeModel.get());
    }

    @Test
    @DisplayName("Find All")
    public void findAll() {
        List<EmployeeModel> listEmployee = employeeRepository.findAll();
        Assert.assertNotNull(listEmployee);
    }

    @Test
    @DisplayName("Update Employee")
    public void updateEmployee() {
        employeeRepository.save(model);

        model.setName("Fahrul Putra");
        employeeRepository.save(model);

        Optional<EmployeeModel> employee = employeeRepository.findByEmail(email);
        Assert.assertTrue(employee.isPresent());
        Assert.assertEquals(employee.get(), model);
    }

    @Test
    @DisplayName("Delete Employee")
    public void deleteEmployee() {
        employeeRepository.save(model);
        Optional<EmployeeModel> employee = employeeRepository.findByEmail(email);
        Assert.assertTrue(employee.isPresent());
        employeeRepository.deleteById(employee.get().getId());
        employee = employeeRepository.findByEmail(email);
        Assert.assertFalse(employee.isPresent());
    }
}
