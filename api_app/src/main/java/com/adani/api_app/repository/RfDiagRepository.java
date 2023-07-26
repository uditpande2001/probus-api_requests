package com.adani.api_app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adani.api_app.entities.RfDiag;
import com.adani.api_app.entities.RfDiagId;
import com.adani.api_app.projections.GwMeterSummaryProjection;

@Repository
public interface RfDiagRepository extends CrudRepository<RfDiag, RfDiagId > {
	
	@Query(value = " SELECT count( DISTINCT node_id)"
			+ "FROM meter_mapping ",nativeQuery = true)
	int findTotalNodes();
	
	
	@Query(value = " SELECT count( DISTINCT node_id)"
			+ "FROM rf_diag rd "
			+ "WHERE server_time >= ?1",nativeQuery = true)
	int findOnlineNodes(LocalDateTime thresholdTime);
	
	@Query (value =" SELECT mm.meter_number as meterNumber, mm.node_id as nodeId\r\n"
			+ "FROM meter_mapping mm  \r\n"
			+ "WHERE mm.node_id IN\r\n"
			+ "				(SELECT DISTINCT node_id\r\n"
			+ "				FROM rf_diag rd \r\n"
			+ "				WHERE gw_id = ?1)  ", nativeQuery = true)
	List<GwMeterSummaryProjection> getMetersForGw(String gw_id);
	
	

	
	
	
}
