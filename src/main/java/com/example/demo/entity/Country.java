package com.example.demo.entity;

import java.util.List;
import java.util.Set;

public class Country {
	private String name;
	private Set<String> languages;
	private Double[] latLong;
	private List<String> allBorders;
	private String carSide ;

	public Country(String name, Set<String> languages, Double[] latLong,List<String> allBorders,String carSide ) {
		this.name = name;
		this.languages = languages;
		this.latLong = latLong;
		this.allBorders = allBorders;
		this.carSide = carSide ;
	}

	
	public static class Builder {
        private String name;
        private Set<String> languages;
        private Double[] latLong;
        private List<String> allBorders;
        private String carSide;

        public Builder() {
        }

        // Setter methods for Builder

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder languages(Set<String> languages) {
            this.languages = languages;
            return this;
        }

        public Builder latLong(Double[] latLong) {
            this.latLong = latLong;
            return this;
        }

        public Builder allBorders(List<String> allBorders) {
            this.allBorders = allBorders;
            return this;
        }

        public Builder carSide(String carSide) {
            this.carSide = carSide;
            return this;
        }

        // Build method to construct the Country object
        public Country build() {
            return new Country(name, languages, latLong, allBorders, carSide);
        }
    }
	
	public String getName() {
		return name;
	}
	public Set<String> getLanguages() {
		return languages;
	}
	public Double[] getLatLong() {
		return latLong;
	}
	public List<String> getAllBorders() {
		return allBorders;
	}
	public String getCarSide() {
		return carSide;
	}

	
}
