package com.adani.api_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adani.api_app.repository.MeterMappingRepository;

@Service
public class MeterMappingService {
	
	@Autowired
	private MeterMappingRepository meterMappingRepository;
	
	public List<String> getMeter(int node_id){
		return meterMappingRepository.findMeterForNode(node_id);
		
	}
	

}
