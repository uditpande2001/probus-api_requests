package com.example.rf_handler.repositories;
import com.example.rf_handler.entities.*;
import java.security.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository

public interface RfDiagRepository extends JpaRepository<RfDiag, RfDiagId> {
	
	@Query(value = "SELECT * FROM rf_diag WHERE node_id = ?1", nativeQuery = true)
    List<RfDiag> findByNodeIdAndServerTimeBetween(int nodeId);
	
	

}
