/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.service;

import com.gli.hiring.hiring.gli.model.DogsBreedsModel;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author fahrul
 */
@Service
public class DogsBreedService {

    @Value("${app.dogsbreeds.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplete;
    
    @Cacheable(cacheNames = "dogs")
    public Optional<DogsBreedsModel<HashMap<String, Object>>> getAll() {
        ResponseEntity<DogsBreedsModel<HashMap<String, Object>>> response = restTemplete
                .exchange(url + "/breeds/list/all",
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<DogsBreedsModel<HashMap<String, Object>>>() {
                });
        if (response.getStatusCode() == HttpStatus.OK) {
            return Optional.of(response.getBody());
        }
        return Optional.empty();
    }
    
    @Cacheable(cacheNames = "dogs_sub")
    public Optional<DogsBreedsModel<List<String>>> getAllSubBreeds() {
        ResponseEntity<DogsBreedsModel<List<String>>> response = restTemplete
                .exchange(url + "/breed/hound/list", HttpMethod.GET, null,
                        new ParameterizedTypeReference<DogsBreedsModel<List<String>>>() {
                });
        if (response.getStatusCode() == HttpStatus.OK) {
            return Optional.of(response.getBody());
        }
        return Optional.empty();
    }

    @Cacheable(cacheNames = "dogs_sub_image", key = "#breed")
    public Optional<DogsBreedsModel<List<String>>> getAllSubBreedImages(String breed) {
        ResponseEntity<DogsBreedsModel<List<String>>> response = restTemplete
                .exchange(url + "/breed/hound/" + breed + "/images", 
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<DogsBreedsModel<List<String>>>() {
                });
        if (response.getStatusCode() == HttpStatus.OK) {
            return Optional.of(response.getBody());
        }
        return Optional.empty();
    }
    
    public Optional<DogsBreedsModel<String>> getSingleSubBreedImageRandom(String breed) {
        ResponseEntity<DogsBreedsModel<String>> response = restTemplete
                .exchange(url + "/breed/hound/" + breed + "/images/random", 
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<DogsBreedsModel<String>>() {
                });
        if (response.getStatusCode() == HttpStatus.OK) {
            return Optional.of(response.getBody());
        }
        return Optional.empty();
    }
    
    public Optional<DogsBreedsModel<List<String>>> getMultiSubBreedImageRandom(String breed, int total) {
        ResponseEntity<DogsBreedsModel<List<String>>> response = restTemplete
                .exchange(url + "/breed/hound/" + breed + "/images/random/" + total, HttpMethod.GET, null,
                        new ParameterizedTypeReference<DogsBreedsModel<List<String>>>() {
                });
        if (response.getStatusCode() == HttpStatus.OK) {
            return Optional.of(response.getBody());
        }
        return Optional.empty();
    }
}
