package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Country;
import com.example.demo.entity.NeighbourDeatilsVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CountryService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	NeighbourService neighbourService;
	
	@Autowired
	SimilarityService similarityService;
	
	@Autowired
	UtilityJSONService utilityJSONService;

	@CircuitBreaker(name="getData",fallbackMethod = "getCountryBlank")
	public List<NeighbourDeatilsVO> getCountryDetails(String name) {
		String json =null;
		String url = "https://restcountries.com/v3.1/name/" + name;
		try {
			json = restTemplate.getForObject(url, String.class);
		}
		catch(Exception e)
		{
			return null;
		}

		Country country = getCountryData(name , json);
		Map<String , Country> neighbours = neighbourService.getNeighboringCountryDetails(country.getAllBorders());
		
		return similarityService.getCountryData(country , neighbours);
	}

	private Country getCountryData(String name, String json) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = null;
		try {
			rootNode = mapper.readTree(json);
			
			Country country = new Country.Builder()
                    .name(name)
                    .languages(utilityJSONService.extractLanguages(rootNode))
                    .latLong(utilityJSONService.extractLatLong(rootNode))
                    .allBorders(utilityJSONService.extractNeighbours(rootNode))
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
	
	public List<NeighbourDeatilsVO> getCountryBlank(Exception ex) 
	{
		return new ArrayList<>();
	}
	
	
}