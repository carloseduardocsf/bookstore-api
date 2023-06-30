package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.service.DBService;

@Configuration
@Profile("teste")
public class TesteConfig {
	
	private DBService dbService;
	
	public TesteConfig(DBService dbService) {
		this.dbService = dbService;
	}
	
	@Bean
	public void popularBanco( ) {
		this.dbService.instanciaBaseDeDados();
	}
	
}
