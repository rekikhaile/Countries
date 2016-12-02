package com.countries.info.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/*The CrudRepository provides CRUD functionality for the entity
 class(Country)
 *  By extending CrudRepository the CountryRepository inherits
 	methods(for saving, deleting, finding .. Country entities) for working with 
 	Country persistence
 *  findByCountryName - CrudRepository can derive the query from 
    the field name
 *  */
public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findByCountryName(String countryName);
    
}