package com.to.crayon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Main application for Favicon App.
 * 
 * @author TOliveira
 *
 */
@SpringBootApplication
public class FaviconTOApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(FaviconTOApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FaviconTOApplication.class);
	}
}
