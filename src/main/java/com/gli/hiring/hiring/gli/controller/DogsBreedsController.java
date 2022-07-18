/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.controller;

import com.gli.hiring.hiring.gli.component.ResponsePayload;
import com.gli.hiring.hiring.gli.model.DogsBreedsModel;
import com.gli.hiring.hiring.gli.service.DogsBreedService;
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
public class DogsBreedsController {

    @Autowired
    private ResponsePayload responsePayload;
    
    @Autowired
    private DogsBreedService dogsBreedService;
    
    @GetMapping
    public ResponseEntity<Object> listAll() {
        Optional<DogsBreedsModel> model = dogsBreedService.getAll();
        
        if (!model.isPresent()) {
            return new ResponseEntity(responsePayload
                    .setStatusError()
                    .setEmptyData().getHash(), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity(responsePayload
                .setStatusSuccess()
                .setData(model.get()).getHash(), HttpStatus.OK);
    }
    
    @GetMapping("/sub")
    public ResponseEntity<Object> getAllSubBreed() {
        Optional<DogsBreedsModel> model = dogsBreedService.getAllSubBreeds();
        if (!model.isPresent()) {
            return new ResponseEntity(responsePayload
                    .setStatusError()
                    .setEmptyData().getHash(), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity(responsePayload
                .setStatusSuccess()
                .setData(model.get()).getHash(), HttpStatus.OK);
    }
    
    @GetMapping("/sub/images/{breed}")
    public ResponseEntity<Object> getAllSubBreedImages(@PathVariable String breed) {
        Optional<DogsBreedsModel> model = dogsBreedService.getAllSubBreedImages(breed);
        
        if (!model.isPresent()) {
            return new ResponseEntity(responsePayload
                    .setStatusError()
                    .setEmptyData().getHash(), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity(responsePayload
                .setStatusSuccess()
                .setData(model.get()).getHash(), HttpStatus.OK);
    }
    
    @GetMapping("/sub/single/{breed}")
    public ResponseEntity<Object> getSingleSubBreed(@PathVariable String breed) {
        Optional<DogsBreedsModel> model = dogsBreedService.getSingleSubBreedImageRandom(breed);
        
        if (!model.isPresent()) {
            return new ResponseEntity(responsePayload
                    .setStatusError()
                    .setEmptyData().getHash(), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity(responsePayload
                .setStatusSuccess()
                .setData(model.get()).getHash(), HttpStatus.OK);
    }
    
    @GetMapping("/sub/multi/{breed}/total/{total}")
    public ResponseEntity<Object> getMultiSubBreed(@PathVariable(name = "breed") String breed, @PathVariable(name = "total") String total) {
        Optional<DogsBreedsModel> model = dogsBreedService.getMultiSubBreedImageRandom(breed, Integer.parseInt(total));
        
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
