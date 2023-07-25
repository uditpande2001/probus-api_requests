package com.example.rf_handler.api_requests;

import com.example.rf_handler.*;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

	public class authenticateTemp {
		
	    public static String auth() {
	        String url = "http://216.48.180.61:9999/auth/login";
	        String password = "probus@123";
	        String userId = "probus";
	        
	        String authToken = "";
	        
	        Map<String, String> credentials = new HashMap();
	        credentials.put("userId", userId);
	        credentials.put("password", password);

	        try {
	        	
	        	
	        	
	        	
	            // Create the URL object
	            URL apiUrl = new URL(url);

	            // Open the connection
	            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

	            // Set the request method to POST
	            connection.setRequestMethod("POST");

	            // Set the request headers
	            connection.setRequestProperty("Content-Type", "application/json");

	            // Enable input and output streams
	            connection.setDoInput(true);
	            connection.setDoOutput(true);

	            // Build the request body
	            Gson gson = new Gson();
	        	String reqbody = gson.toJson(credentials);

	            // Send the request
	            OutputStream outputStream = connection.getOutputStream();
	            outputStream.write(reqbody.getBytes());
	            outputStream.flush();
	            outputStream.close();

	            // Get the response code
	            int responseCode = connection.getResponseCode();

	            if (responseCode == HttpURLConnection.HTTP_OK) {
	            	
	                // Read the response
	                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                String line;
	                StringBuilder response = new StringBuilder();

	                while ((line = reader.readLine()) != null) {
	                    response.append(line);
	                }

	                reader.close();

	                // Parse the response or extract the authentication token
	                 authToken = response.toString();

	                // Do something with the authentication token
//	                System.out.println("Authentication Token: " + authToken);
	            } else {
	                System.out.println("Request failed with response code: " + responseCode);
	            }

	            // Disconnect the connection
	            connection.disconnect();
	            
	          

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        	return authToken;
	    }
	}



