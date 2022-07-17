package com.gli.hiring.hiring.gli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gli.hiring.hiring.gli.component.ResponsePayload;
import com.gli.hiring.hiring.gli.model.EmployeeModel;
import com.gli.hiring.hiring.gli.repository.EmployeeRepository;
import com.gli.hiring.hiring.gli.service.EmployeeService;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@WebMvcTest(controllers = EmployeeController.class)
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackageClasses = {com.gli.hiring.hiring.gli.component.ResponsePayload.class})
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
        
        Optional<EmployeeModel> employee= Optional.of(model);
        given(employeeService.getById(1)).willReturn(employee);
        this.mockMvc.perform(get(path+"/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

//    @Test
//    public void getAllEmployee() throws Exception {
//        this.mockMvc.perform(get(path)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void UpdateEmployee() throws Exception {
//        this.mockMvc.perform(post(path)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mp.writeValueAsString(model)))
//                .andExpect(status().isCreated())
//                .andExpect(header().string("content-type", "application/json"))
//                .andExpect(jsonPath("$.status", is("success")));
//
//        model.setName("Putra");
//
//        this.mockMvc.perform(put(path + "/2")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mp.writeValueAsString(model)))
//                .andExpect(status().isCreated());
//    }
}
