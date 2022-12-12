package com.codestates.ToDoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ToDoAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { // (2)
		return builder.sources(ToDoAppApplication.class);
	}

}
