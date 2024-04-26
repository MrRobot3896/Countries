package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class UtilityJSONService {
	
	public Set<String> extractLanguages(JsonNode rootNode) {
		JsonNode languagesNode = rootNode.get(0).get("languages");
		Set<String> languages = new HashSet<>();

		Iterator<Map.Entry<String, JsonNode>> fields = languagesNode.fields();
		while (fields.hasNext()) {
			Map.Entry<String, JsonNode> entry = fields.next();
			languages.add(entry.getValue().asText());
		}
		
		return languages;
	}

	public List<String> extractNeighbours(JsonNode rootNode) {
		JsonNode bordersNode = rootNode.get(0).get("borders");
		List<String> borders = new ArrayList<>();

		if (bordersNode != null && bordersNode.isArray()) {
			for (JsonNode border : bordersNode) {
				borders.add(border.asText());
			}
		}
		
		return borders;
	}

	public Double[] extractLatLong(JsonNode rootNode) {
		JsonNode latLngNode = rootNode.get(0).get("latlng");
		double latitude = latLngNode.get(0).asDouble();
		double longitude = latLngNode.get(1).asDouble();

		return new Double[] { latitude, longitude };
	}
	
	public String extractName(JsonNode rootNode) {
		JsonNode nameNode = rootNode.get(0).get("name");
        String officialName = nameNode.get("official").asText();

		return officialName;
	}
	
	public String extractCarSide(JsonNode rootNode) {
		JsonNode carNode = rootNode.get(0).get("car");
        String side = carNode.get("side").asText();
		
		return side;
	}

}
