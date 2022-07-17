/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gli.hiring.hiring.gli.component;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;


/**
 *
 * @author fahrul
 */
@Component
public class  ResponsePayload {
        private HashMap<String, Object> hash = null;
        
        @PostConstruct
        public void initialize(){
            hash = new HashMap<>();
            setStatus("error");
            setData("");
        }
        
        public ResponsePayload setStatus(String status){
            hash.put("status", status);
            return this;
        }
        
        public ResponsePayload setEmptyData(){
            hash.put("data", "{}");
            return this;
        }
        
        public ResponsePayload setData(Object data){
            hash.put("data", data);
            return this;
        }
        
        public ResponsePayload setStatusSuccess(){
            setStatus("success");
            return this;
        }
        
        public ResponsePayload setStatusError(){
            setStatus("error");
            return this;
        }
        
        public HashMap<String, Object> getHash(){
            return hash;
        }
    }
