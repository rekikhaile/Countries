package com.countries.info.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContinentRepository extends CrudRepository<Continent, Long> {
	List<Continent> findByContinentName(String continentName);

}
