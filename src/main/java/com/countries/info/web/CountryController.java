package com.countries.info.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.countries.info.domain.ContinentRepository;
import com.countries.info.domain.Country;
import com.countries.info.domain.CountryRepository;

/*@Controller annotation marks class as a Spring web MVC controller
 * Controller handles request and returns the name of the view
 * */
@Controller
public class CountryController {
	
	/*@Autowired bring the repository class into the context
	 * and will inject an instance of the service into the
	 * CountryController class.
	 * */
	@Autowired
	private CountryRepository repository; 
	
	@Autowired
	private ContinentRepository vrepository; 
	
	/*
	 * Handles request for /login and returns view named "login"
	 * that is login.html Thymeleaf template
	 * @RequestMapping annotation maps URLs to controller methods
	 * address:port/login executes login() method
	 * */
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	/*Show all countries using thymeleaf. Model object makes it
	 * accessible to the view.
	 * private CountryRepository repository;
	 * repository.findAll() method returns the list of country objects
	 * */
    @RequestMapping(value="/countrylist")
    public String countryList(Model model) {	
        model.addAttribute("countries", repository.findAll());
        return "countrylist";
    }
   
    /*RESTful service to get all countries - RESTful service is created by
     * using @Controller and @ResponseBody annotations
     * REST returns here in JSON format
     * @ResponseBody annotation converts the return value and write it to http response
     * Uses GET request
     */
    @RequestMapping(value="/countries", method = RequestMethod.GET)
    public @ResponseBody List<Country> countryListRest() {	
        return (List<Country>) repository.findAll();
    }    
    
	/*RESTful service to get country by id returns in JSON format
    * @ResponseBody annotation converts the return value and write it to http response
    */
    @RequestMapping(value="/country/{id}", method = RequestMethod.GET)
    public @ResponseBody Country findCountryRest(@PathVariable("id") Long countryId) {	
    	return repository.findOne(countryId);
    }       
    
    /* Add new country. 
     * Add new model attribute to controller method which shows country creation form. 
     * Also inject continent repository - continent drop down list to country form
     * */
    @RequestMapping(value = "/add")
    public String addCountry(Model model){
    	model.addAttribute("country", new Country());
    	model.addAttribute("continents", vrepository.findAll());
        return "addcountry";
    }     
    
    /*Add new country
     * @PathVariable extracts id from the URI
     * */
    @RequestMapping(value = "/edit/{id}")
    public String editCountry(@PathVariable("id") Long countryId, Model model){
    	model.addAttribute("country", repository.findOne(countryId));
    	model.addAttribute("continents", vrepository.findAll());
        return "editcountry";
    }
    
    /* Save new/edited country 
     * save() method is mapped to POST 
     * Controller handles the form submit.
     * redirect is used after POST to prevent duplicate 
     * form submission
     * */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Country country){
        repository.save(country);
        return "redirect:countrylist";
    }    
   

    // Delete country
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCountry(@PathVariable("id") Long countryId, Model model) {
    	repository.delete(countryId);
        return "redirect:../countrylist";
    }     
    
}
