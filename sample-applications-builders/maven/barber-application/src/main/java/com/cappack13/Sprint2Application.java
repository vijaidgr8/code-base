package com.cappack13;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Sprint2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprint2Application.class, args);
	}

}
