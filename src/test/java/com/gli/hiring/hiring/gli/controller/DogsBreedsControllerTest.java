/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.gli.hiring.hiring.gli.controller;

import com.gli.hiring.hiring.gli.model.DogsBreedsModel;
import com.gli.hiring.hiring.gli.service.DogsBreedService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author fahrul
 */
@AutoConfigureMockMvc(addFilters = false)
@ComponentScan(basePackageClasses = { com.gli.hiring.hiring.gli.security.UnauthorizationEntryPoinSecurity.class, com.gli.hiring.hiring.gli.component.ResponsePayload.class})
@WebMvcTest(controllers = com.gli.hiring.hiring.gli.controller.DogsBreedsController.class)
public class DogsBreedsControllerTest {
    
    @MockBean
    private DogsBreedService DogsBreedService;
    
    @Autowired
    private MockMvc mockMvc;
     
    @Before
    public void setUp() {
    }
    
    
    
    /**
     * Test of listAll method, of class DogsBreedsController.
     */
    @Test
    public void testListAll() throws Exception {
        DogsBreedsModel<HashMap<String, Object>> res;
        res = new DogsBreedsModel<HashMap<String, Object>>();
        HashMap<String, Object> data = new HashMap<String, Object>();
        List<String> list = new ArrayList<>();
        list.add("jenis");
        data.put("afgans", list);
        res.setMessage(data);
        
        BDDMockito.given(DogsBreedService.getAll()).willReturn(Optional.of(res));
        mockMvc.perform(get("/dogs")).andExpect(status().isOk());
    }

    /**
     * Test of getAllSubBreed method, of class DogsBreedsController.
     */
    @Test
    public void testGetAllSubBreed() throws Exception {
        DogsBreedsModel<List<String>> res;
        res = new DogsBreedsModel<List<String>>();
        HashMap<String, Object> data = new HashMap<String, Object>();
        List<String> list = new ArrayList<>();
        data.put("afgans", list);
        
        BDDMockito.given(DogsBreedService.getAllSubBreeds()).willReturn(Optional.of(res));
        mockMvc.perform(get("/dogs/sub")).andExpect(status().isOk());
    }

    /**
     * Test of getAllSubBreedImages method, of class DogsBreedsController.
     */
    @Test
    public void testGetAllSubBreedImages() throws Exception {
        DogsBreedsModel<List<String>> res;
        res = new DogsBreedsModel<List<String>>();
        List<String> data = new ArrayList<String>();
        data.add("gambar");
        res.setMessage(data);
        
        BDDMockito.given(DogsBreedService.getAllSubBreedImages(any(String.class))).willReturn(Optional.of(res));
        mockMvc.perform(get("/dogs/sub/images")).andExpect(status().isOk());
    }

    /**
     * Test of getSingleSubBreed method, of class DogsBreedsController.
     */
    @Test
    public void testGetSingleSubBreed() throws Exception {
        DogsBreedsModel<String> res;
        res = new DogsBreedsModel<String>();
        res.setMessage("Gambar");
        
        BDDMockito.given(DogsBreedService.getSingleSubBreedImageRandom(any(String.class))).willReturn(Optional.of(res));
        mockMvc.perform(get("/dogs/sub/single")).andExpect(status().isOk());
    }

    /**
     * Test of getMultiSubBreed method, of class DogsBreedsController.
     */
    @Test
    public void testGetMultiSubBreed() throws Exception {
        DogsBreedsModel<List<String>> res;
        res = new DogsBreedsModel<List<String>>();
        List<String> data = new ArrayList<String>();
        data.add("gambar");
        res.setMessage(data);
        
        BDDMockito.given(DogsBreedService.getMultiSubBreedImageRandom(any(String.class), any(Integer.class))).willReturn(Optional.of(res));
        mockMvc.perform(get("/dogs/sub/images")).andExpect(status().isOk());
    }
    
}
