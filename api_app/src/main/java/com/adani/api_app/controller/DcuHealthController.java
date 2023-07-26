package com.adani.api_app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adani.api_app.service.DcuHealthService;

@RestController
@RequestMapping("map")
public class DcuHealthController {
	
	@Autowired
	private DcuHealthService dcuHealthService;
	
	@GetMapping("nodeDcu")
	ResponseEntity<?> getNodeDcu(@RequestParam int node_id){
			
			try {
				return new ResponseEntity<>(dcuHealthService.findnodeDcu(node_id), HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	
	@GetMapping("dcuSummary")
	ResponseEntity<?> dcuSummary(@RequestParam int thresholdTime){
		
			try {
				return new ResponseEntity<>(dcuHealthService.dcuSummary(thresholdTime), HttpStatus.OK);
				
			}
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
						
	}
	
	
	   	
	

