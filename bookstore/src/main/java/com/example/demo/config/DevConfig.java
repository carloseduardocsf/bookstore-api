package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	private DBService dbService;
	
	public DevConfig(DBService dbService) {
		this.dbService = dbService;
	}
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	
	@Bean
	public boolean popularBanco() {
		if(strategy.equals("create")) {
			this.dbService.instanciaBaseDeDados();
		}
		return false;
	}
	
}
