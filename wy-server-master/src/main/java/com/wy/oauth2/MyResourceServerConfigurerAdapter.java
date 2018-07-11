package com.wy.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class MyResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()
		.antMatchers("/usernamepassword/token","/households/saveBatch","/test1","/save_household","/get_household_list","/save_house","/get_house_list").permitAll()
		.antMatchers("/users/**","/menus/**","/roles/**","/households/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated();
	}

}
