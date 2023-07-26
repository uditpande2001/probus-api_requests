package com.example.rf_handler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rf_handler.entities.RfDiag;
import com.example.rf_handler.repositories.RfDiagRepository;

@Service
public class BillingService {
	
	
	private final RfDiagRepository rfDiagRepository ;
	
	 @Autowired
	    public BillingService(RfDiagRepository rfDiagRepository) {
	        this.rfDiagRepository = rfDiagRepository;
	    }
	
	
		
	public void getBilling(int node_id) {
		
		List<RfDiag> result =  rfDiagRepository.findByNodeIdAndServerTimeBetween(node_id);
		
		for(RfDiag data : result) {
			
			System.out.println(data.toString());
		}
    }

}
