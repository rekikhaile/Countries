package com.countries.info.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/*Crud tempmate for Continent entity - The CrudRepository provides CRUD functionality for the entity
class(Continent)
*  findByContinentName - CrudRepository can derive the query from 
*  the field name
*  */
public interface ContinentRepository extends CrudRepository<Continent, Long> {
	List<Continent> findByContinentName(String continentName);

}
