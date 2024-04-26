package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Country;
import com.example.demo.entity.NeighbourDeatilsVO;

@Service
public class SimilarityService {
	
	@Autowired
	IDistanceCalculator distanceCalculator;

	public List<NeighbourDeatilsVO> getCountryData(Country country , Map<String, Country> neighbours) {
		
		List<NeighbourDeatilsVO> result = new ArrayList<>();
		for (Map.Entry<String, Country> neighbour : neighbours.entrySet()) {
			Country nghCountry = neighbour.getValue();
			
			//Language
			boolean commonLang = false;
			Set<String> nghLanguages = nghCountry.getLanguages();
			nghLanguages.retainAll(country.getLanguages());
			if (nghLanguages.size() > 0)
				commonLang = true;
			
			//Distance
			Double approxDistance = distanceCalculator.calculate(country.getLatLong(), nghCountry.getLatLong());
			
			//Car Side
			Boolean carSide = country.getCarSide().equalsIgnoreCase(nghCountry.getCarSide());
			
			result.add(new NeighbourDeatilsVO(nghCountry.getName(),commonLang,carSide,approxDistance,country.getName()));

		}
		
		return result;
	}

}
