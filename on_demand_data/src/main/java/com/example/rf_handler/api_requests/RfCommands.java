package com.example.rf_handler.api_requests;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.*;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class RfCommands {
	
	public static void midnight() {
		
		String endpoint = "http://216.48.180.61:9999/command/rfCommand";
		long epochFrom = 1689532200; 
        long epochTo = 1689618599;
		
		
		try {
				Authenticate authenticate = new Authenticate();
				String authToken =  authenticate.auth();
				System.out.println(authToken);
				
				HashMap<String, Object> midnightPayload = new HashMap<>();
				midnightPayload.put("code", "midnight_test");
	            midnightPayload.put("commandDestination", "SENSOR");
	            midnightPayload.put("commandId", String.valueOf(Math.round(System.currentTimeMillis() / 1000.0)));
	            midnightPayload.put("commandType", "P_READ_MIDNIGHT");
	            midnightPayload.put("debug", true);
	            midnightPayload.put("deviceId", "1");
	            midnightPayload.put("hideCommand", true);
	            
	            List<Map<String, Object>> properties = new ArrayList<>();

	            Map<String, Object> prop1 = new HashMap<>();
	            prop1.put("propName", "P_FROM");
	            prop1.put("propValue", String.valueOf(epochFrom));
	            properties.add(prop1);

	            Map<String, Object> prop2 = new HashMap<>();
	            prop2.put("propName", "P_TO");
	            prop2.put("propValue", String.valueOf(epochTo));
	            properties.add(prop2);

	            midnightPayload.put("properties", properties);
	            
	            
	            Gson gson = new Gson();
	    		String payload = gson.toJson(midnightPayload);
	    		
	    		HttpRequest midnightRequest = HttpRequest.newBuilder()
	    	            .uri(new URI(endpoint))
	    	            .header("Content-Type", "application/json")
	    	            .header("Authorization", authToken)
	    	            .POST(BodyPublishers.ofString(payload)) 
	    	            .build();
	    		
	    		// Send the HTTP request
	            HttpClient httpClient = HttpClient.newHttpClient();
	            HttpResponse<String> midnightResponse = httpClient.send(midnightRequest, HttpResponse.BodyHandlers.ofString());

	            // Process the response
	            int statusCode = midnightResponse.statusCode();
	            String responseBody = midnightResponse.body();
	            
	            System.out.println(statusCode);
	            System.out.println(responseBody);

		
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	

}
