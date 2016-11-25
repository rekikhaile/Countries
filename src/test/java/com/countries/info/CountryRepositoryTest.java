package com.countries.info;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.countries.info.domain.Continent;
import com.countries.info.domain.Country;
import com.countries.info.domain.CountryRepository;

/*@DataJpaTest annotation will configure in-memory database, JPA and Spring
Data. It also turns on SQL logging*/
@RunWith(SpringRunner.class)
@DataJpaTest 

public class CountryRepositoryTest {
	 @Autowired
	 private CountryRepository repository;
	 
	 @Test
	 public void findByCountryNameShouldReturnCountry() {
		 List<Country> countries = repository.findByCountryName("Finland");
		 
		 assertThat(countries).hasSize(1);
		 assertThat(countries.get(0).getMonetaryUnit()).isEqualTo("Euro"); 
	 }

	 @Test
	 public void createNewCountry () {
		 Country country = new Country("Finland", 53000, 5000000, "Helsinki","Euro","Suomea",new Continent("IT"));
		 repository.save(country);
		 assertThat(country.getId()).isNotNull();
	 }
	 
	 
	 @Test
	 public void deleteCountry() {
		
		Country country = repository.findByCountryName("Ethiopia").get(0);
		 assertThat(country.getId()).isNotNull();
		 repository.delete(country);
		 
	 }
}
