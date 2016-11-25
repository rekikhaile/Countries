package com.countries.info;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.countries.info.domain.CountryRepository;
import com.countries.info.domain.ContinentRepository;
import com.countries.info.domain.Country;
import com.countries.info.domain.Continent;
import com.countries.info.domain.User;
import com.countries.info.domain.UserRepository;

/**
 * Countries listing application command line runner
 * 
 * @author Rekik Haile
 *
 */
@SpringBootApplication
public class CountriesApplication {

	private static final Logger log = LoggerFactory.getLogger(CountriesApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CountriesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner countryDemo(CountryRepository crepository, ContinentRepository vrepository, UserRepository urepository) {
		return (args) -> {
			log.info("Save some countries");
			vrepository.save(new Continent("Africa"));
			vrepository.save(new Continent("Asia"));
			vrepository.save(new Continent("Europe"));
			vrepository.save(new Continent("North America"));
			vrepository.save(new Continent("Oceania"));
			vrepository.save(new Continent("South America"));
			
			crepository.save(new Country("Ethiopia", 1104300, 99000000, "Addis Ababa","Birr","Amharic",vrepository.findByContinentName("Africa").get(0)));
			crepository.save(new Country("Japan", 377972, 5000000, "Tokyo","Yen","Japanese",vrepository.findByContinentName("Asia").get(0)));
			crepository.save(new Country("Finland", 338424, 5488543, "Helsinki","Euro","Finnish",vrepository.findByContinentName("Europe").get(0)));
			crepository.save(new Country("Canada", 9984670, 36286425, "Ottawa","CAD","English",vrepository.findByContinentName("North America").get(0)));
			crepository.save(new Country("Australia", 7692024, 24278600, "Canberra","AUD","English",vrepository.findByContinentName("Oceania").get(0)));
			crepository.save(new Country("Brazil", 8515767, 206440850, "Brasília","BRL","	Portuguese",vrepository.findByContinentName("South America").get(0)));

			// Create users: admin/password2 user/password1
			User user1 = new User("user", "$2a$10$X9yO8y..u/Sp5biLLxNZuuBK4.hFWdgPWrlX51ItINEzn/82fPJ2a", "USER");//password1 bcrypt
			User user2 = new User("admin", "$2a$10$4KkPnyj.dMMbAIocGkXGcepFnJ61lDefQ7FB8Cwau9gWnRrrKKDei", "ADMIN"); //password2 bcrypt
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all countries");
			for (Country country : crepository.findAll()) {
				log.info(country.toString());
			}

		};
	}
}
