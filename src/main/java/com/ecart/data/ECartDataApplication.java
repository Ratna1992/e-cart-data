package com.ecart.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@Api(value = "ECartDataApplication")
public class ECartDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECartDataApplication.class, args);
	}

}
