package com.adani.api_app.entities;

import jakarta.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meter_mapping" )

public class MeterMapping {
	@Id
	@Column
	private String meter_number;
	@Column
	private Long node_id;
	
	public MeterMapping() {
	
	}

	public String getMeter_number() {
		return meter_number;
	}

	public void setMeter_number(String meter_number) {
		this.meter_number = meter_number;
	}

	public Long getNode_id() {
		return node_id;
	}

	public void setNode_id(Long node_id) {
		this.node_id = node_id;
	}
	


}
