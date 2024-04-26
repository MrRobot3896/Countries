package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.NeighbourDeatilsVO;
import com.example.demo.service.CountryService;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService; 


	@GetMapping("/country/{name}")
    public ResponseEntity<List<NeighbourDeatilsVO>> getCountryDetails(@PathVariable String name) {
    	List<NeighbourDeatilsVO> result = countryService.getCountryDetails(name);
    	if(result == null || result.size() == 0)
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
    	
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
   
}

