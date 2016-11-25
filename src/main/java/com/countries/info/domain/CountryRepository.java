package com.countries.info.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findByCountryName(String countryName);
    
}