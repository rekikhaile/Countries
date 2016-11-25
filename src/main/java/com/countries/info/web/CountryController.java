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

@Controller
public class CountryController {
	
	@Autowired
	private CountryRepository repository; 
	
	@Autowired
	private ContinentRepository vrepository; 
	
	/*@RequestMapping(value = "/countries",method = RequestMethod.GET)
	public @ResponseBody Country countryListRest() {
		return repository.findOne(0L);
	}*/
	
	// Show all countries
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	// Show all countries thymeleaf
    @RequestMapping(value="/countrylist")
    public String countryList(Model model) {	
        model.addAttribute("countries", repository.findAll());
        return "countrylist";
    }
    
	// RESTful service to get all countries
    @RequestMapping(value="/countries", method = RequestMethod.GET)
    public @ResponseBody List<Country> countryListRest() {	
        return (List<Country>) repository.findAll();
    }    
    
	// RESTful service to get country by id
    @RequestMapping(value="/country/{id}", method = RequestMethod.GET)
    public @ResponseBody Country findCountryRest(@PathVariable("id") Long countryId) {	
    	return repository.findOne(countryId);
    }       
    
    // Add new country
    @RequestMapping(value = "/add")
    public String addCountry(Model model){
    	model.addAttribute("country", new Country());
    	model.addAttribute("continents", vrepository.findAll());
        return "addcountry";
    }     
    
    // Add new country
    @RequestMapping(value = "/edit/{id}")
    public String editCountry(@PathVariable("id") Long countryId, Model model){
    	model.addAttribute("country", repository.findOne(countryId));
    	model.addAttribute("continents", vrepository.findAll());
        return "editcountry";
    }
    
    // Save new/edited country
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
