package com.turnmarker.next;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
// @EnableWebSecurity
public class ApplicationSecurityModel extends WebSecurityConfigurerAdapter {
	
	private final String USERNAME = "c374i";
	
	private final String PASSWORD = "{noop}f3l73";

	public ApplicationSecurityModel() {

		// TODO Auto-generated constructor stub
	}

	@Autowired
	private AuthenticationEntryPoint aep;

	@Override
	protected void configure(HttpSecurity htsec) throws Exception {
		
		htsec.csrf().disable().authorizeRequests()
		.anyRequest().authenticated()
		.and().httpBasic().authenticationEntryPoint(aep);
	
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder ambuilder) throws Exception {
	
		ambuilder.inMemoryAuthentication().withUser(USERNAME).password(PASSWORD).roles("USER");
	
	}

}