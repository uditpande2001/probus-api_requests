package com.example.rf_handler.api_requests;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class Authenticate {
	
	public String auth() {
		
	try {	
		
		Map<String, String> credentials = new HashMap();
        credentials.put("userId", "probus");
        credentials.put("password", "probus@123");
		
		Gson gson = new Gson();
		String payload = gson.toJson(credentials);
				
		HttpRequest authRequest = HttpRequest.newBuilder()
	            .uri(new URI("http://216.48.180.61:9999/auth/login"))
	            .header("Content-Type", "application/json")
	            .POST(BodyPublishers.ofString(payload)) 
	            .build();
		
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> authToken = httpClient.send(authRequest, BodyHandlers.ofString());
//		System.out.println(authToken.body());
//        System.out.println(authToken.statusCode());

		return authToken.body();

	}
	catch (Exception e) {
      
        e.printStackTrace();
    }
	return null ;
	
	}
	
}
