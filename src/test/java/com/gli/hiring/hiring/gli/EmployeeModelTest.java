package com.gli.hiring.hiring.gli;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gli.hiring.hiring.gli.controller.EmployeeController;
import com.gli.hiring.hiring.gli.model.EmployeeModel;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = EmployeeController.class)
@ComponentScan
class EmployeeModelTest {
            
        @Autowired
        private MockMvc mockMvc;
        
	@Test
	public void TestCreateEmployee() throws Exception {
            EmployeeModel model = new EmployeeModel();
            
            model.setEmail("fahrulputraa40@gmail.com");
            model.setGender("MALE");
            model.setName("Fahrul");
            model.setSalary(new Double(1222));
            
            ObjectMapper mp = new ObjectMapper();
            mp.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
            ObjectWriter ow = mp.writer().withDefaultPrettyPrinter();
            
            this.mockMvc.perform(post("/employee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(ow.writeValueAsString(model)))
                    .andExpect(status().isCreated())
                    .andExpect(header().string("content-type", "application/json"))
                    .andExpect(jsonPath("$.status", is("success")));
            
            model = new EmployeeModel();
            model.setEmail("fahrulputraa40@gmail.com");
            model.setName("Fahrul");
            model.setSalary(new Double(1222));
            
            ow = mp.writer().withDefaultPrettyPrinter();
            
            this.mockMvc.perform(post("/employee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(ow.writeValueAsString(model)))
                    .andExpect(status().isBadRequest());
	}

}
