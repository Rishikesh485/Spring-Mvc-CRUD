package com.jsp.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages  = "com.jsp")
public class Myconfig {
	
	@Bean
	public EntityManagerFactory getentityManagerFactory() {
		return Persistence.createEntityManagerFactory("rishi");	//created	step2
	}

}
