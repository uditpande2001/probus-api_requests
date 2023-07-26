package com.adani.api_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adani.api_app.entities.MeterMapping;
@Repository

public interface MeterMappingRepository extends CrudRepository<MeterMapping, String> {
	
	@Query(value = "SELECT meter_number FROM meter_mapping mm WHERE node_id = ?1",nativeQuery = true)
	public List<String> findMeterForNode(int node_id);


	

	
}



 