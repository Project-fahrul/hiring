package com.gli.hiring.hiring.gli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gli.hiring.hiring.gli.model.EmployeeModel;
import com.gli.hiring.hiring.gli.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = EmployeeController.class)
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackageClasses = {
    com.gli.hiring.hiring.gli.component.ResponsePayload.class,
    com.gli.hiring.hiring.gli.security.UnauthorizationEntryPoinSecurity.class
})
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private EmployeeService employeeService;
 
    private EmployeeModel model;
    private String email;
    private ObjectMapper mp;
    private String path;

    @BeforeEach
    public void setup() {
        email = "fahrulputraa41@gmail.com";
        model = new EmployeeModel();
        model.setEmail(email);
        model.setGender("MALE");
        model.setName("Fahrul");
        model.setSalary(new Double(1222));
        model.setPassword("Fahrul12345678#");
        model.setAddress("Sleman, Yogyakarta");
        mp = new ObjectMapper();
        path = "/employee";
    }

    @Test
    public void TestCreateEmployee() throws Exception {
        given(employeeService.save(model)).willReturn(model);
        this.mockMvc.perform(post(path)
                .content(mp.writeValueAsString(model))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void getEmployeeById() throws Exception{        
        Optional<EmployeeModel> employee= Optional.of(model);
        given(employeeService.getById(any(Integer.class))).willReturn(employee);
        this.mockMvc.perform(get(path+"/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void getAllEmployee() throws Exception {
        List<EmployeeModel> model = new ArrayList<>();
        given(employeeService.getAll()).willReturn(model);
        this.mockMvc.perform(get(path)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void UpdateEmployee() throws Exception {
        
        given(employeeService.getById(any(Integer.class))).willReturn( Optional.of(model));
        
        given(employeeService.save(model)).willAnswer((invocation)-> invocation.getArgument(0));
        this.mockMvc.perform(put(path + "/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mp.writeValueAsString(model)))
                .andExpect(status().isCreated());
    }
    
    @Test
    public void DeleteEmployee() throws Exception{
       this.mockMvc.perform(delete(path+"/1")
                .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }
}
