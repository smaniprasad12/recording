package com.icon.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icon.user.entity.ServiceEntity;
import com.icon.user.service.ServiceEntityService;

@RestController
public class ServiceEntityController {
	
	
	@Autowired
	private ServiceEntityService serviceentityservice;
	
	@PostMapping("/save")
	public ResponseEntity<ServiceEntity> save(@RequestBody ServiceEntity serviceentity ) {	
		return ResponseEntity.ok().body(serviceentityservice.add(serviceentity));
	}
	
	
    @GetMapping("/getall")
	public ResponseEntity<List<ServiceEntity>> getAlls(){
	return ResponseEntity.ok().body(serviceentityservice.getAll());		
	}
    
    
    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntity> getByIds(@PathVariable int id){
    	return ResponseEntity.ok().body(this.serviceentityservice.getById(id));
    	
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<ServiceEntity> updatess(@PathVariable int id,@RequestBody ServiceEntity serviceEntity){
    	return ResponseEntity.ok().body(this.serviceentityservice.update(serviceEntity));
    	
    }
    
    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable int id){
        this.serviceentityservice.delete(id);
        return HttpStatus.OK;
    }
		
}
