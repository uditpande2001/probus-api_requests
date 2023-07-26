package com.adani.api_app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adani.api_app.projections.GwMeterSummaryProjection;
import com.adani.api_app.repository.RfDiagRepository;
import com.adani.api_app.response.GwMeterSummary;

@Service
public class RfDiagService {

	
	@Autowired
	private RfDiagRepository rfDiagRepository;
	
	
	public HashMap<String,Integer> getOnlineNodes(int offlineThreshold){
		HashMap<String,Integer> result = new HashMap<>();
		
		int total = rfDiagRepository.findTotalNodes();
		int online = rfDiagRepository.findOnlineNodes(LocalDateTime.now().minusMinutes(offlineThreshold));
		int offline = total - online;
		
		result.put("Total nodes", total);
		result.put("Online nodes",online);
		result.put("Offline nodes",offline);
		
		return result;
		
		
	}

	public List<GwMeterSummary> findMetersForGw(String gw_id){
		
		List<GwMeterSummaryProjection> queryResult = rfDiagRepository.getMetersForGw(gw_id);
		
		List<GwMeterSummary> result = new LinkedList<>();
		
		for(GwMeterSummaryProjection meterData: queryResult) {
			
			GwMeterSummary obj = new GwMeterSummary(meterData.getMeterNumber(), meterData.getNodeId());
			
			result.add(obj);
	
		}
		
		return result;
		
	}
	
}