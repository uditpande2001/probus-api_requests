package com.adani.api_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ApiAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAppApplication.class, args);
	}

	
//	public Docket apis() {
//		
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("con.adani.api_app")).build();
//		
//	}
	
	
	
}
