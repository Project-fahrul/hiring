/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.gli.hiring.hiring.gli.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author fahrul
 */
public class DogsBreedsControllerTest {
    
    public DogsBreedsControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listAll method, of class DogsBreedsController.
     */
    @Test
    public void testListAll() {
        System.out.println("listAll");
        DogsBreedsController instance = new DogsBreedsController();
        ResponseEntity<Object> expResult = null;
        ResponseEntity<Object> result = instance.listAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllSubBreed method, of class DogsBreedsController.
     */
    @Test
    public void testGetAllSubBreed() {
        System.out.println("getAllSubBreed");
        DogsBreedsController instance = new DogsBreedsController();
        ResponseEntity<Object> expResult = null;
        ResponseEntity<Object> result = instance.getAllSubBreed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllSubBreedImages method, of class DogsBreedsController.
     */
    @Test
    public void testGetAllSubBreedImages() {
        System.out.println("getAllSubBreedImages");
        String breed = "";
        DogsBreedsController instance = new DogsBreedsController();
        ResponseEntity<Object> expResult = null;
        ResponseEntity<Object> result = instance.getAllSubBreedImages(breed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSingleSubBreed method, of class DogsBreedsController.
     */
    @Test
    public void testGetSingleSubBreed() {
        System.out.println("getSingleSubBreed");
        String breed = "";
        DogsBreedsController instance = new DogsBreedsController();
        ResponseEntity<Object> expResult = null;
        ResponseEntity<Object> result = instance.getSingleSubBreed(breed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMultiSubBreed method, of class DogsBreedsController.
     */
    @Test
    public void testGetMultiSubBreed() {
        System.out.println("getMultiSubBreed");
        String breed = "";
        String total = "";
        DogsBreedsController instance = new DogsBreedsController();
        ResponseEntity<Object> expResult = null;
        ResponseEntity<Object> result = instance.getMultiSubBreed(breed, total);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
