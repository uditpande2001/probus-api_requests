package com.adani.api_app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.adani.api_app.service.MeterMappingService;


@RestController
@RequestMapping("map")
public class MeterMappingController {
	@Autowired
	private MeterMappingService meterMappingService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MeterMappingController.class);

	
	
	
//	@GetMapping("/getMeter")
//	public List<String> getMeterByNode(@RequestParam int node_id){
//		return meterMappingService.getMeter(node_id);

	@GetMapping("/getMeter")
	ResponseEntity<?> getMeterByNode(@RequestParam int node_id){
		
		try {
			return new ResponseEntity<>(meterMappingService.getMeter(node_id), HttpStatus.OK);
		}
		catch (Exception e) {
			LOGGER.error("Error getting meter-node data",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
		

}
