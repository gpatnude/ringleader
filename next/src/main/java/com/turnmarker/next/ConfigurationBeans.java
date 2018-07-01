package com.turnmarker.next;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.turnmarker.next.beans.AuthenticationFilterBean;

public class ConfigurationBeans {

	public ConfigurationBeans() {

		// TODO Auto-generated constructor stub

	}

	// @Bean
	public FilterRegistrationBean<AuthenticationFilterBean> authenticationFilterBean() {

		// INSTANTIATE:
		FilterRegistrationBean<AuthenticationFilterBean> frbean = new FilterRegistrationBean<AuthenticationFilterBean>();
		
		// CONFIGURATE: 
		frbean.setFilter(new AuthenticationFilterBean());
		
		// In case you want the filter to apply to specific URL patterns only
		// registration.addUrlPatterns("/filtered-paths/*");
		
		// AND RETURN:
		return frbean;

	}

}
