package com.countries.info.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Country {
     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     private Long id;	
	 private String countryName;
	 private float area;
	 private int population;
	 private String capital;
	 private String monetaryUnit;
	 private String language;
	 
	 
	 @ManyToOne
	 @JsonIgnore
	 @JoinColumn(name = "continentId")
	 private Continent continent;
	   
	   
	public Country() {
		super();
	}

	
	public Country(String countryName, float area, int population,
			String capital, String monetaryUnit, String language,
			Continent continent) {
		super();
		this.countryName = countryName;
		this.area = area;
		this.population = population;
		this.capital = capital;
		this.monetaryUnit = monetaryUnit;
		this.language = language;
		this.continent = continent;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public Continent getContinent() {
		return continent;
	}


	public void setContinent(Continent continent) {
		this.continent = continent;
	}


	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getMonetaryUnit() {
		return monetaryUnit;
	}

	public void setMonetaryUnit(String monetaryUnit) {
		this.monetaryUnit = monetaryUnit;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", area="
				+ area + ", population=" + population + ", capital=" + capital
				+ ", monetaryUnit=" + monetaryUnit + ", language=" + language
				+ ", continent=" + continent + "]";
	}

	
	 
}
