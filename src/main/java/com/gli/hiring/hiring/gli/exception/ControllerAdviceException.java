/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.exception;

import com.gli.hiring.hiring.gli.component.ResponsePayload;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author fahrul
 */
@ControllerAdvice
public class ControllerAdviceException extends ResponseEntityExceptionHandler{
    
   @Autowired
   ResponsePayload responsePayload;
   
   @Override
   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
       ListIterator<FieldError> err = ex.getFieldErrors().listIterator();
       List<String> errors = new ArrayList<String>();
       while(err.hasNext()){
           FieldError errVal = err.next();
           errors.add(errVal.getDefaultMessage());
       }
       return new ResponseEntity<Object>(responsePayload
                        .setStatusError()
                        .setData(String.join(",", errors))
                        .getHash(), HttpStatus.BAD_REQUEST);
   }
    
}
