package com.countries.info.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*An entity represents a table in relational database
 * An entity class is annotated with @Entity annotation
 * by default the table name is the name of the entity class*/
@Entity
public class Country {
	/* @Id annotation is used for creating id column of the table
	 * @GeneratedValue(strategy = GenerationType.AUTO)generates 
	 	automatically a unique primary key for every new entity object
	 * 
	  */
     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     private Long id;	
	 private String countryName;
	 private float area;
	 private int population;
	 private String capital;
	 private String monetaryUnit;
	 private String language;
	 
	 /* @ManyToOne - many-to-one relationship between Class and Continent entities
	  * The annotation @JoinColumn indicates that this entity is the owner
 		of the relationship that is: the corresponding table has a column
 		 with a foreign key to the referenced table
 	  * @JsonIgnore - ignore one-to-many relationship from JSON to avoid endless loop 
 	  	of the entity relationship
 	  * Add new continent attribute with the @ManyToOne and @JoinColumn
	  * */
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
