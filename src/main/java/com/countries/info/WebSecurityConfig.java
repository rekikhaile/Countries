package com.countries.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.countries.info.web.UserDetailServiceImpl;

/*@EnableWebSecurity annotation enables Spring 
 * Security web security support
 * */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;	
	
    /*configure(HttpSecurity) - defines which URL paths are secured
     * and the path for login form*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
       // .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
       // .and()
        .authorizeRequests()
        .antMatchers("/", "add", "save", "countrylist", "delete/{id}").permitAll()
          .anyRequest().authenticated()
          .and()
      .formLogin()
          .loginPage("/login")
          .defaultSuccessUrl("/countrylist")
        //  .permitAll()
         // .and()
   //   .logout()
          .permitAll()
          .and().httpBasic();
        
        http.logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login");
    }
    /*Change Spring Security configuration to use your UserDetailService implementation*/
    /*Using Bcrypt hash algorithm*/
    /*configureGlobal(AuthenticationManagerBuilder) is used to configure
     * authentication and create in-memory users for testing when needed*/
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}