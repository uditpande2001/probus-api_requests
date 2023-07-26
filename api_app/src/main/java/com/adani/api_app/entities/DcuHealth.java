package com.adani.api_app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import java.sql.Timestamp;

@Entity
//@Table(name = "dcu_health", schema = "public")
@Table(name = "dcu_health")

public class DcuHealth {

    @Id
    private UUID id;
    
    private String batteryVoltage;

    private Timestamp healthTime;

    private String hubUuid;

    private String selectedSim;

    private String signalStrength;

    private String simIp;

    private String simOperator;

    private String simSerialNo;

    private String version;
      
 // Constructors, getters, and setters

    public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getBatteryVoltage() {
		return batteryVoltage;
	}

	public void setBatteryVoltage(String batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}

	public Timestamp getHealthTime() {
		return healthTime;
	}

	public void setHealthTime(Timestamp healthTime) {
		this.healthTime = healthTime;
	}

	public String getHubUuid() {
		return hubUuid;
	}

	public void setHubUuid(String hubUuid) {
		this.hubUuid = hubUuid;
	}

	public String getSelectedSim() {
		return selectedSim;
	}

	public void setSelectedSim(String selectedSim) {
		this.selectedSim = selectedSim;
	}

	public String getSignalStrength() {
		return signalStrength;
	}

	public void setSignalStrength(String signalStrength) {
		this.signalStrength = signalStrength;
	}

	public String getSimIp() {
		return simIp;
	}

	public void setSimIp(String simIp) {
		this.simIp = simIp;
	}

	public String getSimOperator() {
		return simOperator;
	}

	public void setSimOperator(String simOperator) {
		this.simOperator = simOperator;
	}

	public String getSimSerialNo() {
		return simSerialNo;
	}

	public void setSimSerialNo(String simSerialNo) {
		this.simSerialNo = simSerialNo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	
    // Constructors, getters, and setters

    public DcuHealth() {
    }

    public DcuHealth(UUID id, String batteryVoltage, Timestamp healthTime, String hubUuid, String selectedSim,
                     String signalStrength, String simIp, String simOperator, String simSerialNo, String version) {
        this.id = id;
        this.batteryVoltage = batteryVoltage;
        this.healthTime = healthTime;
        this.hubUuid = hubUuid;
        this.selectedSim = selectedSim;
       
}
    }