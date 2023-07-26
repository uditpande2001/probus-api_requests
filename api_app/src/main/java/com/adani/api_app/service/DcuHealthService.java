package com.adani.api_app.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adani.api_app.repository.DcuHealthRepository;
import com.adani.api_app.response.DcuSummary;

@Service
public class DcuHealthService {
	
	@Autowired
	private DcuHealthRepository dcuHealthRepository;
	
	public Map<Object, Object> findnodeDcu(int node_id) {
		
		List<Object[]> resultList = dcuHealthRepository.getNodeDcu(node_id);
		Map<Object, Object> resultMap = new HashMap<>();
		
		for (Object[] row : resultList) {
			
			for(int i=0; i<row.length; i=i+2) {
				if (i + 1 < row.length && row[i] !=null) {
					
					 resultMap.put(row[i], row[i + 1]);					
				
				}
		
			}	
			
		}
		return resultMap;

	}
	
	public DcuSummary dcuSummary(int thresholdTime) {
		
		int total = dcuHealthRepository.findTotalDcu();
		LocalDateTime req = LocalDateTime.now().minusMinutes(thresholdTime);
		int online = dcuHealthRepository.findOnlineDcu(req);
		int offline = total - online;
		
		DcuSummary dcuSummary = new DcuSummary();
		dcuSummary.setCount(total);
		dcuSummary.setOnline(online);
		dcuSummary.setOffline(offline);
		
		return dcuSummary;
		
		
		
	}

	
	
	
	
	
}
