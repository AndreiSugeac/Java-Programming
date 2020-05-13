package com.example.ExtremeSportBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ExtremeSportBackendApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(ExtremeSportBackendApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ExtremeSportBackendApplication.class, args);
	}

}