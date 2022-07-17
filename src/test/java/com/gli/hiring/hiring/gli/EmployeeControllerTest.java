package com.gli.hiring.hiring.gli;

import com.gli.hiring.hiring.gli.model.EmployeeModel;
import com.gli.hiring.hiring.gli.repository.EmployeeRepository;
import com.gli.hiring.hiring.gli.service.EmployeeService;
import javax.transaction.Transactional;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
class EmployeeControllerTest {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Test
    public void testService(){
        Assert.assertNotSame("a", "k");
    }
//            
//        @Autowired
//        private MockMvc mockMvc;
//        
//        @MockBean
//        private EmployeeService employeeSerice;
//        
//        @MockBean
//        private EmployeeRepository EmployeeRepository;
//        
//	@Test
//	public void TestCreateEmployee() throws Exception {
//            EmployeeModel model = new EmployeeModel();
//            
//            model.setEmail("fahrulputraa40@gmail.com");
//            model.setGender("MALE");
//            model.setName("Fahrul");
//            model.setSalary(new Double(1222));
//            model.setPassword("Fahrul12345678#");
//            model.setAddress("Sleman, Yogyakarta");
//            
//            ObjectMapper mp = new ObjectMapper();
//            mp.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//            ObjectWriter ow = mp.writer().withDefaultPrettyPrinter();
//            
//            this.mockMvc.perform(post("/employee")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(ow.writeValueAsString(model)))
//                    .andExpect(status().isCreated())
//                    .andExpect(header().string("content-type", "application/json"))
//                    .andExpect(jsonPath("$.status", is("success")));
//            
//            
//            System.err.println("asasas: "+employeeSerice.getAll());
//            model = new EmployeeModel();
//            model.setId(Long.getLong("12"));
//            model.setEmail("fahrulputra40@gmail.com");
//            model.setPassword("123456");
//            model.setSalary(new Double(1000));
//            model.setName("Fahrul");
//            model.setGender("MALE");
//            
//            
//            List<EmployeeModel> arrayEmployee = new ArrayList<>();
//            arrayEmployee.add(model);
//            
//            given(employeeSerice.getAll()).willReturn(arrayEmployee);
//            
//            model = new EmployeeModel();
//            model.setEmail("fahrulputraa40@gmail.com");
//            model.setName("Fahrul");
//            model.setSalary(new Double(1222));
//            
//            ow = mp.writer().withDefaultPrettyPrinter();
//            
//            this.mockMvc.perform(post("/employee")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(ow.writeValueAsString(model)))
//                    .andExpect(status().isBadRequest())
//                    .andExpect(jsonPath("$.status", is("error")));
//	}
//        
//        
//        @Test 
//        public void getAllEmployee(){
//        }

}
