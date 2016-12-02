package com.countries.info.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*An entity represents a table in relational database
 * An entity class is annotated with @Entity annotation
 * by default the table name is the name of the entity class*/
@Entity
public class Continent {
	/* @Id annotation is used for creating id column of the table
	 * @GeneratedValue(strategy = GenerationType.AUTO)generates 
	 	automatically a unique primary key for every new entity object
	 * 
	  */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long continentId;
    private String continentName;
    
    /*@OneToMany - one-to-many relationship between Continent and Class entities
	  * Add new country attribute with @OneToMany
	  * */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "continent")
	private List<Country> countries;
	
	public Continent() {}
	
	public Continent(String continentName) {
		super();
		this.continentName = continentName;
	}
	
	public Long getContinentid() {
		return continentId;
	}
	
	public void setContinentid(Long continentId) {
		this.continentId = continentId;
	}


	public Long getContinentId() {
		return continentId;
	}

	public void setContinentId(Long continentId) {
		this.continentId = continentId;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "Continent [continentId=" + continentId + ", continentName=" + continentName + "]";
	}
}
