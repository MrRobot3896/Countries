package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Country;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NeighbourService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UtilityJSONService utilityJSONService;
	
	
	public Map<String , Country> getNeighboringCountryDetails(List<String> borders) {
		Map<String , Country> ngh =new HashMap<>();
		for(String border: borders)
		{
			Country nghcountry = getCountryDetailsByCode(border);
			ngh.put(nghcountry.getName(), nghcountry);
		}
		return ngh;
	}
	
	public Country getCountryDetailsByCode(String code) {
		String url = "https://restcountries.com/v3.1/alpha/" + code;
		String json = restTemplate.getForObject(url, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = null;
		try {
			rootNode = mapper.readTree(json);
			
			Country country = new Country.Builder()
                    .name(utilityJSONService.extractName(rootNode))
                    .languages(utilityJSONService.extractLanguages(rootNode))
                    .latLong(utilityJSONService.extractLatLong(rootNode))
                    .carSide(utilityJSONService.extractCarSide(rootNode))
                    .build();
			
			return country;

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
