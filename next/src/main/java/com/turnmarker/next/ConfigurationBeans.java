package com.turnmarker.next;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.turnmarker.next.beans.AuthenticationFilterBean;
import com.turnmarker.next.models.RingGraphModel;

public class ConfigurationBeans {

	public ConfigurationBeans() {

		// TODO Auto-generated constructor stub

	}

	@Bean
	public FilterRegistrationBean<AuthenticationFilterBean> authenticationFilterBean() {

		// INSTANTIATE:
		FilterRegistrationBean<AuthenticationFilterBean> frbean = new FilterRegistrationBean<AuthenticationFilterBean>();
		
		// CONFIGURATE: 
		frbean.setFilter(new AuthenticationFilterBean());
		
		// RESTRICT THIS FILTER TO SPECIFIC PATHS:
		// frbean.addUrlPatterns("/filtered/path/*", "/additional/filtered/paths/*");
		
		// AND RETURN:
		return frbean;

	}
	
	@Bean
	public RingGraphModel getRingGraphModel() {
		
		return RingGraphModel.getFactory();
		
	}

}
