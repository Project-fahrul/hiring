/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.controller;

import com.gli.hiring.hiring.gli.component.ResponsePayload;
import com.gli.hiring.hiring.gli.model.DogsBreedsModel;
import com.gli.hiring.hiring.gli.service.DogsBreedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fahrul
 */
@RestController
@RequestMapping("/dogs")
@Api(value = "This API is to get all data from dogs breed", description="This Api is used to get all dogs bread and sub breed")
public class DogsBreedsController {

    @Autowired
    private ResponsePayload responsePayload;
    
    @Autowired
    private DogsBreedService dogsBreedService;
    
    
    @ApiOperation(value = "Get all dogs breed. The X-Access-Token see in application.properties", produces = "application/json")
    @GetMapping
    public ResponseEntity<Object> listAll() {
        Optional<DogsBreedsModel<HashMap<String, Object>>> model = dogsBreedService.getAll();
        
        if (!model.isPresent()) {
            return new ResponseEntity(responsePayload
                    .setStatusError()
                    .setEmptyData().getHash(), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity(responsePayload
                .setStatusSuccess()
                .setData(model.get()).getHash(), HttpStatus.OK);
    }
    @ApiOperation(value = "Get all sub breed. The X-Access-Token see in application.properties", produces = "application/json")
    @GetMapping("/sub")
    public ResponseEntity<Object> getAllSubBreed() {
        Optional<DogsBreedsModel<List<String>>> model = dogsBreedService.getAllSubBreeds();
        if (!model.isPresent()) {
            return new ResponseEntity(responsePayload
                    .setStatusError()
                    .setEmptyData().getHash(), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity(responsePayload
                .setStatusSuccess()
                .setData(model.get()).getHash(), HttpStatus.OK);
    }
    
    @ApiOperation(value = "Get all sub dogs breed images. The X-Access-Token see in application.properties", produces = "application/json")
    @GetMapping("/sub/images/{breed}")
    public ResponseEntity<Object> getAllSubBreedImages(@PathVariable String breed) {
        Optional<DogsBreedsModel<List<String>>> model = dogsBreedService.getAllSubBreedImages(breed);
        
        if (!model.isPresent()) {
            return new ResponseEntity(responsePayload
                    .setStatusError()
                    .setEmptyData().getHash(), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity(responsePayload
                .setStatusSuccess()
                .setData(model.get()).getHash(), HttpStatus.OK);
    }
    @ApiOperation( value = "Get single image dogs breed. The X-Access-Token see in application.properties", produces = "application/json")
    @GetMapping("/sub/single/{breed}")
    public ResponseEntity<Object> getSingleSubBreed(@PathVariable String breed) {
        Optional<DogsBreedsModel<String>> model = dogsBreedService.getSingleSubBreedImageRandom(breed);
        
        if (!model.isPresent()) {
            return new ResponseEntity(responsePayload
                    .setStatusError()
                    .setEmptyData().getHash(), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity(responsePayload
                .setStatusSuccess()
                .setData(model.get()).getHash(), HttpStatus.OK);
    }
    
    @ApiOperation(value = "Get multi sub dogs breed image. The X-Access-Token see in application.properties", produces = "application/json")
    @GetMapping("/sub/multi/{breed}/total/{total}")
    public ResponseEntity<Object> getMultiSubBreed(@PathVariable(name = "breed") String breed, @PathVariable(name = "total") String total) {
        Optional<DogsBreedsModel<List<String>>> model = dogsBreedService.getMultiSubBreedImageRandom(breed, Integer.parseInt(total));
        
        if (!model.isPresent()) {
            return new ResponseEntity(responsePayload
                    .setStatusError()
                    .setEmptyData().getHash(), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity(responsePayload
                .setStatusSuccess()
                .setData(model.get()).getHash(), HttpStatus.OK);
    }
}
