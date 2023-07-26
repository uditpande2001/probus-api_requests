package com.adani.api_app.repository;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adani.api_app.entities.DcuHealth;

@Repository
public interface DcuHealthRepository extends CrudRepository<DcuHealth, UUID> {
	
	
	@Query(value = "WITH req_nodes AS \r\n"
			+ "(\r\n"
			+ "    SELECT *,\r\n"
			+ "        ROW_NUMBER() OVER (PARTITION BY node_id ORDER BY server_time DESC) AS entry,\r\n"
			+ "        COUNT(1) OVER (PARTITION BY node_id) AS slot_count\r\n"
			+ "    FROM rf_diag\r\n"
			+ "    WHERE node_id =?1  \r\n"
			+ "),\r\n"
			+ "dcu AS \r\n"
			+ "(  SELECT hub_uuid, max(health_time) AS dcu_health\r\n"
			+ "		FROM dcu_health dh \r\n"
			+ "		GROUP BY hub_uuid\r\n"
			+ ")\r\n"
			+ "SELECT req_nodes.node_id, req_nodes.server_time, dcu.hub_uuid,dcu.dcu_health\r\n"
			+ "FROM req_nodes\r\n"
			+ "left JOIN dcu ON req_nodes.gw_id = dcu.hub_uuid\r\n"
			+ "WHERE entry = 1", nativeQuery = true)
	
	List<Object[]> getNodeDcu(int node_id);
	
	@Query(value = "SELECT count(DISTINCT hub_uuid) \r\n"
			+ "FROM dcu_health dh ",nativeQuery = true)
	
	int findTotalDcu();
	
	@Query(value = "SELECT count(DISTINCT hub_uuid) \r\n"
			+ "FROM dcu_health dh \r\n"
			+ "WHERE health_time >= ?1",nativeQuery = true)
	
	int findOnlineDcu(LocalDateTime thresholdTime);
	
	

}