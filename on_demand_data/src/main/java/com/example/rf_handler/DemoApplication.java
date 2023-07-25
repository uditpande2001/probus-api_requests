package com.example.rf_handler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.rf_handler.api_requests.RfCommands;
import com.example.rf_handler.api_requests.authenticateTemp;
import com.example.rf_handler.api_requests.Authenticate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		 
		 
		 RfCommands rfcommand = new RfCommands();
		 rfcommand.midnight();
		
		
	}

}
