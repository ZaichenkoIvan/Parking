package com.example.parking.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;


public class AppConfig {
	@Bean
	public static ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
