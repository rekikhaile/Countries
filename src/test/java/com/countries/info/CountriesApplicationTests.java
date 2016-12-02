package com.countries.info;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.countries.info.web.CountryController;

/**
 *
 * Spring Boot first created this class after the testing 
 * dependency is added to pom.xml
 *  @author Rekik Haile
 * Smoke testing
 *
 */

/*@RunWith tells JUnit to run using Spring's testing support*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CountriesApplicationTests {

    @Autowired
    private CountryController controller;
    
    /*@Test defines a method to be test method
     * 
     *  Testing that the context is creating the controller*/
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
