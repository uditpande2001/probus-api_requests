package com.adani.api_app.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.adani.api_app.service.RfDiagService;

@RestController
@RequestMapping("map")
public class RfDiagController {
	
	@Autowired 
	private RfDiagService rfDiagService;
	
	@GetMapping("/getOnlineNodes")
	public HashMap<String,Integer> getOnlineNodes(@RequestParam int offlineThreshold){
		return rfDiagService.getOnlineNodes(offlineThreshold);
	}
	
	
	@GetMapping("/gwMeter")
	ResponseEntity<?> findMetersForGw(@RequestParam String gw_id){
		
		try {
			return new ResponseEntity<>(rfDiagService.findMetersForGw(gw_id), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}